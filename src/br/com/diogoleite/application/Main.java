/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diogoleite.application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author diogo_leite
 */
public class Main extends Application{
    private static Stage stage;
    @Override
    public void start(Stage stage){
        try{
            Main.stage = stage;
            Parent parent = FXMLLoader.load(getClass().getResource("/br/com/diogoleite/view/FXMLConversor.fxml"));
            Scene scene = new Scene(parent);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    
    public static Stage getStage(){
        return stage;
    }
}