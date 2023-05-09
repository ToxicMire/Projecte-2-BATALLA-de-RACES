drop database if exists battle_of_races;

create database if not exists battle_of_races;

use battle_of_races;

create table WEAPONS (
WEAPON_ID INT AUTO_INCREMENT PRIMARY KEY,
WEAPON_NAME  VARCHAR(256),
WEAPON_POINTS INT,
WEAPON_IMAGE_PATH VARCHAR(256)
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
insert into WEAPONS (WEAPON_NAME,WEAPON_POINTS,WEAPON_IMAGE_PATH) values
	("Dagger",10,"dagger.jpeg"),
	("Sword",10,"sword.jpeg"),
	("Axe",10,"axe.jpg"),
	("Dual Swords",14,"dualSwords.jpg"),
	("Scimitar",14,"scimitar.jpg"),
	("bow",15,"bow.png"),
	("Katana",18,"katana.jpg"),
	("Dirk",12,"dirk.jpeg"),
	("Double-handed Axe",20,"double-handedAxe.png");
    
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
	("Gimli","enanoGimli.jpg",1),
	("Thorin","enanoThorin.jpg",1),
	("Dwalin","enanoDwalin.jpg",1),
    ("Aragorn","humanoAragorn.jpg",2),
	("Galadriel","humanoGaladriel.jpg",2),
	("Elric","humanoElric.jpg",2),
	("Legolas","elfoLegolas.jpg",3),
	("Arwen","elfoArwen.jpg",3),
	("Eowyn","elfoEowyn.jpg",3)
    ;