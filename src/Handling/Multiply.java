package Handling;

import java.math.BigDecimal;

public class Multiply extends AbstractHandler {

    public Multiply() {
        super("*");
    }

    @Override
    public BigDecimal getResult(BigDecimal arg1, BigDecimal arg2) {
        if (checkArguments(arg1, arg2))
            return arg1.multiply(arg2);
        return null;
    }

}