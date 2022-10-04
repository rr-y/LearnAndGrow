package personal.ThreadPrinter;

/**
 * Basic thread
 * They will execute the run method concurrently
 */
public class BasicThread extends Thread{

    @Override
    public void run() {
        for(int i=0;i<100;i++)
            System.out.println(i+" "+Thread.currentThread().getId());
    }

    public void print(){
        for(int i=0;i<100;i++)
            System.out.println(i);
    }


    public static void main(String[] args) {
        BasicThread basicThread = new BasicThread();
        BasicThread basicThread1 = new BasicThread();
        basicThread1.print();
        basicThread.print();
        basicThread.start();
        basicThread1.start();
    }
}
