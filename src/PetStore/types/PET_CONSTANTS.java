/*
@Author: Violet French
@src: https://github.com/Pirategirl9000/PetStoreApp
 */

package PetStore.types;

/**
 * Interface containing constants for Pet Objects or those superseded by Pet
 */
public interface PET_CONSTANTS {
    /**
     * Stores various common feeding schedule constants
     */
     enum FEEDING_SCHEDULE {
        TRI_DAILY,
        TWICE_DAILY,
        DAILY,
        TRI_WEEKLY,
        TWICE_WEEKLY,
        WEEKLY,
        OTHER,
        UNSPECIFIED
    }

    /**
     * Stores various common habitat type constants
     */
    enum HABITAT_TYPE {
        CAGE,
        TANK,
        INSIDE,
        OUTSIDE,
        PEN,
        OTHER,
        UNSPECIFIED
    }
}
