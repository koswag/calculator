package Comm;

import java.math.BigDecimal;

public class Result {

    private String result;

    public Result(BigDecimal value) {
        if (value != null)
            this.result = value.toString();
        else
            this.result = "Err";
    }

    @Override
    public String toString() {
        return result;
    }
}