/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.UsersDataModel;
import Database.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dahl
 */
@Stateless
public class UsersModuleSession implements UsersModuleSessionRemote {

    @PersistenceContext(unitName = "SlitServer-ejbPU")
    private EntityManager em;

    @Override
    public UsersDataModel getUserFromId(int id) {
        Users user = em.find(Users.class, id);
        
        return convertUser(user); 
    }
    
    private UsersDataModel convertUser(Users user)
    {
        UsersDataModel userDataModule = new UsersDataModel(); 
        
        userDataModule.setId(user.getId());
        userDataModule.setPassword(user.getPassword());
        userDataModule.setFirstName(user.getFirstName());
        userDataModule.setLastName(user.getLastName());
        userDataModule.setMail(user.getMail());
        
        return userDataModule; 
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
