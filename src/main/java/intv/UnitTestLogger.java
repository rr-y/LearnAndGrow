package intv;

public class UnitTestLogger implements Logger{
    private String memory;

    public void setMemory(String memory) {
        this.memory = memory;
    }

    //

    @Override
    public void print(String str) {
        memory = str;
        System.out.println(str);
    }
}

