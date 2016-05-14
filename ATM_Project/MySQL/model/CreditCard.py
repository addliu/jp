# /usr/bin/python
from ATM_Project.MySQL.model.Card import Card


class CreditCard(Card):
    INSERT = "INSERT INTO CreditCard(cardNum, owner, personID, phoneNum," \
             " password, deposit, creditLimit) VALUES (%s, %s, %s, %s, %s, %s, %s)"
    DELETE = "DELETE FROM CreditCard WHERE id = %s"
    UPDATE = "UPDATE CreditCard SET owner=%s, personID=%s, phoneNum=%s, password=%s," \
             "deposit=%s, creditLimit=%s WHERE id=%s"
    QUERY_ALL = "SELECT * FROM CreditCard"
    QUERY = "SELECT * FROM CreditCard WHERE id=%s"
    KIND = "CreditCard"

    def __init__(self):
        Card.__init__(self)
        self._creditLimit = 0

    def get_i_p(self):
        return (self.get_cardNum(), self.get_owner(), self.get_personID(), self.get_phoneNumber(),
                self.get_password(), self.get_deposit(), self.get_creditLimit())

    def get_u_p(self):
        return (self.get_owner(), self.get_personID(), self.get_phoneNumber(), self.get_password(),
                self.get_deposit(), self.get_creditLimit(), self.get_id())

    def to_string(self):
        Card.to_string(self)
        print("CreditCard limit:", self._creditLimit)

    def set_creditLimit(self, creditLimit):
        self._creditLimit = creditLimit

    def get_creditLimit(self):
        return self._creditLimit

