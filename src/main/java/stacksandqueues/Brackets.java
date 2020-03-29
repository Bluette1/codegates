package stacksandqueues;

/**
 * Solution for the Brackets task.
 *
 * @author marylene
 * @see https://app.codility.com/demo/results/trainingFRC6GN-7KP/
 * @since 29 August 2018
 */
public class Brackets {

    /**
     * This will determine whether a given string of parentheses (multiple types) 
     * is properly nested.
     *
     * @param string a string of parentheses
     * @return 1|0 predicate based on whether the given string of parentheses
     *         is properly nested or not
     */
    static int isNested(String string) {
        Stack openBracs = new Stack();
        int length = string.length();
        int i = 0;
        if (i == 1) { //one unnested bracket
            return 0;
        }
        while (i < length) {
            char bracket = string.charAt(i);
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                openBracs.push(bracket);
            } else {
                try {
                    switch (bracket) {
                        case ')':
                            if (openBracs.pop() != '(') {// the bracket string is unnested 
                                return 0;
                            }
                            break;
                        case '}':
                            if (openBracs.pop() != '{') {// the bracket string is unnested
                                return 0;
                            }
                            break;
                        case ']':
                            if (openBracs.pop() != '[') {// the bracket string is unnested
                                return 0;
                            }
                            break;
                        default://invalid character
                            return 0;
                    }
                } catch (Exception e) {// tried to pop bracket off an empty stack
                    return 0;
                }
            }
            i++;
        }
        if (!openBracs.isEmpty()) {// unclosed open brackets left, so unnested 
            return 0;
        }
        return 1;
    }
}
