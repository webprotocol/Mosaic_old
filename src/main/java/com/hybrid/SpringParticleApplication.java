package com.hybrid;

import java.util.Arrays;

import javax.inject.Inject;

import org.controlsfx.control.StatusBar;
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

import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;

public class SpringParticleApplication extends ParticleApplication {
	public static ParticleApplication main;
	public static Particle particle;
	public static MenuBar menuBar;
	public static ToolBar toolBar;
	public static StatusBar statusBar;
	public static SpringContext sprintCtx;
	public static ApplicationContext ctx;
	
	@Inject
	ApplicationContext context;
	
	public SpringParticleApplication(String name) {
		super(name);
        
        main = this;
        particle = getParticle();
        
        sprintCtx = new SpringContext(this, () -> Arrays.asList(MainApplication.class.getPackage().getName()));
        sprintCtx.init();
	}
	
	@Override
	public void postInit(Scene scene) {
		super.postInit(scene);
    	ctx = context;
	}
}

@Configuration
@ImportResource({"classpath:com/hybrid/Spring.xml"})
class SpringConfig  {
	public SpringConfig() {
		System.out.println("SpringConfig()...");
	}
	
	@Bean
	public Service provideService() {
		System.out.println("provideService()...");
		return new Service();
	}
	
//	@Bean
//	public Particle provideParticle() {
//		System.out.println("provideParticle()...");
////		return SpringParticleApplication.particle;
//		return null;
//	}
	
//	@Bean
//	public ParticleApplication provideParticleApplication() {
//		System.out.println("provideParticleApplication()...");
////		return SpringParticleApplication.main;
//		return null;
//	}
	
//	@Bean
//	public ViewManager provideViewManager() {
//		System.out.println("provideViewManager()...");
////		return SpringParticleApplication.particle.getViewManager();
//		return null;
//	}

//	@Bean
//	public FormManager provideFormManager() {
//		System.out.println("provideFormManager()...");
////		return SpringParticleApplication.particle.getFormManager();
//		return null;
//	}
	
//	@Bean
//	public StateManager provideStateManager() {
//		System.out.println("provideStateManager()...");
////		return SpringParticleApplication.particle.getStateManager();
//		return null;
//	}	

//	@Bean
//	public MenuBar provideMenuBar() {
//		System.out.println("provideMenuBar()...");
////		return SpringParticleApplication.menuBar;
//		return null;
//	}	

//	@Bean
//	public ToolBar provideToolBar() {
//		System.out.println("provideToolBar()...");
////		return SpringParticleApplication.toolBar;
//		return null;
//	}

//	@Bean
//	public StatusBar provideStatusBar() {
//		System.out.println("provideStatusBar()...");
////		return SpringParticleApplication.statusBar;
//		return null;
//	}

}