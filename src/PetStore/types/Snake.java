/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore.types;

import PetStore.types.enums.FEEDING_SCHEDULE;
import PetStore.types.enums.HABITAT_TYPE;

/**
 * Class for handling Snakes, a child of Pet
 */
public class Snake extends Pet {
    /**
     * Boolean representing whether they are safe to handle
     */
    protected boolean safeToHandle = false;

    /**
     * Boolean representing whether they are venomous
     */
    protected boolean venomous = true;

    /**
     * Valid HABITAT_TYPE's for Snakes
     */
    protected final HABITAT_TYPE[] VALID_HABITATS = {HABITAT_TYPE.OUTSIDE, HABITAT_TYPE.INSIDE, HABITAT_TYPE.UNSPECIFIED, HABITAT_TYPE.OTHER, HABITAT_TYPE.TANK};

    /**
     * Create instance of Dog using enum data types for habitat and feedingSchedule
     * @param name the name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     * @param habitat ideal habitat for the pet as an instance of HABITAT_TYPE enum
     * @param feedingSchedule ideal feeding schedule for the pet as an instance of FEEDING_SCHEDULE enum
     * @param venomous whether the snake is venomous
     * @param safeToHandle whether the snake is safe to handle
     */
    public Snake(String name, int age, float weight, HABITAT_TYPE habitat, FEEDING_SCHEDULE feedingSchedule, boolean venomous, boolean safeToHandle) {
        super(name, age, weight, habitat, feedingSchedule);
        this.setPetType("Snake");
        this.venomous = venomous;
        this.safeToHandle = safeToHandle;
    }
    /**
     * Create instance of Snake using String data types for habitat and feedingSchedule
     * @param name name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     * @param habitat ideal habitat for the pet as an instance of HABITAT_TYPE enum
     * @param feedingSchedule ideal feeding schedule for the pet as an instance of FEEDING_SCHEDULE enum
     * @param venomous whether the snake is venomous
     * @param safeToHandle whether the snake is safe to handle
     */
    public Snake(String name, int age, float weight, String habitat, String feedingSchedule, boolean venomous, boolean safeToHandle) {
        super(name, age, weight, habitat, feedingSchedule);
        this.venomous = venomous;
        this.safeToHandle = safeToHandle;
        this.setPetType("Snake");
    }

    /**
     * Create instance of Snake
     * @param name name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     */
    public Snake(String name, int age, float weight) {
        super(name, age, weight);
        this.setPetType("Snake");
        //this.venomous = true
        //this.safeToHandle = false
    }

    /**
     * Create instance of Snake with only a name set
     * @param name name of the pet
     */
    public Snake(String name) {
        super(name);
        this.setPetType("Snake");
        //this.venomous = true
        //this.safeToHandle = false
    }

    /**
     * Creates a blank Snake instance with default values
     */
    public Snake() {
        super();
        this.setPetType("Snake");
        //this.venomous = true
        //this.safeToHandle = false
    }

    /**
     * Sets the Snake's habitat type
     * @param habitat ideal habitat for the pet as an instance of HABITAT_TYPE enum
     * @throws IllegalArgumentException if habitat is not in VALID_HABITATS for Snakes(Domesticated)
     */
    @Override public void setHabitat(HABITAT_TYPE habitat) {
        for (HABITAT_TYPE h : VALID_HABITATS) {
            if (h == habitat) {
                super.setHabitat(habitat);
                return;
            }
        }

        throw new IllegalArgumentException(habitat + " is not a valid habitat for domesticated Snakes"); // Abusive owner
    }

    /**
     * Sets whether the Snake is safe to handle
     * @param status whether the Snake is safeToHandle
     */
    public void setSafeToHandle(boolean status) {
        this.safeToHandle = status;
    }

    /**
     * Returns whether the Snake is safe to handle
     * @return safeToHandle status
     */
    public boolean getSafeToHandle() {
        return this.safeToHandle;
    }

    /**
     * Sets the Snake's venomous status
     * @param status venomous status
     */
    public void setVenomous(boolean status) {
        this.venomous = status;
    }

    /**
     * Returns whether the snake is venomous
     * @return venomous
     */
    public boolean getVenomous() {
        return this.venomous;
    }

    /**
     * Returns a definition of Snake
     * @return snake
     */
    @Override public String toString() {
        // ID|NAME|AGE|WEIGHT|HABITAT|FEEDINGSCHEDULE|||VENOMOUS|SAFETOHANDLE|
        return String.format("%5d|%20s|%7d|%9.2f|%15s|%19s|%20s|%6s|%9s|%15s|", this.petID, this.getName(), this.getAge(), this.getWeight(), this.getHabitat().toString(), this.getFeedingSchedule().toString(), "", "", this.venomous, this.safeToHandle);
    }
}
