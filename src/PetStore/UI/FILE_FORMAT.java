/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore.UI;

enum FILE_FORMAT {
    PetType,  // Type of Pet (Class name)
    Name,  // Name of the Pet
    Age,  // Age of the Pet
    Weight,  // Weight of the Pet
    Habitat,  // Habitat for the Pet as instance of HABITAT_TYPE enum
    Feeding,  // Feeding Schedule for the Pet as instance of FEEDING_SCHEDULE enum
    Breed,  // Breed of Dog (DOGS ONLY)
    Vaccinated,  // Vaccination Status (DOGS ONLY)
    Venomous,  // Whether snake is venomous (SNAKES ONLY)
    Safe_To_Handle  // Whether snake is safe to handle (SNAKES ONLY)
}
