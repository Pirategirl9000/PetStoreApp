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
import java.util.ArrayList;
import java.util.Scanner;


public class PetStore extends Inventory {
    private File fileOut;
    private File fileIn;
    enum FILE_FORMAT {PetType, Name, Age, Weight, Habitat, Feeding};




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
        return;





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
        // String PetType, String name, int age, float weight, HABITAT_TYPE habitat, FEEDING_SCHEDULE feedingSchedule

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


                for (String segment: token) { // EACH SEGMENT OF IT
                    segment = segment.trim();

                    if (segment.isEmpty()) {
                        continue;
                    }

                    this.setValue(pet, FILE_FORMAT.values()[currentIndex], segment);
                    currentIndex++;
                }


                this.addPet(pet);
            }




        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void saveToFile() {
        return;





    }
}
