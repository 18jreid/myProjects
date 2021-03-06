/*
 * This Java source file was generated by the Gradle 'init' task.
 */

// Justin Reid
// A02276642
// CS3100 OS and Concurrency
// Assign. 2

package CS3100_Assign2;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        for (String arg : args) {
            switch (arg) {
                case "-cpu": {
                    Runtime runtime = Runtime.getRuntime();
                    printCpuInfo(runtime);
                    break;
                }
                case "-mem": {
                    Runtime runtime = Runtime.getRuntime();
                    printMemoryInfo(runtime);
                    break;
                }
                case "-dirs":
                    printDirectories();
                    break;
                case "-os":
                    printOperatingSystemInfo();
                    break;
                case "-java":
                    printJavaInfo();
                    break;
            }
        }
    }

    /***
     * Prints how many processors the CPU has.
     * @param runtime current runtime of program
     */
    static void printCpuInfo(Runtime runtime) {
        System.out.println("\nProcessors : " + runtime.availableProcessors() + "\n");
    }

    /***
     * Prints free, total, and maximum memory of computer.
     * @param runtime current runtime of program.
     */
    static void printMemoryInfo(Runtime runtime) {
        System.out.println("\nFree Memory : " + runtime.freeMemory());
        System.out.println("Total Memory : " + runtime.totalMemory());
        System.out.println("Max Memory : " + runtime.maxMemory() + "\n");
    }

    /***
     * Prints working, and user home directory.
     */
    static void printDirectories() {
        System.out.println("\nWorking Directory : " + System.getProperty("user.dir"));
        System.out.println("User Home Directory : " + System.getProperty("user.home") + "\n");
    }

    /***
     * Prints OS name and version.
     */
    static void printOperatingSystemInfo() {
        System.out.println("\nOS Name : " + System.getProperty("os.name"));
        System.out.println("OS Version : " + System.getProperty("os.version") + "\n");
    }

    /***
     * Prints all java info (Vendor, Runtime name, version, VM version, VM name).
     */
    static void printJavaInfo() {
        System.out.println("\nJava Vendor : " + System.getProperty("java.vendor"));
        System.out.println("Java Runtime : " + System.getProperty("java.runtime.name"));
        System.out.println("Java Version : " + System.getProperty("java.version"));
        System.out.println("Java VM Version : " + System.getProperty("java.vm.version"));
        System.out.println("Java VM Name : " + System.getProperty("java.vm.name") + "\n");
    }
}
