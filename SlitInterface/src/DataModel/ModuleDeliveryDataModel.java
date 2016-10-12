/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

/**
 *
 * @author Dahl
 */
public class ModuleDeliveryDataModel implements java.io.Serializable {
    
    private String userId; 
    
    private String moduleId; 
    
    private String uploadDate;  
    
    private boolean moduleStatus; 
    
    private String moduleDelivery; 
    
    private String moduleAssesmentComment; 

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public boolean isModuleStatus() {
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
    
   
}
