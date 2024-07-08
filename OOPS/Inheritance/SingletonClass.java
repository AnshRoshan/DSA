package Inheritance;

/**
 * 1. Private Constructor: Singleton classes have a private constructor to
 * prevent
 * direct instantiation of the class from external classes. This means that the
 * class cannot be instantiated using the new keyword from outside the class.
 * Static Instance: The class provides a static method that returns the same
 * instance of the class every time it's called. This instance is usually
 * created when the class is loaded, or on-demand, and is stored as a static
 * variable.
 * Lazy Initialization (optional): The instance of the Singleton class can be
 * lazily initialized, meaning it is created only when the getInstance() method
 * is called for the first time. This can save resources if the Singleton object
 * is not always needed.
 * Thread Safety (optional): If the Singleton class is used in a multi-threaded
 * environment, precautions need to be taken to ensure that only one instance is
 * created. This can be achieved using synchronized blocks, double-checked
 * locking, or using the initialization-on-demand holder idiom.
 */
class Singleton {
    // Static variable to hold the single instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        // Optional: Initialization code
    }

    // Static method to get the single instance of the class
    public static Singleton getInstance() {
        // Lazy initialization: create the instance if it doesn't exist
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Optional: Other methods of the class
    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");
    }
}

public class SingletonClass {

    public static void main(String[] args) {
        // Get the Singleton instance
        Singleton singleton = Singleton.getInstance();

        // Call methods on the Singleton instance
        singleton.showMessage();
    }
}

/**
 * ### Explanation of the Code:
 * - The `Singleton` class has a private constructor, preventing direct
 * instantiation from outside the class.
 * - The `getInstance()` method provides the single instance of the class. It
 * creates the instance if it doesn't exist (lazy initialization).
 * - The `Main` class demonstrates how to use the Singleton class by calling the
 * `getInstance()` method to get the single instance and then calling methods on
 * that instance.
 * 
 * ### Notes:
 * 
 * - This implementation of the Singleton pattern is not thread-safe. If
 * multiple threads access the `getInstance()` method simultaneously, it may
 * result in the creation of multiple instances of the Singleton class. To make
 * it thread-safe, you can use synchronization or other techniques.
 * - In Java, you can also implement the Singleton pattern using an enum or
 * using the initialization-on-demand holder idiom for lazy initialization
 * without synchronization.
 * 
 * 
 */