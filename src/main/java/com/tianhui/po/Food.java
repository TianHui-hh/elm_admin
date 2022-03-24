package com.tianhui.po;

public class Food {
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private Double foodPrice;
    private Integer businessId;

    @Override
    public String toString() {
        return "食品:  {" +
                "食品编号=" + foodId +
                ", 食品名称='" + foodName + '\'' +
                ", 食品介绍='" + foodExplain + '\'' +
                ", 食品价格=" + foodPrice +
                ", 所属商家编号=" + businessId +
                '}';
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodExplain() {
        return foodExplain;
    }

    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }
}
