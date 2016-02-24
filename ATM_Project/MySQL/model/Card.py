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
    INSERT = "INSERT INTO Card(cardNum, owner, personID, phoneNum, password, deposit) " \
             "VALUES (%s, %s, %s, %s, %s, %s)"
    DELETE = "DELETE FROM Card WHERE id=%s"
    UPDATE = "UPDATE Card SET owner=%s, personID=%s, phoneNum=%s, password=%s, deposit=%s " \
             "WHERE id=%s"
    QUERY_ALL = "SELECT * FROM Card"
    QUERY = "SELECT * FROM Card WHERE id = %s"
    KIND = "Card"

    def __init__(self):
        #  ID
        self._id = 0
        # Card number
        self._cardNum = ''
        # User name
        self._owner = 'John\0'
        # User person ID
        self._personID = '420123123456781234\0'
        # User phone number
        self._phoneNum = '15612345678\0'
        # Card password
        self._password = ''
        # User deposit
        self._deposit = 0.0

        self._genarate_card_number()
        self._genarate_password()

    # Get insert params
    def get_i_p(self):
        return (self.get_cardNum(), self.get_owner(), self.get_personID(),
                self.get_phoneNumber(), self.get_password(), self.get_deposit())

    # Get update params
    def get_u_p(self):
        return (self.get_owner(), self.get_personID(), self.get_phoneNumber(),
                self.get_password(), self.get_deposit(), self.get_id())

    # Set a random card number
    def _genarate_card_number(self):
        for i in range(0, CARD_NUM_LEN):
            self._cardNum += str(random.randint(0, 10))
        self._cardNum += '\0'

    # Set a random password
    def _genarate_password(self):
        for i in range(0, PWD_LEN):
            self._password = str(random.randint(0, 10))
        self._password += '\0'

    # Print Card message
    def to_string(self):
        print("Card info is:\nCard Number:", self._cardNum,
              "\nname: ", self._owner, "\npersonID:", self._personID,
              "\nphone number:", self._phoneNum, "\ndeposit:",
              self._deposit)

    def get_deposit(self):
        return self._deposit

    def set_deposit(self, deposit):
        self._deposit = deposit

    def get_cardNum(self):
        return self._cardNum

    def set_cardNum(self, cardNum):
        self._cardNum = cardNum

    def set_owner(self, owner):
        self._owner = owner

    def get_owner(self):
        return self._owner

    def set_personID(self, personID):
        self._personID = personID

    def get_personID(self):
        return self._personID

    def set_phoneNumber(self, phoneNumber):
        self._phoneNum = phoneNumber

    def get_phoneNumber(self):
        return self._phoneNum

    def get_password(self):
        return self._password

    def set_password(self, password):
        self._password = password

    # Get id
    def get_id(self):
        return self._id

    # Set id
    def set_id(self, ID):
        self._id = ID
