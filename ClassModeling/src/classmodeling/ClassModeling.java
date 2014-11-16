
package classmodeling;
//Create a new NetBeans project called ClassModeling.  Model and create Java classes for the 
//following: 
// 
//1. House 
//2. Student 
//3. Employee 
//4. Manager 
//5. Airplane 
//6. School 
//7. City 
//8. Car 
//9. Truck 
//10. Square 
//11. Circle 
//12. Triangle 
//13. Chair 
//14. Couch 
//15. Table 
// 
//Do the following for each class: 
//1. Define properties ­ determine which will be read/write and which will be read­only 
//2. Implement setters and getters (as appropriate) for each property 
//3. Implement a constructor to initialize some of all of the property values 
//4. Determine what behaviors the class should have and then define (do not implement) the 
//methods associated with each behavior. 
public class ClassModeling {

    public static void main(String[] args) {
        Car car1 = new Car("Ford","Mustang",2002,"Red",305);
        
        System.out.println(car1.getMake());
    }
    
}
