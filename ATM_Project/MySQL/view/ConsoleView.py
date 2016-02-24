# /usr/bin/python
import sys
import time
from ATM_Project.MySQL.controller.ATMController import *


# print main menu
def main():
    """
    NoneType -> NoneType
    This function just print prompt message
    """
    print(CONTEXT)
    print("Please choose a function")


# insert a message
def insert():
    """
    NoneType -> NoneType
    This function insert a new message to database
    """
    print("Please choose one kind of card\n"
          "[1]: Card\n"
          "[2]: CreditCard\n")
    kind = input()
    if 1 == int(kind):
        card = Card()
    elif 2 == int(kind):
        card = CreditCard()
        print("Please set credit limit(between 10,000 to 100,000):")
        card.set_creditLimit(int(input()))
    else:
        print("Please input true value")
        return
    print("Please enter your name:\n")
    card.set_owner(str(input()))
    print("Please enter your person ID:\n")
    card.set_personID(str(input()))
    print("Please enter your phone number:\n")
    card.set_phoneNumber(str(input()))
    print("Please set your password:\n")
    card.set_password(str(input()))
    add_card(card)


# Delete a message
def delete():
    """
    NoneType -> NoneType
    This function remove a record from database
    """
    print("Choose one kind of card to delete:\n"
          "[1]: Card\n"
          "[2]: CreditCard\n")
    kind = int(input())
    if 1 == kind:
        card = Card()
    elif 2 == kind:
        card = CreditCard()
    else:
        print("Input error!!!")
        time.sleep(1)
        return
    print("Please enter the card's id which you want to delete")
    delete_card(card, int(input()))


# Update a message
def update():
    """
    NoneType -> NoneType
    This function modifier a record
    """
    card = get()
    print("Please enter id:")
    card = query_card(card, int(input()))
    print("Please enter your name:(not change using null)\n")
    name = str(input())
    if name != 'null':
        card.set_owner(str(input()))
    print("Please enter your person ID:\n")
    name = str(input())
    if name != 'null':
        card.set_personID(str(input()))
    print("Please enter your phone number:\n")
    name = str(input())
    if name != 'null':
        card.set_phoneNumber(str(input()))
    print("Please set your password:\n")
    name = str(input())
    if name != 'null':
        card.set_password(str(input()))
    update_card(card)


# get a message for detail
def get():
    """
    NoneType -> Card(CreditCard)
    This function get a Card or CreditCard object
    """
    print("Choose one kind of card to delete:\n"
          "[1]: Card\n"
          "[2]: CreditCard\n")
    kind = int(input())
    if 1 == kind:
        card = Card()
    elif 2 == kind:
        card = CreditCard()
    else:
        print("Input error!!!")
        time.sleep(1)
        return
    print("Please enter id:")
    return query_card(card, int(input()))


# Get all card message
def query():
    """
    NoneType -> list()
    In list, it's a (list of) Card or CreditCard object(s)
    This function get a list of Card or CreditCard objects
    """
    print("Choose one kind of card to query:\n"
          "[1]: Card\n"
          "[2]: CreditCard\n")
    kind = int(input())
    if 1 == kind:
        c_list = query_all_card(Card())
    elif 2 == kind:
        c_list = query_all_card(CreditCard())
    else:
        print("Input error!!!")
        time.sleep(1)
        return
    return c_list


if __name__ != '__main__':
    sys.exit()

CONTEXT = "Welcome for using this system\n" \
          "There is main menu:\n" \
          "[MAIN/M]: Show main menu\n" \
          "[INSERT/I]: Add a message\n" \
          "[DELETE/D]: Delete a message\n" \
          "[UPDATE/U]: Update a message\n" \
          "[GET/G]: Query a message\n" \
          "[QUERY/Q]: Query all messages\n" \
          "[EXIT/E]: Quit system\n"

OPERATOR_MAIN = "MAIN"
OPERATOR_INSERT = "INSERT"
OPERATOR_DELETE = "DELETE"
OPERATOR_UPDATE = "UPDATE"
OPERATOR_GET = "GET"
OPERATOR_QUERY = "QUERY"
OPERATOR_EXIT = "EXIT"

main()
while True:
    std_in = input()
    if std_in.upper() == OPERATOR_MAIN \
            or std_in.upper() == OPERATOR_MAIN[0]:
        main()
    elif std_in.upper() == OPERATOR_INSERT\
            or std_in.upper() == OPERATOR_INSERT[0]:
        insert()
        print("Add card success!\n")
        time.sleep(1)
        main()
    elif std_in.upper() == OPERATOR_DELETE[0] \
            or std_in.upper() == OPERATOR_INSERT:
        delete()
        print("That card have been remove successful!")
        time.sleep(1)
        main()
    elif std_in.upper() == OPERATOR_UPDATE[0] \
            or std_in.upper() == OPERATOR_UPDATE:
        update()
    elif std_in.upper() == OPERATOR_GET[0] \
            or std_in.upper() == OPERATOR_GET:
        c = get()
        c.to_string()
        time.sleep(3)
        main()
    elif std_in.upper() == OPERATOR_QUERY[0] \
            or std_in.upper() == OPERATOR_QUERY:
        cl = query()
        for c in cl:
            print("kind:{}\tid:{}\towner:{}".format(c.KIND, c.get_id(),
                                                    c.get_owner()))
        time.sleep(3)
        main()
    elif std_in.upper() == OPERATOR_EXIT[0] \
            or std_in.upper() == OPERATOR_EXIT:
        break
    else:
        print("Your string is ", str(std_in))
        main()
