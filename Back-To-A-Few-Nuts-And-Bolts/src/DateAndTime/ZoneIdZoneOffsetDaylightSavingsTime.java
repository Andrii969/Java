package DateAndTime;

import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class ZoneIdZoneOffsetDaylightSavingsTime {

    public static void main(String[] args) {

        System.out.println(ZoneId.systemDefault());
        System.out.println("Number of TZs = " + ZoneId.getAvailableZoneIds().size());

//        ZoneId.getAvailableZoneIds().stream()
//                .filter(tz -> tz.startsWith("Europe"))
//                .sorted().forEach(System.out::println);

//        ZoneId.getAvailableZoneIds().stream()
//                .filter(tz -> tz.startsWith("Europe"))
//                .sorted()
//                .map(ZoneId::of)
//                .forEach(zoneId -> System.out.println(zoneId.getId() + ": " + zoneId.getRules()));

        Set<String> jdk8Zones = ZoneId.getAvailableZoneIds();
        String[] alternate = TimeZone.getAvailableIDs();
        Set<String> oldway = new HashSet<>(Set.of(alternate));
        System.out.println(jdk8Zones.size());
        oldway.removeAll(jdk8Zones);
        System.out.println(oldway);

        ZoneId bet = ZoneId.of("BET", ZoneId.SHORT_IDS);
        System.out.println(bet);



    }
}
