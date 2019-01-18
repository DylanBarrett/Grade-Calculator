/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcbk34gradecalculator;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author DylanBarrett
 */
public class Dcbk34GradeCalculator extends Application {
    
    public String title = "Grade Calculator"; 
    public int width = 500; 
    public int height = 400; 
    
    public String fontStyle = "Comic Sans MS"; 
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title); 
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(15);
        root.setVgap(15);
        //root.setPadding(new Insets(25,25,25,25));
        
//        Text sceneTitle = new Text("Welcome Please Login");
//        sceneTitle.setFont(Font.font(fontStyle, FontWeight.BOLD,26));
//        root.add(sceneTitle, 0,0,2,1);
        
        Label category1 = new Label("Category1 (30%):");
        category1.setFont(Font.font(fontStyle, FontWeight.NORMAL, 18));
        root.add(category1, 0, 0);
        
        TextField score1TextField = new TextField();
        score1TextField.setPrefWidth(400);
        root.add(score1TextField,0 ,1);
        
        Label category2 = new Label("Category2 (70%):");
        category2.setFont(Font.font(fontStyle, FontWeight.NORMAL, 18));
        root.add(category2, 0, 2);
        
        TextField score2TextField = new TextField();
        score2TextField.setPrefWidth(400);
        root.add(score2TextField,0 ,3);
        
        Label myFinalScore = new Label("My Final Score:");
        myFinalScore.setFont(Font.font(fontStyle, FontWeight.NORMAL, 18));
        root.add(myFinalScore, 0, 4);
        
        TextField score3TextField = new TextField();
        score3TextField.setPrefWidth(400);
        root.add(score3TextField,0 ,5);
        
        //creating buttons
        Button maximizeButton = new Button("Maximize");
        Button calculateButton = new Button("Calculate");
        Button clearButton = new Button("Clear");
        Button alertButton = new Button("Alert");
        //setting buttons to all have the same width.
        maximizeButton.setMaxWidth(Double.MAX_VALUE);
        calculateButton.setMaxWidth(Double.MAX_VALUE);
        clearButton.setMaxWidth(Double.MAX_VALUE);
        alertButton.setMaxWidth(Double.MAX_VALUE);
        
        //vbox adding buttons and setting the padding and spacing between them
        VBox vb = new VBox();
        vb.setSpacing(15);
        vb.setPadding(new Insets(0,0,15,0));
        vb.getChildren().add(maximizeButton);
        vb.getChildren().add(calculateButton);
        vb.getChildren().add(clearButton);
        vb.getChildren().add(alertButton);
        
        root.add(vb,0,6);
       
        Scene scene = new Scene(root,width,height);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        maximizeButton.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        score1TextField.setText("100");
        score2TextField.setText("100");
      }
    });
        
        calculateButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
           DecimalFormat decFor = new DecimalFormat("0.00"); //format number with two decimal place
           String score1=score1TextField.getText();
           String score2=score2TextField.getText();
           double finalValue;
           finalValue = Double.parseDouble(score1)*0.3+Double.parseDouble(score2)*0.7;
           score3TextField.setText("My final grade should be " + score1TextField.getText() + " * .3" +" + " + score2TextField.getText() + " * .7" + " = " +decFor.format(finalValue));
            }
        });
        
        clearButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                score1TextField.setText(" ");
                score2TextField.setText(" ");
                score3TextField.setText(" ");
            }
        });
        
        alertButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
           DecimalFormat decFor = new DecimalFormat("0.00"); //format number with two decimal place
           String score1=score1TextField.getText();
           String score2=score2TextField.getText();
           double finalValue;
           finalValue = Double.parseDouble(score1)*0.3+Double.parseDouble(score2)*0.7;
            //get textfield values and show in alert dialog
            Dialog d=new Alert(Alert.AlertType.INFORMATION,"My final grade should be " + score1TextField.getText() + "* .3" +" + " + score2TextField.getText() + "* .7" + " = " +decFor.format(finalValue));
            d.show();
    }
        });
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}