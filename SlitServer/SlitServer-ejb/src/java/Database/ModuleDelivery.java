/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dahl
 */
@Entity
@Table(name = "ModuleDelivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModuleDelivery.findAll", query = "SELECT m FROM ModuleDelivery m")
    , @NamedQuery(name = "ModuleDelivery.findByUserId", query = "SELECT m FROM ModuleDelivery m WHERE m.moduleDeliveryPK.userId = :userId")
    , @NamedQuery(name = "ModuleDelivery.findByModuleId", query = "SELECT m FROM ModuleDelivery m WHERE m.moduleDeliveryPK.moduleId = :moduleId")
    , @NamedQuery(name = "ModuleDelivery.findByUploadDate", query = "SELECT m FROM ModuleDelivery m WHERE m.uploadDate = :uploadDate")
    , @NamedQuery(name = "ModuleDelivery.findByModuleStatus", query = "SELECT m FROM ModuleDelivery m WHERE m.moduleStatus = :moduleStatus")})
public class ModuleDelivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModuleDeliveryPK moduleDeliveryPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uploadDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "moduleStatus")
    private boolean moduleStatus;
    @Lob
    @Size(max = 65535)
    @Column(name = "moduleDelivery")
    private String moduleDelivery;
    @Lob
    @Size(max = 65535)
    @Column(name = "moduleAssesmentComment")
    private String moduleAssesmentComment;
    @JoinColumn(name = "moduleId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Module module;
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public ModuleDelivery() {
    }

    public ModuleDelivery(ModuleDeliveryPK moduleDeliveryPK) {
        this.moduleDeliveryPK = moduleDeliveryPK;
    }

    public ModuleDelivery(ModuleDeliveryPK moduleDeliveryPK, Date uploadDate, boolean moduleStatus) {
        this.moduleDeliveryPK = moduleDeliveryPK;
        this.uploadDate = uploadDate;
        this.moduleStatus = moduleStatus;
    }

    public ModuleDelivery(int userId, int moduleId) {
        this.moduleDeliveryPK = new ModuleDeliveryPK(userId, moduleId);
    }

    public ModuleDeliveryPK getModuleDeliveryPK() {
        return moduleDeliveryPK;
    }

    public void setModuleDeliveryPK(ModuleDeliveryPK moduleDeliveryPK) {
        this.moduleDeliveryPK = moduleDeliveryPK;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public boolean getModuleStatus() {
        return moduleStatus;
    }

    public void setModuleStatus(boolean moduleStatus) {
        this.moduleStatus = moduleStatus;
    }

    public String getModuleDelivery() {
        return moduleDelivery;
    }

    public void setModuleDelivery(String moduleDelivery) {
        this.moduleDelivery = moduleDelivery;
    }

    public String getModuleAssesmentComment() {
        return moduleAssesmentComment;
    }

    public void setModuleAssesmentComment(String moduleAssesmentComment) {
        this.moduleAssesmentComment = moduleAssesmentComment;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduleDeliveryPK != null ? moduleDeliveryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModuleDelivery)) {
            return false;
        }
        ModuleDelivery other = (ModuleDelivery) object;
        if ((this.moduleDeliveryPK == null && other.moduleDeliveryPK != null) || (this.moduleDeliveryPK != null && !this.moduleDeliveryPK.equals(other.moduleDeliveryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.ModuleDelivery[ moduleDeliveryPK=" + moduleDeliveryPK + " ]";
    }
    
}
