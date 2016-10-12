/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitgui;

import DataModel.ModuleDataModule;
import Framework.ModuleManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author Dahl
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private ListView<String> listViewFx;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ModuleManager manager = new ModuleManager();
        
        List<ModuleDataModule> modules = manager.getModules(); 
        
        
        ObservableList<String> items =FXCollections.observableArrayList (); 
        
        for(ModuleDataModule module : modules)
        {
            items.add(module.getModuleName()); 
        }
        
        listViewFx.setItems(items);
    }    
    
}
