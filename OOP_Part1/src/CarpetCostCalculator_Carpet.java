public class CarpetCostCalculator_Carpet {

    private double cost;


    public CarpetCostCalculator_Carpet(double cost) {
        if (cost < 0) {
            this.cost = 0;
        } else {
            this.cost = cost;
        }
    }

    public double getCost() {
        return cost;
    }
}
