package com.hybrid.actions;

import javax.inject.Inject;

import org.controlsfx.control.StatusBar;

import com.gluonhq.particle.annotation.ParticleActions;
import com.hybrid.SpringParticleApplication;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;

@ParticleActions
public class SpringMenuActions {

	@Inject MenuBar menuBar;
	@Inject ToolBar toolBar;
	@Inject StatusBar statusBar;
    @Inject FXMLLoader fxmlLoader;	// Gluon FXMLLoader
    
    public SpringMenuActions() {
    	Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				
				SpringParticleApplication.menuBar = menuBar;
				SpringParticleApplication.toolBar = toolBar;
				SpringParticleApplication.statusBar = statusBar;
				
				/*
				 * Gluon FXMLLoader ==> Spring FXMLLoader 로 교체
				 */
				fxmlLoader.setControllerFactory(SpringParticleApplication.ctx.getBean(FXMLLoader.class).getControllerFactory());
			}
		});
	}

}