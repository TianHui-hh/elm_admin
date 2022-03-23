package com.tianhui.dao;

import com.tianhui.po.Business;

import java.sql.SQLException;
import java.util.List;

public interface BusinessDao {
    public List<Business> listBusiness(String businessName, String businessAddress) throws SQLException;

    public int saveBusiness(String businessName) throws SQLException;

    public int removeBusiness(int businessId) throws SQLException;

    public Business getBusinessByIdByPassword(Integer businessId, String password) throws SQLException;

    public Business getBusinessById(Integer businessId) throws SQLException;

    public int updateBusiness(Business business) throws SQLException;

    public int updateBusinessByPassword(Integer businessId, String password) throws SQLException;
}
