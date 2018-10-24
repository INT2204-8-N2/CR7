/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.MySQLDatabase;


public class InsertViewController implements Initializable {
  MySQLDatabase b;
  
  
    @FXML
    private Label label;
    @FXML
    private Button btInsert;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtDefine;

    public InsertViewController() throws SQLException {
        this.b = MySQLDatabase.getInstance("jdbc:mysql://localhost:3306/SINHVIEN","root","12345678" );
    }
    
   
    @FXML
    public void handleButtonAction(ActionEvent event) {
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btInsert.setOnAction((ActionEvent event1) -> {
          if(txtWord.getText().length()>0&&txtDefine.getText().length()>0){
          try {
              Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Message");
              if(b.insertWord(txtWord.getText(),txtDefine.getText()) == 1){
                  System.out.println("Insert Sucessfully");
                  
                a.setHeaderText("Insert Suceessfully");
                a.show();
              }
              else {
                  System.out.println("Insert Failed");
                  a.setHeaderText("Insert Failed");
                  a.show();
              }
              
          } catch (SQLException ex) {
              Logger.getLogger(InsertViewController.class.getName()).log(Level.SEVERE, null, ex);
          }
          }else{
              System.out.println("loi");
              Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                  a.setTitle("Message");
                  a.setHeaderText("Warning");
                  a.show();
          }
      });
    }    
    
}
