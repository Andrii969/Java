package genericsChallenge;

import java.util.Arrays;

public abstract class Line implements Mappable{

    private double[][] locations;

    public Line(String... locations) { // using Line(String... locations) allows to pass one or multiple locations
        this.locations = new double[locations.length][]; // create two-dimensional array with length places
        int index = 0;
        for (var location : locations) { // for each location String
            this.locations[index++] = Mappable.stringToLatLan(location); // return an array of location & assign to two-dimensional array
        }
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }

    private String locations() {
        return Arrays.deepToString(locations); // deepToString as the array is two-dimensional
    };

}