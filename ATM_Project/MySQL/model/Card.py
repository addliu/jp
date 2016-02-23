import random
# Card number length
CARD_NUM_LEN = 17
# User name length
NAME_LEN = 10
# User ID length
ID_LEN = 20
# User phone number length
PHONE_NUM_LEN = 12
# Card password length
PWD_LEN = 7


class Card:
    def __init__(self):
        # Card number
        self._my_card_number = ''
        # User name
        self._my_name = 'John\0'
        # User person ID
        self._my_personID = '420123123456781234\0'
        # Card password
        self._my_password = ''
        # User phone number
        self._my_phone_number = '15612345678\0'
        # User deposit
        self._my_deposit = 0.0

        self._genarate_card_number()
        self._genarate_password()

    # Set a random card number
    def _genarate_card_number(self):
        for i in range(0, CARD_NUM_LEN):
            self._my_card_number += str(random.randint(0, 10))
        self._my_card_number += '\0'

    # Set a random password
    def _genarate_password(self):
        for i in range(0, PWD_LEN):
            self._my_password = str(random.randint(0, 10))
        self._my_password = '\0'

    # Print Card message
    def print_message(self):
        print("Card info is:\nCard Number:", self._my_card_number,
              "\nname: ", self._my_name, "\npersonID:", self._my_personID,
              "\nphone number:", self._my_phone_number, "\ndeposit",
              self._my_deposit)

    def get_deposit(self):
        return self._my_deposit
