package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.PostfixEvaluator;

/** An {@link ArithPostfixEvaluator} is a postfix evaluator over simple arithmetic expressions. */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

  private final StackInterface<Operand<Integer>> stack;

  /** Constructs an {@link ArithPostfixEvaluator} */
  public ArithPostfixEvaluator() {
    // TODO Initialize to your LinkedStack
    stack = new LinkedStack<Operand<Integer>>(); 
  }

  /** {@inheritDoc} */
  @Override
  public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
    ArithPostfixParser parser = new ArithPostfixParser(expr);
    for (Token<Integer> token : parser) {
      Type type = token.getType();
      switch (type) {
        case OPERAND:
          // TODO What do we do when we see an operand?
          Operand<Integer> oprnd = token.getOperand(); 
          stack.push(oprnd); 
          break;
        case OPERATOR:
          // TODO What do we do when we see an operator?
          Operator<Integer> operator = token.getOperator();

          if(operator.getNumberOfArguments() == 2){
            Operand<Integer> first = stack.pop();
            Operand<Integer> seccond = stack.pop();
            operator.setOperand(1, first);
            operator.setOperand(0, seccond);

            Operand<Integer> result = operator.performOperation(); 

            stack.push(result); 
          } else if(operator.getNumberOfArguments() == 1){

            Operand<Integer> singleOp = stack.pop();

            operator.setOperand(0, singleOp);
            
            Operand<Integer> result2 = operator.performOperation();

            stack.push(result2); 

          }
          break;
        default:
          throw new IllegalStateException("Parser returned an invalid Type: " + type);
      }
    }
    // TODO What do we return?
    if(stack.size() == 1){
      return stack.pop().getValue();
    } else{
      throw new IllegalPostfixExpressionException(); 
    }
  }
}
