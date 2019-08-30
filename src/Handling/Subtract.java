package Handling;

import java.math.BigDecimal;

public class Subtract extends AbstractHandler {

    public Subtract() {
        super("-");
    }

    @Override
    public BigDecimal getResult(BigDecimal arg1, BigDecimal arg2) {
        if (checkArguments(arg1, arg2))
            return arg1.subtract(arg2);
        return null;
    }
}