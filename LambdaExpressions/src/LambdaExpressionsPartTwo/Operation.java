package LambdaExpressionsPartTwo;

public interface Operation<T> {
    // For this type, I won't include any bounds, so this interface can be used with any type.

    T operate(T value1, T value2);
    // I'll add a single abstract method, called operate.
    // This interface is a functional interface. It has one single abstract method.

}
