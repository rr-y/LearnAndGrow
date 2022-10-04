package intv;

public class ConsoleLogger implements Logger{

    private final String  expected = "Rahul's interview";
    @Override
    public void print(String str) {

        // check the str
        try{
//            validateLog(str);
            System.out.println(str);

        }catch (Exception e){

        }
    }
}
