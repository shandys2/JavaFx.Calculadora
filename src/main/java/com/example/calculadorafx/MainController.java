package com.example.calculadorafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private Button bc;

    @FXML
    private Button bdiv;

    @FXML
    private Button bce;

    @FXML
    private Button b0;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button bcom;

    @FXML
    private Button bmenos;

    @FXML
    private Button b5;

    @FXML
    private Button bmas;

    @FXML
    private Button bigual;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private TextField txtView;

    @FXML
    private Button b9;

    @FXML
    private Button bpor;


    private int numero1;
    private String coma=".";
    StringBuilder n1= new StringBuilder("");
    private double numero2;


    @FXML
    protected void onNumeroClick(ActionEvent actionEvent) {

        String txt=((Button)actionEvent.getSource()).getText();
        //comprobamos que sea el caracter '.' y que no exista ya en el string
        if(txt.equals(coma) && (n1.indexOf(coma)==-1)){
            n1.append('.');
            ((Button)actionEvent.getSource()).setDisable(true);
        }else{
            n1.append(((Button)actionEvent.getSource()).getText());
            txtView.setText(String.valueOf(n1));
        }
    }


    @FXML
    protected void onOperadorClick(ActionEvent actionEvent) {

        String operacion=((Button)actionEvent.getSource()).getText();

        switch (operacion) {

            case "+":{ txtView.setText("sumando");}break;
            case "-":{ txtView.setText("restando"); }break;
            case "/":{ txtView.setText("dividiendo"); }break;
            case "*":{  txtView.setText("multiplicando");}break;

            }
        }

    @FXML
     protected void onResulClick() {
        txtView.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onLimpiarClick() {
        txtView.setText("");
        numero1=0;
        numero2=0;
    }


}