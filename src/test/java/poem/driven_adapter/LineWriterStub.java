package poem.driven_adapter;

import poem.boundary.driven_port.IWriteLines;

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
