package genericsChallenge;

public interface Mappable {

    void render();

    static double[] stringToLatLan(String location) {
        var splits = location.split(",");
        double lat = Double.parseDouble(splits[0]);
        double lng = Double.parseDouble(splits[1]);
        return new double[]{lat, lng};
    }




}
