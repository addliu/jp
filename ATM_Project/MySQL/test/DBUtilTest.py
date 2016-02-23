from MySQL.db.DBUtil import *
import sys

if __name__ != '__main__':
    sys.exit()

cnx = get_connection()
query = "select * from Card;"
cursor = cnx.cursor()
cursor.execute(query)
for (cn, ow, pi, pn, pw, dp) in cursor:
    print(cn, ow, pi, pn, pw, str(dp))
cursor.close()
cnx.close()
