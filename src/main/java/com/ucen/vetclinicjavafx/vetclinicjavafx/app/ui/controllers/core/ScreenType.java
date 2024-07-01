package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.*;

/**
 * The enum Screen type.
 */
public enum ScreenType {
    /**
     * All animals screen screen type.
     */
    ALL_ANIMALS_SCREEN(AllAnimalsScreenController.class),
    /**
     * All hospitals screen screen type.
     */
    ALL_HOSPITALS_SCREEN(AllHospitalsScreenController.class),
    /**
     * Create animal screen screen type.
     */
    CREATE_ANIMAL_SCREEN(CreateAnimalScreenController.class),
    /**
     * Create hospital booking screen screen type.
     */
    CREATE_HOSPITAL_BOOKING_SCREEN(CreateHospitalBookingScreenController.class),
    /**
     * Create hospital screen screen type.
     */
    CREATE_HOSPITAL_SCREEN(CreateHospitalScreenController.class),
    /**
     * My bookings screen screen type.
     */
    MY_BOOKINGS_SCREEN(MyBookingsScreenController.class),
    /**
     * User login screen screen type.
     */
    USER_LOGIN_SCREEN(UserLoginScreenController.class);
    private Class controller;

    ScreenType(Class controller) {
        this.controller = controller;
    }

    /**
     * Gets controller.
     *
     * @return the controller
     */
    public Class getController() {
        return controller;
    }
}
