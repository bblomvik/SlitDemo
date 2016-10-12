/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ModuleDataModule;
import Database.Module;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dahl
 */
@Stateless
public class ModuleSessionBean implements ModuleSessionBeanRemote {

    @PersistenceContext(unitName = "SlitServer-ejbPU")
    private EntityManager em;

    @Override
    public String getModuleById(int id) {
        return "test"; 
    }

    @Override
    public List<ModuleDataModule> getModules()
    {
        
        List<ModuleDataModule> dataModules = new ArrayList<ModuleDataModule>(); 

        
        try 
        {
            Query query = em.createNamedQuery("Module.findAll", Module.class);
            
            List<Module> modules = query.getResultList();
            
            
            for(Module module : modules) 
            {
                dataModules.add(this.convertModule(module)); 
            }
           
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return dataModules;
    }
    
    @Override
    public List<String> getModulesNames()
    {
        List<String> dataModules = new ArrayList<String>(); 
        
        try 
        {
            Query query = em.createNamedQuery("Module.findAll", Module.class);
            
            List<Module> modules = query.getResultList();
            
  
            for(Module module : modules) 
            {
                dataModules.add(module.getModuleName()); 
            }
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        return dataModules; 
    }
    
    public ModuleDataModule convertModule(Module module) 
    {
        ModuleDataModule moduleDataModule = new ModuleDataModule(); 
        
        moduleDataModule.setId(module.getId());
        moduleDataModule.setModuleDescription(module.getModuleDescription());
        moduleDataModule.setModuleName(module.getModuleName());
        moduleDataModule.setModuleSummary(module.getModuleSummary());
        
        return moduleDataModule; 
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
