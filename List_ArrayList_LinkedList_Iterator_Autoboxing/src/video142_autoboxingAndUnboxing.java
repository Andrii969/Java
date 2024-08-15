public class video142_autoboxingAndUnboxing {

    public static void main(String[] args) {

        Integer boxedInteger = Integer.valueOf(15); // preferred but unnecessary
        System.out.println(boxedInteger);

        Integer deprecatedBoxing = new Integer(15); // deprecated since JDK 9
        System.out.println(deprecatedBoxing);

        int unboxedInt = boxedInteger.intValue(); // Unnecessary unboxing
        System.out.println(unboxedInt);

        // Automatic
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;
        System.out.println(autoBoxed.getClass().getName());
//        System.out.println(autoUnboxed.getClass().getName());

    }
}
