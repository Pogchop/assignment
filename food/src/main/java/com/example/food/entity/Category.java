package com.example.food.entity;

import com.example.food.annotation.Column;
import com.example.food.annotation.Entity;
import com.example.food.annotation.Id;
import com.example.food.util.SQLDataTypes;

@Entity(tableName = "category")
public class Category {

    @Id(autoIncrement = true)
    @Column(columnName = "id", columnType = SQLDataTypes.INTEGER)
    private int id;
    @Column(columnName = "name", columnType = SQLDataTypes.VARCHAR255)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
