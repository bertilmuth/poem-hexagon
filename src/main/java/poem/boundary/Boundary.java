package poem.boundary;

import org.requirementsascode.Model;
import org.requirementsascode.ModelRunner;

import poem.boundary.driven_port.IObtainPoems;
import poem.boundary.driven_port.IWriteLines;
import poem.boundary.driver_port.IReactToCommands;
import poem.boundary.internal.command_handler.DisplayRandomPoem;
import poem.command.AskForPoem;

/**
 * The boundary class is the only point of communication with left-side driver
 * adapters. It accepts commands, and calls the appropriate command handler.
 * 
 * On creation, this class wires up the dependencies between command types and
 * command handlers, by injecting the command handlers into a use case model.
 * 
 * After creation, this class sends each command it receives to the runner of
 * the use case model. The model runner then dispatches the command to the
 * appropriate command handler, which in turn calls the driven adapters.
 * 
 * @author b_muth
 *
 */
public class Boundary implements IReactToCommands {
	private static final Class<AskForPoem> asksForPoem = AskForPoem.class;

	private Model model;

	public Boundary(IObtainPoems poemObtainer, IWriteLines lineWriter) {
		model = buildModel(poemObtainer, lineWriter);
	}

	private Model buildModel(IObtainPoems poemObtainer, IWriteLines lineWriter) {
		// Create the command handler(s)
		DisplayRandomPoem displaysRandomPoem = new DisplayRandomPoem(poemObtainer, lineWriter);

		// With a use case model, map classes of command objects to command handlers.
		Model model = Model.builder()
			.user(asksForPoem).system(displaysRandomPoem)
		.build();
		
		return model;
	}

	@Override
	public void reactTo(Object commandObject) {
		new ModelRunner().run(model).reactTo(commandObject);
	}
}