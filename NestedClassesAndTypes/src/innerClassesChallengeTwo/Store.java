package innerClassesChallengeTwo;

public class Store {

    public static void main(String[] args) {

        Meal regularMeal = new Meal();
        System.out.println(regularMeal);

        Meal USRegularMeal = new Meal(0.68);
        USRegularMeal.addToppings("CHEESE", "Bacon", "Mayo", "Cheddar");
        System.out.println(USRegularMeal);
    }
}