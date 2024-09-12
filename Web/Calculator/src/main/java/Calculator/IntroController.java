package Calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IntroController {
    private final HelloService helSer;

    //Конструктор
    public IntroController(HelloService helSer){
        this.helSer = helSer;
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


}
