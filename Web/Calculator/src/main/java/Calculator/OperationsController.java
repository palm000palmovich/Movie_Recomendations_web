package Calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class OperationsController {
    private final OperationsService oper;

    //Конструктор
    public OperationsController(OperationsService oper){
        this.oper = oper;
    }

    //Операции
    //Сложение
    @GetMapping(path = "/plus")
    public String Plus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        return oper.Plus(num1, num2);
    }

    //Вычитание
    @GetMapping(path = "/minus")
    public String Minus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){

        return oper.Minus(num1, num2);
    }

    //Умножение
    @GetMapping(path = "/multiply")
    public String Multiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        return oper.Multiply(num1, num2);
    }

    //Деление
    @GetMapping(path = "/divide")
    public String Divide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2){
        if (num2 == 0){
            return "num2 не может быть нулевым!";
        } else {
            return oper.Divide(num1, num2);
        }
    }


}
