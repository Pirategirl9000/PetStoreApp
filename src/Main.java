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
            return;  // Should've configured a save file, don't hold me accountable for your own failures
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
