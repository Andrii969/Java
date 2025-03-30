package FinalModifier.main;

import FinalModifier.child.ChildClass;
import FinalModifier.external.Logger;
import FinalModifier.generic.BaseClass;

public class Main {

    public static void main(String[] args) {

        BaseClass parent = new BaseClass();
        ChildClass childClass = new ChildClass();
        BaseClass childReferredToAsBase = new ChildClass();

        System.out.println("parent.recommendedMethod(); >>> ");
        parent.recommendedMethod();
        System.out.println();

        System.out.println("childClass.recommendedMethod(); >>> ");
        childClass.recommendedMethod();
        System.out.println();

        System.out.println("childReferredToAsBase.recommendedMethod(); >>> ");
        childReferredToAsBase.recommendedMethod();
        System.out.println();

        System.out.println("--------");

        System.out.println("parent.recommendedStatic(); >>> ");
        parent.recommendedStatic();
        System.out.println();

        System.out.println("childClass.recommendedStatic(); >>> ");
        childClass.recommendedStatic();
        System.out.println();

        System.out.println("childReferredToAsBase.recommendedStatic(); >>> ");
        childReferredToAsBase.recommendedStatic();
        System.out.println();

        System.out.println("-".repeat(30));

        BaseClass.recommendedStatic();
        System.out.println();
        ChildClass.recommendedStatic();

        System.out.println("-".repeat(30));

        String xArgument = "This is all I've got to say about Section ";
        StringBuilder zArgument = new StringBuilder("Only saying this: Section ");
        doXYZ(xArgument, 16, zArgument);
        System.out.println("After method, xArgument: " + xArgument);
        System.out.println("After method, zArgument: " + zArgument);

        System.out.println("-".repeat(30));

        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(", Step 2 is xyz.");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging, tracker = " + tracker);

    }

    private static void doXYZ(String x, int y, final StringBuilder z) {

        final String c = x + y;
        System.out.println("c = " + c);
        x = c;
        z.append(y);
    }
}
