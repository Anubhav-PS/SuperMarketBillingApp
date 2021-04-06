package com.anubhavps.products;

import java.util.Objects;

public class Products {
    static int id = 0;
    int productId;
    String productName;
    float productPrice;
    int productStock;

    public Products(){
    }
    public Products(String productName, float productPrice, int productStock) {
        id +=1;
        this.productId = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public int getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public int getProductStock() {
        return productStock;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return productId == products.productId && Objects.equals(productName.toLowerCase(), products.productName.toLowerCase());
    }


}
