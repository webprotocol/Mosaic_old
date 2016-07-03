package com.hybrid.controllers;

import java.util.ResourceBundle;

import javax.inject.Inject;

import org.controlsfx.control.StatusBar;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;

import com.gluonhq.particle.application.Particle;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.form.FormManager;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.ViewManager;
import com.hybrid.service.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;

public class InjectController {

	@FXML
	Button btnSelect;
	@FXML
	ListView<String> listResult;
    @FXML
    ResourceBundle resources;
    
    @Inject
    Service service;
    
    public void initialize() {
    	
//    	ObservableList<String> items = FXCollections.observableArrayList ();

    	btnSelect.setOnAction(e -> {
    		System.out.println("btnSelect...");
    		addContent("btnSelect Clicked...");
//    		listResult.setItems(items);
    	});
    	addContent("initialize()...");
    		
    }
    void addContent(String tag) {
    		listResult.getItems().add("#####################################");
    		listResult.getItems().add("### " + tag);
    		listResult.getItems().add("#####################################");
    		listResult.getItems().add("service.getText = " + service.getText());
    		listResult.getItems().add("label.text = " + resources.getString("label.text"));
    		listResult.getItems().add("ResourceBundle = " + resources);
    		listResult.getItems().add("ParticleApplication = " + app);
    		listResult.getItems().add("Particle = " + particle);
    		listResult.getItems().add("ViewManager = " + viewManager);
    		listResult.getItems().add("FormManager = " + formManager);
    		listResult.getItems().add("StateManager = " + stateManager);
    		listResult.getItems().add("MenuBar = " + menuBar);
    		listResult.getItems().add("ToolBar = " + toolBar);
    		listResult.getItems().add("StatusBar = " + statusBar);
    		listResult.getItems().add("FXMLLoader = " + fxmlLoader);
    }
    
    
    /*
     * Life Cycle
     */
    @Inject ParticleApplication app;
    @Inject Particle particle;
    @Inject ViewManager viewManager;
    @Inject FormManager formManager;
    @Inject StateManager stateManager;
    @Inject MenuBar menuBar;
    @Inject ToolBar toolBar;
    @Inject StatusBar statusBar;
    @Inject FXMLLoader fxmlLoader;
    
    private Action actionHome;
    private Action menu1;
    
    private Menu menu;
    
    public void init() {

    	addContent("init()...");
    	
    	ActionMap.register(this);
    	actionHome =  ActionMap.action("goHome");
    	menu1 =  ActionMap.action("menu1");
    	
    	particle.buildMenu("Injection Test -> [menu1, menu2]");

		menu =  menuBar.getMenus().remove(menuBar.getMenus().size() - 1);
    }
    
    public void postInit() {
        app.getParticle().getToolBarActions().addAll(actionHome, menu1);

        removeMenu();
        
        menuBar.getMenus().add(menu);
       	
    }
    
    public void dispose() {
        app.getParticle().getToolBarActions().removeAll(actionHome, menu1);

        removeMenu();
    }
    
    private void removeMenu() {
    	
		for (int i=0; i<menuBar.getMenus().size(); i++) {
			if (menuBar.getMenus().get(i).getText().equals(menu.getText())) {
				menuBar.getMenus().remove(i);
				i--;
			}
		}
    }

    /*
     * ActionProxy
     */
    
    @ActionProxy(text = "Home")
    private void goHome() {
        viewManager.switchView("primary");
    }
    
    @ActionProxy(text = "Menu1")
    private void menu1() {
    	System.out.println("menu1...");
    }
    
    @ActionProxy(text = "Menu2")
    private void menu2() {
    	System.out.println("menu2...");
    }
    
}
