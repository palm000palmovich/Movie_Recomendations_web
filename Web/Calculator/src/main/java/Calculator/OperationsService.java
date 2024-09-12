package Calculator;

import org.springframework.stereotype.Service;

@Service
public class OperationsService {

    public String Plus(Integer num1, Integer num2){
        if (num1 == null || num2 == null){
            return "Одна их переменных не задана!";
        } else {
            return (num1 + " + " + num2 + " = " + (num1+num2));
        }
    }

    public String Minus(Integer num1, Integer num2){
        if (num1 == null || num2 == null){
            return "Одна их переменных не задана!";
        } else {
            return (num1 + " - " + num2 + " = " + (num1-num2));
        }
    }

    public String Multiply(Integer num1, Integer num2){
        if (num1 == null || num2 == null){
            return "Одна их переменных не задана!";
        } else {
            return (num1 + " * " + num2 + " = " + (num1*num2));
        }
    }

    public String Divide(Integer num1, Integer num2){
        if ((num1 == null || num2 == null) && num2 != 0){
            return "Одна их переменных не задана!";
        } else {
            return (num1 + " / " + num2 + " = " + (num1/num2));
        }
    }
}
