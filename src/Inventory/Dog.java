/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package Inventory;

public class Dog extends Pet {
    public Dog(String name, int age, float weight, HABITAT_TYPE habitat, FEEDING_SCHEDULE feedingSchedule) {
        super(name, age, weight, habitat, feedingSchedule);
    }

    public Dog(String name, int age, float weight, String habitat, String feedingSchedule) {
        super(name, age, weight, habitat, feedingSchedule);
    }

    public Dog(String name, int age, float weight) {
        super(name, age, weight);
    }

    public Dog(String name, int age) {
        super(name);
    }
}
