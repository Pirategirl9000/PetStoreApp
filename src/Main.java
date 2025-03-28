
/*
• date field
• UML diagram as a JPG file (also checked into GitHub)
 */


/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

import PetStore.UI.PetStore;
import PetStore.types.enums.*;
import PetStore.types.Pet;

/**
 * Driver Code
 */
public class Main {
    public static void main(String[] args) {
        PetStore ps = new PetStore();
        ps.addPet(new Pet("Danny", 5, 30, HABITAT_TYPE.UNSPECIFIED, FEEDING_SCHEDULE.UNSPECIFIED));

        ps.initCLI();



    }
}
