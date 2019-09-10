package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.SalesTaxRate;

import java.util.List;

public interface SalesTaxDao {

    /*
        The values in sales_tax_rate and sales_tax_rate_test are READ-ONLY
        and therefore have NO necessity for any other operations except GET.
        This is to protect the values of the tax rates from being changed.
        Please refer to SQL files attached in this project for the "insert
        statements" that can be placed into MySQL database for testing.
     */

    SalesTaxRate getTaxRate(String state);

    List<SalesTaxRate> getAllTaxRates();

}
