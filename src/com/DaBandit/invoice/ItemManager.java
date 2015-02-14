/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaBandit.invoice;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author angel
 */
public class ItemManager {
    
    List<Item> list = new ArrayList<>();
    ObservableList<Item> observableList = FXCollections.observableArrayList(list);
    
    public static ItemManager instance = null;
    
    protected ItemManager(){
        
    }
    public static ItemManager getInstance(){
        if (instance == null){
            instance = new ItemManager();
        }
        return instance;
    }
    
    public void addItem(Item itm){
        Item item = new Item(itm);
        observableList.add(item);
    }
    
    public ArrayList<Item> getAllItems(){
        ArrayList<Item> copyList = new ArrayList<>();
        observableList.forEach((p) -> 
        copyList.add(p));
        return copyList;
    }
    
    
}
