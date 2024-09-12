package Calculator;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String Hel(){
        return "Hello";
    }

    public String HelCalculator(){
        return "Добро пожаловать в калькулятор!";
    }

}
