public class CarpetCostCalculator_Main {

    public static void main(String[] args) {
        CarpetCostCalculator_Carpet carpet = new CarpetCostCalculator_Carpet(3.5);
        CarpetCostCalculator_Floor floor = new CarpetCostCalculator_Floor(2.75, 4.0);
        CarpetCostCalculator_Calculator calculator = new CarpetCostCalculator_Calculator(floor, carpet);
        System.out.println("total= " + calculator.getTotalCost());
        carpet = new CarpetCostCalculator_Carpet(1.5);
        floor = new CarpetCostCalculator_Floor(5.4, 4.5);
        calculator = new CarpetCostCalculator_Calculator(floor, carpet);
        System.out.println("total= " + calculator.getTotalCost());
    }

}

