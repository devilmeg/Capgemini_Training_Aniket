package Threadss;

class  ThreadsDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("heloooo");
    }
}
public class RunnableDemo {


    public static void main(String[] args) {
    ThreadsDemo t=new ThreadsDemo();
        System.out.println("Task the started");
        Thread t1=new Thread(t);
        t1.start();
        try{
            t1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Task the finished");
    }


}
