package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import ru.spring.training.Calculator;

public class CalculatorSteps {

    private Calculator calc;

    double a;
    double b;
    double result;

    @Дано("^две цифры (\\d) и (\\d)")
    public void given(double a, double b) {
        this.a = a;
        this.b = b;
        this.calc = new Calculator();
    }

    @Тогда("^ищем сумму двух цифр")
    public void when() {
        result = calc.sum(a, b);
    }

    @Когда("^результат должен быть (\\d)")
    public void then(double res) {
        Assert.assertEquals(res, result, 0.0001);
    }
}