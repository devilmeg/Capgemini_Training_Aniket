package Threadss;

public class ThreadDemo extends Thread {
    public void run(){
        try{
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            System.out.println(i);

        }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
    public void main(String[] args){
    ThreadDemo t=new ThreadDemo();
    t.setName("Aniket");
    t.start();

        try{
            t.join();
        } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
        System.out.println("hello");
    }
}
