package dev2;

// What's interesting about an enum is that underneath, it's really just a class, and each
// of the constants is an instance of that class. We can add fields, methods, and even
// constructors to the enum type. Before you add any methods or
// code in the enum, you have to include a semicolon after the list of values.

public enum Topping {

    MUSTARD,

    PICKLES,

    BACON,

    CHEDDAR,

    TOMATO;

    public double getPrice() {

        return switch (this) {
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.0;
        };
    }
}
