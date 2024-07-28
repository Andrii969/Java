public class Cylinder extends Circle {

    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return super.getArea() * height; //  since the getArea method is not overridden in the Cylinder class,
                                        // you can call it without super. However, using super makes it clear
                                        // that the method is being called from the superclass.
                                        // This can improve code readability and maintainability,
                                        // especially if you later add a method with the same name in the subclass.
    }
}
