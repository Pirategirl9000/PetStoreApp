/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore.UI;

import PetStore.types.PET_CONSTANTS;
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


    public PetStore(String fileOut, String fileIn) {
        super();
        this.setFileOut(fileOut);
        this.setFileIn(fileIn);

        this.readFile();
    }

    public PetStore(Pet... pets) {
        super(pets);
    }

    public PetStore() {
        super();
    }

    public void setFileOut(String fileOut) {
        this.fileOut = new File(fileOut);
    }

    public void setFileIn(String fileIn) {
        this.fileIn = new File(fileIn);
    }

    public File getFileOut() {
        return fileOut;
    }

    public File getFileIn() {
        return fileIn;
    }

    public void initCLI() {
        Scanner console = new Scanner(System.in);
        String command;

        while (true) {
            command = console.nextLine();

            switch (COMMANDS.valueOf(command)) {
                case addPet:
                    this.addPet(console);
                    break;
                case clearInv:
                    this.clearInventory();
                    break;
                case setSaveFile:
                    this.saveToFile();
                    break;
                case help:
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
                case printInv:
                    System.out.print(this.toString());
                    break;
                case save:
                    break;
                case removePet:
                    break;
                case readFile:
                    break;
                case setInputFile:
                    break;
                case quit:
                    return;
            }


        }




    }

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
                pet.setHabitat(PET_CONSTANTS.HABITAT_TYPE.valueOf(value.toString()));
                break;
            case Feeding:
                pet.setFeedingSchedule(PET_CONSTANTS.FEEDING_SCHEDULE.valueOf(value.toString()));
                break;
        }
    }

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

    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter(this.fileOut);

            fw.write(this.getRawInventory());

            fw.close();
        } catch (IOException e) {
            System.out.println("The item at: " + this.fileIn.getAbsolutePath() + " is a directory and cannot be written to.");
        }





    }


    public void addPet(Scanner sc) {  // Mimics the function addPet(Pet p) but instead prompts those values

    }
}
