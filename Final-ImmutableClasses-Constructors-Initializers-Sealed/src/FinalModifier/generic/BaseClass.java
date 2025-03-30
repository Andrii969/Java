package FinalModifier.generic;

public class BaseClass {

    public final void recommendedMethod() {
        System.out.println("BaseClass It's Recommended Method");
        optionalMethod();
        mandatoryMethod();
    }

    protected void optionalMethod() {
        System.out.println("BaseClass It's Optional Method");
    }

    private void mandatoryMethod() {
        System.out.println("BaseClass It's Mandatory Method");
    }

    public static void recommendedStatic() {
        System.out.println("BaseClass It's Recommended Static");
        optionalStatic();
        mandatoryStatic();
    }

    protected static void optionalStatic() {
        System.out.println("BaseClass It's Optional Static");
    }

    private static void mandatoryStatic() {
        System.out.println("BaseClass It's Mandatory Static");
    }

}
