package Interface;

public class ABC {
    public static void main(String[] args) {


//        @Override
//                public void m1(){
//            System.out.println("Not worked");
//        }
        add obj = new add() {
            @Override
            public void m1(){
                System.out.println("m1");
            }
        };
        obj.m1();
    }
}
