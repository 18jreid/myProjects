package CS3100_Assign4;

import java.text.DecimalFormat;
import java.util.HashMap;

public class MyTable {
    HashMap<Integer, Integer> myHashTable;
    private final Bpp calculator = new Bpp();
    private double startTime;
    private double endTime;

    MyTable() {
        this.myHashTable = new HashMap<>();
    }

    /***
     * Inserts calculated decimal place digit into hash table.
     * @param myDigit decimal place digit to be calculated.
     */
    void insertDigit(int myDigit) {
        int calculatedDigit = calculateDigit(myDigit);
        this.myHashTable.put(myDigit, calculatedDigit);

        if ((this.myHashTable.size()) % 10 == 0) {
            System.out.flush();
            System.out.print(".");
        }
    }

    /***
     * Calculates desired decimal place digit.
     * @param digit
     * @return
     */
    int calculateDigit(int digit) {
        return calculator.getDecimal(digit);
    }

    /***
     * Prints entire calculated PI.
     */
    void printPi() {
        stopClock();
        StringBuilder builder = new StringBuilder("\n3.");
        for (int i = 1; i < myHashTable.size() + 1; i++) {
            builder.append(myHashTable.get(i));
        }

        System.out.print("\nThe value of pi up to 1000 decimals is: ");
        System.out.println(builder.toString());
        String testPi = "\n3.14159265358979323846264338327950288419716939937510" +
                "58209749445923078164062862089986280348253421170679" +
                "82148086513282306647093844609550582231725359408128" +
                "48111745028410270193852110555964462294895493038196" +
                "44288109756659334461284756482337867831652712019091" +
                "45648566923460348610454326648213393607260249141273" +
                "72458700660631558817488152092096282925409171536436" +
                "78925903600113305305488204665213841469519415116094" +
                "33057270365759591953092186117381932611793105118548" +
                "07446237996274956735188575272489122793818301194912" +
                "98336733624406566430860213949463952247371907021798" +
                "60943702770539217176293176752384674818467669405132" +
                "00056812714526356082778577134275778960917363717872" +
                "14684409012249534301465495853710507922796892589235" +
                "42019956112129021960864034418159813629774771309960" +
                "51870721134999999837297804995105973173281609631859" +
                "50244594553469083026425223082533446850352619311881" +
                "71010003137838752886587533208381420617177669147303" +
                "59825349042875546873115956286388235378759375195778" +
                "18577805321712268066130019278766111959092164201989";
        System.out.println("Is this calculation correct: " + testPi.equals(builder.toString()) + "!");

        DecimalFormat df = new DecimalFormat("###.##");
        double num = computeTime() / 1000000000;
        System.out.println("Program Run-Time: " + df.format(num) + " seconds\n");
    }

    /***
     * Starts clock time for calculating PI.
     */
    void startClock() {
        this.startTime = System.nanoTime();
    }

    /***
     * Ends clock time for calculating PI.
     */
    void stopClock() {
        this.endTime = System.nanoTime();
    }

    /***
     * Computes total time it took to calculate PI.
     * @return total time in milliseconds it took.
     */
    double computeTime() {
        return this.endTime - this.startTime;
    }
}
