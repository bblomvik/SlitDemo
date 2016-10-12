/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.UsersDataModel;
import javax.ejb.Remote;

/**
 *
 * @author Dahl
 */
@Remote
public interface UsersModuleSessionRemote {
    
    UsersDataModel getUserFromId(int id); 
    
}
