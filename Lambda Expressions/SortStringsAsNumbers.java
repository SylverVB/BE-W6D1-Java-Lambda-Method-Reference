// Exercise

// Given an array of numbers where every number is represented as string, successfully execute a Java program that sorts these numbers in ascending and descending order, using lambdas.

import java.util.*;

public class SortStringsAsNumbers {

    public static void main(String[] args) {
        // Create a List of Strings that represent numbers
        List<String> numbers = new ArrayList<>();
        numbers.add("10");
        numbers.add("5");
        numbers.add("100");
        numbers.add("25");
        numbers.add("3");

        // Sort in ascending order using lambda expression
        Collections.sort(numbers, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
        System.out.println("Ascending order: " + numbers);

        // Sort in descending order using lambda expression
        Collections.sort(numbers, (a, b) -> Integer.parseInt(b) - Integer.parseInt(a));
        System.out.println("Descending order: " + numbers);
    }
}

// Key Concepts:
// • Lambda Expressions: (a, b) -> Integer.parseInt(a) - Integer.parseInt(b) and (a, b) -> Integer.parseInt(b) - Integer.parseInt(a) are lambdas used to define the comparison logic for sorting the numbers.
// • Integer Parsing: Integer.parseInt() converts the String values to integers for numerical comparison, which is necessary because string sorting doesn't work as expected for numbers.
// • Sorting Mechanism: Collections.sort() uses the comparator passed to it (in this case, the lambda) to determine the sorting order.