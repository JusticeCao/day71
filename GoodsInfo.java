package com.util.Dao;

public class GoodsInfo {
    private int id;
    private String goodsInfo_name;
    private String goodsInfo_pic;
    private String goodsInfo_price;
    private String goodsInfo_description;
    private String goods_stock;
    private String flag;
    private String created;
    private String created_date;

    public GoodsInfo() {
    }

    public GoodsInfo(int id, String goodsInfo_name, String goodsInfo_pic, String goodsInfo_price, String goodsInfo_description, String goods_stock, String flag, String created, String created_date) {
        this.id = id;
        this.goodsInfo_name = goodsInfo_name;
        this.goodsInfo_pic = goodsInfo_pic;
        this.goodsInfo_price = goodsInfo_price;
        this.goodsInfo_description = goodsInfo_description;
        this.goods_stock = goods_stock;
        this.flag = flag;
        this.created = created;
        this.created_date = created_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsInfo_name() {
        return goodsInfo_name;
    }

    public void setGoodsInfo_name(String goodsInfo_name) {
        this.goodsInfo_name = goodsInfo_name;
    }

    public String getGoodsInfo_pic() {
        return goodsInfo_pic;
    }

    public void setGoodsInfo_pic(String goodsInfo_pic) {
        this.goodsInfo_pic = goodsInfo_pic;
    }

    public String getGoodsInfo_price() {
        return goodsInfo_price;
    }

    public void setGoodsInfo_price(String goodsInfo_price) {
        this.goodsInfo_price = goodsInfo_price;
    }

    public String getGoodsInfo_description() {
        return goodsInfo_description;
    }

    public void setGoodsInfo_description(String goodsInfo_description) {
        this.goodsInfo_description = goodsInfo_description;
    }

    public String getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(String goods_stock) {
        this.goods_stock = goods_stock;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id=" + id +
                ", goodsInfo_name='" + goodsInfo_name + '\'' +
                ", goodsInfo_pic='" + goodsInfo_pic + '\'' +
                ", goodsInfo_price='" + goodsInfo_price + '\'' +
                ", goodsInfo_description='" + goodsInfo_description + '\'' +
                ", goods_stock='" + goods_stock + '\'' +
                ", flag='" + flag + '\'' +
                ", created='" + created + '\'' +
                ", created_date='" + created_date + '\'' +
                '}';
    }
}
