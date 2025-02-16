# **Lambda Expressions in Java**

## **1. Introduction to Lambda Expressions**
Lambda expressions in Java provide a concise way to represent **anonymous functions**. They enable functional programming by allowing behavior to be passed as arguments. Lambda expressions work with **functional interfaces**, which contain exactly **one abstract method**.

---

## **2. Functional Interfaces and Lambdas**

### **What is a Functional Interface?**
A **functional interface** is an interface with only **one abstract method**. It may contain **default** and **static** methods, but only one abstract method.

#### **Example: Functional Interface**
```java
@FunctionalInterface
public interface MathOperation {
    int apply(int a, int b);  // Single abstract method
}
```
The `@FunctionalInterface` annotation is optional but ensures that the interface has only one abstract method.

### **What is a Lambda Expression?**
A **lambda expression** provides a way to implement the abstract method of a functional interface concisely.

#### **Syntax**
```java
(parameters) -> expression
```

#### **Example: Lambda Expression**
```java
MathOperation addition = (a, b) -> a + b;  // Lambda expression for addition
```
- `(a, b) -> a + b` is a **lambda expression**.
- It **implements** the `apply` method of `MathOperation`.

---

## **3. How Functional Interfaces and Lambdas Work Together**
Functional interfaces and lambdas allow behavior to be **passed as arguments** or **returned from methods**.

### **Example: Using a Lambda Expression with a Functional Interface**
```java
@FunctionalInterface
public interface MathOperation {
    int apply(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Using a lambda to implement MathOperation
        MathOperation addition = (a, b) -> a + b;
        MathOperation multiplication = (a, b) -> a * b;

        System.out.println("Addition: " + addition.apply(10, 5));  // 15
        System.out.println("Multiplication: " + multiplication.apply(10, 5));  // 50
    }
}
```

### **How it Works**
- `MathOperation` is a **functional interface**.
- `(a, b) -> a + b` and `(a, b) -> a * b` are **lambda expressions** that implement the `apply` method.

---

## **4. Using Built-in Functional Interfaces**
Java provides several built-in functional interfaces, such as:
- **Consumer<T>** (takes input, no return)
- **Function<T, R>** (takes input, returns output)
- **Predicate<T>** (returns boolean)
- **Supplier<T>** (returns a value)

### **Example: Using `Consumer<T>`**
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerLambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using a lambda expression with Consumer
        Consumer<String> greet = name -> System.out.println("Hello, " + name);

        // Using forEach() with Consumer
        names.forEach(greet);
    }
}
```
**Explanation:**
- `Consumer<String>` has a single method **accept()**.
- `name -> System.out.println("Hello, " + name)` is a lambda implementing **accept()**.
- `names.forEach(greet)` applies it to each name in the list.

---

## **5. Lambda Expressions as Method Arguments**
Lambda expressions can be passed as **arguments to methods**.

### **Example: Passing a Lambda as an Argument**
```java
@FunctionalInterface
public interface BinaryCalculator {
    int binaryOperation(int value1, int value2);
}

public class LambdaAsArgumentExample {
    public static void printBinaryResult(int a, int b, BinaryCalculator func) {
        int result = func.binaryOperation(a, b);
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Using lambda expressions as arguments
        printBinaryResult(3, 4, (a, b) -> a + b);  // Prints 7
        printBinaryResult(3, 4, (a, b) -> a * b);  // Prints 12
    }
}
```
**Explanation:**
- `printBinaryResult` takes a **functional interface** (`BinaryCalculator`) as a parameter.
- Lambda expressions implement **binaryOperation()**.

---

## **6. Using Lambdas with Collections**
Lambdas simplify operations on collections, such as **sorting**.

### **Example: Sorting with Lambda Expressions**
```java
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class LambdaSortExample {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("10", "5", "100", "25", "3");

        // Sorting using a lambda expression
        Collections.sort(numbers, (a, b) -> a.compareTo(b));

        System.out.println("Sorted: " + numbers);
    }
}
```
**Explanation:**
- `(a, b) -> a.compareTo(b)` implements **Comparator** to sort elements.

---

## **7. Syntax of Lambda Expressions**
Lambda expressions in Java follow specific syntax rules.

### **General Syntax**
```java
(parameters) -> { body }
```

### **Key Syntax Rules**
#### **1. Parentheses for Parameters**
- **Single Parameter:** Parentheses **can** be omitted.
  ```java
  a -> a * 2
  ```
- **Multiple Parameters:** Parentheses are **required**.
  ```java
  (a, b) -> a + b
  ```

#### **2. Parameter Types**
- Explicit types:
  ```java
  (int a, int b) -> a + b
  ```
- Inferred types:
  ```java
  (a, b) -> a + b
  ```

#### **3. No Parameters**
```java
() -> System.out.println("Hello, World!")
```

#### **4. Curly Braces**
- **Single Expression (No Curly Braces)**
  ```java
  (a, b) -> a + b
  ```
- **Multiple Statements (Curly Braces Required)**
  ```java
  (a, b) -> {
      int sum = a + b;
      return sum;
  }
  ```

#### **5. Return Statement**
- **Single-line Body (No `return`)**
  ```java
  (x, y) -> x * y
  ```
- **Multi-line Body (Explicit `return` required)**
  ```java
  (x, y) -> {
      int result = x * y;
      return result;
  }
  ```

#### **6. Accessing Variables**
Lambdas can access **effectively final** variables (unchanged after initialization).

```java
int multiplier = 2;
Function<Integer, Integer> multiply = a -> a * multiplier;
```

---

## **8. Invalid Lambda Syntax**
🚫 **Incorrect: Missing parentheses with multiple parameters**
```java
a, b -> a + b  // ❌ Incorrect
```

🚫 **Incorrect: Using `return` without braces**
```java
(a, b) -> return a + b;  // ❌ Incorrect
```

---

## **9. Benefits of Lambda Expressions**
✅ **Conciseness** – Reduces boilerplate code.  
✅ **Flexibility** – Pass behavior as arguments.  
✅ **Readability** – Easier to understand.  
✅ **Functional Programming** – Supports functional-style coding.

---

## **10. Summary**
| Feature | Explanation |
|---------|------------|
| **Functional Interface** | An interface with a single abstract method. |
| **Lambda Expression** | A concise way to express instances of functional interfaces. |
| **Built-in Functional Interfaces** | `Consumer`, `Function`, `Predicate`, etc. |
| **Advantages** | Improves readability, reduces verbosity, enables functional programming. |

By following these concepts, you can effectively use lambda expressions in Java!