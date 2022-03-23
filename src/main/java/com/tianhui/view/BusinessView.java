package com.tianhui.view;

import com.tianhui.po.Business;

import java.sql.SQLException;

public interface BusinessView {
    public void listBusinessAll() throws SQLException;

    public void listBusiness() throws SQLException;

    public void saveBusiness() throws SQLException;

    public void removeBusiness() throws SQLException;

    public Business login() throws SQLException;

    public void showBusiness(Integer businessId) throws SQLException;

    public void editBusiness(Integer businessId) throws SQLException;

    public void updateBusinessByPassword(Integer businessId) throws SQLException;
}
