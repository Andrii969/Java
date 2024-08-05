package dev.lpa;

public class video119_ArraysPart1 {

        public static void main(String[] args) {

            int[] myIntArray = new int[10]; // the size can't be changed after the array is instantiated;
            myIntArray[5] = 50;

            double[] myDoubleArray = new double[10];
            myDoubleArray[2] = 3.5;
            System.out.println(myDoubleArray[2]);

            int[] firstFivePositives = new int[] {1,2,3,4,5};

            int[] nextFivePositives = {6,7,8,9,10}; // anonymous array
            System.out.println("sixth = " + nextFivePositives[0]);
            int nextFivePositivesLength = nextFivePositives.length;
            System.out.println("nextFivePositivesLength = " + nextFivePositivesLength);
            System.out.println("last = " + nextFivePositives[nextFivePositivesLength - 1]);

            int[] newArray;
            newArray = new int[] {1,2,3,4,5};

            for (int i = 0; i < newArray.length; i++) {
                System.out.println("newArray index" + i + " = " + newArray[i]);
            }
        }
    }
