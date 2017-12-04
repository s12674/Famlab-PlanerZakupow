package com.famlab.mateusz.planer.ds.models;

import java.util.List;

/**
 * Created by Mateusz on 30.11.2017.
 */

public class Shop {
    public Long id;
    public Contact contact;
    public User shopkeeper;
    public List<Product> products;
    public String name;
    public String location;
    public String description;
    public float rate; // ocena sklepu nadana przez użytkowników
    public int countOfRates; // ilość ocen użytkowników
}
