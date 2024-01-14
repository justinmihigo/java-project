-- Hospital Table
CREATE TABLE hospital (
    hospitalId INT AUTO_INCREMENT PRIMARY KEY,
    hospitalName VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(255)
);

-- Doctor Table
CREATE TABLE doctors (
    doctorId INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(255),
    lname VARCHAR(255),
    specialization VARCHAR(255),
    hospitalId INT,
    hospitalName VARCHAR(255), -- Added
    dob DATE, -- Added
    gender VARCHAR(10), -- Added
    email VARCHAR(255)
);

-- Parent Table
CREATE TABLE parents (
    parentId INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(255),
    lname VARCHAR(255),
    sex VARCHAR(10), -- Added
    dob DATE, -- Added
    email VARCHAR(255)
);

-- Child Table
CREATE TABLE child (
    childId INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(255),
    lname VARCHAR(255),
    dob DATE,
    age INT, -- Added
    gender VARCHAR(10), -- Added
    parentId INT
);

-- GrowthData Table
CREATE TABLE growthdata (
    growthdataId INT AUTO_INCREMENT PRIMARY KEY,
    childId INT,
    doneat DATE,
    height DECIMAL(5,2),
    weight DECIMAL(5,2),
    headCircum DECIMAL(5,2)
);

-- Recommendations Table
CREATE TABLE recommendations (
    recommendId INT AUTO_INCREMENT PRIMARY KEY,
    parentId INT, -- Modified
    doneat DATE,
    recommendtext TEXT
);

-- Vaccinations Table
CREATE TABLE vaccination (
    vaccineId INT AUTO_INCREMENT PRIMARY KEY,
    childId INT,
    vaccineName VARCHAR(255)
);

-- Appointment Table
CREATE TABLE Appointment (
    appointmentId INT AUTO_INCREMENT PRIMARY KEY,
    appointDate DATE,
    childId INT,
    parentId INT,
    hospitalId INT,
    doctorId INT
);

-- HealthConsultant Table
CREATE TABLE healthconsultant (
    consultantID INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(255),
    lname VARCHAR(255),
    email VARCHAR(255),
    tel VARCHAR(15),
    address VARCHAR(255),
    dob DATE,
    childId INT
);

CREATE TABLE users (
    userId INT AUTO_INCREMENT PRIMARY KEY, 
    fname VARCHAR(255),
    lname VARCHAR(255),
    dob VARCHAR(255),
    tel VARCHAR(25),
    email VARCHAR(255),
    password VARCHAR(255),
    gender VARCHAR(16)
);
