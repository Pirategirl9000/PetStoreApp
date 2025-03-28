
/*
• include your group member’s full names and repo URL in each class
• using protected access modifier when appropriate
• date field
• 2 derived classes. Possible suggestions: Fish, Bird, etc.
• 2 unique fields per derived class.
• A user-friendly interface for managing the Pet’s store inventory
which allows:
• adding inventory
• display the inventory in a column structured list using printf
• saving the inventory to a text file, using piped delimited
• loading the inventory from a text file, using piped delimited
• UML diagram as a JPG file (also checked into GitHub)


• Optional (extra credit points):
• 5 points = updating inventory
• 5 points = properly written README.md
• 5 points = properly written JavaDoc
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
