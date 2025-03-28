/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore.types;

import PetStore.types.enums.*;



/**
 * Parent class for any type of animal in the pet store
 */
public class Pet {

    /**
     * Unique Identifier for each pet, used when checking equality or when creating default Pet(name=petID)
     */
    protected final int petID;  // Used by children for their toString()

    protected String petType = "Default";

    /**
     * Used to give each pet a unique ID
     */
    private static int PET_ID_COUNTER = 0;

    /**
     * Name of the pet
     */
    protected String name;

    /**
     * Age of the pet
     */
    protected int age;

    /**
     * Float representation of the pet's weight
     */
    protected float weight;

    /**
     * Ideal habitat for the pet
     */
    protected HABITAT_TYPE habitat;

    /**
     * Feeding schedule of the pet
     */
    protected FEEDING_SCHEDULE feedingSchedule;


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

    /**
     * Create instance of pet with default feedingSchedule and habitat
     * @param name the name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     */
    public Pet(String name, int age, float weight) {
        this(name, age, weight, HABITAT_TYPE.UNSPECIFIED, FEEDING_SCHEDULE.UNSPECIFIED);
    }

    /**
     * Create instance of pet with a name and default values
     * @param name the name of the pet
     */
    public Pet(String name) {
        this(name, 0, 0, HABITAT_TYPE.UNSPECIFIED, FEEDING_SCHEDULE.UNSPECIFIED);
    }

    /**
     * Create a default instance of a pet
     */
    public Pet() {
        this("", 0, 0, HABITAT_TYPE.UNSPECIFIED, FEEDING_SCHEDULE.UNSPECIFIED); // Name will throw exception that is caught by override constructor
    }

    /**
     * Sets the habitat, must be instance of HABITAT_TYPE
     * @param habitat ideal habitat for the pet as an instance of HABITAT_TYPE enum
     */
    public void setHabitat(HABITAT_TYPE habitat) {
        this.habitat = habitat;
    }

    /**
     * Sets the habitat, must be equal to value in HABITAT_TYPE enum
     * @param habitat ideal habitat for the pet; must match item in HABITAT_TYPE enum
     * @throws IllegalArgumentException if habitat does not match item in HABITAT_TYPE enum
     */
    public void setHabitat(String habitat) throws IllegalArgumentException {
        try {
            this.habitat = HABITAT_TYPE.valueOf(habitat);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Habitat, Habitat Assignment Aborted");
        }
    }

    /**
     * Sets the type of pet
     * @param petType type of pet: dog, cat, snake, etc.
     */
    public void setPetType(String petType) {
        this.petType = petType;
    }

    /**
     * Sets the name of the pet
     * @param name the name of the pet
     * @throws IllegalArgumentException if name is blank
     */
    public void setName(String name) {
        name = name.trim();

        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        this.name = name;
    }

    /**
     * Sets the age of the pet
     * @param age the age of the pet
     * @throws IllegalArgumentException if age < 0
     */
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.age = age;
    }

    /**
     * Sets the weight of the pet
     * @param weight weight of the pet
     * @throws IllegalArgumentException if weight < 0
     */
    public void setWeight(float weight) {
        if (weight < 0) { // Allow weight == 0 because I can't be bothered to try-catch weight in the constructors
            throw new IllegalArgumentException("Weight cannot be negative");
        }

        this.weight = weight;
    }

    /**
     * Sets the feedingSchedule, must be instance of FEEDING_SCHEDULE
     * @param feedingSchedule ideal feeding schedule for the pet as an instance of FEEDING_SCHEDULE enum
     */
    public void setFeedingSchedule(FEEDING_SCHEDULE feedingSchedule) {
        this.feedingSchedule = feedingSchedule;
    }

    /**
     * Sets the feedingSchedule, must be instance of FEEDING_SCHEDULE
     * @param feedingSchedule ideal feedingSchedule for the pet; must match item in FEEDING_SCHEDULE enum
     * @throws IllegalArgumentException if feedingSchedule does not match item in FEEDING_SCHEDULE enum
     */
    public void setFeedingSchedule(String feedingSchedule) throws IllegalArgumentException {
        try {
            this.feedingSchedule = FEEDING_SCHEDULE.valueOf(feedingSchedule);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid FeedingSchedule, FeedingSchedule Assignment Aborted");
        }
    }

    /**
     * Returns the name of the pet
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the age of the pet
     * @return age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Returns the weight of the pet
     * @return weight
     */
    public float getWeight() {
        return this.weight;
    }

    /**
     * Returns the habitat of the pet
     * @return habitat
     */
    public HABITAT_TYPE getHabitat() {
        return this.habitat;
    }

    /**
     * Returns the feedingSchedule of the pet
     * @return feedingSchedule
     */
    public FEEDING_SCHEDULE getFeedingSchedule() {
        return this.feedingSchedule;
    }


    /**
     * Returns the type of Pet
     */
    public String getPetType() {
        return this.petType;
    }

    @Override public String toString() {
        // ID|NAME|AGE|WEIGHT|HABITAT|FEEDINGSCHEDULE|||||
        return String.format("%5d|%20s|%7d|%9.2f|%15s|%19s|%20s|%6s|%9s|%15s|", this.petID, this.getName(), this.getAge(), this.getWeight(), this.getHabitat().toString(), this.getFeedingSchedule().toString(), "", "", "", "");
    }
}