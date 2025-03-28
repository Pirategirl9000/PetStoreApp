/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore.UI;

enum COMMANDS {
    clearinv,  // Clears the Inventory
    printinv,  // Prints a stringified list of the current pets in Inventory

    setinputfile,  // Sets a file for reading into
    readfile,  // Reads into set file

    setsavefile,  // Sets a save file
    save,  // Save the current changes to inventory

    addpet,  // Activates interface for creating a new pet
    removepet,  // Activates interface for removing a pet

    help,  // Displays Available commands
    quit  // Quits the Running CLI instance
}