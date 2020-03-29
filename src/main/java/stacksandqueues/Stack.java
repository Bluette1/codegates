package stacksandqueues;

 /**
     * The Stack Class.
     *
     * @author marylene
     * @since 29 August 2018
     */
    public class Stack {

        /**
         * An object of type Node holds one of the items in the linked list that
         * represents the stack.
         *
         * @author marylene
         * @since 29 August 2018
         */
        private static class Node {

            int size;
            Node next;
        }

        //Pointer to the Node that is at the top of
        //of the stack. If top == null, then the
        //stack is empty.
        private Node top;

        /**
         * Adds an item to the top of the stack.
         *
         * @param item the item to add on the stack
         */
        void push(int size) {
            Node newTop;
            // A Node to hold the new item.
            newTop = new Node();
            newTop.size = size;
            // Store N in the new Node.
            newTop.next = top;
            // The new Node points to the old top.
            top = newTop;
            // The new item is now on top.
        }

        /**
         * Removes the top item from the stack. Throws an IllegalStateException
         * if the stack is empty when this method is called.
         *
         * @return the size of the new item on top of the stack
         */
        int pop() {
            if (top == null) {
                throw new IllegalStateException("Can’t pop from an empty stack.");
            }
            int topSize = top.size; // The item that is being popped.
            top = top.next;
            // The previous second item is now on top.
            return topSize;
        }

        /**
         * Returns the size of the item on top of the stack. Throws an
         * IllegalStateException if the stack is empty.
         *
         * @return the size of the item on top of the stack
         */
        int peek() {
            if (top == null) {
                throw new IllegalStateException("Stack is empty.");
            }
            return top.size;
        }

        /**
         * Returns true if the stack is empty. Returns false if there are one or
         * more items on the stack.
         *
         * @return true|false whether the stack is empty or not
         */
        boolean isEmpty() {
            return (top == null);
        }
    }