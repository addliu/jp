from ATM_Project.MySQL.model.CardDAO import *
from ATM_Project.MySQL.model.Card import Card
from ATM_Project.MySQL.model.CreditCard import CreditCard

# # Add Card Test
# card = Card()
# card.set_owner("Tom")
# card.set_personID("120119199703111413")
# card.set_deposit(100.0)
# card.set_password("534261")
# card.set_phoneNumber("12019871897")
# add(card)
#
# # Add CreditCard Test
# card = CreditCard()
# card.set_owner("John")
# card.set_personID("110090198703011234")
# card.set_deposit(100.0)
# card.set_password("123456")
# card.set_phoneNumber("11017878787")
# card.set_creditLimit(10000)
# add(card)

# # Query all message
# iter1 = query_all(CreditCard())
# for a in iter1:
#     a.to_string()
# iter2 = query_all(Card())
# for b in iter2:
#     b.to_string()

# # Query message by id
# query(Card(), 5)
# query(CreditCard(), 3)

# # Update test
# card1 = query(Card(), 4)
# card1.set_deposit(1000.0)
# card1.to_string()
# card2 = query(CreditCard(), 3)
# card2.set_deposit(1000.0)
# card2.to_string()

# # Delete test
# delete(Card(), 4)
# delete(CreditCard(), 4)
