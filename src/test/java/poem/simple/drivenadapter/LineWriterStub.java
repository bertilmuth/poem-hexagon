package poem.simple.drivenadapter;

import poem.hexagon.boundary.drivenport.IWriteLines;

public class LineWriterStub implements IWriteLines {
	private String[] lines;

	@Override
	public void writeLines(String[] lines) {
		this.lines = lines;
	}

	public String[] getLines() {
		return lines;
	}
}
