package com.tianhui.view.impl;

import com.tianhui.dao.FoodDao;
import com.tianhui.dao.impl.FoodDaoImpl;
import com.tianhui.po.Food;
import com.tianhui.view.FoodView;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    private Scanner input = new Scanner(System.in);

    @Override
    public List<Food> showFoodList(Integer businessId) throws SQLException {
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = dao.listFoodByBusinessId(businessId);
        System.out.println("食品编号\t食品名称\t食品介绍\t食品价格\n");
        for (Food food : list) {
            System.out.println(food.getFoodId() + "\t" + food.getFoodName() + "\t" + food.getFoodExplain() + "\t" + food.getFoodPrice() + "\n");
        }
        return list;
    }

    @Override
    public void saveFood(Integer businessId) throws SQLException {
        Food food = new Food();
        System.out.println("请输入食品名称:  ");
        food.setFoodName(input.next());
        System.out.println("请输入食品介绍:  ");
        food.setFoodExplain(input.next());
        System.out.println("请输入食品价格:  ");
        food.setFoodPrice(input.nextDouble());
        food.setBusinessId(businessId);

        FoodDao daoao = new FoodDaoImpl();
        int result = daoao.saveFood(food);
        if (result > 0) {
            System.out.println("\n新增食品成功!  ");
        } else {
            System.out.println("新增食品失败!  ");
        }
    }

    @Override
    public void updateFood(Integer businessId) throws SQLException {

        FoodDao dao = new FoodDaoImpl();
        List<Food> list = showFoodList(businessId);
        if (list.size() == 0) {
            System.out.println("没有任何食品!  ");
        } else {
            System.out.println("请选择要更新的食品编号:  ");
            int foodId = input.nextInt();
            Food food = dao.getFoodById(foodId);
            System.out.println(food);

            String inputStr = " ";
            System.out.println("是否更新食品名称(y/n):  ");
            inputStr = input.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品名称:  ");
                food.setFoodName(input.next());
            }

            System.out.println("是否更新食品介绍(y/n):  ");
            inputStr = input.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品介绍:  ");
                food.setFoodExplain(input.next());
            }

            System.out.println("是否更新食品价格(y/n):  ");
            inputStr = input.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品价格:  ");
                food.setFoodPrice(input.nextDouble());
            }

            int result = dao.updateFood(food);
            if (result > 0) {
                System.out.println("\n修改食品成功!  ");
            } else {
                System.out.println("\n修改食品失败");
            }
        }
    }

    @Override
    public void removeFood(Integer businessId) throws SQLException {
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = showFoodList(businessId);
        if (list.size() == 0) {
            System.out.println("没有任何食品!  ");
        } else {
            System.out.println("请选择要删除的食品编号:  ");
            int foodId = input.nextInt();
            System.out.println("确认要删除该食品吗?(y/n):  ");
            if (input.next().equals("y")) {
                int result = dao.removeFood(foodId);
                if (result > 0) {
                    System.out.println("\n删除食品成功!  \n");
                } else {
                    System.out.println("\n删除食品失败   \n");
                }
            }
        }
    }
}
