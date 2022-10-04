package intv;

class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}

class MyClass{
    void myFun() throws MyException{
        System.out.println("Throwing exceptions");
        throw new MyException("Throwing my exception");
    }
}



public class ExceptionChecking {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        try{
            int a = 0;
            int b = 1;
            int c = b/a;
            myClass.myFun();
        }catch (Exception e){
            System.out.println("Throwing from my exception: "+e.getMessage());
        }catch (Throwable throwable){
            System.out.println("Throwing from throwable: "+throwable.getMessage());
        }
    }
}
