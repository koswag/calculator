package Handling;

import java.math.BigDecimal;

public class Power extends AbstractHandler {

    public Power() {
        super("^");
    }

    @Override
    public BigDecimal getResult(BigDecimal arg1, BigDecimal arg2) {
        if (checkArguments(arg1, arg2)) {
            double a = arg1.doubleValue();
            double n = arg2.doubleValue();
            double res = Math.pow(a, n);
            return new BigDecimal("" + res);
        }
        return null;
    }
}