package model;

import java.util.Arrays;
import java.util.LinkedList;

public class Face {

	public int[] vertIndices;
	
	public Face(int[] vertIndices) {
		this.vertIndices = vertIndices;
		//System.out.println("Face created");
	}

	@Override
	public String toString() {
		String output = "";
		
		for(int i = 0; i < vertIndices.length; i++) {
			output += vertIndices[i] + " ";
		}
		return output;
	}
}
