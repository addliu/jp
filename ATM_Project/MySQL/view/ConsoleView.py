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


# create a new account
def create_account():
    """
    NoneType -> NoneType
    This function create a new  account
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


# Reset password
def reset_password():
    """
    NoneType -> NoneType
    This function Reset password
    """
    print("Choose Your card :\n"
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
    print("Please enter the  your card's id:")
    card = query_card(card, int(input()))
    print("Please enter your new password:")
    card.set_password(str(input()))
    update_card(card)


# get account balance
def get_balance():
    """
    NoneType -> double
    This function get account balance
    """
    print("Choose Your card :\n"
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
    card = query_card(card, int(input()))
    balance = card.get_deposit()
    if 1 == kind:
        pass
    elif 2 == kind:
        balance += card.get_creditLimit()
    return balance


# withdraw money
def withdraw():
    """
    NoneType -> NoneType
    This function withdraw money
    """
    print("Choose one kind of card:\n"
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
    card = query_card(card, int(input()))
    if 1 == kind:
        balance = card.get_deposit()
    elif 2 == kind:
        balance = card.get_deposit() + card.get_creditLimit()
    print("Please enter how much money you want to withdraw:")
    money = int(input())
    if money > balance:
        print("You don't have enough money!")
    elif money > card.get_deposit():
        card.set_deposit(0.0)
        card.set_creditLimit(balance - money)
    elif money <= card.get_deposit():
        card.set_deposit(balance - money)
    update_card(card)


# Deposit money
def deposit():
    """
    NoneType -> NoneType
    This function deposit you money
    """
    print("Choose one kind of card to query:\n"
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
    print("Please enter card id:")
    card = query_card(card, int(input()))
    print("Please enter how much money you'd like to deposit:")
    money = int(input())
    card.set_deposit(card.get_deposit() + money)
    update_card(card)


# Transfer money
def transfer():
    """
    NoneType -> NoneType
    This function finish transfer money
    """
    print("Choose one kind of card:\n"
          "[1]: Card\n"
          "[2]: CreditCard\n")
    kind = int(input())
    if 1 == kind:
        card = Card()
        card2 = Card()
    elif 2 == kind:
        card = CreditCard()
        card2 = CreditCard()
    else:
        print("Input error!!!")
        time.sleep(1)
        return
    print("Please enter your card's id:")
    card = query_card(card, int(input()))
    print("Please enter other's card's id:")
    card2 = query_card(card2, int(input()))
    print("Please enter how much money you want to transfer:")
    money = int(input())
    if 1 == kind:
        balance = card.get_deposit()
    elif 2 == kind:
        balance = card.get_deposit() + card.get_creditLimit()
    if money > balance:
        print("You don't have enough money!")
    elif money > card.get_deposit():
        card.set_deposit(0.0)
        card.set_creditLimit(balance - money)
        card2.set_deposit(card2.get_deposit() + money)
    elif money <= card.get_deposit():
        card.set_deposit(balance - money)
        card2.set_deposit(card2.get_deposit() + money)
    update_card(card)
    update_card(card2)

if __name__ != '__main__':
    sys.exit()

CONTEXT = "Welcome for using this system\n" \
          "There is main menu:\n" \
          "[MAIN/M]: Show main menu\n" \
          "[CREATE/C]: Create a account\n" \
          "[PASSWORD/P]: Change your password\n" \
          "[BALANCE/B]: Check balance\n" \
          "[WITHDRAW/W]: WITHDRAW money\n" \
          "[DEPOSIT/D]: Deposit money\n" \
          "[TRANSFER/T]: Transfer monet\n" \
          "[EXIT/E]: Quit system\n"

OPERATOR_MAIN = "MAIN"
OPERATOR_CREATE = "CREATE"
OPERATOR_PASSWORD = "PASSWORD"
OPERATOR_BALANCE = "BALANCE"
OPERATOR_WITHDRAW = "WITHDRAW"
OPERATOR_DEPOSIT = "DEPOSIT"
OPERATOR_TRANSFER = "TRANSFER"
OPERATOR_EXIT = "EXIT"

main()
while True:
    std_in = input()
    if std_in.upper() == OPERATOR_MAIN \
            or std_in.upper() == OPERATOR_MAIN[0]:
        main()
    elif std_in.upper() == OPERATOR_CREATE\
            or std_in.upper() == OPERATOR_CREATE[0]:
        create_account()
        print("Create account success!\n")
        time.sleep(1)
        main()
    elif std_in.upper() == OPERATOR_PASSWORD[0] \
            or std_in.upper() == OPERATOR_PASSWORD:
        reset_password()
        print("Reset password successful!")
        time.sleep(1)
        main()
    elif std_in.upper() == OPERATOR_BALANCE[0] \
            or std_in.upper() == OPERATOR_BALANCE:
        print("Your balance is:", str(get_balance()))
        time.sleep(1)
        main()
    elif std_in.upper() == OPERATOR_WITHDRAW[0] \
            or std_in.upper() == OPERATOR_WITHDRAW:
        withdraw()
        print("Withdraw success!")
        time.sleep(1)
        main()
    elif std_in.upper() == OPERATOR_DEPOSIT[0] \
            or std_in.upper() == OPERATOR_DEPOSIT:
        deposit()
        print("Deposit money finish!")
        time.sleep(1)
        main()
    elif std_in.upper() == OPERATOR_TRANSFER[0] \
            or std_in.upper() == OPERATOR_TRANSFER:
        transfer()
        main()
    elif std_in.upper() == OPERATOR_EXIT[0] \
            or std_in.upper() == OPERATOR_EXIT:
        break
    else:
        print("Your string is ", str(std_in))
        main()
