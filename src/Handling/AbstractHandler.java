package Handling;

import Comm.Request;
import Comm.Result;

import java.math.BigDecimal;

public abstract class AbstractHandler {

    private AbstractHandler next;
    private String operator;

    protected AbstractHandler(String operator) {
        this.operator = operator;
    }

    public AbstractHandler append(AbstractHandler handler) {
        var lastHandler = this;

        while (lastHandler.next != null)
            lastHandler = lastHandler.next;

        lastHandler.next = handler;
        return this;
    }

    public Result handle(Request req) {
        if (req.getOperator().equals(operator)) {
            return evaluate(req);
        } else {
            if (next != null)
                return next.handle(req);
            else
                return operationMissing();
        }
    }

    private Result evaluate(Request req) {
        BigDecimal res = getResult(req.getArg(0), req.getArg(1));
        return new Result(res);
    }

    private Result operationMissing() {
        return new Result(null);
    }

    protected static boolean checkArguments(BigDecimal arg1, BigDecimal arg2) {
        return arg1 != null && arg2 != null;
    }

    public abstract BigDecimal getResult(BigDecimal arg1, BigDecimal arg2);
}