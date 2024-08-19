CREATE TABLE TblRegistration (
pkRegID		 INTEGER(5) AUTO_INCREMENT,
UserName	 VARCHAR(30),
EmailId		 VARCHAR(30),
pwd	 	 VARCHAR(15),
RegistrationType CHAR(1),
ActiveFlag 	 CHAR(1),
CreatedDateTime	 DATE,
CreatedByIP	 VARCHAR(15),
PRIMARY KEY (pkRegID)
) ;

CREATE TABLE TblForgotPassword (
pkFPID		Integer(5) AUTO_INCREMENT,
EmailId		Varchar(30),
CreatedDateTime	Date,
CreatedByIP	Varchar(15),
PRIMARY KEY (pkFPID)
) ;

CREATE TABLE TblLogin (
pkLoginID	INTEGER(5) AUTO_INCREMENT,
EmailId		VARCHAR(30),
fkRegID		INTEGER(5),
CreatedDateTime	DATE,
CreatedByIP	VARCHAR(15),
PRIMARY KEY (pkLoginID),
FOREIGN KEY (fkRegID) REFERENCES TblRegistration(pkRegID)
);

CREATE TABLE TblCustomer (
pkCustomerID		Integer(5) AUTO_INCREMENT,
CustomerName		Varchar(30),
CustomerEmailID		Varchar(30),
CustomerContactNo	Varchar(10),
CustomerAddress		Varchar(100),
CustomerCity		Varchar(20),
CustomerState		Varchar(20),
CustomerCountry		Varchar(20),
fkRegID			INTEGER(5),
CreatedDateTime		Date,
CreatedByIP		Varchar(15),
Primary key (pkCustomerID),
FOREIGN KEY (fkRegID) REFERENCES TblRegistration(pkRegID)
);

CREATE TABLE TblProject (
pkProjectID		Integer(5) AUTO_INCREMENT,
ProjectName		Varchar(30),
ProjectDescription	Varchar(30),
fkCustomerID		Integer(5),
ProjectDuration		Integer(4),
ProjectStartDate	Date,
ProjectEndDate		Date,	
ProjectCost		Integer(7),
ProjectRemarks		Varchar(100),
ProjectStatus		Varchar(20),
fkRegID			INTEGER(5),
CustomerReview		Varchar(100),
CreatedDateTime		Date,
CreatedByIP		Varchar(15),
Primary key (pkProjectID),
FOREIGN KEY (fkCustomerID) REFERENCES TblCustomer(pkCustomerID),
FOREIGN KEY (fkRegID) REFERENCES TblRegistration(pkRegID)
);

CREATE TABLE TblCustomerFeedback (
pkFeedbackID	Integer(5) AUTO_INCREMENT,
CustomerEmailID	Varchar(30),
Description	Varchar(100),
Suggestion	Varchar(100),
fkRegID		INTEGER(5),
CreatedDateTime	Date,
CreatedByIP	Varchar(15),
Primary key (pkFeedbackID),
FOREIGN KEY (fkRegID) REFERENCES TblRegistration(pkRegID)
);

CREATE TABLE TblCustomerQuery (
pkQueryID	INTEGER(5) AUTO_INCREMENT,
CustomerEmailID	VARCHAR(30),
Description	VARCHAR(100),
Suggestion	VARCHAR(100),
Response	VARCHAR(100),
fkResponseID	INTEGER(5),
fkRegID		INTEGER(5),
ResponseDate	DATE,
CreatedDateTime	DATE,
CreatedByIP	VARCHAR(15),
PRIMARY KEY (pkQueryID),
FOREIGN KEY (fkResponseID) REFERENCES TblRegistration(pkRegID),
FOREIGN KEY (fkRegID) REFERENCES TblRegistration(pkRegID)
);

CREATE TABLE TblContactUs (
pkContactUsID	INTEGER(5) AUTO_INCREMENT,
YourName	VARCHAR(30),
YourEmailID	VARCHAR(30),
YourMessage	VARCHAR(100),
CreatedDateTime	DATE,
CreatedByIP	VARCHAR(15),
PRIMARY KEY     (pkContactUsID)
);
