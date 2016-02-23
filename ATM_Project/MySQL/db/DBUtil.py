import mysql.connector

config = {
    'user': 'root',
    'password': 'root',
    'host': '127.0.0.1',
    'database': 'ATMProject'
}


def get_connection():
    """
    NoneType -> MySQL.connector.connect
    Connect to ATMProject database
    """
    cnx = mysql.connector.connect(**config)
    return cnx
