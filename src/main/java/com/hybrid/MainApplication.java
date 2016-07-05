package com.hybrid;

import javafx.scene.Scene;

import static org.controlsfx.control.action.ActionMap.actions;

public class MainApplication extends SpringParticleApplication {

    public MainApplication() {
        super("Mosaic Application");
    }

    @Override
    public void postInit(Scene scene) {
    	
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