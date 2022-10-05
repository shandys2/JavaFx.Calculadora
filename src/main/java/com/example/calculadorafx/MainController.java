package com.example.calculadorafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private List<String> entrada1=null;
    private List<String> entrada2=null;
    Double operando1=0.0;
    Double operando2=0.0;
    String operacion="";
    Boolean hayOperacion=false;
    @FXML
    protected void onNumeroClick(ActionEvent actionEvent) {

        String txt;

        if(entrada1==null && entrada2==null){
            entrada1= new ArrayList<>();
            entrada2= new ArrayList<>();
        }
        if (!hayOperacion){
            txt=((Button)actionEvent.getSource()).getText();
            entrada1.add(txt);
            txtView.setText(String.join("",entrada1));
        }else{
            txt=((Button)actionEvent.getSource()).getText();
            entrada2.add(txt);
            txtView.setText(String.join("",entrada2));
        }
    }

    @FXML
    protected void onPuntoClick(ActionEvent actionEvent) {

        if (!hayOperacion){
            entrada1.add(".");
            txtView.setText(String.join("",entrada1));
        }else{
            entrada2.add(".");
            txtView.setText(String.join("",entrada2));
        }
    }
    @FXML
    protected void onOperadorClick(ActionEvent actionEvent) {
        String oper=((Button)actionEvent.getSource()).getText();
        switch (oper) {
            case "+":{ operacion="+";}break;
            case "-":{ operacion="-"; }break;
            case "/":{ operacion="/"; }break;
            case "*":{ operacion="*";}break;
            }
        hayOperacion=true;
        }

    @FXML
     protected void onResulClick() {
        //parseamos las entradas
        operando1= listToDouble(entrada1);
        operando2= listToDouble(entrada2);
        //hacemos y mostramos la operacion
        Double respuesta = hacerOperacion(operando1,operando2);
        txtView.setText(String.valueOf(respuesta));
        //y reseteamos valores
        entrada1=null;
        entrada2=null;
        hayOperacion=false;
    }

    @FXML
    protected void onLimpiarClick() {
        txtView.setText("");
        entrada1=null;
        entrada2=null;
    }

    protected Double listToDouble(List<String> entrada){

        //Hacemos un join al array lo parseamos a Double
        String aux = String.join("",entrada);
        Double numero = Double.valueOf(aux);
        return numero;

    }

    protected Double hacerOperacion(Double numero1, Double numero2){
        Double resultado=0.0;
        //Sin comentarios
        switch (operacion){
            case "*":return numero1 * numero2;
            case "+":return numero1 + numero2;
            case "-":return numero1 - numero2;
            case "/":return numero1 / numero2;
        }
        return resultado;
    }


}