DROP DATABASE IF EXISTS filtro;
CREATE DATABASE filtro;
USE filtro; 

CREATE TABLE type_of_content(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE StateVisualization(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    stateVisualization VARCHAR(255) NOT NULL
);

CREATE TABLE Gender(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    gender VARCHAR(255) NOT NULL
);

CREATE TABLE Costumer(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    secondName VARCHAR(255),
    firstLastName VARCHAR(255) NOT NULL,
    secondLastName VARCHAR(255)
);

CREATE TABLE Platform(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    typeOfContent_ID BIGINT NOT NULL,
    FOREIGN KEY(typeOfContent_ID) REFERENCES type_of_content(id)
);

CREATE TABLE AudioVisual(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    platform_ID BIGINT NOT NULL,
    gender_ID BIGINT NOT NULL,
    stateVisualization_ID BIGINT NOT NULL,
    FOREIGN KEY(platform_ID) REFERENCES Platform(id),
    FOREIGN KEY(gender_ID) REFERENCES Gender(id),
    FOREIGN KEY(stateVisualization_ID) REFERENCES StateVisualization(id)
);

CREATE TABLE CostumerAudioVisual(
    costumer_ID BIGINT NOT NULL,
    audioVisual_ID BIGINT NOT NULL,
    PRIMARY KEY(costumer_ID, audioVisual_ID),
    FOREIGN KEY(costumer_ID) REFERENCES Costumer(id),
    FOREIGN KEY(audioVisual_ID) REFERENCES AudioVisual(id)
);

CREATE TABLE Register(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    qualification DOUBLE NOT NULL,
    comment VARCHAR(255) NOT NULL,
    audioVisual_ID BIGINT NOT NULL,
    FOREIGN KEY(audioVisual_ID) REFERENCES AudioVisual(id)
);
