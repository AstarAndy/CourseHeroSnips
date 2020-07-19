package com.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * BoundingBox - screening problem for Even Financial
 * @author [redacted]
 */
public class BoundingBox {

	private static final char CHECKED = 'x';
	
	public static List<Box> getMinimumBoundingBoxes(char[][] input, int numOfRows, int numOfCols) {
		List<Box> boxes = new ArrayList<>();
		// Iterate through every cell in 2D array
		for(int i=0; i < numOfRows; i++) {
			for(int j=0; j < numOfCols; j++) {
				if(input[i][j] == CHECKED) { // skip checked cell
					continue;
				}else if(input[i][j] == '-') { // mark the cell as visited if it's a hyphen
					input[i][j] = CHECKED;
				}else { // check for potential bounding box for asterisk
					Box box = findBox(input, i, j, numOfRows, numOfCols);
					if(box.size > 1) { // bounding box has to have size > 1
						addToListIfNotOverlapping(boxes, box);
					}
				}
			}
		}
		
		Collections.sort(boxes);
		List<Box> result = new ArrayList<>();
		
		if(boxes.size() > 0) {
			Box largest = boxes.remove(0);
			result.add(largest);
			for(Box box : boxes) {
				if(box.size == largest.size)
					result.add(box);
			}
		}
		
		return result;
	}
	
	public static void addToListIfNotOverlapping(List<Box> boxes, Box target) {
		// check existing registered boxes and remove any overlapping one with target box
		boolean isOverlapping = boxes.removeIf(box -> checkOverlapping(box, target));
		if(!isOverlapping) {
			boxes.add(target);
		}
	}
	
	public static boolean checkOverlapping(Box box1, Box box2) {
		if(box1.left > box2.right || box1.right < box2.left) {
			return false;
		}
		if(box1.top > box2.bottom || box1.bottom < box2.top ) {
			return false;
		}
		return true;
	}
	
	public static Box findBox(char[][] input, int rowNum, int colNum, int numOfRows, int numOfCols) {
		Box box = new Box(rowNum, rowNum, colNum, colNum);
		updateBox(input, rowNum, colNum, numOfRows, numOfCols, box);
		box.calcSize();
		return box;
	}
	
	// recursively check adjacent cells and update the bounding box
	public static void updateBox(char[][] input, int rowNum, int colNum, int numOfRows, int numOfCols, Box box) {
		input[rowNum][colNum] = CHECKED;
		
		if(rowNum != 0 && input[rowNum-1][colNum] == '*'){
			box.top = Math.min(box.top, rowNum-1);
			updateBox(input, rowNum-1, colNum, numOfRows, numOfCols, box);
		}
		if(rowNum != numOfRows-1 && input[rowNum+1][colNum] == '*') {
			box.bottom = Math.max(box.bottom, rowNum+1);
			updateBox(input, rowNum+1, colNum, numOfRows, numOfCols, box);
		}
		if(colNum > 0 && input[rowNum][colNum-1] == '*') {
			box.left = Math.min(box.left, colNum-1);
			updateBox(input, rowNum, colNum-1, numOfRows, numOfCols, box);
		}
		if(colNum != numOfCols-1 && input[rowNum][colNum+1] == '*') {
			box.right = Math.max(box.right, colNum+1);
			updateBox(input, rowNum, colNum+1, numOfRows, numOfCols, box);
		}
	}
	
	private static class Box implements Comparable<Box>{
		
		int top;
		int bottom;
		int left;
		int right;
		int size;
		
		public Box(int top, int bottom, int left, int right) {
			this.top = top;
			this.bottom = bottom;
			this.left = left;
			this.right = right;
		}
		
		public void calcSize() {
			int length = 1 + (right - left);
			int height = 1 + (bottom - top);
			size = length*height;
		}
		
		@Override
		public String toString() {
			return String.format("(%d,%d)(%d,%d)",top+1, left+1, bottom+1, right+1);
		}

		@Override
		public int compareTo(Box o) {
			if(o == null)
				return 1;
			else 
				return o.size - this.size; // descending order
		}
		
	}
	
	public static void main(String... args) {
		
		int lineLength = 0;
		int numLines = 0;
		List<char[]> lines = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String line;
			while((line = br.readLine()) != null) {
				line = line.trim();
				if(line.length() > 0) {
					lines.add(line.toCharArray());
					lineLength = line.length();
					numLines++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		String[] strArray = new String[10];
		
		
		char[][] inputArr = new char[numLines][lineLength];
		for(int i = 0; i<numLines; i++) {
			char[] lineArr = lines.get(i);
			inputArr[i] = lineArr; 
		}
		
		List<Box> result = getMinimumBoundingBoxes(inputArr, numLines, lineLength);
		for(Box box : result) {
			System.out.println(box);
		}
	}
}
