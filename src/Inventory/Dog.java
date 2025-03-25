/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package Inventory;

public class Dog extends Pet {

    /**
     * Create instance of Dog using enum data types for habitat and feedingSchedule
     * @param name the name of the pet
     * @param age age of the pet
     * @param weight weight of the pet
     * @param habitat ideal habitat for the pet as an instance of HABITAT_TYPE enum
     * @param feedingSchedule ideal feeding schedule for the pet as an instance of FEEDING_SCHEDULE enum
     */
    public Dog(String name, int age, float weight, HABITAT_TYPE habitat, FEEDING_SCHEDULE feedingSchedule) {
        super(name, age, weight, habitat, feedingSchedule);
    }

    public Dog(String name, int age, float weight, String habitat, String feedingSchedule) {
        super(name, age, weight, habitat, feedingSchedule);
    }

    public Dog(String name, int age, float weight) {
        super(name, age, weight);
    }

    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }
}
