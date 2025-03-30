package FinalModifier.child;

import FinalModifier.generic.BaseClass;

public class ChildClass extends BaseClass {

    @Override
    protected void optionalMethod() {
        System.out.println("<ChildClass Override optionalMethod()>");
        super.optionalMethod();
    }

    public static void recommendedStatic() {
        System.out.println("ChildClass It's Recommended Static");
        optionalStatic();
    }
}
