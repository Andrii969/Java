public class CarpetCostCalculator_Calculator {

    private CarpetCostCalculator_Floor floor;
    private CarpetCostCalculator_Carpet carpet;

    public CarpetCostCalculator_Calculator(CarpetCostCalculator_Floor floor, CarpetCostCalculator_Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public double getTotalCost() {
        return floor.getArea() * carpet.getCost();
    }


}
