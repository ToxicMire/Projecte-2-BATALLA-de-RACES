use battle_of_races;

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