package poem.boundary.internal.command_handler;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import poem.boundary.driven_port.IObtainPoems;
import poem.boundary.driven_port.IWriteLines;
import poem.boundary.internal.domain.Poem;
import poem.boundary.internal.domain.RandomPoemPicker;
import poem.command.AskForPoem;

/**
 * The command handler for displaying a random poem.
 * 
 * @author b_muth
 *
 */
public class DisplayRandomPoem implements Consumer<AskForPoem> {
	private IObtainPoems poemObtainer;
	private RandomPoemPicker randomPoemPicker;
	private IWriteLines lineWriter;

	public DisplayRandomPoem(IObtainPoems poemObtainer, IWriteLines lineWriter) {
		this.poemObtainer = poemObtainer;
		this.randomPoemPicker = new RandomPoemPicker();
		this.lineWriter = lineWriter;
	}

	@Override
	public void accept(AskForPoem askForPoem) {
		List<Poem> poems = obtainPoems(askForPoem);
		Optional<Poem> poem = pickRandomPoem(poems);
		writeLines(poem);		
	}

	private List<Poem> obtainPoems(AskForPoem askForPoem) {
		String language = askForPoem.getLanguage();
		String[] poems = poemObtainer.getMePoems(language);
		List<Poem> poemDomainObjects = 
			Arrays.stream(poems)
				.map(Poem::new)
				.collect(Collectors.toList());
		return poemDomainObjects;
	}
	
	private Optional<Poem> pickRandomPoem(List<Poem> poemList) {
		Optional<Poem> randomPoem = randomPoemPicker.pickPoem(poemList);
		return randomPoem;
	}
	
	private void writeLines(Optional<Poem> poem) {
		poem.ifPresent(p -> lineWriter.writeLines(p.getVerses()));
	}
}
