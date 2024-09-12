package Calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Activities {
    private final HelloService helSer;
    private final OperationsService oper;

    //Конструктор
    public Activities(HelloService helSer, OperationsService oper){
        this.helSer = helSer;
        this.oper = oper;
    }


    //Стартовый экран - ПРИВЕТСТВИЕ
    @GetMapping
    public String Hel(){
        return helSer.Hel();
    }

    //реакция на /calculator
    @GetMapping(path = "/calculator")
    public String HelCalculator(){
        return helSer.HelCalculator();
    }


    //Операции
    //Сложение
    @GetMapping(path = "/calculator/plus")
    public String Plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return oper.Plus(num1, num2);
    }

}
