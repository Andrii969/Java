public class Printer_Main {

    public static void main(String[] args) {
//        Printer duplexPrinter = new Printer(50, true);
//        System.out.println("initial page count = " + duplexPrinter.getPagesPrinted());
//        int pagesPrintedOnDuplexPrinter = duplexPrinter.printPages(5);
//        System.out.printf("Current Job Pages: %d, Printed Total: %d %n", pagesPrintedOnDuplexPrinter, duplexPrinter.getPagesPrinted());
//        pagesPrintedOnDuplexPrinter = duplexPrinter.printPages(10);
//        System.out.printf("Current Job Pages: %d, Printed Total: %d %n", pagesPrintedOnDuplexPrinter, duplexPrinter.getPagesPrinted());
//
//        Printer printer = new Printer(50, false);
//        System.out.println("initial page count = " + printer.getPagesPrinted());
//        int pagesPrinted = printer.printPages(5);
//        System.out.printf("Current Job Pages: %d, Printed Total: %d %n", pagesPrinted, printer.getPagesPrinted());
//        pagesPrinted = printer.printPages(10);
//        System.out.printf("Current Job Pages: %d, Printed Total: %d %n", pagesPrinted, printer.getPagesPrinted());

        Printer printer = new Printer(50, false);
        System.out.println(printer.addToner(51));


    }
}
