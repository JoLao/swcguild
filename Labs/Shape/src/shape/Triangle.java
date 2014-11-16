/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shape;

/**
 *
 * @author apprentice
 */
public class Triangle extends Shape {
    private double width;
    private double height;
    
    @Override
    public double area() {
        return (width * height) / 2;
    }
    
    @Override
    public double perimeter() {
        double side =  Math.sqrt(((width*width/4) + height*height));
        return side * 3;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    
    
}
