package poem.simple.adapter.driven;

import poem.boundary.port.driven.IWriteLines;

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
