package core.utils.specialReportUtils;

/**
 * Created by majid on 6/6/17.
 */
public enum Operators {

    openBracket("openBracket","message.conditionCreator.operator.openBracket.value","message.conditionCreator.operator.openBracket.title"),
    closeBracket("closeBracket","message.conditionCreator.operator.closeBracket.value","message.conditionCreator.operator.closeBracket.title"),
    equal("equal","message.conditionCreator.operator.equal.value","message.conditionCreator.operator.equal.title"),
    nonEqual("nonEqual","message.conditionCreator.operator.nonEqual.value","message.conditionCreator.operator.nonEqual.title"),
    greater("greater","message.conditionCreator.operator.greater.value","message.conditionCreator.operator.greater.title"),
    greaterEqual("greaterEqual","message.conditionCreator.operator.greaterEqual.value","message.conditionCreator.operator.greaterEqual.title"),
    less("less","message.conditionCreator.operator.less.value","message.conditionCreator.operator.less.title"),
    lessEqual("lessEqual","message.conditionCreator.operator.lessEqual.value","message.conditionCreator.operator.lessEqual.title"),
    and("and","message.conditionCreator.operator.and.value","message.conditionCreator.operator.and.title"),
    or("or","message.conditionCreator.operator.or.value","message.conditionCreator.operator.or.title");

    private String key;
    private String value;
    private String title;

    Operators(String key, String value, String title) {
        this.key = key;
        this.value = value;
        this.title = title;
    }

    public static Operators getValue(String key){
        if (key!=null) {
            if (key.equals(openBracket.getKey()))
                return openBracket;
            else if (key.equals(closeBracket.getKey()))
                return closeBracket;
            else if (key.equals(equal.getKey()))
                return equal;
            else if (key.equals(nonEqual.getKey()))
                return nonEqual;
            else if (key.equals(greater.getKey()))
                return greater;
            else if (key.equals(greaterEqual.getKey()))
                return greaterEqual;
            else if (key.equals(less.getKey()))
                return less;
            else if (key.equals(lessEqual.getKey()))
                return lessEqual;
            else if (key.equals(and.getKey()))
                return and;
            else if (key.equals(or.getKey()))
                return or;
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }
}
