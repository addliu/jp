from ATM_Project.MySQL.db.DBUtil import *
import sys

if __name__ != '__main__':
    sys.exit()

cnx = get_connection()
query = "SELECT * FROM Card"
cursor = cnx.cursor()
cursor.execute(query)
for c in cursor:
    print(c)
cursor.close()
cnx.close()
