/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package Inventory;

/**
 * Stores various common feeding schedule constants
 */
enum FEEDING_SCHEDULE {
    TRI_DAILY,
    TWICE_DAILY,
    DAILY,
    TRI_WEEKLY,
    TWICE_WEEKLY,
    WEEKLY,
    OTHER,
    UNSPECIFIED
}

/**
 * Stores various common habitat type constants
 */
enum HABITAT_TYPE {
    CAGE,
    TANK,
    INSIDE,
    OUTSIDE,
    PEN,
    OTHER,
    UNSPECIFIED
}

/**
 * Parent class for any type of animal in the pet store
 */
public class Pet {
    /**
     * Unique Identifier for each pet, used when checking equality or when creating default Pet(name=petID)
     */
    private final int petID;

    /**
     * Used to give each pet a unique ID
     */
    private static int PET_ID_COUNTER = 0;

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
     * Create instance of pet using enum data types for habitat and feedingSchedule; used by other constructors for basic setup
     * @param name the name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     * @param habitat ideal habitat for the pet as an instance of HABITAT_TYPE enum
     * @param feedingSchedule ideal feeding schedule for the pet as an instance of FEEDING_SCHEDULE enum
     */
    public Pet(String name, int age, float weight, HABITAT_TYPE habitat, FEEDING_SCHEDULE feedingSchedule) {
        this.petID = ++PET_ID_COUNTER;

        try { // Name is run through try-catch just in case default constructor is used, or they enter a blank name
            this.setName(name);
        } catch (IllegalArgumentException e) {
            this.setName(String.valueOf(petID));
        }

        this.setAge(age);
        this.setWeight(weight);
        this.setHabitat(habitat);
        this.setFeedingSchedule(feedingSchedule);
    }

    /**
     * Create instance of pet using String data types for habitat and feedingSchedule
     * @param name the name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     * @param habitat ideal habitat for the pet as an instance of HABITAT_TYPE enum
     * @param feedingSchedule ideal feeding schedule for the pet as an instance of FEEDING_SCHEDULE enum
     */
    public Pet(String name, int age, float weight, String habitat, String feedingSchedule) {
        this.petID = ++PET_ID_COUNTER;

        try { // Name is run through try-catch just in case default constructor is used, or they enter a blank name
            this.setName(name);
        } catch (IllegalArgumentException e) {
            this.setName(String.valueOf(this.petID));
        }

        this.setAge(age);
        this.setWeight(weight);
        this.setHabitat(habitat);
        this.setFeedingSchedule(feedingSchedule);
    }

    public Pet(String name, int age, float weight) {
        this(name, age, weight, HABITAT_TYPE.UNSPECIFIED, FEEDING_SCHEDULE.UNSPECIFIED);
    }

    public Pet(String name) {
        this(name, 0, 0, HABITAT_TYPE.UNSPECIFIED, FEEDING_SCHEDULE.UNSPECIFIED);
    }

    public Pet() {
        this("", 0, 0, HABITAT_TYPE.UNSPECIFIED, FEEDING_SCHEDULE.UNSPECIFIED)
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

    public void setFeedingSchedule(FEEDING_SCHEDULE feedingSchedule) {
        this.feedingSchedule = feedingSchedule;
    }

    public void setFeedingSchedule(String feedingSchedule) throws IllegalArgumentException {
        try {
            this.feedingSchedule = FEEDING_SCHEDULE.valueOf(feedingSchedule);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid FeedingSchedule, FeedingSchedule Assignment Aborted");
        }
    }
}
