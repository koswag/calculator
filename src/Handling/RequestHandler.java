package Handling;

import Comm.Request;
import Comm.Result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestHandler {

    private AbstractHandler add = new Add(),
            sub = new Subtract(),
            mul = new Multiply(),
            div = new Divide(),
            pow = new Power(),
            first;

    private static Pattern pattern = Pattern.compile("(\\d+\\.*\\d*)\\s*(\\D)\\s*(\\d+\\.*\\d*)");

    public RequestHandler() {
        createChain();
    }

    private void createChain() {
        first = add
                .append(sub)
                .append(mul)
                .append(div)
                .append(pow);
    }

    public String getResult(String line) {
        String[] values = getValues(line);
        Request req = new Request(values[0], values[1], values[2]);

        Result res = handle(req);

        if (res != null)
            return res.toString();
        else
            return "Err";
    }

    private String[] getValues(String line) {
        Matcher m = pattern.matcher(line);
        String[] res;

        if (m.matches())
            res = new String[]{m.group(1), m.group(2), m.group(3)};
        else
            res = new String[]{"", "", ""};

        return res;
    }

    private Result handle(Request req) {
        if (!req.errorOccurred())
            return first.handle(req);
        else
            return null;
    }
}