package genericsChallenge;

public class Main {

    public static void main(String[] args) {

        Park park = new Park("Yellowstone", "44.4882, -110.5916");
        park.render();
        System.out.println("-".repeat(30));

        var nationalUSParks = new Park[]{
                new Park("Yellowstone", "44.4882, -110.5916"),
                new Park("Grand Canyon", "36.2885, -102.03657"),
                new Park("Yosemite", "37.8855, -119.5360")
        };

        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();
        System.out.println("-".repeat(30));

        var nationalUSRivers = new River[]{
                new River("Mississippi", "44.4882, -110.5916", "44.4882, -110.5916"),
                new River("Missouri", "37.8855, -119.5360", "37.8855, -119.5360")
        };

        Layer<River> riwerLayer = new Layer<>(nationalUSRivers);
        riwerLayer.addElements(new River("Delaware", "37.8855, -119.5360", "37.8855, -119.5360"));
        riwerLayer.renderLayer();

    }
}
