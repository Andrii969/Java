public class Wall {

    private double width;
    private double height;


    public Wall() {

    }

    public Wall(double width, double height) { // constructor declaration
        setWidth(width); // setter methods called
        setHeight(height); // setter methods called


        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) { // setter method with validation
        if (width < 0) {
            this.width = 0;
        } else {
            this.width = width;
        }
    }

    public void setHeight(double height) { // setter method with validation
        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }

    public double getArea() {
        return width * height;
    }

}
