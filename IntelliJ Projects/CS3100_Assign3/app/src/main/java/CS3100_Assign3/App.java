// Justin Reid
// A02276642
// Assignment 6 OS and Concurrency

/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package CS3100_Assign3;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }
    static ArrayList<String> commandHistory = new ArrayList<String>();

    public static void main(String[] args) {
        while (true) {
            String[] commandsArray = getInput().split(" ");
            executeCommands(commandsArray);
        }
    }

    /***
     * Gets user commandline input.
     * @return returns string of users line input.
     */
    static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("[" + getCurrDirectory() + "]: ");

        return scanner.nextLine();
    }

    /***
     * Executes commands given by user.
     * @param commands String Array of all commands to be executed.
     */
    static void executeCommands(String[] commands) {
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == null) {
                System.out.println("SKIP");
                continue;
            }

            switch (commands[i]) {
                case "cd":
                    if (i == commands.length - 1) {
                        changeCurrDirectory();
                        commandHistory.add(commands[i]);
                    } else if (commands[i + 1].equals("help") | commands[i + 1].equals("ptime") | commands[i + 1].equals("history")
                            | commands[i + 1].equals("^") | commands[i + 1].equals("list") | commands[i + 1].equals("cd")
                            | commands[i + 1].equals("mdir") | commands[i + 1].equals("rdir") | commands[i + 1].equals("|")
                            | commands[i + 1].equals("exit")) {
                        changeCurrDirectory();
                        commandHistory.add(commands[i]);
                    } else {
                        changeCurrDirectory(commands[i + 1]);
                        commandHistory.add(commands[i] + " " + commands[i + 1]);
                    }
                    break;
                case "help":
                    showHelpMenu();
                    commandHistory.add(commands[i]);
                    break;
                case "list":
                    listFiles();
                    commandHistory.add(commands[i]);
                    break;
                case "mdir":
                    if (i == commands.length - 1) {
                        makeDirectory("untitled_folder");
                        commandHistory.add(commands[i]);
                    } else if (commands[i + 1].equals("help") | commands[i + 1].equals("ptime") | commands[i + 1].equals("history")
                            | commands[i + 1].equals("^") | commands[i + 1].equals("list") | commands[i + 1].equals("cd")
                            | commands[i + 1].equals("mdir") | commands[i + 1].equals("rdir") | commands[i + 1].equals("|")
                            | commands[i + 1].equals("exit")) {
                        makeDirectory("untitled_folder");
                        commandHistory.add(commands[i]);
                    } else {
                        makeDirectory(commands[i + 1]);
                        commandHistory.add(commands[i] + " " + commands[i + 1]);
                    }
                    break;
                case "rdir":
                    if (i == commands.length - 1) {
                        System.out.println("Please provide directory to remove.");
                    } else if (commands[i + 1].equals("help") | commands[i + 1].equals("ptime") | commands[i + 1].equals("history")
                            | commands[i + 1].equals("^") | commands[i + 1].equals("list") | commands[i + 1].equals("cd")
                            | commands[i + 1].equals("mdir") | commands[i + 1].equals("rdir") | commands[i + 1].equals("|")
                            | commands[i + 1].equals("exit")) {
                        System.out.println("Please provide directory to remove.");
                    } else {
                        removeDirectory(commands[i + 1]);
                        commandHistory.add(commands[i] + " " + commands[i + 1]);
                    }
                    break;
                case "history":
                    printCommandHistory();
                    break;
                case "^":
                    if (i == commands.length - 1) {
                        System.out.println("Please provide number for index of command history.");
                    } else if (commands[i + 1].equals("help") | commands[i + 1].equals("ptime") | commands[i + 1].equals("history")
                            | commands[i + 1].equals("^") | commands[i + 1].equals("list") | commands[i + 1].equals("cd")
                            | commands[i + 1].equals("mdir") | commands[i + 1].equals("rdir") | commands[i + 1].equals("|")
                            | commands[i + 1].equals("exit")) {
                        System.out.println("Please provide number for index of command history.");
                    } else {
                        printCommandAtIndex(Integer.parseInt(commands[i + 1]));
                        commandHistory.add(commands[i] + " " + commands[i + 1]);
                    }
                    break;
                case "exit":
                    System.exit(1);
            }
        }
    }

    /***
     * Lists files in working directory.
     */
    static void listFiles() {
        File file = new File(getCurrDirectory());
        String[] allFiles = file.list();

        assert allFiles != null;
        for (String fileName : allFiles) {
            System.out.print(fileName + " ");
        }
        System.out.println();
    }

    /***
     * Gets current/working directory.
     * @return working directory path.
     */
    static String getCurrDirectory() {
        return System.getProperty("user.dir");
    }

    /***
     * Changes working directory to new desired directory.
     * @param newDir desired directory.
     */
    static void changeCurrDirectory(String newDir) {
        File myFile = new File(getCurrDirectory());
        if (newDir.equals("..")) {
            System.setProperty("user.dir", myFile.getParent());
        }
        else {
            String[] allFiles = myFile.list();
            boolean fileFound = false;
            assert allFiles != null;
            for (String file : allFiles) {
                if (file.equals(newDir) || file.startsWith(newDir)) {
                    System.setProperty("user.dir", getCurrDirectory() + "/" + file.toString());
                    fileFound = true;
                }
            }
            if (!fileFound) {
                System.out.println("File does not exist");
            }
        }
    }

    /***
     * Changes working directory to user directory.
     */
    static void changeCurrDirectory() {
        System.setProperty("user.dir", System.getProperty("user.home"));
    }

    /***
     * Makes a directory with specific name
     * @param dirName desired name of directory
     */
    static void makeDirectory(String dirName) {
        File newDir = new File(getCurrDirectory() + "/" + dirName);
        if (!newDir.exists()) {
            newDir.mkdirs();
        }
    }

    /***
     * Removes directory with specific name
     * @param dirName desired name of directory to be removed
     */
    static void removeDirectory(String dirName) {
        File desiredRemoveDir = new File(getCurrDirectory() + "/" + dirName);
        if (desiredRemoveDir.exists()) {
            desiredRemoveDir.delete();
        }
        else {
            System.out.println(dirName + " does not exist");
        }
    }

    /***
     * Prints command history
     */
    static void printCommandHistory() {
        if (commandHistory.size() < 10) {
            for (String command : commandHistory) {
                System.out.println(command);
            }
        }

        else {
            for (int i = commandHistory.size() - 10; i < commandHistory.size(); i++) {
                System.out.println(commandHistory.get(i));
            }
        }
    }

    /***
     * Prints command at specific index
     * @param index desired index of command history
     */
    static void printCommandAtIndex(int index) {
        if (index - 1 <= commandHistory.size()) {
            System.out.println(commandHistory.get(index - 1));
        }

        else {
            System.out.println("Index out of range.");
        }
    }

    /***
     * Prints a help menu for the user
     */
    static void showHelpMenu() {
        System.out.println("\nhelp - lists all commands"); //DONE
        System.out.println("ptime - amount of time processes take (NOT IMPLEMENTED)");
        System.out.println("history - shows history of commands"); //DONE
        System.out.println("^ <number> - prints specific command at index <number>"); //DONE
        System.out.println("list - shows all files and directories in current directory"); //DONE
        System.out.println("cd - changes current directory"); //DONE
        System.out.println("mdir - makes a directory"); //DONE
        System.out.println("rdir removes a directory"); //DONE
        System.out.println("| - to pipe between two external commands (NOT IMPLEMENTED)");
        System.out.println("exit - exits program\n"); //DONE
    }
}
