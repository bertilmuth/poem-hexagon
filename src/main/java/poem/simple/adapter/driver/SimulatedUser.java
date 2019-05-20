package poem.simple.adapter.driver;

import poem.boundary.port.driver.IReactToCommands;
import poem.command.AskForPoem;

/**
 * The driver adapter. It's on the left side of the hexagon. It sends user
 * requests as command objects to a driver port on the hexagon boundary. For
 * simplicity, sending is done autonomously without user interaction. That's
 * why the class is called {@link SimulatedUser}.
 * 
 * @author b_muth
 *
 */
public class SimulatedUser {
	private IReactToCommands driverPort;

	public SimulatedUser(IReactToCommands driverPort) {
		this.driverPort = driverPort;
	}

	public void run() {
		driverPort.reactTo(new AskForPoem("en"));
		System.out.println("");
		driverPort.reactTo(new AskForPoem("de"));
	}
}
