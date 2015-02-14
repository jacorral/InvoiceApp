/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceapp;

import com.DaBandit.invoice.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jacorral
 */
public class FXMLDocumentController implements Initializable {
    private final ItemManager im = ItemManager.getInstance();
    private ObservableList<Item> itemList = FXCollections.observableArrayList();
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       // System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        buildItems();
        printItems();
        
        
    }    
    
    private void buildItems(){
        Item item1 = new Item("item 1", 50.0, 10, 0.9);
        Item item2 = new Item("item 2", 150.0, 11, 0.9);
        Item item3 = new Item("item 3", 250.0, 12, 0.9);
        
        im.addItem(item1);
        im.addItem(item2);
        im.addItem(item3);
    }
    private void printItems(){
        itemList = FXCollections.observableList(im.getAllItems());
        
        for(int i = 0; i < itemList.size(); i++){
            System.out.println("Item: " + itemList.get(i).itemNumber.get() 
                    + " Discription: " + itemList.get(i).getDescription()
                    + " Total = "+ itemList.get(i).calculateTotal());
        }
    }
    
}
