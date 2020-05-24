package poem.application;

import poem.boundary.Boundary;
import poem.driven_adapter.ConsoleWriter;
import poem.driven_adapter.HardcodedPoemLibrary;
import poem.driver_adapter.SimulatedUser;

/**
 * Main class that starts the hexagon example application.
 * 
 * The application is inspired by a talk by A. Cockburn and T. Pierrain on hexagonal architecture:
 * https://www.youtube.com/watch?v=th4AgBcrEHA
 * 
 * @author b_muth
 *
 */
public class PoemConsoleApplication {
	public static void main(String[] args) {
		new PoemConsoleApplication().startApplication();
	}

	private void startApplication() {
		// Instantiate driven, right-side adapters
		HardcodedPoemLibrary poemLibrary = new HardcodedPoemLibrary();
		ConsoleWriter consoleWriter = new ConsoleWriter();

		// Inject driven adapters into boundary
		Boundary boundary = new Boundary(poemLibrary, consoleWriter);

		// Start the driver adapter for the application
		new SimulatedUser(boundary).run();
	}
}
