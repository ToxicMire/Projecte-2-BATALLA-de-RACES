import mysql.connector

mydb = mysql.connector.connect(
    host="localhost",
    user="admin",
    password="P@ssw0rd",
    database="battle_of_races"
)

mycursor = mydb.cursor()

mycursor.execute("select * from BATTLE")

myresult = mycursor.fetchall()

with open("battle.xml", "w") as f:
    f.write('' +
            '<?xml version="1.0"?>\n' +
            '<table name=\"battle\">\n')
    for dupla in myresult:
        f.write('     <row>\n')
        cont=0
        for dada in dupla:
            cont+=1
            f.write('' +
                '         <field name="'+ str(cont) +'">'+ str(dada) +'</field>\n')
        f.write(''+
            '     </row>\n')
    f.write('</table>')