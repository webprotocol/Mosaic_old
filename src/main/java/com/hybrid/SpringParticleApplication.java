package com.hybrid;

import java.util.Arrays;

import javax.inject.Inject;

import org.controlsfx.control.StatusBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.gluonhq.ignite.spring.SpringContext;
import com.gluonhq.particle.application.Particle;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.form.FormManager;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.ViewManager;
import com.hybrid.service.Service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;

public class SpringParticleApplication extends ParticleApplication {
	public static FXMLLoader fxmlLoader;
	public static SpringContext sprintCtx;
	public static ApplicationContext ctx;
	
	@Autowired
	ApplicationContext context;
	@Autowired
	FXMLLoader springFxmlLoader;	// Spring FXMLLoader
	
	public SpringParticleApplication(String name) {
		super(name);
		System.out.println("SpringParticleApplication()...");
        
        sprintCtx = new SpringContext(this, () -> Arrays.asList(SpringParticleApplication.class.getPackage().getName()));
        sprintCtx.init();
        
        ctx = context;
        fxmlLoader = springFxmlLoader;
	}
}

