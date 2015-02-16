/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceapp;

import javafx.application.Application;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Locale;

/**
 *
 * @author jacorral
 */
public class InvoiceApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       // Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        Locale loc = new Locale("en","US");
        
        fxmlLoader.setResources(ResourceBundle.getBundle("properties.Bundle",loc));
        fxmlLoader.setLocation(InvoiceApp.class.getResource("FXMLDocument.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("'We got em Items'");
        stage.setScene(scene);
        stage.show();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
