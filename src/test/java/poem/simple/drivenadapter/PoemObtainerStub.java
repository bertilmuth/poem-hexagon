package poem.simple.drivenadapter;

import poem.hexagon.boundary.drivenport.IObtainPoems;

public class PoemObtainerStub implements IObtainPoems {
	public static final String ENGLISH_POEM = "Random english poem.";
	public static final String GERMAN_POEM = "Random german poem.";

	@Override
	public String[] getMePoems(String language) {
		if ("de".equals(language)) {
			return new String[] { GERMAN_POEM };
		} else {
			return new String[] { ENGLISH_POEM };
		}
	}
}
