/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shape;

public class Rectangle extends Shape {
    private double len;
    private double width;
    
    @Override
    public double area() {
        return len * width;
    }
    
    @Override
    public double perimeter() {
        return (len + width) * 2;
    }

    public double getLen() {
        return len;
    }

    public void setLen(double len) {
        this.len = len;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    
}
