package Java.OOPS.Interfaces;

public class PowerEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Power engine start");
    }

    @Override
    public void stop() {
        System.out.println("Power engine stop");
    }

    @Override
    public void accelarate() {
        System.out.println("Power engine accelerate");
    }

    @Override
    public void decelarate() {
        // TODO Auto-generated method stub
        System.out.println("Power engine decelarate");

    }
}