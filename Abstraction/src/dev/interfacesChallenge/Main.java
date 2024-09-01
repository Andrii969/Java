package dev.interfacesChallenge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        TestFigure figure = new TestFigure("nice figure");
//        Mappable.mapIt(figure);

        Building building = new Building("Test Building", UsageType.ENTERTAINMENT);
        List<Mappable> mappables = new ArrayList<>();
        mappables.add(building);
        mappables.add(new Building("Sydney Town Hall", UsageType.GOVERNMENT));
        mappables.add(new Building("Sydney Opera House", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Stadium Australia", UsageType.SPORTS));
        mappables.add(new UtilityLine("College St", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("Olympic Blvd", UtilityType.WATER));


        for (var m : mappables) {
            Mappable.mapIt(m);
        }


    }
}
