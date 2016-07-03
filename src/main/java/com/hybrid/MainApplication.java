package com.hybrid;

import com.gluonhq.ignite.spring.SpringContext;
import com.gluonhq.particle.application.ParticleApplication;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;

import static org.controlsfx.control.action.ActionMap.actions;

import java.util.Arrays;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

public class MainApplication extends SpringParticleApplication {

    public MainApplication() {
        super("Mosaic Application");
    }

    @Override
    public void postInit(Scene scene) {
    	super.postInit(scene);
    	
    	setShowCloseConfirmation(false);
    	
        scene.getStylesheets().add(MainApplication.class.getResource("style.css").toExternalForm());

        setTitle("Mosaic Application");

        getParticle().buildMenu("File -> [exit]",
        						"Spring -> [inject]",
        						"Native -> [Chart -> [piechart, barchart, linechart, areachart], Widget -> [table, list] ]",
		        				"Webapp -> [cube]",		
        						"Help -> [about]");
        
        
        
        
        getParticle().getToolBarActions().addAll(0, actions("about", "exit", "---"));
        
    }

    public static void main(String[] args) {
		launch(args);
	}
    

}