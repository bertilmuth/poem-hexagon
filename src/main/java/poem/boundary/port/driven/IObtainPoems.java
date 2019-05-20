package poem.boundary.port.driven;

/**
 * Driven, right side port for obtaining poems, e.g. from a repository outside
 * the hexagon.
 * 
 * @author b_muth
 *
 */
public interface IObtainPoems {
	String[] getMePoems(String language);
}