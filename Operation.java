import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public enum Operation {
    SUM("+"), DIVIDE("/"), MULTIPLY("*"), SUBTRACT("-");

    private String operator;
    private static Map<String, Operation> map;
    private Operation(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    static
    {
        map = new HashMap<>(4);
        map.put("+", SUM);
        map.put("/", DIVIDE);
        map.put("*", MULTIPLY);
        map.put("-", SUBTRACT);
    }

    public static Operation getFrom(String operator)
    {
        return map.get(operator);
    }
}

