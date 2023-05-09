import os

os.system("mysqldump --xml --host='localhost' --password='1234' --user='root' " +
          "battle_of_races BATTLE > battle.xml")