package stack.operations;

import stack.model.Stack;

public class ReverseStack<T> {
    public void reverse(Stack<T> stack) {
        if (stack.isEmpty()){
            return;
        }
        T element = stack.pop();
        reverse(stack);
        insertAtBottom(element, stack);
    }

    private void insertAtBottom(T element, Stack<T> stack) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        T temp = stack.pop();
        insertAtBottom(element, stack);
        stack.push(temp);
    }
}
