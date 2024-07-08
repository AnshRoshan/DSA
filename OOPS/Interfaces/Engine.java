package Interfaces;

public interface Engine {

    // it is already a constant so no need for static final
    static final int PRICE = 990000;
    // int PRICE = 990000;

    public static int getPRICE() {
        return PRICE;
    }

    void start();

    void stop();

    void accelarate();

    void decelarate();

}
