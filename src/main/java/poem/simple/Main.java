package poem.simple;

import poem.boundary.Boundary;
import poem.simple.adapter.driven.ConsoleWriter;
import poem.simple.adapter.driven.PoetryLibrary;
import poem.simple.adapter.driver.Driver;

/**
 * Main class that starts the hexagon example application.
 * 
 * Inspired by a talk by A. Cockburn and T. Pierrain on hexagonal architecture:
 * https://www.youtube.com/watch?v=th4AgBcrEHA
 * 
 * @author b_muth
 *
 */
public class Main {
	public static void main(String[] args) {
		new Main().startApplication();
	}

	private void startApplication() {
		// Instantiate driven, right-side adapters
		PoetryLibrary poetryLibrary = new PoetryLibrary();
		ConsoleWriter consoleWriter = new ConsoleWriter();

		// Inject driven adapters into boundary
		Boundary boundary = new Boundary(poetryLibrary, consoleWriter);

		// Start the driver adapter for the application
		new Driver(boundary).run();
	}
}
