package Calculator;

import org.springframework.stereotype.Service;

@Service
public class OperationsService {

    public String Plus(int num1, int num2){
        return (num1 + " + " + num2 + " = " + (num1+num2));
    }

}
