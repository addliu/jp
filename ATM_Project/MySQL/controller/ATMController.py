from ATM_Project.MySQL.model.CardDAO import *


# add one kind of card
def add_card(card):
    add(card)


# delete a message
def delete_card(card, id):
    delete(card, id)


# update a message
def update_card(card):
    update(card)


# Query a message
def query_card(card, id):
    return query(card, id)


# Query all message
def query_all_card(card):
    return query_all(card)
