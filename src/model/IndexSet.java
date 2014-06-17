package model;

import java.util.Arrays;
import java.util.LinkedList;

public class IndexSet {

	int[] indices;
	
	public int[] getIndices() {
		return indices;
	}
	
	public IndexSet(int[] vertIndices) {
		this.indices = vertIndices;
		//System.out.println("Face created");
	}

	@Override
	public String toString() {
		String output = "";
		
		for(int i = 0; i < indices.length - 1; i++) {
			output += indices[i] + " ";
		}
		output += indices[indices.length - 1];
		return output;
	}
}
