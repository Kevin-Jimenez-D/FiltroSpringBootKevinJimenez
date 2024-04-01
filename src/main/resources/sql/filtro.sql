DROP DATABASE IF EXISTS filtro;
CREATE DATABASE filtro;
USE filtro; 
CREATE TABLE TypeOfContent(
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE StateVisualization(
    id VARCHAR(255) NOT NULL,
    stateVisualization VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE Gender(
    id VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE Costumer(
    id VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    secondName VARCHAR(255) NULL,
    firstLastName VARCHAR(255) NOT NULL,
    secondLastName VARCHAR(255) NULL,
    PRIMARY KEY(id)
);
CREATE TABLE Platform(
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    typeOfContent_ID VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE CostumerAudioVisual(
    costumer_ID VARCHAR(255) NOT NULL,
    audioVisual_ID VARCHAR(255) NOT NULL,
    PRIMARY KEY(costumer_ID,audioVisual_ID)
);
CREATE TABLE Register(
    id VARCHAR(255) NOT NULL,
    qualification DOUBLE NOT NULL,
    comment VARCHAR(255) NOT NULL,
    audioVisual_ID VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE AudioVisual(
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    platform_ID VARCHAR(255) NOT NULL,
    gender_ID VARCHAR(255) NOT NULL,
    stateVisualization_ID VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
ALTER TABLE
    AudioVisual ADD CONSTRAINT audiovisual_gender_id_foreign FOREIGN KEY(gender_ID) REFERENCES Gender(id);

ALTER TABLE
    Register ADD CONSTRAINT register_audiovisual_id_foreign FOREIGN KEY(audioVisual_ID) REFERENCES AudioVisual(id);
ALTER TABLE
    AudioVisual ADD CONSTRAINT audiovisual_statevisualization_id_foreign FOREIGN KEY(stateVisualization_ID) REFERENCES StateVisualization(id);
ALTER TABLE
    Platform ADD CONSTRAINT platform_typeofcontent_id_foreign FOREIGN KEY(typeOfContent_ID) REFERENCES TypeOfContent(id);
ALTER TABLE
    CostumerAudioVisual ADD CONSTRAINT costumeraudiovisual_audiovisual_id_foreign FOREIGN KEY(audioVisual_ID) REFERENCES AudioVisual(id);
ALTER TABLE
    CostumerAudioVisual ADD CONSTRAINT costumerAudioVisual_id_foreign FOREIGN KEY(costumer_ID) REFERENCES Costumer(id);
ALTER TABLE
    AudioVisual ADD CONSTRAINT audiovisual_platform_id_foreign FOREIGN KEY(platform_ID) REFERENCES Platform(id);