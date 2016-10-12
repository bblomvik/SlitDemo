/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Dahl
 */
@Embeddable
public class ModuleDeliveryPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "userId")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "moduleId")
    private int moduleId;

    public ModuleDeliveryPK() {
    }

    public ModuleDeliveryPK(int userId, int moduleId) {
        this.userId = userId;
        this.moduleId = moduleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) moduleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModuleDeliveryPK)) {
            return false;
        }
        ModuleDeliveryPK other = (ModuleDeliveryPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.moduleId != other.moduleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.ModuleDeliveryPK[ userId=" + userId + ", moduleId=" + moduleId + " ]";
    }
    
}
