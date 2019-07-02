package poem.boundary.driven_port;

/**
 * Driven, right side port for writing the lines of a poem to an output device
 * outside the hexagon, e.g. the console.
 * 
 * @author b_muth
 *
 */
public interface IWriteLines {
	void writeLines(String[] strings);
}