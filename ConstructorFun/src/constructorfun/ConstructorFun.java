
package constructorfun;


public class ConstructorFun {

    public static void main(String[] args) {
       Dog dog1 = new Dog("Fido");
       dog1.setName("Fido");
       dog1.bark();
       
       Retriever ret1 = new Retriever("Buster");
       ret1.setName("Buster");
       ret1.bark();
       ret1.hunt();
    }
    
}
