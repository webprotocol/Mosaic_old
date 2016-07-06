package com.hybrid.views;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.View;
import com.gluonhq.particle.view.ViewManager;
import com.hybrid.SpringParticleApplication;
import com.hybrid.controllers.PrimaryController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

@ParticleView(name = "primary", isDefault = true)
public class PrimaryView_xxx implements View {
	
    @Inject ParticleApplication app;
    @Inject private ViewManager viewManager;
    @Inject private StateManager stateManager;
    
	@Inject
	FXMLLoader fxmlLoader;
	PrimaryController controller;
	Pane pane;
    
    public PrimaryView_xxx() {
    	
    }
    
    @Override
    public void init() {
    	ResourceBundle resources = ResourceBundle.getBundle("bundles/primary");
    	fxmlLoader.setResources(resources);
    	fxmlLoader.setControllerFactory(SpringParticleApplication.fxmlLoader.getControllerFactory());
    	
		try {
			pane = fxmlLoader.load(PrimaryView_xxx.class.getResourceAsStream("primary.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	controller = (PrimaryController) fxmlLoader.getController();
    	
    	controller.app = app;
    	controller.stateManager = stateManager;
    	controller.viewManager = viewManager;
    	
    	controller.init();
    }
    
    @Override
    public Node getContent() {
    	System.out.println("PrimaryView.getContent()...");
    	return pane;
    }
    
    
    @Override
    public void start() {
   		controller.postInit();
    }
    
    @Override
    public void stop() {
    	controller.dispose();
    }
    
}
