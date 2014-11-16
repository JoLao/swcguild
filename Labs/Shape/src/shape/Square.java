/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shape;

public class Square extends Shape {
    private double side;
    
    //add @Override keyword otherwise it will
    //not be visible
    @Override
    public double area() {
        return side * side;
    }
    
    @Override
    public double perimeter() {
        return side * 4;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    
    
    
}
