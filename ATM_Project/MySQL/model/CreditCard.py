from MySQL.model.Card import Card


class CreditCard(Card):
    def __init__(self):
        Card.__init__(self)
        self.my_credit_card_limit = 0

    def print_message(self):
        Card.print_message(self)
        print("CreditCard limit:", self.my_credit_card_limit)

card = CreditCard()
card.print_message()
