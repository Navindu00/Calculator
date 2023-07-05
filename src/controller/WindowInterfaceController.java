package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WindowInterfaceController{
     @FXML
    private Pane titlePane;
    
    private double x;
    private double y;
    private String operator = "+";
    private double num1 = 0.0;

     @FXML
    private ImageView btnClose;

    @FXML
    private ImageView btnMinimize;

    @FXML
    private Label lblResult;

    
    public void init(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent ->{
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        titlePane.setOnMouseDragged(mouseEvent ->{
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        btnClose.setOnMouseClicked(mouseEvent ->{
            stage.close();
        });

        btnMinimize.setOnMouseClicked(mouseEvent ->{
            stage.setIconified(true);
        });
    }

    @FXML
    void onNumberClicked(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("btn",""));
        String show = Double.parseDouble(lblResult.getText())==0? String.valueOf((double)value): String.valueOf(Double.parseDouble(lblResult.getText())*10+value);
        lblResult.setText(show);
    }

     @FXML
    void onSymbolClicked(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("btn","");
        
        if(symbol.equals("Equal")){
            double num2 = Double.parseDouble(lblResult.getText());
            switch (operator) {
                case "+": 
                    lblResult.setText((num1+num2)+"");
                    break;
                case "-": 
                    lblResult.setText((num1-num2)+"");
                    break;
                case "*": 
                    lblResult.setText((num1*num2)+"");
                    break;
                case "/": 
                    lblResult.setText((num1/num2)+"");
                    break;
            }
            operator = "$";

        }else if(symbol.equals("Clear")){
            lblResult.setText(String.valueOf(0.0));
            operator = "$";
            
        }else{
            switch (symbol) {
                case "Plus":
                    operator = "+";
                    break;
                case "Minus":
                    operator = "-";
                    break;
                case "Multiply":
                    operator = "*";
                    break;
                case "Divide":
                    operator = "/";
                    break;
            }

            num1 =  Double.parseDouble(lblResult.getText());
            lblResult.setText(String.valueOf(0.0));
        }
    }
  
}
