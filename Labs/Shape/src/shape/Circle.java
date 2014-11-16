/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shape;


public class Circle extends Shape {
    private double radius;
    
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
    
    @Override
    public double perimeter() {
        return Math.PI * radius * 2;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
}
