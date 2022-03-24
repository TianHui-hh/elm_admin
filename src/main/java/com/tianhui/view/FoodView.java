package com.tianhui.view;

import com.tianhui.po.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodView {
    public List<Food> showFoodList(Integer businessId) throws SQLException;

    public void saveFood(Integer businessId) throws SQLException;

    public void updateFood(Integer businessId) throws SQLException;

    public void removeFood(Integer businessId) throws SQLException;
}
