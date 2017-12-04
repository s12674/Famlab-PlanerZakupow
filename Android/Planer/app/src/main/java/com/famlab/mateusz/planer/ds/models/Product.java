package com.famlab.mateusz.planer.ds.models;

import java.util.List;

/**
 * Created by Mateusz on 30.11.2017.
 */

public class Product {
    public Long id;
    public Producer producer;
    public List<String> images;
    public String name;
    public String description;
    public String country;
    public Long price;
    public Category category;
    public String thumbnail;
}
