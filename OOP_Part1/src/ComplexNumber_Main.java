public class ComplexNumber_Main {

    public static void main(String[] args) {
        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);
        one.add(1,1);
        System.out.println("one.real= " + one.getReal()); // 1+1 = 2
        System.out.println("one.imaginary= " + one.getImaginary()); // 1+1 = 2
        one.subtract(number);
        System.out.println("one.real= " + one.getReal()); // 2-2.5 = -0.5
        System.out.println("one.imaginary= " + one.getImaginary()); //  2.0 - (-1.5) = 2.0 + 1.5 = 3.5
        number.subtract(one);
        System.out.println("number.real= " + number.getReal()); // 2.5 - (-0.5) = 2.5 + 0.5 = 3
        System.out.println("number.imaginary= " + number.getImaginary()); // -1.5 - 3.5 = -5
    }
}
