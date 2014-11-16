/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shape;


public class ShapeTest {
    public static void main(String[] args) {
        Square sq = new Square();
        sq.setName("Square");
        sq.setColor("Blue");
        sq.setSide(4);        
        getAnswer(sq);
        
        
        Rectangle rect = new Rectangle();
        rect.setName("Rectangle");
        rect.setColor("Green");
        rect.setLen(10);
        rect.setWidth(20);
        getAnswer(rect);
        
        Triangle tri = new Triangle();
        tri.setName("Triangle");
        tri.setColor("Orange");
        tri.setHeight(8);
        tri.setWidth(12);
        getAnswer(tri);
        
        Circle circ = new Circle();
        circ.setName("Circle");
        circ.setColor("Red");
        circ.setRadius(10);
        getAnswer(circ);
        
    }
    public static void getAnswer(Shape s) {
        System.out.println(" ");
        System.out.println("The shape is "+s.getName());
        System.out.println("Color is "+s.getColor());
        System.out.println("Area is "+s.area());
        System.out.println("Perimeter is "+s.perimeter());
    }
}
