package Java.OOPS.Inheritance;

// Parent class
class Parent {
    private int privateVarParent;
    protected int protectedVarParent;
    public int publicVarParent;

    public Parent() {
        System.out.println("Parent constructor");
        privateVarParent = 10;
        protectedVarParent = 20;
        publicVarParent = 30;
    }

    private void privateMethodParent() {
        System.out.println("Private method in Parent");
    }

    protected void protectedMethodParent() {
        System.out.println("Protected method in Parent");
    }

    public void publicMethodParent() {
        System.out.println("Public method in Parent");
    }

    public void accessVariablesAndMethods() {
        System.out.println("Accessing variables and methods of Parent class:");
        System.out.println("Private variable: " + privateVarParent); // Accessible only within the same class
        privateMethodParent(); // Accessible only within the same class
        System.out.println("Protected variable: " + protectedVarParent); // Accessible within the same package and
                                                                         // subclasses
        protectedMethodParent(); // Accessible within the same package and subclasses
        System.out.println("Public variable: " + publicVarParent); // Accessible from anywhere
        publicMethodParent(); // Accessible from anywhere
    }
}

// Child class
class Child extends Parent {
    private int privateVarChild;
    protected int protectedVarChild;
    public int publicVarChild;

    public Child() {
        System.out.println("Child constructor");
        privateVarChild = 100;
        protectedVarChild = 200;
        publicVarChild = 300;
    }

    private void privateMethodChild() {
        System.out.println("Private method in Child");
    }

    protected void protectedMethodChild() {
        System.out.println("Protected method in Child");
    }

    public void publicMethodChild() {
        System.out.println("Public method in Child");
    }

    public void accessVariablesAndMethods() {
        System.out.println("Accessing variables and methods of Child class:");
        // Accessing variables and methods from Parent class
        // System.out.println("Private variable: " + privateVarParent); // Error:
        // privateVarParent has private access in Parent
        // privateMethodParent(); // Error: privateMethodParent() has private access in
        // Parent
        System.out.println("Protected variable: " + protectedVarParent);
        // Accessible within the same package and
        // subclasses
        protectedMethodParent(); // Accessible within the same package and subclasses
        System.out.println("Public variable: " + publicVarParent); // Accessible from anywhere
        publicMethodParent(); // Accessible from anywhere

        // Accessing variables and methods from Child class
        System.out.println("Private variable: " + privateVarChild); // Accessible only within the same class
        privateMethodChild(); // Accessible only within the same class
        System.out.println("Protected variable: " + protectedVarChild); // Accessible within the same package and
                                                                        // subclasses
        protectedMethodChild(); // Accessible within the same package and subclasses
        System.out.println("Public variable: " + publicVarChild); // Accessible from anywhere
        publicMethodChild(); // Accessible from anywhere
    }
}

// Main class
public class Inheritances {

    public static void main(String[] args) {
        // Creating objects
        Parent parentObj = new Parent();
        Child childObj = new Child();

        // Accessing variables and methods
        parentObj.accessVariablesAndMethods();
        System.out.println("------------------------------");
        childObj.accessVariablesAndMethods();
    }
}
