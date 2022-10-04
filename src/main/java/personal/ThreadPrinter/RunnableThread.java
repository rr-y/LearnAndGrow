package personal.ThreadPrinter;

public class RunnableThread implements Runnable{
    private final State state;
    private final Integer step;
    private final Integer maxValue;
    private final State nextState;
    private Integer currentVal;
    private final State currentState;


    public RunnableThread(State state, Integer step, Integer maxValue, State nextState, Integer currentVal, State currentState) {
        this.state = state;
        this.step = step;
        this.maxValue = maxValue;
        this.nextState = nextState;
        this.currentState = currentState;
        this.currentVal = currentVal;
    }

    @Override
    public void  run() {
        while (currentVal < maxValue){
            synchronized (currentState){
                while(!currentState.getType().equals(this.state.getType())) {
                    try {
                        currentState.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(state.getType() + " " + currentVal + " Thread " + Thread.currentThread().getName());
                currentVal += step;
                currentState.setType(nextState.getType());
                currentState.notify();

            }

        }
    }


    public static void main(String[] args) {
        State currentState = new State(CalType.ODD);
        RunnableThread runnableThread = new RunnableThread(new State(CalType.EVEN), 2, 100, new State(CalType.ODD), 2, currentState);
        RunnableThread runnableThread1 = new RunnableThread(new State(CalType.ODD), 2, 100, new State(CalType.EVEN), 1, currentState);

        Thread th1 = new Thread(runnableThread);
        Thread th2 = new Thread(runnableThread1);

        th1.start();
        th2.start();
    }
}

