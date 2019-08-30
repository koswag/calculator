package Handling;

import java.math.BigDecimal;

public class Add extends AbstractHandler {

    public Add() {
        super("+");
    }

    @Override
    public BigDecimal getResult(BigDecimal arg1, BigDecimal arg2) {
        if (checkArguments(arg1, arg2))
            return arg1.add(arg2);
        return null;
    }
}