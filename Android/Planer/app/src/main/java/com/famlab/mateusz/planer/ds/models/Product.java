package com.famlab.mateusz.planer.ds.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mateusz on 30.11.2017.
 */

public class Product implements Serializable {
    public Long id;
    public Producer producer;
    public List<String> images;
    public String name;
    public String description;
    public String country;
    public Float price;
    public Categories categories;
    public String thumbnail;
}
