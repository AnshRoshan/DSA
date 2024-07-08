package Abstract;

public class Main {

    public static void main(String[] args) {

        Son s = new Son(99);
        // The static method greeting() from the type Parents should be accessed in a
        // static way ,by using the class name not the object of the class
        // s.greeting();
        s.age();
        s.name();
        s.relationship();
        s.salary();

        Daughter d = new Daughter(101);
        Parents.greeting();
        Parents.greeting();
        d.age();
        d.name();
        d.relationship();
        d.salary();

    }
}
