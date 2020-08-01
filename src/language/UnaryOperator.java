package language;


public abstract class UnaryOperator<T> implements Operator<T> {

  protected Operand<T> op0;

  /** {@inheritDoc} */
  @Override
  public final int getNumberOfArguments() {
    return 1;
  }

  /** {@inheritDoc} */
  public void setOperand(int i, Operand<T> operand) {
    if (operand == null) throw new NullPointerException("Could not set null operand.");
    
    if(i != 0){
        throw new IllegalArgumentException("Only accepts operand 0 but recieved" + i + ".");  
    }

    if(i == 0){
        if(op0 != null){
            throw new IllegalStateException("Position alredy set");
        }

    
    op0 = operand; 
    }


    }

}