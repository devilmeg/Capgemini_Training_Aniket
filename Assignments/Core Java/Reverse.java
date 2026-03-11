import java.util.Arrays;
import java.util.Scanner;

public class Reverse {

    public static int[] reverseArray(int[] arr){
        int len = arr.length;
        int i=0 ;
        int j= len-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] arr = new int[length];
        for(int i=0 ; i< length ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(reverseArray(arr)));

    }
}
