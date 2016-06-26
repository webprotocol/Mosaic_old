package com.hybrid;

import com.gluonhq.particle.application.ParticleApplication;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;

import static org.controlsfx.control.action.ActionMap.actions;

import javax.inject.Inject;

public class MainApplication extends ParticleApplication {

    public MainApplication() {
        super("Mosaic Application");
    }

    @Override
    public void postInit(Scene scene) {
    	setShowCloseConfirmation(false);
    	
        scene.getStylesheets().add(MainApplication.class.getResource("style.css").toExternalForm());

        setTitle("Mosaic Application");

        getParticle().buildMenu("File -> [exit]", 
        						"Native -> [Chart -> [piechart, barchart, linechart, areachart], Widget -> [table, list] ]",
		        				"Webapp -> [cube]",		
        						"Help -> [about]");
        
        
        getParticle().getToolBarActions().addAll(0, actions("about", "exit", "---"));
        
    }

    public static void main(String[] args) {
		launch(args);
	}
    

}