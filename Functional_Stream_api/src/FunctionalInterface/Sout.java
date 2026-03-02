package FunctionalInterface;

public class Sout {
    static class A{
        public void say(String s){
            System.out.println("string args");

        }
        public void say(int arr[]){
            System.out.println("Array argument method");
        }
        public void say(Object s){
            System.out.println("string object");
        }
    }
    public static void main(String[] args) {
        A a=new A();
//        a.say(null);
    }
}
