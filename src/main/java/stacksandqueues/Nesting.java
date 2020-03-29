package stacksandqueues;

/**
 * Solution for the Nesting task
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingWAJHZQ-GGP
 * @since 29 August 2018
 */
public class Nesting {
    
    /**
     * This will determine whether a given string of parentheses (single type) 
     * is properly nested.
     *
     * @param string a string of parentheses
     * @return 1|0 predicate based on whether the given string of parentheses
     *         is properly nested or not
     */ 
    static int isNested(String string) {
        Stack openBracs = new Stack(); // create a stack for storing open brackets
        int length = string.length();
        int i = 0;
        if (i == 1) { // there is only one bracket, so it is not nested
            return 0;
        }
        while (i < length) {
            char bracket = string.charAt(i);
            if (bracket == '(') {
                openBracs.push(bracket);
            } else if (bracket == ')') {
                try {
                    if (openBracs.pop() != '(') {// the bracket string is unnested 
                        return 0;
                    }
                } catch (Exception e) {// tried to pop bracket off an empty stack
                    return 0;
                }
            } else { // invalid character
               
                return 0;
            }
            i++;
        }
        if (!openBracs.isEmpty()) { // unclosed open brackets left, so unnested 
            return 0;
        }
        return 1;
    }
}
