package poem.boundary;

import org.requirementsascode.Model;
import org.requirementsascode.ModelRunner;

import poem.boundary.driven_port.IObtainPoems;
import poem.boundary.driven_port.IWriteLines;
import poem.boundary.driver_port.IReactToCommands;
import poem.boundary.internal.command_handler.DisplayRandomPoem;

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

	private ModelRunner modelRunner;

	public Boundary(IObtainPoems poemObtainer, IWriteLines lineWriter) {
		Model model = buildModel(poemObtainer, lineWriter);
		modelRunner = new ModelRunner().run(model);
	}

	private Model buildModel(IObtainPoems poemObtainer, IWriteLines lineWriter) {
		// Create the command handler(s)
		DisplayRandomPoem displayRandomPoem = new DisplayRandomPoem(poemObtainer, lineWriter);

		// Inject command handler(s) into use case model, to tie them to command
		// types.
		Model model = UseCaseModel.build(displayRandomPoem);
		return model;
	}

	@Override
	public void reactTo(Object commandObject) {
		modelRunner.reactTo(commandObject);
	}
}