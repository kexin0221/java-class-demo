package chapter19;

public class WildCardNeedDemo {
    public static void main(String[] args ) {
        GenericStack<Integer> intStack = new GenericStack<Integer>();
        intStack.push(1); // 1 is autoboxed into new Integer(1)
        intStack.push(2);
        intStack.push(-2);

//        System.out.print("The max number is " + max(intStack));
    }

    /** Find the maximum in a stack of numbers */
    public static double max(GenericStack<Number> stack) {
        return AnyWildCardDemo.max(stack);
    }
}
