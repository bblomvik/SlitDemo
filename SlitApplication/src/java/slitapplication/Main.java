/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import DataModel.ModuleDataModule;
import Framework.ModuleManager;
import Framework.UserManager;
import java.util.List;

/**
 *
 * @author Dahl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserManager manager = new UserManager();  
        
        System.out.println(manager.getUserFromId(1).getFirstName());
        
        ModuleManager moduleManager = new ModuleManager(); 
        
        List<ModuleDataModule> modules = moduleManager.getModules(); 
        
        for(ModuleDataModule module : modules )
        {
            System.out.println(module.getModuleName());
        }
    }
    
}
