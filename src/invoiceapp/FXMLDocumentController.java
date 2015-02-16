/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceapp;

import com.DaBandit.invoice.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Currency;
import java.text.NumberFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.TextField;


/**
 *
 * @author jacorral
 */
public class FXMLDocumentController implements Initializable {
    private final ItemManager im = ItemManager.getInstance();
    private ObservableList<Item> itemList = FXCollections.observableArrayList();
    //private ObservableList<Item> tableItems = FXCollections.observableList(im.getAllItems());
    
    private Label label;
    @FXML
    private TableView<Item> itemsTable;
    @FXML
    private TableColumn<Item, IntegerProperty> itemNumberColumn;
    
    @FXML
    private TableColumn<?, ?> descriptionColumn;
    @FXML
    private TableColumn<Item, Double> priceColumn;
    @FXML
    private TableColumn<?, ?> quantityColumn;
    @FXML
    private TableColumn<?, ?> taxColumn;
    @FXML
    private TableColumn<Item, Double> totalColumn;
    @FXML
    private TextField itemsTotal;
    @FXML
    private ComboBox<String> listComboBox;
    
    private  ResourceBundle resources;
    private Currency currentCurrency;
    private NumberFormat currencyFormatter;
    
    
    private void handleButtonAction(ActionEvent event) {
       // System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //@FXML
    //public void initialize( ){
       
        //Locale locale = Locale.getDefault();
        Locale locale = new Locale("zh","CN");
        resources = ResourceBundle.getBundle("properties.Bundle_es_MX", locale);
        
        //Currency formatter
        currentCurrency = Currency.getInstance(locale);
        currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        
        //resources = rb;
        setTable();
        // TODO
        //resources = ResourceBundle.getBundle("properties.Bundle", locale);
        
      
        
        //fxmlLoader.setResources(resources);
        buildItems();
        printItems();
        buildTable(locale);
        listComboBox.getItems().addAll("Chicago", "Mexico", "Brazil");
       // listComboBox.setValue(null);
        
        
    }
    
  
    
    private void buildItems(){
        Item item1 = new Item("item 1", 50.0, 10, 0.1);
        Item item2 = new Item("item 2", 150.0, 11, 0.1);
        Item item3 = new Item("item 3", 250.0, 12, 0.1);
        
        im.addItem(item1);
        im.addItem(item2);
        im.addItem(item3);
    }
    private void printItems(){
        itemList = FXCollections.observableList(im.getAllItems());
        
        for(int i = 0; i < itemList.size(); i++){
            System.out.println("Item: " + itemList.get(i).itemNumber.get() 
                    + " Discription: " + itemList.get(i).description.get()
                    + "Quantity: " + itemList.get(i).quantity.get()
                    + " Price: " + itemList.get(i).price.get()
                    + " Tax: " + itemList.get(i).tax.get()
                    + " Total = "+ itemList.get(i).total.get());
        }
    }
    private void buildTable(Locale locale){
        // Locale locale = new Locale("zh", "CN");
        //resources = ResourceBundle.getBundle("properties.Bundle", locale);
        
        //Currency formatter
        currentCurrency = Currency.getInstance(locale);
        currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        
        
        
        ObservableList<Item> tableItems = FXCollections.observableList(im.getAllItems());
       // System.out.println(tableItems.get(1).price.get());
        itemNumberColumn.setCellValueFactory(new PropertyValueFactory<>("itemNumber"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceColumn.setCellFactory(column ->{
            return new TableCell<Item, Double>(){
                @Override
                protected void updateItem(Double num, boolean empty){
                    super.updateItem(num, empty);
                    if (num == null || empty){
                        setText(null);
                        setStyle("");
                    }else{
                        setText(currencyFormatter.format(num));
                    }
                }
                
            };
        });
        
        
        taxColumn.setCellValueFactory(new PropertyValueFactory<>("tax"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        totalColumn.setCellFactory(column ->{
            return new TableCell<Item, Double>(){
                @Override
                protected void updateItem(Double num, boolean empty){
                    super.updateItem(num, empty);
                    if (num == null || empty){
                        setText(null);
                        setStyle("");
                    }else{
                        setText(currencyFormatter.format(num));
                    }
                }
                
            };
        });
        
        itemsTable.setItems(tableItems);
        //Calculate the total of the combined items
        double sum = 0;
        for (int i = 0; i < tableItems.size(); i++){
            sum = sum + tableItems.get(i).total.get();
        }
       // System.out.println( ((Number)sum).toString()  );
        
        itemsTotal.setText(currencyFormatter.format(sum));
        
    }
    
    public void setTable(){
        //Update headings
     //  Locale locale = new Locale("es", "MX");
     //  resources = ResourceBundle.getBundle("properties.Bundle_es_MX",locale);
       // currentCurrency 
        
        itemNumberColumn.setText(resources.getString("item"));
        descriptionColumn.setText(resources.getString("description"));
        quantityColumn.setText(resources.getString("quantity"));
        priceColumn.setText(resources.getString("price"));
        taxColumn.setText(resources.getString("tax"));
        totalColumn.setText(resources.getString("total"));
        listComboBox.setPromptText(resources.getString("setLocation"));
        
    }
}
