package com.famlab.mateusz.planer.ds.models;

import java.util.List;

/**
 * Created by Mateusz on 30.11.2017.
 */

public class User {

    private int id;
    private Status status;
    private Role role;
    private List<Shop> favouriteShops;
    private List<ShoppingList> shoppinglists;
    private String email;
    private String password;
    private String username;
    private float rate; // ocena wiarygodnosci danego uzytkownika

}
