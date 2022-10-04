package personal.ThreadPrinter;

public class State {
    private  CalType type;
    public State(CalType calType) {
        this.type = calType;
    }

    public CalType getType() {
        return type;
    }

    public void setType(CalType type) {
        this.type = type;
    }
}
