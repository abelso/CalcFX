package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class MainController {
    public float number1 = 0;
    public float number2 = 0;

    public int currentNumber = 1;
    public String operator = "";

    public boolean isDecimal = false;

    @FXML
    public Label result;
    public Label operation;

    public void processNumber(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (currentNumber == 1) {
            operation.setText("");
            result.setText(result.getText() + value);
            number1 = Float.parseFloat(result.getText());
        } else {
            result.setText(result.getText() + value);
            number2 = Float.parseFloat(result.getText());
        }

        System.out.println(number1);
        System.out.println(number2);
    }

    public void decimalPoint() {
        if (!isDecimal) {
            result.setText(result.getText() + ".");
            isDecimal = true;
        }
    }

    public void processOperator(ActionEvent event) {
        operator = ((Button)event.getSource()).getText();
        if (currentNumber == 1) {
            operation.setText(number1 + " " + operator);
            isDecimal = false;
            result.setText("");
            currentNumber = 2;
        }
    }

    public void changeSign() {
        if (currentNumber == 1) {
            number1 = number1 * (-1);
            result.setText(Float.toString(number1));
        }
    }

    public void clearAll() {
        number1 = 0;
        number2 = 0;
        operator = "";
        result.setText("");
        operation.setText("");
    }

    public void percentage() {
        if (currentNumber == 1) {
            number1 = number1 * 0.01f;
        } else {
            number2 = number2 * 0.01f;
        }
    }

    public void equals() {
        switch (operator) {
            case "÷":
                try {
                    result.setText(Float.toString(number1 / number2));
                } catch (Exception e) {
                    result.setText("Err");
                }
                break;
            case "x":
                result.setText(Float.toString(number1 * number2));
                break;
            case "-":
                result.setText(Float.toString(number1 - number2));
                break;
            case "+":
                result.setText(Float.toString(number1 + number2));
                break;

        }

        operation.setText(number1 + " " + operator + " " + number2);
        number1 = Float.parseFloat(result.getText());
    }
}
