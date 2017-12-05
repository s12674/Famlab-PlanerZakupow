package com.famlab.mateusz.planer.ds.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mateusz on 30.11.2017.
 */

@DatabaseTable(tableName = "Product")
public class Product implements Serializable {

    @DatabaseField(id = true)
    public int id;

    public Producer producer;

    public List<String> images;

    @DatabaseField(columnName = "name")
    public String name;

    @DatabaseField(columnName = "description")
    public String description;

    @DatabaseField(columnName = "country")
    public String country;

    @DatabaseField(columnName = "price")
    public Float price;

    public Categories categories;

    @DatabaseField(columnName = "thumbnail")
    public String thumbnail;
}
