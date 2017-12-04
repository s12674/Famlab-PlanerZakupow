package com.famlab.mateusz.planer.ds.models;

import java.util.List;

/**
 * Created by Mateusz on 30.11.2017.
 */

public class Shop {
    private Long id;
    private Contact contact;
    private User shopkeeper;
    private List<Product> products;
    private String name;
    private String location;
    private String description;
    private float rate; // ocena sklepu nadana przez użytkowników
    private int countOfRates; // ilość ocen użytkowników
}
