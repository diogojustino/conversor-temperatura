/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diogoleite.controller;

import br.com.diogoleite.application.Main;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author diogo_leite
 */
public class FXMLConversorController implements Initializable {

    private double pontoAtualMouseX;
    private double pontoAtualMouseY;   
    
     @FXML
    private AnchorPane apPrincipal;

    @FXML
    private RadioButton rdbtnCelsius;

    @FXML
    private ToggleGroup tipoTemperatura;

    @FXML
    private RadioButton rdbtnFahrenheit;

    @FXML
    private RadioButton rdbtnKelvin;

    @FXML
    private TextField txtTemperatura;

    @FXML
    private Label txtCelsius;

    @FXML
    private Label txtFahrenheit;

    @FXML
    private Label txtKelvin;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        apPrincipal.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                pontoAtualMouseX = event.getSceneX();
                pontoAtualMouseY = event.getSceneY();
            }
        });

        apPrincipal.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Main.getStage().setX(event.getScreenX() - pontoAtualMouseX);
                Main.getStage().setY(event.getScreenY() - pontoAtualMouseY);

            }
        });
        txtTemperatura.setOnKeyReleased(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent keyEvent){
                RadioButton radio = (RadioButton) tipoTemperatura.getSelectedToggle();
              
                String valor = txtTemperatura.getText();
                double temperatura = 0;
                try{
                  temperatura = Double.parseDouble(valor);
                }catch(RuntimeException runtimeException){
                    valor = valor.substring(0, valor.length()-1);
                    temperatura = Double.parseDouble(valor);
                    txtTemperatura.setText(valor);
                    System.out.println(valor);
                }
                
                if(radio == rdbtnCelsius){
                    txtCelsius.setText(String.valueOf(temperatura));
                    txtFahrenheit.setText(String.valueOf(temperatura * 1.8 + 32));
                    txtKelvin.setText(String.valueOf(temperatura + 273));
                }
                
                if(radio == rdbtnFahrenheit){
                    txtFahrenheit.setText(String.valueOf(temperatura));
                    double cel = (temperatura - 32)/1.8;
                    txtCelsius.setText(String.valueOf(cel));
                    txtKelvin.setText(String.valueOf(cel + 273));
                }
                
                if( radio == rdbtnKelvin){
                    txtKelvin.setText(String.valueOf(temperatura));
                    double cel = temperatura - 273;
                    txtCelsius.setText(String.valueOf(cel));
                    txtFahrenheit.setText(String.valueOf(cel * 1.8 / 32));
                }
            }
        });
       
    }
}
