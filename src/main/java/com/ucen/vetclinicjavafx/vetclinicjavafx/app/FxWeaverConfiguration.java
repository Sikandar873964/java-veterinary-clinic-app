package com.ucen.vetclinicjavafx.vetclinicjavafx.app;

import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * The type Fx weaver configuration.
 */
@Configuration
public class FxWeaverConfiguration
{
    /**
     * Fx weaver fx weaver.
     *
     * @param applicationContext the application context
     * @return the fx weaver
     */
    public FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext)
    {
        return new SpringFxWeaver(applicationContext);
    }
}
