package com.tianhui.dao;

import com.tianhui.po.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodDao {
    public List<Food> listFoodByBusinessId(Integer businessId) throws SQLException;

    public int saveFood(Food food) throws SQLException;

    public Food getFoodById(Integer foodId) throws SQLException;

    public int updateFood(Food food) throws SQLException;

    public int removeFood(Integer foodId) throws SQLException;
}
