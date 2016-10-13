/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ModuleDataModule;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Dahl
 */
@Remote
public interface ModuleSessionBeanRemote {
    
    String getModuleById(int id); 
    
    List<ModuleDataModule> getModules();
    
    List<String> getModulesNames();
    
    String getModuleNameFromId(int id); 
    
    ModuleDataModule getModule(int id) ;
    
    List<ModuleDataModule> getAllModules(); 
    
    boolean storeModule(ModuleDataModule module); 
    
     ModuleDataModule findModuleByName(String moduleName); 
    
}
