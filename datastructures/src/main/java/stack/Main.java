package stack;

import stack.model.Stack;
import stack.operations.ReverseStack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.toString());
        ReverseStack<Integer> reverseStack = new ReverseStack<>();
        reverseStack.reverse(stack);
        System.out.println(stack.toString());
    }
}
