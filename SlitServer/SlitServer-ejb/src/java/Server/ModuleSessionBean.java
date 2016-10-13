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

    /**
     * Get a module name by id.
     * @param id
     * @return 
     */
    @Override
    public String getModuleById(int id) {
        return "test"; 
    }

    /**
     * Get all the modules in the database. 
     * @return List<ModuleDataModule> 
     */
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
    
    /**
     * Get all the modules with only the names. 
     * @return List<String> 
     */
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
    
    /**
     * Convert Entity module to a ModuleDataModule 
     * @param module
     * @return ModuleDataModule 
     */
    public ModuleDataModule convertModule(Module module) 
    {
        ModuleDataModule moduleDataModule = new ModuleDataModule(); 
        
        moduleDataModule.setId(module.getId());
        moduleDataModule.setModuleDescription(module.getModuleDescription());
        moduleDataModule.setModuleName(module.getModuleName());
        moduleDataModule.setModuleSummary(module.getModuleSummary());
        
        return moduleDataModule; 
    }
   
    /**
     * Convert a ModuleDataModule to an entity.
     * @param module
     * @return Module
     */
    private Module convertToModuleEntity(ModuleDataModule module) 
    {
        Module moduleEntity = new Module(); 
        
        moduleEntity.setId(module.getId());
        moduleEntity.setModuleDescription(module.getModuleDescription());
        moduleEntity.setModuleName(module.getModuleName());
        moduleEntity.setModuleSummary(module.getModuleSummary());
        
        return moduleEntity; 
    }
    
    /**
     * Get module name from id. 
     * @param id
     * @return String
     */
    @Override
    public String getModuleNameFromId(int id) 
    {
        Module module = em.find(Module.class, id);
        
        return module.getModuleName(); 
    }
    
    /**
     * Get module from id. 
     * @param id
     * @return ModuleDataModule
     */
    @Override 
    public ModuleDataModule getModule(int id) 
    {
        Module module = em.find(Module.class, id);
        
        return this.convertModule(module); 
    }
    
    /**
     * Get all modules in the database. 
     * @return List<ModuleDataModule>
     */
    @Override
    public List<ModuleDataModule> getAllModules() 
    {
        
        List<ModuleDataModule> moduleList = new ArrayList<ModuleDataModule>();
        
        try 
        {
            Query query = em.createNamedQuery("Module.findAll", Module.class); 
            
            List<Module> modules = query.getResultList();
            
            for(Module module : modules) 
            {
                moduleList.add(this.convertModule(module)); 
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        return moduleList; 
    }

    /**
     * Find
     * @param moduleName
     * @return ModuleDataModule
     */
    @Override 
    public ModuleDataModule findModuleByName(String moduleName)
    {
        ModuleDataModule retModule = new ModuleDataModule(); 
        
        try 
        {
            Query query = em.createNamedQuery("Module.findByModuleName", Module.class);
            
            query.setParameter("moduleName", moduleName);
            
            Module module = (Module)query.getSingleResult();
            
            retModule = this.convertModule(module);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return retModule; 
    }
    
    /**
     * Store a module to the database. 
     * @param module
     * @return boolean 
     */
    @Override
    public boolean storeModule(ModuleDataModule module)
    {
        Module moduleEntity = this.convertToModuleEntity(module);
        
        try 
        {
            em.persist(moduleEntity);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
            return false; 
        }
        
        return true; 
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
