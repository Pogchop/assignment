package com.example.food.entity;

import com.example.food.annotation.Column;
import com.example.food.annotation.Entity;
import com.example.food.annotation.ForeignKey;
import com.example.food.annotation.Id;
import com.example.food.util.SQLDataTypes;
import com.example.food.util.ValidationUtil;

import java.util.HashMap;

@Entity(tableName = "food")
public class Food {

    @Id(autoIncrement = true)
    @Column(columnName = "id", columnType = SQLDataTypes.INTEGER)
    private int id;
    @Column(columnName = "name", columnType = SQLDataTypes.VARCHAR255)
    private String name;
    @Column(columnName = "idname", columnType = SQLDataTypes.VARCHAR255)
    private String idname;
    @Column(columnName = "description", columnType = SQLDataTypes.VARCHAR255)
    private String description;
    @Column(columnName = "thumbnail", columnType = SQLDataTypes.VARCHAR255)
    private String thumbnail;
    @Column(columnName = "price", columnType = SQLDataTypes.INTEGER)
    private int price;
    @Column(columnName = "selldate", columnType = SQLDataTypes.VARCHAR255)
    private String selldate;
    @Column(columnName = "editdate", columnType = SQLDataTypes.VARCHAR255)
    private String editdate;
    @Column(columnName = "status", columnType = SQLDataTypes.INTEGER)
    private int status;
    @Column(columnName = "categoryid", columnType = SQLDataTypes.INTEGER)
    @ForeignKey(referencecolumn = "id",referencetable = "category")
    private int categoryid;

    public Food(String name, String idname, String description, String thumbnail, int price, String selldate, String editdate, int status, int categoryid) {
        this.name = name;
        this.idname = idname;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.selldate = selldate;
        this.editdate = editdate;
        this.status = status;
        this.categoryid = categoryid;
    }

    public Food() {
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idname='" + idname + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", price=" + price +
                ", selldate='" + selldate + '\'' +
                ", editdate='" + editdate + '\'' +
                ", status=" + status +
                '}';
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

    public String getIdname() {
        return idname;
    }

    public void setIdname(String idname) {
        this.idname = idname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSelldate() {
        return selldate;
    }

    public void setSelldate(String selldate) {
        this.selldate = selldate;
    }

    public String getEditdate() {
        return editdate;
    }

    public void setEditdate(String editdate) {
        this.editdate = editdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public boolean isValid() {
        return getErrors().size() == 0;
    }

    public HashMap<String, String> getErrors(){
        HashMap<String, String> errors = new HashMap<>();
        if (name == null || name.length() >= 7){
            errors.put("name", "Vui long nhap ten san pham.");
        }
        if (idname == null || idname.length() == 0){
            errors.put("idname", "Vui long nhap id san pham.");
        }
        if (description == null || description.length() == 0){
            errors.put("description", "Vui long nhap mo ta san pham.");
        }
        if (thumbnail == null || thumbnail.length() == 0){
            errors.put("thumbnail", "Vui long lua chon anh cho san pham.");
        } else if (!ValidationUtil.checkUrl(thumbnail)){
            errors.put("thumbnail", "Anh sai dinh dang, vui long nhap vao mot link");
        }
        if (price == 0){
            errors.put("price", "Vui long nhap gia san pham.");
        }
        if (selldate == null || selldate.length() == 0){
            errors.put("selldate", "Vui long nhap ngay ban san pham.");
        }
        if (editdate == null || editdate.length() == 0){
            errors.put("editdate", "Vui long nhap ngay sua san pham.");
        }
        return errors;
    }
}
