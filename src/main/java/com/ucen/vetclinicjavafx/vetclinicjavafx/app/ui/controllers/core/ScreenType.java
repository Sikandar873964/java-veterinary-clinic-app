package com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.core;

import com.ucen.vetclinicjavafx.vetclinicjavafx.app.ui.controllers.*;

public enum ScreenType {
    private Class controller;

    ScreenType(Class controller) {
        this.controller = controller;
    }

    public Class getController() {
        return controller;
    }
}
