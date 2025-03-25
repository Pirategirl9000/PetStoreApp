/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore.types;

/**
 * Class for handling Dog type Pets
 */
public class Dog extends Pet {
    /**
     * Boolean representing whether they have had their vaccines
     */
    protected boolean vaccinated = false;

    /**
     * String representing the breed of dog
     */
    protected String breed = "Unknown";

    /**
     * Valid FEEDING_SCHEDULE's for dogs
     */
    protected final FEEDING_SCHEDULE[] VALID_FEEDING_SCHEDULE = {FEEDING_SCHEDULE.UNSPECIFIED, FEEDING_SCHEDULE.OTHER, FEEDING_SCHEDULE.TRI_DAILY, FEEDING_SCHEDULE.TWICE_DAILY, FEEDING_SCHEDULE.DAILY};

    /**
     * Valid HABITAT_TYPE's for Dogs
     */
    protected final HABITAT_TYPE[] VALID_HABITATS = {HABITAT_TYPE.OUTSIDE, HABITAT_TYPE.INSIDE, HABITAT_TYPE.UNSPECIFIED, HABITAT_TYPE.OTHER};

    /**
     * Create instance of Dog using enum data types for habitat and feedingSchedule
     * @param name the name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     * @param habitat ideal habitat for the pet as an instance of HABITAT_TYPE enum
     * @param feedingSchedule ideal feeding schedule for the pet as an instance of FEEDING_SCHEDULE enum
     * @param breed the breed of dog
     * @param vaccinated whether the dog has been vaccinated
     */
    public Dog(String name, int age, float weight, HABITAT_TYPE habitat, FEEDING_SCHEDULE feedingSchedule, String breed, boolean vaccinated) {
        super(name, age, weight, habitat, feedingSchedule);
        this.vaccinated = vaccinated;
        try {
            this.setBreed(breed);
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting breed for dog: " + this);
            System.out.println("A default value has been assigned to the breed");
        }
    }
    /**
     * Create instance of Dog using String data types for habitat and feedingSchedule
     * @param name name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     * @param habitat ideal habitat for the pet as an instance of HABITAT_TYPE enum
     * @param feedingSchedule ideal feeding schedule for the pet as an instance of FEEDING_SCHEDULE enum
     * @param breed the breed of dog
     * @param vaccinated whether the dog has been vaccinated
     */
    public Dog(String name, int age, float weight, String habitat, String feedingSchedule, String breed, boolean vaccinated) {
        super(name, age, weight, habitat, feedingSchedule);
        this.vaccinated = vaccinated;
        try {
            this.setBreed(breed);
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting breed for dog: " + this);
            System.out.println("A default value has been assigned to the breed");
        }
    }

    /**
     * Create instance of Dog
     * @param name name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     */
    public Dog(String name, int age, float weight) {
        super(name, age, weight);
        //this.vaccinated = false;
        //this.setBreed("Unknown")
    }

    /**
     * Create instance of Dog with only a name set
     * @param name name of the pet
     */
    public Dog(String name) {
        super(name);
        //this.vaccinated = false;
        //this.setBreed("Unknown")
    }

    /**
     * Creates a blank Dog instance with default values
     */
    public Dog() {
        super();
        //this.vaccinated = false;
        //this.setBreed("Unknown")
    }

    /**
     * Sets the Dog's habitat type
     * @param habitat ideal habitat for the pet as an instance of HABITAT_TYPE enum
     * @throws IllegalArgumentException if habitat is not in VALID_HABITATS for Dogs
     */
    @Override public void setHabitat(HABITAT_TYPE habitat) {
        for (HABITAT_TYPE h : VALID_HABITATS) {
            if (h == habitat) {
                super.setHabitat(habitat);
                return;
            }
        }

        throw new IllegalArgumentException(habitat + " is not a valid habitat for dogs"); // Abusive owner
    }

    /**
     * Sets the Dog's feedingSchedule type
     * @param feedingSchedule ideal feeding schedule for the pet as an instance of FEEDING_SCHEDULE enum
     * @throws IllegalArgumentException if feedingSchedule is not in VALID_FEEDING_SCHEDULE for Dogs
     */
    @Override public void setFeedingSchedule(FEEDING_SCHEDULE feedingSchedule) {
        for (FEEDING_SCHEDULE f : VALID_FEEDING_SCHEDULE) {
            if (f == feedingSchedule) {
                super.setFeedingSchedule(f); // This is peak programmer laziness, OOP does all the hard work
                return;
            }
        }

        throw new IllegalArgumentException(feedingSchedule + " is not a valid feeding schedule for dogs");
    }

    /**
     * Sets the breed of dog
     * @param breed the dog's breed
     * @throws IllegalArgumentException if breed is blank
     */
    public void setBreed(String breed) {
        breed = breed.trim();
        if (breed.isBlank()) {
            throw new IllegalArgumentException("Breed cannot be blank");
        }
        this.breed = breed;
    }

    /**
     * Sets the Dog's vaccination status
     * @param status vaccination status
     */
    public void setVaccinated(boolean status) {
        this.vaccinated = status;
    }

    /**
     * Returns whether the dog is vaccinated
     * @return vaccinated
     */
    public boolean getVaccinated() {
        return this.vaccinated;
    }



    /**
     * Returns a String representation of the object
     * @return Dog: {petID}
     */
    @Override public String toString() {
        // Built this way so that Dog d != Pet d since dog has more info that pet doesn't
        return "Dog: " + String.valueOf(this.petID);
    }
}
