package genericsChallenge;

import java.util.Arrays;

public abstract class Point implements Mappable{ // Because this class is abstract, I don't actually have to implement the Mappable's
                                                // abstract method. Any class that extends this abstract class will be required to
                                                // implement render, if I don't do it here.

    private double[] location = new double[2];

    public Point(String location) {
        this.location = Mappable.stringToLatLan(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + location() + ")"); // this = the string representation
                                                                                // of the class that's calling this method,
    }

    private String location() {
        return Arrays.toString(location);
    };
}
