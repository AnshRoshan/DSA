

## rule for overidding

In Java, when you override a method from a superclass (or implement a method from an interface), you can change the access modifier to be more permissive but not less permissive than the original method. This is known as the "override rule" or the "accessibility rule."

Here's a summary of the rule:

- If a method in a subclass (or implementing class) has the same name, parameter list, and return type as a method in its superclass (or interface), and it has an access modifier that is more permissive (i.e., broader visibility) than the original method, then it's considered an overriding method.

- Access modifiers in Java can be ranked in terms of permissiveness from most permissive to least permissive: `public`, `protected`, default (package-private), and `private`.

- When overriding a method, you can increase the visibility of the method, but you cannot decrease it. In other words:
  - You can override a `protected` or `public` method and make it `public`.
  - You can override a `protected` method and make it `protected` or `public`.
  - You can override a `default` (package-private) method and make it `default`, `protected`, or `public`.
  - You cannot override a method with `private` access modifier, as it's not accessible outside the declaring class.

Here's an example to illustrate this rule:

```java
class Superclass {
    // Original method with protected access modifier
    protected void display() {
        System.out.println("Superclass method");
    }
}

class Subclass extends Superclass {
    // Overriding method with public access modifier (more permissive)
    public void display() {
        System.out.println("Subclass method");
    }
}

public class Main {
    public static void main(String[] args) {
        Subclass obj = new Subclass();
        obj.display(); // Output: Subclass method
    }
}
```

In this example, `Subclass` overrides the `display()` method from `Superclass` and changes its access modifier from `protected` to `public`, which is more permissive. This is allowed by the accessibility rule in Java.

However, if you try to make the access modifier less permissive, such as changing from `public` to `protected` or `private`, it will result in a compilation error because it violates the accessibility rule.