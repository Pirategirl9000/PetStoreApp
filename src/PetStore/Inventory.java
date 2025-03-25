/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore;

import PetStore.types.Pet;

import java.util.ArrayList;
import java.util.Arrays;


public class Inventory {
    /**
     * Arraylist storing all the pets in Inventory
     */
    private ArrayList<Pet> pets = new ArrayList<>();

    /**
     * Creates a new instance of Inventory with a variable number of pets
     * @param pets vararg : any number of pets you want to initialize the Inventory with
     */
    public Inventory(Pet... pets) { // Use varargs to append any optional pets on creation
        this.pets.addAll(Arrays.asList(pets));
    }

    /**
     * Removes a Pet from the Inventory :: permanent
     * @param p the pet to be removed
     */
    public void removePet(Pet p) {
        pets.remove(p);
    }

    /**
     * Adds a new pet to the inventory
     * @param p the pet to be added
     */
    public void addPet(Pet p) {
        pets.add(p);
    }


}
