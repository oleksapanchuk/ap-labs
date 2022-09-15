package com.panchuk.lab3.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    private static Scanner scanner;
    private static String filePath;

    static {
        scanner = new Scanner(System.in);
    }

    /**
     * method create a file for writing in future
     *
     * @param fName file name without extension and dot
     */
    public static void createFile(String fName) {
        try {
            File battleFile = new File("files/" + fName + ".txt");

            if (battleFile.createNewFile()) {
                System.out.println("File created: " + battleFile.getName());
                filePath = "files/" + fName + ".txt";
            } else {
                System.out.println("File '" + fName + "' already exists.");
                System.out.print("Input another file name: ");
                createFile(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("An error occurred! File cannot be created!");
            e.printStackTrace();
        }
    }

    /**
     * method open file in writing mode and write info
     *
     * @param string info for writing
     */
    public static void writeToFile(String string) {
        try {
            try (FileWriter battleWrite = new FileWriter(filePath)) {
                battleWrite.write(string);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * method shows the contents of the file
     */
    public static void readFile() {

        allBattles();

        System.out.print("\nInput File Name: ");
        String fileName = inputFileName();

        try {
            File replayBattle = new File("files/" + fileName + ".txt");
            scanner = new Scanner(replayBattle);

            System.out.println("\n---------- REPLAY of BATTLE --- " + fileName + " ---" +
                    "-----------------------------------------\n");

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * method displays all recorded battles
     */
    private static void allBattles() {
        File folder = new File("files");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("\nNo battle recorded!!!");
            return;
        }

        System.out.println("\nAll battles that are available for viewing:");
        for (File item : listOfFiles) {
            if (item.isFile()) {
                System.out.println("\tBattle -> " + item.getName());
            }
        }
    }

    /**
     * method accepts the file name and checks whether we can read it
     *
     * @return fName File Name
     */
    private static String inputFileName() {
        while (true) {
            String fName = scanner.nextLine().replace(".txt", "");
            File openFile = new File("files/" + fName + ".txt");

            if (!openFile.canRead()) {
                System.err.print("Cannot open file - '" + fName + "'. Try again: ");
            } else {
                return fName;
            }
        }
    }
}
