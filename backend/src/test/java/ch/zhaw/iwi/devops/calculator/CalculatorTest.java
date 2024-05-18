package ch.zhaw.iwi.devops.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.ch.zhaw.iwi.devops.calculator.Calculator;

public class CalculatorTest {


    //Addition
    @Test
    public void testCalculateAdd() {
        Assertions.assertEquals(6, Calculator.calculate(3, 3, "add"));
    }

  @Test
    public void testCalculateSubtract() {
        Assertions.assertEquals(3, Calculator.calculate(6, 3, "subtract"));
    }
  
}

