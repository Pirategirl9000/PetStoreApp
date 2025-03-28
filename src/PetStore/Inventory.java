/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore;

import PetStore.types.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inventory {
    /**
     * Arraylist storing all the pets in Inventory
     */
    protected final ArrayList<Pet> pets = new ArrayList<>();

    /**
     * Header String for the printout
     */
    private static final String PRINTOUTKEY = String.format("%5s|%20s|%7s|%9s|%15s|%19s|%20s|%6s|%9s|%15s", "ID", "NAME", "AGE", "WEIGHT", "HABITAT", "FEEDING_SCHEDULE", "BREED", "VACCINATED", "VENOMOUS", "SAFE_TO_HANDLE");


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
     * Clears the current inventory
     */
    public void clearInventory() {
        this.pets.clear();
    }

    /**
     * Returns the RawInventory used for saving
     * @return Every Pet's .toString() result in a line by line String
     */
    public String getRawInventory() {
        StringBuilder output = new StringBuilder();

        for (Pet p : this.pets) {
            output.append(p.toString()).append("\n");
        }

        return output.toString();
    }

    /**
     * Returns a pet object with a matching ID
     * @param id the id of the pet
     * @return Pet object with matching ID
     * @throws Exception if no pet has that ID
     */
    public Pet getPetByID(int id) throws Exception {
        for (Pet p : this.pets) {
            if (p.getPetID() == id) {
                return p;
            }
        }

        throw new Exception("Pet with ID " + id + " not found");
    }

    /**
     * Returns a stringified list of the Inventory and prints the header
     * @return String of this.pets
     */
    @Override public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("Inventory:\n");
        output.append(PRINTOUTKEY);
        output.append("\n");

        for (Pet p : this.pets) {
            output.append(p.toString()).append("\n");
        }

        return output.toString();
    }
}
