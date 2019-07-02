package poem.command;

/**
 * Command object representing the user request for a poem in a certain
 * language. Supported languages are: "de" for German, "en" for English.
 * 
 * The command also includes a reference to the system's output destination
 * where the poem's content is stored for display. As examples, for Spring, that
 * would be the Spring MVC model. For a console writer, that would be
 * System.out.
 * 
 * @author b_muth
 *
 */
public class AskForPoem {
	private String language;
	private Object systemOutput;

	public AskForPoem(String language, Object systemOutput) {
		this.language = language;
		this.systemOutput = systemOutput;
	}

	public String getLanguage() {
		return language;
	}

	public Object getSystemOutput() {
		return systemOutput;
	}
}
