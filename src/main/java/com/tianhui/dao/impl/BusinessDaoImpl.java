package com.tianhui.dao.impl;

import com.tianhui.dao.BusinessDao;
import com.tianhui.po.Business;
import com.tianhui.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) throws SQLException {
        List<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1");
        if (businessName != null && !(businessName.equals(" "))) {
            sql.append(" and businessName like '%" + businessName + "%'");
        }
        if (businessAddress != null && !(businessAddress.equals(" "))) {
            sql.append(" and businessAddress like '%" + businessAddress + "%'");
        }
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while (rs.next()) {
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return list;

    }

    @Override
    public int saveBusiness(String businessName) throws SQLException {
        int businessId = 0;
        String sql = "insert into business (businessName,password) value(?,'123')";
        try {
            con = DBUtil.getConnection();
            //设置返回自增长列值
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, businessName);
            pst.executeUpdate();
            //获取自增长列值(一行一列)
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                businessId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return businessId;
    }

    @Override
    public int removeBusiness(int businessId) throws SQLException {
        int result = 0;
        String delFoodSql = "delete from food where businessId=?";
        String delBusinessSql = "delete from business where businessId=?";
        try {
            con = DBUtil.getConnection();
            //开启一个事务
            con.setAutoCommit(false);

            pst = con.prepareStatement(delFoodSql);
            pst.setInt(1, businessId);
            pst.executeUpdate();

            pst = con.prepareStatement(delBusinessSql);
            pst.setInt(1, businessId);
            result = pst.executeUpdate();

            con.commit();

        } catch (
                SQLException e) {
            result = 0;
            con.rollback();
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }
}