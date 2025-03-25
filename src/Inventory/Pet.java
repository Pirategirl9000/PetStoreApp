/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package Inventory;

/**
 * Parent class for any type of animal in the pet store
 */
public class Pet {
    /**
     * Name of the pet
     */
    private String name;
    /**
     * Age of the pet
     */
    private int age;
    /**
     * Float representation of the pet's weight
     */
    private float weight;
    /**
     * Ideal habitat for the pet
     */
    private HABITAT_TYPE habitat;
    /**
     * Feeding schedule of the pet
     */
    private FEEDING_SCHEDULE feedingSchedule;

    /**
     * Stores various common habitat type constants
     */
    enum HABITAT_TYPE {
        UNSPECIFIED,
        CAGE,
        TANK,
        INSIDE,
        OUTSIDE,
        PEN,
        OTHER
    }

    /**
     * Stores various common feeding schedule constants
     */
    enum FEEDING_SCHEDULE {

    }


    /**
     * Create instance of pet with name, age, weight, and habitat
     * @param name the name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     * @param habitat ideal habitat for the pet
     * @param feedingSchedule ideal feeding schedule for the pet
     */
    public Pet(String name, int age, float weight, HABITAT_TYPE habitat, FEEDING_SCHEDULE feedingSchedule) {
        this.setName(name);
        this.age = age;
        this.weight = weight;
        this.setHabitat(habitat);
        this.setFeedingSchedule(feedingSchedule);
    }

    public Pet(String name, int age, float weight, String habitat, String feedingSchedule) {
        this.setName(name);
        this.age = age;
        this.weight = weight;
        this.setHabitat(habitat);
        this.setFeedingSchedule(feedingSchedule);
    }

    public Pet(String name, int age, float weight) {
        this.setName(name);
        this.age = age;
        this.weight = weight;
        this.setHabitat(HABITAT_TYPE.UNSPECIFIED);
    }

    public Pet(String name) {
        this.setName(name);
        this.setAge()

        this.setHabitat(HABITAT_TYPE.UNSPECIFIED);
    }

    public void setHabitat(HABITAT_TYPE habitat) {
        this.habitat = habitat;
    }


    public void setHabitat(String habitat) throws IllegalArgumentException {
        try {
            this.habitat = HABITAT_TYPE.valueOf(habitat);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Habitat, Habitat Assignment Aborted");
        }
    }

    public void setName(String name) {
        if (name.trim().isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.age = age;
    }

    public void setWeight(float weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }

        this.weight = weight;
    }
}
