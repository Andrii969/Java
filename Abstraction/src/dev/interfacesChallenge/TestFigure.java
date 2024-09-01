package dev.interfacesChallenge;

public class TestFigure implements Mappable{

    private String label;
    private Geometry shape = Geometry.LINE;
    private String marker = LineMarker.DASHED.toString();

    public TestFigure(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public Geometry getShape() {
        return shape;
    }

    @Override
    public String getMarker() {
        return marker;
    }
}
