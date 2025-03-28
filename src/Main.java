
/*
• date field
• UML diagram as a JPG file (also checked into GitHub)
 */


/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

import PetStore.UI.PetStore;

/**
 * Driver Code
 */
public class Main extends PetStore {
    /**
     * Starts the program loop
     */
    public Main() {
        this.initCLI();

        // try to save, if it can't save it then it's not my problem, you'll have to ask 'e'
        try {
            this.saveToFile();
        } catch (Exception e) {
            return;
        }
    }

    /**
     * Driver code calls constructor and initCLI()
     * @param args null
     */
    public static void main(String[] args) {
        Main petStore = new Main();
    }
}
