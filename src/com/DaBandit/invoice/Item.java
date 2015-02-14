/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaBandit.invoice;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author angel
 */
public class Item {
    public static int count = 1000;
    public Double calculateTotal;
    
    public final IntegerProperty itemNumber =
            new SimpleIntegerProperty(this, "itemNumber", count);
    public final StringProperty description =
            new SimpleStringProperty(this, "description", "");
    public final DoubleProperty price =
            new SimpleDoubleProperty(this, "price", 0.0);
    public final IntegerProperty quantity =
            new SimpleIntegerProperty(this, "quantity", 0);
    public final DoubleProperty tax =
            new SimpleDoubleProperty(this, "tax", 0.00);
    public final DoubleProperty total =
            new SimpleDoubleProperty(this, "total", 0);
    
            
    
    public Item(String desc, Double price, Integer quantity, Double tax){
        this.itemNumber.set(count++);
        this.description.set(desc);
        this.price.set(price);
        this.quantity.set(quantity);
        this.tax.set(tax);
        
    }
    
    public Item(Item itm){
        this.itemNumber.set(itm.getItemNumber());
        this.description.set(itm.getDescription());
        this.price.set(itm.getPrice());
        this.quantity.set(itm.getQuantity());
        this.tax.set(itm.getTax());
        this.total.set(itm.calculateTotal());
       
        
    }
    //Setters and getters for the property values
    public int getItemNumber(){
        return this.itemNumber.get();
    }
    
    public void setDescription(String s){
        this.description.set(s);
    }
    
    public String getDescription(){
       return this.description.get();
    }
    
    public void setPrice(Double d){
        this.price.set(d);
    }
    public Double getPrice(){
        return this.price.get();
    }
    public void setQuantity(Integer d){
        this.quantity.set(d);
    }
    public Integer getQuantity(){
        return this.quantity.get();
    }
    public void setTax(Double d){
        this.tax.set(d);
    }
    public Double getTax(){
        return this.tax.get();
    }
   
    public Double getTotal(){
        this.total.set(this.calculateTotal());
        return this.total.get();
    }
    
    
    public Double calculateTotal(){
      Double lItemTotal = (this.quantity.get()*this.price.get())*this.tax.get();
      Double total = lItemTotal + (this.quantity.get()*this.price.get());
      
        return total;
    }
    
    
    
}
