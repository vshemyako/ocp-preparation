package chapter08;

import java.io.File;

/**
 * Some interesting things that I've encountered during studying Java's IO
 */
public class FileIoUtilities {

    /**
     * Returns file separator specific to the current file system from a {@link System} class
     */
    private static String getFileSeparatorFromProperty() {
        return System.getProperty("file.separator");
    }

    /**
     * Returns file separator specific to the current file system from a {@link File} field
     */
    private static String getFileSeparatorFromField() {
        return File.separator;
    }

    /**
     * Shows usage of different {@link File} constructors.
     * <p>
     * Note: {@link File} class might represent a file or a directory, which may seem not self explanatory for most users
     */
    private static void fileConstructorTest() {
        File ocaTest = new File("c:\\Library\\Java\\Oracles Certification\\OCA Preparation\\Chapter 1 Test.txt");
        File ocpTest = new File("c:\\Library\\Java\\Oracles Certification\\OCP Preparation\\Chapter 1 Test.txt");

        if (ocaTest.exists()) {
            System.out.println(ocaTest.getName() + " exists");
        }

        if (ocpTest.exists()) {
            System.out.println(ocpTest.getName() + " exists");
        }
    }

    /**
     * There are several methods which participant in OCP exam should know
     */
    private static void useBasicFileMethods() {
        File ocaTest = new File("c:\\Library\\Java\\Oracles Certification\\OCA Preparation\\Chapter 002 Test.txt");
        if (ocaTest.exists()) {
            System.out.println("Specified file do exist:");
            System.out.println("\tName of the file: " + ocaTest.getName());
            System.out.println("\tAbsolute path: " + ocaTest.getAbsolutePath());
            System.out.println("\tIt's a directory: " + ocaTest.isDirectory());
            System.out.println("\tIt's a file: " + ocaTest.isFile());
            System.out.println("\tLength of file in bytes: " + ocaTest.length());
            System.out.println("\tLast modified since epoch: " + ocaTest.lastModified());
            System.out.println("\tParent directory: " + ocaTest.getParent());
        } else {
            System.out.println("Specified file does not exist");
        }
    }

    /**
     * Demonstrates usage of basic directory methods
     */
    private static void useBasicDirectoryMethods() {
        File ocaDirectory = new File("c:\\Library\\Java\\Oracles Certification\\OCA Preparation");
        if (ocaDirectory.exists()) {
            System.out.println("Specified directory do exist:");
            System.out.println("\tName of the directory: " + ocaDirectory.getName());
            if (ocaDirectory.isDirectory()) {
                System.out.println("\tIt's a directory");
                for (File file : ocaDirectory.listFiles()) {
                    System.out.println("\t" + file.getName());
                }
            } else {
                System.out.println("\tIt's not a directory");
            }
        } else {
            System.out.println("Specified directory does not exist");
        }
    }

    /**
     * Shows how to rename a file
     */
    private static void renameExample() {
        File ocaTest = new File("c:\\Library\\Java\\Oracles Certification\\OCA Preparation\\Chapter 2 Test.txt");
        File newFileName = new File("c:\\Library\\Java\\Oracles Certification\\OCA Preparation\\Chapter 002 Test.txt");
        ocaTest.renameTo(newFileName);
    }

    /**
     * Shows how to create new directories and rename existing ones
     */
    private static void directoriesModification() {
        File parentDirectory = new File("c:\\Library\\Java\\Oracles Certification\\OCA Preparation");
        File directoryToCreate = new File(parentDirectory, "\\firstLevel\\secondLevel\\directoryForTests");

        if (directoryToCreate.mkdir()) {
            System.out.println("Directory was created");
        } else {
            System.out.println("Directory wasn't created");
            //workaround - maybe several directories have to be created
            if (directoryToCreate.mkdirs()) {
                System.out.println("Several directories were created");
                //removes directory if it's empty
                if (directoryToCreate.delete()) {
                    System.out.println("Removed previously created directory");
                }
            }
        }
    }

    /**
     * Tests specific classes
     */
    public static void main(String[] args) {
        //System.out.println(getFileSeparatorFromProperty());
        //System.out.println(getFileSeparatorFromField());
        //fileConstructorTest();
        useBasicFileMethods();
        //useBasicDirectoryMethods();
        //directoriesModification();
        //renameExample();
    }
}
