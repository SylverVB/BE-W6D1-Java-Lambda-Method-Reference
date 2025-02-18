// Exercise:
// • Complete the commented line below with a method reference call to "addition."
// • Compile, test, and run the program.


import java.util.function.BiFunction;

public class StaticMethodReference {

    public static void main(String[] args) {

        // Option 1: Method reference to the static method "addition"
        BiFunction<Integer, Integer, Integer> customFI = StaticMethodReference::addition;

        // Option 2: Using a lambda expression to add two integers
        // BiFunction<Integer, Integer, Integer> customFI = (a, b) -> a + b;

        int sum = customFI.apply(10, 20);
        System.out.println("Addition: " + sum);

    }

    // Static method to add two integers
    public static int addition(int a, int b) {
        return a + b;
    }
}

// Explanation of the Code:

// 1. BiFunction<Integer, Integer, Integer>:

// • BiFunction is a functional interface that takes two arguments of type Integer and returns a result of type Integer.
// • Its method, apply(T t, U u), is used to invoke the referenced method.

// 2. Option 1: StaticMethodReference2::addition:

// • This is a method reference to the static method addition in the StaticMethodReference2 class.
// • It matches the BiFunction functional interface because the method addition(int a, int b) takes two int arguments and returns an int.

// 3. Lambda expression (a, b) -> a + b: (Option 2):

// • The lambda (a, b) defines two parameters a and b, which are the two integers to be added.
// • The expression a + b performs the addition and returns the result.
// • Instead of referring to the static method addition using StaticMethodReference2::addition, we directly specify the logic of addition in the lambda.

// 4. customFI.apply(10, 20):

// • This calls the apply method of the BiFunction interface, which internally invokes the addition method.
// • 10 and 20 are passed as arguments to the addition method.

// 5. Static Method:

// • addition is declared static, so it can be referenced directly through the class name without needing an instance of the class.



// Comparison of Lambda and Method Reference

// 1. Using Lambda

// BiFunction<Integer, Integer, Integer> customFI = (a, b) -> a + b;

// • Here, the lambda defines the logic directly. This is useful if you don't have or need a predefined method like addition.

// 2. Using Method Reference

// BiFunction<Integer, Integer, Integer> customFI = StaticMethodReference2::addition;

// • This approach reuses the addition method. It's concise and avoids rewriting the same logic, relying instead on an already-tested and reusable utility function.

// Why Use Method Reference If Lambda Works?
// • Reusability: The addition method might already exist in your project or a utility class. By using a method reference, you avoid duplicating logic.
// • Readability: A method reference like StaticMethodReference2::addition tells the reader exactly what the logic is (addition in this case). With a lambda, you might have to read and understand the expression.
// • Maintainability: If the logic for addition changes, you only need to update the addition method. Every place using the method reference will automatically reflect the change.

// When Should You Use Lambda Instead?

// • If the logic is unique to a specific context and not reused elsewhere.
// • If adding a separate static method for simple logic would clutter your codebase unnecessarily.

// Both approaches are correct, and which one to use depends on the context and your preference for code clarity or conciseness.