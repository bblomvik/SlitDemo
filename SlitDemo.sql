use SlitDemo; 


CREATE TABLE Users
(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    firstName VARCHAR(64) NOT NULL, 
    lastName VARCHAR(64) NOT NULL, 
    password VARCHAR(64) NOT NULL, 
    mail VARCHAR(64) NOT NULL
);

CREATE TABLE Module 
(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    moduleName VARCHAR(128) NOT NULL, 
    moduleSummary TEXT NULL, 
    moduleDescription TEXT NULL
); 

CREATE TABLE ModuleDelivery(
	userId INT, 
    moduleId INT, 
    uploadDate TIMESTAMP NOT NULL DEFAULT NOW(), 
    moduleStatus BOOLEAN NOT NULL DEFAULT FALSE, 
    moduleDelivery TEXT NULL, 
    moduleAssesmentComment TEXT NULL,
    CONSTRAINT moduleDelivery_pk PRIMARY KEY(userId, moduleId), 
    CONSTRAINT moduleDelivery_module_fk FOREIGN KEY(moduleId) REFERENCES Module(id), 
    CONSTRAINT mdouleDelivery_user_fk FOREIGN KEY(userId) REFERENCES Users(id)
); 

INSERT INTO Users VALUES(null, 'John Martin', 'Dahl', 'Test123', 'kaalsaas@hotmail.com'); 
INSERT INTO Users VALUES(null, 'Robin', 'Rondestvedt', 'Test123', 'robin_rondestvedt@live.no');

INSERT INTO Module(moduleName, moduleSummary, moduleDescription) VALUES ('Module 1', 'Module 1 wuhu', 'In the module one you are supposed to do'); 
INSERT INTO Module(moduleName, moduleSummary, moduleDescription) VALUES ('Module 2', 'Module 2 wuhu', 'In the module one you are supposed to do'); 

INSERT INTO ModuleDelivery (userId, moduleId, moduleDelivery) VALUES (1, 1, 'Test of delivery for user 1'); 
  

