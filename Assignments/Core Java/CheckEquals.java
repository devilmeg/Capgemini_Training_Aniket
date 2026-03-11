import java.util.Scanner;

public class CheckEquals {

    public static boolean isEqual(int[] ar1 , int[] ar2){
        int l1 = ar1.length;
        int l2 = ar2.length;
        if(l1 != l2){
            return false;
        }
        for(int i=0 ; i< l1 ; i++){
            if(ar1[i] != ar2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int length1 = sc.nextInt();
        int length2 = sc.nextInt();

        int[] ar1 = new int[length1];
        int[] ar2 = new int[length2];
        for(int i=0 ; i < length1 ; i++){
            ar1[i] = sc.nextInt();
            ar2[i] = sc.nextInt();

        }

        System.out.println(isEqual(ar1 , ar2));





    }
}
