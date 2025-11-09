package chapter19;

public class AnyWildCardDemo {
  public static void main(String[] args ) {
     GenericStack<Integer> intStack = new GenericStack<Integer>();
     intStack.push(1); // 1 is autoboxed into new Integer(1)
     intStack.push(2);
     intStack.push(-2);

     print(intStack);
     System.out.print("The max number is " + max(intStack));
     
     GenericStack<String> sStack = new GenericStack<String>();
     sStack.push("hello");
     print(sStack);
     
     System.out.print("The max number is " + max(sStack));
  }

  /** Print objects and empties the stack */
//  public static void print(GenericStack<? extends Number> stack) {
  public static void print(GenericStack<?> stack) {
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }
  
  public static double max(GenericStack<? extends Number> stack) {
    double max = stack.pop().doubleValue(); // initialize max

    while (!stack.isEmpty()) {
      double value = stack.pop().doubleValue();
      if (value > max)
        max = value;
    }

    return max;
 }
  
}
