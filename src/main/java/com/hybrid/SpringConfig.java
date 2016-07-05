package com.hybrid;

import org.controlsfx.control.StatusBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.gluonhq.particle.application.Particle;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.form.FormManager;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.ViewManager;

import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;

@Configuration
@ImportResource({"classpath:SpringConfig.xml"} )
class SpringConfig  {
	public SpringConfig() {
		System.out.println("SpringConfig()...");
	}
	
	@Bean
	public Particle provideParticle() {
		System.out.println("provideParticle()...");
		return null;
	}
	
	@Bean
	public ParticleApplication provideParticleApplication() {
		System.out.println("provideParticleApplication()...");
		return null;
	}
	
	@Bean
	public ViewManager provideViewManager() {
		System.out.println("provideViewManager()...");
		return null;
	}

	@Bean
	public FormManager provideFormManager() {
		System.out.println("provideFormManager()...");
		return null;
	}
	
	@Bean
	public StateManager provideStateManager() {
		System.out.println("provideStateManager()...");
		return null;
	}	

	@Bean
	public MenuBar provideMenuBar() {
		System.out.println("provideMenuBar()...");
		return null;
	}	

	@Bean
	public ToolBar provideToolBar() {
		System.out.println("provideToolBar()...");
		return null;
	}

	@Bean
	public StatusBar provideStatusBar() {
		System.out.println("provideStatusBar()...");
		return null;
	}	
	
}