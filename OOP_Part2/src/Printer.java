public class Printer {

    private int tonerLevel; // percentage
    private int pagesPrinted; // zero by default
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.duplex = duplex;
    }

//    public int addToner(int tonerAmount) {
//        if (tonerAmount < 0 || tonerAmount > 100) {
//            return -1;
//        };
//        if ((this.tonerLevel + tonerAmount) > 100) {
//            return -1;
//        }
//        this.tonerLevel += tonerAmount;
//        return this.tonerLevel;
//    }

    public int addToner(int tonerAmount) {

        if (tonerAmount > 0 && tonerAmount <= 100) {
            if (this.tonerLevel + tonerAmount > 100) {
                return -1;
            }
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        } else {
            return -1;
        }
    }

    public int printPages(int pages) {

        int jobPages = (duplex) ? (pages / 2) + (pages % 2) : pages;
        pagesPrinted += jobPages;
        return jobPages;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

}
