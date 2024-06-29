package com.ucen.vetclinicjavafx.vetclinicjavafx.app;

import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FxWeaverConfiguration
{
    public FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext)
    {
        return new SpringFxWeaver(applicationContext);
    }
}
