package poem.simple.driven_adapter;

import java.io.PrintStream;
import java.util.Objects;

import poem.boundary.driven_port.IWriteLines;

/**
 * Right-side, driven adapter for writing text to the console.
 * 
 * @author b_muth
 *
 */
public class ConsoleWriter implements IWriteLines {
	@Override
	public void writeLines(String[] lines, Object systemOutput) {
		Objects.requireNonNull(lines);

		if (systemOutput instanceof PrintStream) {
			PrintStream systemOutputStream = ((PrintStream) systemOutput);
			for (String line : lines) {
				systemOutputStream.println(line);
			}
			systemOutputStream.println("");
		} else {
			throw new IllegalArgumentException("systemOutput must be a PrintStream!");
		}
	}
}