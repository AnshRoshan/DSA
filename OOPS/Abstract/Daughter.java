package Abstract;

public class Daughter extends Parents {

    Daughter(int a) {
        super(a);
    }

    @Override
    public void age() {
        System.out.println("Daughter's age is 30");
    }

    @Override
    public void name() {
        System.out.println("Daughter's name is Sonali");
    }

    @Override
    void relationship() {
        System.out.println("she is married");
    }

    @Override
    void salary() {
        System.out.println("she is working in 10000");
    }

}
