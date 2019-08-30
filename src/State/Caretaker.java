package State;

public class Caretaker {
    private Memento m = new Memento();

    public void setState(String in, String out) {
        m.setInput(in);
        m.setOutput(out);
    }

    public Memento getState() {
        return m;
    }
}