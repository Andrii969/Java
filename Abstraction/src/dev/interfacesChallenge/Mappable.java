package dev.interfacesChallenge;

public interface Mappable {

    String JSON_PROPERTY = """ 
            "properties": {%s} """;
    // String JSON_PROPERTY is public static final

    String getLabel();

    Geometry getShape();

    String getMarker();

    default String toJSON() { // default toJSON() method, classes don't have to override it, but they can do it, to change the output
        return """
                "type": "%s", "label": "%s", "marker": "%s" """.formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
    // Choosing static for mapIt:
    //Ensures it can be called without an instance (Mappable.mapIt(...)).
    //Prevents unnecessary redundancy of implementing or overriding the method in each class.
    //Organizes utility methods that are directly related to the interface without polluting the namespace of implementing classes.

}
