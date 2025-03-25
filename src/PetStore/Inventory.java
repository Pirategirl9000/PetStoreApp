/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore;

import PetStore.types.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Inventory {
    /**
     * Arraylist storing all the pets in Inventory
     */
    private final ArrayList<Pet> pets = new ArrayList<>();

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
        this.pets.remove(p);
    }

    /**
     * Adds a new pet to the inventory
     * @param p the pet to be added
     */
    public void addPet(Pet p) {
        this.pets.add(p);
    }

    /**
     * Returns the pet at the given index
     * @param index the index to grab
     * @return Pet()
     */
    public Pet getPet(int index) {
        return this.pets.get(index);
    }

    /**
     * Returns a stringified list of the Inventory
     * @return String of this.pets
     */
    @Override public String toString() {
        return pets.toString();
    }



}
