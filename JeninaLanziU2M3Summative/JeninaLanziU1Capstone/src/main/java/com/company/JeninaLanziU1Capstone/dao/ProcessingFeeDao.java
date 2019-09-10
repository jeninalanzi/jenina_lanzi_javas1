package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.ProcessingFee;

import java.util.List;

public interface ProcessingFeeDao {

    /*
        The values in processing_fee and processing_fee_test are READ-ONLY
        and therefore have NO necessity for any other operations except GET.
        This is to protect the values of the fee rates from being changed.
        Please refer to SQL files attached in this project for the "insert
        statements" that can be placed into MySQL database for testing.

        Options for product type are:
            1. Consoles
            2. Games
            3. T-Shirts
    */

    ProcessingFee getProcessingFee(String productType);

    List<ProcessingFee> getAllProcessingFees();
}
