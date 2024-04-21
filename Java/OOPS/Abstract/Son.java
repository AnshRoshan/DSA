package Java.OOPS.Abstract;

public class Son extends Parents {

    Son(int a) {
        super(a);
    }

    @Override
    public void age() {
        System.out.println("Son's age is 5");

    }

    @Override
    public void name() {
        System.out.println("Son's name is Sonu");

    }

    @Override
    void relationship() {
        System.out.println("he is single");
    }

    @Override
    void salary() {
        System.out.println("he is not working");
    }

}
