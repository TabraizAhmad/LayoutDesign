package com.goldenscent.layoutdesign.dummyData;

public class BestSellerData {

    String firstItemBrand;
    String firstItemDescription;
    String firstItemPrice;
    String reducedPrice;

    public BestSellerData(String firstItemBrand, String firstItemDescription, String firstItemPrice, String reducedPrice) {
        this.firstItemBrand = firstItemBrand;
        this.firstItemDescription = firstItemDescription;
        this.firstItemPrice = firstItemPrice;
        this.reducedPrice = reducedPrice;
    }

    public String getFirstItemBrand() {
        return firstItemBrand;
    }

    public void setFirstItemBrand(String firstItemBrand) {
        this.firstItemBrand = firstItemBrand;
    }

    public String getFirstItemDescription() {
        return firstItemDescription;
    }

    public void setFirstItemDescription(String firstItemDescription) {
        this.firstItemDescription = firstItemDescription;
    }

    public String getFirstItemPrice() {
        return firstItemPrice;
    }

    public void setFirstItemPrice(String firstItemPrice) {
        this.firstItemPrice = firstItemPrice;
    }

    public String getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(String reducedPrice) {
        this.reducedPrice = reducedPrice;
    }


}
