package com.hybrid.controllers;

import com.gluonhq.ignite.spring.SpringContext;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.ViewManager;
import com.hybrid.AutoTest;
import com.hybrid.config.SpringConfig;

import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

public class PrimaryController {

    
    private boolean first = true;
    
    @FXML
    private Label label;
    
    @FXML
    private Button button;
    
    @FXML
    private ResourceBundle resources;
    
    @Autowired
    ApplicationContext ctx;
    
    private Action actionSignin;

    public PrimaryController() {
    	/*
    	 * Spring Init
    	 */
    	SpringContext sprintCtx = new SpringContext(this, () -> Arrays.asList(SpringConfig.class.getPackage().getName()));
    	sprintCtx.init();
    	SpringConfig.sprintCtx = sprintCtx;
    }
    
    public void initialize() {
        ActionMap.register(this);
        actionSignin =  ActionMap.action("signin");
        
        button.setOnAction(e -> { 
        	viewManager.switchView("secondary");
        	AutoTest a = SpringConfig.sprintCtx.getInstance(AutoTest.class);
//        	AutoTest a = new AutoTest();
//        	ctx.getAutowireCapableBeanFactory().autowireBean(a);
        	
        	System.out.println("AutoTest a = " + a.ctx);
        
        });
        
        System.out.println("PrimaryController.initialize()... " +  ctx);
        
    }
    
    @Inject private ParticleApplication app;
    @Inject private ViewManager viewManager;
    @Inject private StateManager stateManager;
    
    @Inject private FXMLLoader fxmlLoader;

    public void init() {
    	/*
    	 * fxmlLoader <- Spring
    	 */
    	fxmlLoader.setControllerFactory(ctx.getBean(FXMLLoader.class).getControllerFactory());
    	System.out.println("PrimaryController.init()... " +  fxmlLoader.getControllerFactory());
    }
    
    public void postInit() {
        if (first) {
            stateManager.setPersistenceMode(StateManager.PersistenceMode.USER);
            addUser(stateManager.getProperty("UserName").orElse("").toString());
            first = false;
        }
        app.getParticle().getToolBarActions().add(actionSignin);
    }
    
    public void dispose() {
        app.getParticle().getToolBarActions().remove(actionSignin);
    }
    
    public void addUser(String userName) {
        label.setText(resources.getString("label.text") + (userName.isEmpty() ? "" :  ", " + userName) + "!");
        stateManager.setProperty("UserName", userName);
    }

    @ActionProxy(text="Sign In")
    private void signin() {
        TextInputDialog input = new TextInputDialog(stateManager.getProperty("UserName").orElse("").toString());
        input.setTitle("User name");
        input.setHeaderText(null);
        input.setContentText("Input your name:");
        input.showAndWait().ifPresent(this::addUser);
    }

}