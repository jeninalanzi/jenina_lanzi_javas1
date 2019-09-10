package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.TShirt;

import java.util.List;

public interface TShirtDao {

    /*
    Perform standard CRUD operations for T-Shirts
    Search for T-Shirts by Color
    Search for T-Shirts by Size
    You must create a separate DAO for T-Shirts
     */

    TShirt addTshirt(TShirt tee);

    TShirt getTshirt(int id);

    List<TShirt> getAllTshirts();

    List<TShirt> searchByColor(String color);

    List<TShirt> searchBySize(String size);

    void updateTshirt(TShirt tee);

    void deleteTshirt(int id);

}
