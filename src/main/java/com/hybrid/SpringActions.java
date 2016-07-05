package com.hybrid;

import com.gluonhq.particle.annotation.ParticleActions;
import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.inject.Inject;
import org.controlsfx.control.action.ActionProxy;

@ParticleActions
public class SpringActions {

    @Inject FXMLLoader fxmlLoader;	// Gluon FXMLLoader
    
    public SpringActions() {
    	Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("SpringActions()...");
				/*
				 * Gluon FXMLLoader ==> Spring FXMLLoader
				 */
				fxmlLoader.setControllerFactory(SpringParticleApplication.fxmlLoader.getControllerFactory());
			}
		});
	}
}