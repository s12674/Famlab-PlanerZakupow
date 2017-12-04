package com.famlab.mateusz.planer.ds.models;

import java.util.List;

/**
 * Created by Mateusz on 30.11.2017.
 */

public class User {

    public int id;
    public Status status;
    public Role role;
    public List<Shop> favouriteShops;
    public List<ShoppingList> shoppinglists;
    public String email;
    public String password;
    public String username;
    public float rate; // ocena wiarygodnosci danego uzytkownika

}
