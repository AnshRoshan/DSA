package Java.OOPS.Abstract;

public abstract class Parents {

    static int a = 0;

    static void greeting() {
        System.out.println("Hello from the static method number --> " + a);
    }

    int life = 90;

    Parents(int a) {
        ++Parents.a;
        greeting();
        this.life = a;
    }

    // Abstract method
    public abstract void age();

    public abstract void name();

    abstract void salary();

    abstract void relationship();
}
