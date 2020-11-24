package service.Impl;

import org.springframework.stereotype.Service;

@Service
public class CaculatorServiceImpl implements service.CaculatorService {
    @Override
    public double caculate(double num1, double num2, String data) {
        double result = 0;
        switch (data) {
            case "Addition(+)":
                result = num1 + num2;
                break;
            case "Subtraction(-)":
                result = num1 - num2;
                break;
            case "Multiplication(X)":
                result = num1 * num2;
                break;
            case "Division(/)":
                result = num1 / num2;
                break;
        }
        return result;
    }
}
