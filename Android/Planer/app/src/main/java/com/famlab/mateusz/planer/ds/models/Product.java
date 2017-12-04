package com.famlab.mateusz.planer.ds.models;

import java.util.List;

/**
 * Created by Mateusz on 30.11.2017.
 */

public class Product {
    private Long id;
    private Producer producer;
    private List<String> images;
    private String name;
    private String description;
    private String country;
    private Long price;
}
