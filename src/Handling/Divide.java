package Handling;

import java.math.BigDecimal;

public class Divide extends AbstractHandler {

    public Divide() {
        super("/");
    }

    @Override
    public BigDecimal getResult(BigDecimal arg1, BigDecimal arg2) {
        BigDecimal res = null;
        if (arg2.compareTo(BigDecimal.ZERO) != 0 && checkArguments(arg1, arg2))
            try {
                res = arg1.divide(arg2);
            } catch (ArithmeticException ignored) {
            }
        return res;
    }
}