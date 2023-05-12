drop database if exists battle_of_races;

create database if not exists battle_of_races;

use battle_of_races;

create table WEAPONS (
WEAPON_ID INT AUTO_INCREMENT PRIMARY KEY,
WEAPON_NAME  VARCHAR(256),
WEAPON_POINTS INT,
WEAPON_IMAGE_PATH VARCHAR(256),
WEAPON_STRENGTH INT,
WEAPON_SPEED INT
);

create table WARRIORS(
WARRIOR_ID INT AUTO_INCREMENT PRIMARY KEY,
WARRIOR_NAME VARCHAR(256),
WARRIOR_IMAGE_PATH VARCHAR(256),
WARRIORS_RACE_ID INT
);

create table PLAYERS(
PLAYER_ID INT AUTO_INCREMENT PRIMARY KEY,
PLAYER_NAME VARCHAR(256)
);

create table RACES(
RACE_ID INT AUTO_INCREMENT PRIMARY KEY,
RACE_NAME VARCHAR(256),
RACE_POINTS INT,
RACE_HP INT,
RACE_STRENGTH INT,
RACE_DEFENSE INT,
RACE_AGILITY INT,
RACE_SPEED INT
);

create table WEAPONS_AVAILABLE(
WEAPON_ID INT,
RACE_ID INT
);

create table BATTLE(
BATTLE_ID INT AUTO_INCREMENT PRIMARY KEY,
PLAYER_ID INT,
WARRIOR_ID INT,
WARRIOR_WEAPON_ID INT,
OPPONENT_ID INT,
OPPONENT_WEAPON_ID INT,
INJURIES_CAUSED INT,
INJURIES_SUFFERED INT,
BATTLE_POINTS INT
);

/* ALTERS */
alter table WARRIORS
	add constraint FOREIGN KEY (WARRIORS_RACE_ID) REFERENCES RACES(RACE_ID);

alter table WEAPONS_AVAILABLE
	add constraint FOREIGN KEY (WEAPON_ID) REFERENCES WEAPONS(WEAPON_ID),
    add constraint FOREIGN KEY (RACE_ID) REFERENCES RACES(RACE_ID); 

alter table BATTLE
	add constraint FOREIGN KEY (PLAYER_ID) REFERENCES PLAYERS(PLAYER_ID),
    add constraint FOREIGN KEY (WARRIOR_ID) REFERENCES WARRIORS(WARRIOR_ID),
    add constraint FOREIGN KEY (WARRIOR_WEAPON_ID) REFERENCES WEAPONS(WEAPON_ID),
    add constraint FOREIGN KEY (OPPONENT_ID) REFERENCES WARRIORS(WARRIOR_ID),
    add constraint FOREIGN KEY (OPPONENT_WEAPON_ID) REFERENCES WEAPONS(WEAPON_ID);
    
/* INSERTS */
insert into WEAPONS (WEAPON_NAME,WEAPON_POINTS,WEAPON_IMAGE_PATH,WEAPON_STRENGTH,WEAPON_SPEED) values
	("Dagger",10,"dagger.png",0,3),
	("Sword",10,"sword.png",1,1),
	("Axe",10,"axe.png",3,0),
	("Dual Swords",14,"dualSwords.png",2,2),
	("Scimitar",14,"scimitar.png",1,2),
	("Bow",15,"bow.png",1,5),
	("Katana",18,"katana.png",2,3),
	("Dirk",12,"dirk.png",0,4),
	("Double-handed Axe",20,"double-handedAxe.png",5,0);
    
insert into RACES (RACE_NAME,RACE_POINTS,RACE_HP,RACE_STRENGTH,RACE_DEFENSE,RACE_AGILITY,RACE_SPEED) values
	("Dwarf",20,60,6,4,5,3),
	("Human",19,50,5,3,6,5),
	("Elf",21,40,4,2,7,7);
    
insert into WEAPONS_AVAILABLE (WEAPON_ID,RACE_ID) values
	(1,2),
    (1,3),
    (2,1),
    (2,2),
    (2,3),
    (3,1),
    (3,2),
    (4,2),
    (4,3),
    (5,2),
    (5,3),
    (6,3),
    (7,2),
    (8,1),
    (8,2),
    (8,3),
    (9,1);
    
insert into WARRIORS (WARRIOR_NAME,WARRIOR_IMAGE_PATH,WARRIORS_RACE_ID) values
	("Gimli","enanoGimli.png",1),
	("Thorin","enanoThorin.png",1),
	("Dwalin","enanoDwalin.png",1),
    ("Aragorn","humanoAragorn.png",2),
	("Galadriel","humanoGaladriel.png",2),
	("Elric","humanoElric.png",2),
	("Legolas","elfoLegolas.png",3),
	("Arwen","elfoArwen.png",3),
	("Eowyn","elfoEowyn.png",3)
    ;
    
insert into PLAYERS (PLAYER_NAME) VALUE
("Pepe"),("Pepa"),("Pape"),("Papa"),("Apap"),("Epep"),("Apep"),("Epap"),("Eppa"),("Eppe"),("Appa"),("Juan");

insert into BATTLE (PLAYER_ID,WARRIOR_ID,WARRIOR_WEAPON_ID,OPPONENT_ID,OPPONENT_WEAPON_ID,INJURIES_CAUSED,INJURIES_SUFFERED,BATTLE_POINTS) VALUES
(1,1,1,2,2,1000,500,1500),
(1,1,1,2,2,2000,1000,3000),
(1,1,1,2,2,1000,1000,2000),
(2,1,1,2,3,1000,200,1200),
(3,1,1,2,2,2000,2000,4000),
(4,1,1,2,2,500,1000,1500),
(5,1,1,2,2,700,1000,1700),
(6,1,1,2,2,2000,500,2500),
(7,1,1,2,2,2000,1000,3000),
(8,1,1,2,2,2000,1000,3000),
(9,1,1,2,2,2000,1000,3000),
(10,1,1,2,2,2000,1000,3000),
(11,1,1,2,2,2000,1000,3000),
(12,1,1,2,2,2000,1000,3000)
;