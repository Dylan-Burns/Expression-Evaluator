package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.operators.*;

import java.util.*;

public class Evaluator {

  private final Stack<Operand> operandStack;
  private final Stack<Operator> operatorStack;
  private static final String delimiters = "()+-*^/#!";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public void process() {
    while (operatorStack.peek().priority() > 1) {
      Operator operatorFromStack = operatorStack.pop();
      Operand operandTwo = operandStack.pop();
      Operand operandOne = operandStack.pop();
      Operand result = operatorFromStack.execute(operandOne, operandTwo);
      operandStack.push( result );
    }
    operatorStack.pop();
  }

  public int evaluateExpression(String expression ) throws InvalidTokenException{
    operatorStack.push(new StartExpressionOperator());
    String expressionToken;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    StringTokenizer expressionTokenizer = new StringTokenizer(expression, delimiters, true);

    // initialize operator stack - necessary with operator priority schema
    // the priority of any operator in the operator stack other than
    // the usual mathematical operators - "+-*/" - should be less than the priority
    // of the usual operators

    while ( expressionTokenizer.hasMoreTokens() ) {
      // filter out spaces
      if ( !( expressionToken = expressionTokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand
        if ( Operand.check( expressionToken )) {
          operandStack.push( new Operand( expressionToken ));
        } else {
          if ( !Operator.check( expressionToken )) {
            throw new InvalidTokenException();
          }
          if(expressionToken.equals(")")){
            process();
            continue;
          }
          if(expressionToken.equals("(")){
            operatorStack.push(new OpenParenthesisOperator());
            continue;
          }
          Operator newOperator = Operator.getOperator(expressionToken);

          if(operatorStack.isEmpty()){
            operatorStack.add(newOperator);
            continue;
          }

          // TODO Operator is abstract - these two lines will need to be fixed:
          // The Operator class should contain an instance of a HashMap,
          // and values will be instances of the Operators.  See Operator class
          // skeleton for an example.

          while (operatorStack.peek().priority() >= newOperator.priority() ) {
            // note that when we eval the expression 1 - 2 we will
            // push the 1 then the 2 and then do the subtraction operation
            // This means that the first number to be popped is the
            // second operand, not the first operand - see the following code
            Operator operatorFromStack = operatorStack.pop();
            Operand operandTwo = operandStack.pop();
            Operand operandOne = operandStack.pop();
            Operand result = operatorFromStack.execute( operandOne, operandTwo );
            operandStack.push( result );
          }
          operatorStack.push( newOperator );
        }
      }
    }


    // Control gets here when we've picked up all the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks,
    // that is, we should keep evaluating the operator stack until it is empty;
    // Suggestion: create a method that processes the operator stack until empty.
    while(operatorStack.peek().priority() > 0){
      Operator opFromStack = operatorStack.pop();
      Operand op2 = operandStack.pop();
      Operand op1 = operandStack.pop();
      operandStack.push(opFromStack.execute(op1, op2));
    }
    return operandStack.pop().getValue();

  }
}

