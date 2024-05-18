package ch.zhaw.iwi.devops.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    //Addition
    @Test
    public void testCalculateAdd() {
        Assertions.assertEquals(6, Calculator.calculate(3, 3, "add"));
    }

  
}

