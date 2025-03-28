/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore.UI;

import PetStore.types.Dog;
import PetStore.types.Snake;
import PetStore.types.enums.*;
import PetStore.types.Pet;
import PetStore.Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PetStore extends Inventory {
    private File fileOut;
    private File fileIn;

    /**
     * Initializes a pet store with
     * @param fileOut file to save to
     * @param fileIn file to take input from
     */
    public PetStore(String fileOut, String fileIn) {
        super();
        try {
            this.setFileOut(fileOut);
            this.setFileIn(fileIn);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        this.readFile();
    }

    /**
     * Initializes a pet store with varargs pets
     * @param pets variable amount of pets
     */
    public PetStore(Pet... pets) {
        super(pets);
    }

    /**
     * Initializes a pet store
     */
    public PetStore() {
        super();
    }

    /**
     * Sets the file to save to, can be same as fileIn
     * @param fileOut the path to the file to print to
     * @throws FileNotFoundException if the file couldn't be found
     */
    public void setFileOut(String fileOut) throws FileNotFoundException {
        this.fileOut = new File(fileOut);
    }

    /**
     * Sets the file to take input from, can be same as fileOut
     * @param fileIn the path to the file to take input from
     * @throws FileNotFoundException if the file couldn't be found
     */
    public void setFileIn(String fileIn) throws FileNotFoundException {
        this.fileIn = new File(fileIn);
    }

    /**
     * Returns the File object that is being saved to
     * @return File()
     */
    public File getFileOut() {
        return fileOut;
    }

    /**
     * Returns the File object that is set for input
     * @return File()
     */
    public File getFileIn() {
        return fileIn;
    }

    /**
     * Initializes a CLI interface for managing a PetStore inventory, should be called after initialization
     */
    public void initCLI() {
        Scanner console = new Scanner(System.in);
        String command;

        while (true) {
            // I present, my CLI prompt
            System.out.print("PSUtil>");

            // I think the name is complex looking without being pretentious
            // People who label things with all these sci-fi names makes it come off so, ick
            // I miss the simple days when we created a genius model for conducting electricity to perform arithmetic and naming it 'Adder'

            command = console.nextLine();

            switch (COMMANDS.valueOf(command)) {
                // ---------------------------------Inventory Management---------------------------------//
                case addPet:
                    try {
                        this.addPet(console);
                    } catch (Exception e) {
                        System.out.println("Error was encountered while trying to add pet, shutting down");
                        this.saveToFile();  // Save the program before we close
                        System.exit(0);
                    }
                    break;

                case removePet:
                    System.out.print("Pet ID: ");
                    int id = console.nextInt();
                    try {
                        this.removePet(this.getPetByID(id));
                    } catch (Exception e) {
                        System.out.println("Pet with ID: " + id + " could not be found");
                    }

                    break;

                case clearInv:
                    this.clearInventory();
                    break;

                case printInv:
                    System.out.println(this);
                    break;



                // ------------------------------------File IO------------------------------------//
                case setSaveFile:
                    System.out.print("Path to File: ");
                    command = console.nextLine();

                    try {
                        this.setFileOut(command);
                    } catch (FileNotFoundException e) {
                        System.out.println("An error was encountered while setting the file. Error: " + e.getMessage());
                    }

                    break;

                case save:
                    this.saveToFile();
                    break;


                case setInputFile:
                    System.out.print("Path to File: ");
                    command = console.nextLine();

                    try {
                        this.setFileIn(command);
                    } catch (FileNotFoundException e) {
                        System.out.println("An error was encountered while setting the file. Error: " + e.getMessage());
                    }

                    break;

                case readFile:
                    this.readFile();
                    break;

                case help:
                    // Don't worry I didn't do all that indentation and stuff, just copy pasted the enum code into some double quotes and IntelliJ formatted it
                    System.out.print("COMMANDS {\n" +
                            "    clearInv,  // Clears the Inventory\n" +
                            "    printInv,  // Prints a stringified list of the current pets in Inventory\n" +
                            "\n" +
                            "    setInputFile,  // Sets a file for reading into\n" +
                            "    readFile,  // Reads into set file\n" +
                            "\n" +
                            "    setSaveFile,  // Sets a save file\n" +
                            "    save,  // Save the current changes to inventory\n" +
                            "\n" +
                            "    addPet,  // Activates interface for creating a new pet\n" +
                            "    removePet,  // Activates interface for removing a pet\n" +
                            "\n" +
                            "    help,  // Displays Available commands\n" +
                            "    quit  // Quits the Running CLI instance\n" +
                            "}");
                    break;

                case quit:
                    return;
            }

            System.out.println(); // Add line break each time
        }
    }

    /**
     * Changes the value of one of Pet's values
     * @param pet the pet to change
     * @param valueType the value to change
     * @param value the value to change it to
     * @throws IllegalArgumentException if any errors are encountered setting the properties
     */
    private void setValue(Pet pet, FILE_FORMAT valueType, Object value) throws IllegalArgumentException {
        switch (valueType) {
            case PetType:
                pet.setPetType(value.toString());
                break;
            case Name:
                pet.setName(value.toString());
                break;
            case Age:
                pet.setAge((int) value);
                break;
            case Weight:
                pet.setWeight((int) value);
                break;
            case Habitat:
                pet.setHabitat(HABITAT_TYPE.valueOf(value.toString()));
                break;
            case Feeding:
                pet.setFeedingSchedule(FEEDING_SCHEDULE.valueOf(value.toString()));
                break;
        }
    }

    /**
     * Reads fileIn save file
     */
    public void readFile() {
        // String PetType | String name | int age | float weight | HABITAT_TYPE habitat | FEEDING_SCHEDULE feedingSchedule

        try {
            Scanner sc = new Scanner(this.fileIn);
            ArrayList<String[]> tokens = new ArrayList<>();  // Holds String arrays where tokens.get(0)[0] returns the first segment of the first line

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                tokens.add(line.split("\\|"));  // { | } delimiter requires two backslashes
            }

            int currentIndex;
            String currentType;
            Pet pet;

            for (String[] token : tokens) { // ENTIRE LINE
                currentIndex = 0;
                pet = new Pet();

                if (token.length == 0) {  // Checking for blank line in file
                    continue;
                }


                for (String segment: token) { // EACH SEGMENT OF IT
                    segment = segment.trim();

                    if (segment.isEmpty()) {
                        continue;
                    }

                    try {
                        this.setValue(pet, FILE_FORMAT.values()[currentIndex], segment);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Unable to parse input for {" + segment + "} in input file.");
                    }

                    currentIndex++;
                }


                this.addPet(pet);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file " + this.fileIn.getAbsolutePath());
            System.out.println("Reason: File not Found");
        }
    }

    /**
     * Saves the current Inventory to fileOut
     */
    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter(this.fileOut);

            fw.write(this.getRawInventory());

            fw.close();
        } catch (IOException e) {
            System.out.println("The item at: " + this.fileIn.getAbsolutePath() + " is a directory and cannot be written to.");
        }
    }


    /**
     * Adds a pet using a Scanner reference to prompt for input
     * @param sc the input stream for the prompts
     */
    public void addPet(Scanner sc) {  // Mimics the function addPet(Pet p) but instead prompts those values
        ArrayList<String> responses = new ArrayList<>();
        String[] prompts = new String[] {
                "What is your pet's name: ",
                "What is your pet's age: ",
                "What is your pet's weight: ",
                "What is your pet's habitat: ",
                "What is your pet's feeding schedule: "
        };

        int petType;


        System.out.print("What type of pet do you want to add(1 = Default Pet; 2 = Dog; 3 = Snake): ");
        petType = sc.nextInt();

        sc.reset();

        // Get the info on basic Pets
        for (String prompt : prompts) {
            System.out.print(prompt);
            responses.add(sc.nextLine());
        }




        if (petType == 1) {
            this.addPet(new Pet(responses.get(0), Integer.parseInt(responses.get(1)), Float.parseFloat(responses.get(2)), responses.get(3), responses.get(4)));
        }
        else if (petType == 2) {
            System.out.print("What is your dog's breed: ");
            responses.add(sc.nextLine());
            System.out.println();

            System.out.print("Is your dog vaccinated(y, n): ");
            responses.add(sc.nextLine());
            System.out.println();

            this.addPet(new Dog(responses.get(0), Integer.parseInt(responses.get(1)), Float.parseFloat(responses.get(2)), responses.get(3), responses.get(4), responses.get(5), responses.get(6).equalsIgnoreCase("y")));

        } else if (petType == 3) {
            System.out.print("Is your snake venomous(y, n): ");
            responses.add(sc.nextLine());
            System.out.println();

            System.out.print("Is your snake safe to handle(y, n): ");
            responses.add(sc.nextLine());
            System.out.println();

            this.addPet(new Snake(responses.get(0), Integer.parseInt(responses.get(1)), Float.parseFloat(responses.get(2)), responses.get(3), responses.get(4), responses.get(5).equalsIgnoreCase("n"), responses.get(6).equalsIgnoreCase("y")));
        }
    }
}
