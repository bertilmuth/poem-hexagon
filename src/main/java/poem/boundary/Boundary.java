package poem.boundary;

import java.util.function.Consumer;

import org.requirementsascode.BehaviorModel;
import org.requirementsascode.Model;
import org.requirementsascode.StatelessBehavior;

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
 * command handlers, by injecting the command handlers into a behavior model.
 * 
 * After creation, this class sends each command it receives to the behavior.
 * The behavior then dispatches the command to the appropriate command handler,
 * which in turn calls the driven adapters.
 * 
 * @author b_muth
 *
 */
public class Boundary implements IReactToCommands, BehaviorModel {
  private final IObtainPoems poemObtainer;
  private final IWriteLines lineWriter;
  private final StatelessBehavior behavior;

  private static final Class<AskForPoem> asksForPoem = AskForPoem.class;

  public Boundary(IObtainPoems poemObtainer, IWriteLines lineWriter) {
    this.poemObtainer = poemObtainer;
    this.lineWriter = lineWriter;
    this.behavior = StatelessBehavior.of(this);
  }

  @Override
  public Model model() {
    return Model.builder()
        .user(asksForPoem).system(displaysRandomPoem())
        .build();
  }

  @Override
  public void reactTo(Object commandObject) {
    behavior.reactTo(commandObject);
  }

  private Consumer<AskForPoem> displaysRandomPoem() {
    return new DisplayRandomPoem(poemObtainer, lineWriter);
  }
}