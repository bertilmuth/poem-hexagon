package poem.simple.adapter.driven;

import java.util.Objects;

import poem.boundary.port.driven.IWriteLines;

/**
 * Right-side, driven adapter for writing text to the console.
 * 
 * @author b_muth
 *
 */
public class ConsoleWriter implements IWriteLines {
	public void writeLines(String[] lines) {
		Objects.requireNonNull(lines);
		for (String line : lines) {
			System.out.println(line);
		}
	}
}