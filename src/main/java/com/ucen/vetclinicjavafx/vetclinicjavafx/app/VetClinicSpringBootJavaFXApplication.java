package com.ucen.vetclinicjavafx.vetclinicjavafx.app;

import com.ucen.vetclinicjavafx.vetclinicjavafx.VetClinincApplication;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.events.models.StageReadyEvent;
import com.ucen.vetclinicjavafx.vetclinicjavafx.app.services.HospitalService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * The type Vet clinic spring boot java fx application.
 */
public class VetClinicSpringBootJavaFXApplication extends Application {

    private ConfigurableApplicationContext context;


    @Override
    public void init() throws Exception {
        ApplicationContextInitializer<GenericApplicationContext> initializer =
                context -> {
                    context.registerBean(Application.class, () -> VetClinicSpringBootJavaFXApplication.this);
                    context.registerBean(Parameters.class, this::getParameters); // for demonstration, not really needed
                };
        this.context = new SpringApplicationBuilder()
                .sources(VetClinincApplication.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Starting applicatino");

        HospitalService hospitalService=context.getBean(HospitalService.class);
        context.publishEvent(new StageReadyEvent( primaryStage)); //(2)
    }

    @Override
    public void stop() throws Exception { //(3)
        this.context.close();
        Platform.exit();
    }
}
