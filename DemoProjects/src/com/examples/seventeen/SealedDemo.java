package com.examples.seventeen;

public class SealedDemo {

	public static void main(String[] args) {
		Shape triangleShape =new Triangle();
		triangleShape.area();
		
		Shape circleShape = new Circle();
		circleShape.area();
		
		Shape squareShape = new Square();
		squareShape.area();
		
		ColouredSquare colouredSquare = new ColouredSquare();
		colouredSquare.printSquareColor();
		
	}

}
