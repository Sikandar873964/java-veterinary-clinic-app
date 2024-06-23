package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.*;

public enum ScreenType {
    ALL_HOSPITALS_SCREEN(AllHospitalsScreenController.class),
    CREATE_HOSPITAL_SCREEN(CreateHospitalScreenController.class),
    MY_BOOKINGS_SCREEN(MyBookingsScreenController.class),
    USER_LOGIN_SCREEN(UserLoginScreenController.class);
    private Class controller;

    ScreenType(Class controller) {
        this.controller = controller;
    }

    public Class getController() {
        return controller;
    }
}
