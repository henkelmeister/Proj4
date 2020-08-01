package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure to allow for
 * unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

  private LLNode<T> head; 
  private int size; 

  public LinkedStack(){
    size = 0;
    head = null; 
  }

  /** {@inheritDoc} */
  @Override
  public T pop() throws StackUnderflowException {
    // TODO: Implement the stack operation for `pop`!
     if(head == null) throw new StackUnderflowException("Empty stack");

     T removedNode = head.getData(); 

     if(head.getNext() == null){
       head = null; 
       size--;
       return removedNode; 
     }

     head = head.getNext(); 
     size--; 
     return removedNode;
  }

  /** {@inheritDoc} */
  @Override
  public T top() throws StackUnderflowException {
    // TODO: Implement the stack operation for `top`!
    if(head == null) throw new StackUnderflowException("Empty stack");

    return head.getData();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmpty() {
    // TODO: Implement the stack operation for `isEmpty`!
    return head == null; 
  }

  /** {@inheritDoc} */
  @Override
  public int size() {
    // TODO: Implement the stack operation for `size`!
    return size;
  }

  /** {@inheritDoc} */
  @Override
  public void push(T elem) {
    // TODO: Implement the stack operation for `push`!
    LLNode<T> newNode = new LLNode<T>(elem);
    if(head == null){
      head = newNode; 
      size++; 
      return; 
    } else{
      newNode.setNext(head);
      head = newNode; 
      size++; 
      return; 
    }
    
  }
}
