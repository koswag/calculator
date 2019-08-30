package Comm;

import java.math.BigDecimal;

public class Request {

    private BigDecimal[] args;
    private String operator;

    private boolean valueError = false;

    public Request(String arg1, String operator, String arg2) {
        this.operator = operator;

        setArguments(arg1, arg2);
    }

    public BigDecimal getArg(int i) {
        return args[i];
    }

    public String getOperator() {
        return operator;
    }

    private void setArguments(String arg1, String arg2) {
        this.args = new BigDecimal[2];
        try {
            this.args[0] = new BigDecimal(arg1);
            this.args[1] = new BigDecimal(arg2);
        } catch (NumberFormatException e) {
            valueError = true;
        }
    }

    public boolean errorOccurred() {
        return valueError;
    }
}