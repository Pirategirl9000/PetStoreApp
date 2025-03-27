/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore.UI;

enum COMMANDS {
    clearInv,  // Clears the Inventory
    printInv,  // Prints a stringified list of the current pets in Inventory

    setInputFile,  // Sets a file for reading into
    readFile,  // Reads into set file

    setSaveFile,  // Sets a save file
    save,  // Save the current changes to inventory

    addPet,  // Activates interface for creating a new pet
    removePet,  // Activates interface for removing a pet

    help,  // Displays Available commands
    quit  // Quits the Running CLI instance
}