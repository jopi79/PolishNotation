import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.regex.PatternSyntaxException;

public class PolishNotationParser {
    public static double parse(String s) {
        Deque<Double> stack = new ArrayDeque<Double>();
        String[] words = s.split(" ");
        for(int i=0;i<words.length;i++)
        {
            Operation operation = getOperator(words[i]);
            if(operation == null)
            {
                Double a = Double.parseDouble(words[i]);
                stack.push(a);
            }
            else
            {
                if(stack.isEmpty()) throw new IllegalArgumentException();
                Double a = stack.pop();
                if(stack.isEmpty()) throw new IllegalArgumentException();
                Double b = stack.pop();
                Double value = calculate(a,b,operation);
                stack.push(value);
            }
        }
        return stack.pop();
    }

    private static Double calculate(Double a, Double b, Operation operation) {
        switch (operation){
            case SUM -> {
                return a+b;
            }
            case DIVIDE -> {
                return b/a;
            }
            case MULTIPLY -> {
                return a*b;
            }
            case SUBTRACT -> {
                return b-a;
            }
            default -> throw new IllegalArgumentException();
        }
    }

    private static Operation getOperator(String operator) {
        return Operation.getFrom(operator);
    }

    private static boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "/".equals(s) || "×".equals(s);
    }

    public static void main(String[] a)
    {
        Operation.valueOf("+");
    }
}

