package maze;

import graph.Vertex;

public class Cell extends Vertex{

	public int x,y;
	
	public String type;
	
	public Cell(String type, int x, int y) {
		this.x=x;
		this.y=y;
		this.type=type;
	}
	
	public Cell(int x, int y) {
		this.x=x;
		this.y=y;
	}

}
