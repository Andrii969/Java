public class SmartKitchen_Main {

    public static void main(String[] args) {

//        CoffeeMaker myCoffeeMaker = new CoffeeMaker();
//        DishWasher myDishWasher = new DishWasher();
//        Refrigerator myRefrigerator = new Refrigerator();
//        SmartKitchen kitchen = new SmartKitchen(myCoffeeMaker, myDishWasher, myRefrigerator);

        SmartKitchen kitchen = new SmartKitchen();
        kitchen.setKitchenState(true, true, true);
        kitchen.doKitchenWork();
//        kitchen.getBrewMaster().brewCoffee();
//        kitchen.getDishWasher().doDishes();
//        kitchen.getIceBox().orderFood();

    }
}
