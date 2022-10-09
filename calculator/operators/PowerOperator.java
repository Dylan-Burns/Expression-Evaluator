package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator {
    @Override
    public int priority() {
        return 4;
    }

    public Operand execute( Operand op1, Operand op2 ) {
        return new Operand( power(op1.getValue(), op2.getValue()) );
    }

    public int power( int num1, int num2 ) {
        int result = num1;
        for( int i = 2; i <= num2; i++ ) {
            result *= num1;
        }
        return result;
    }
}
