import java.util.Arrays;
import java.util.Scanner;

public class CountPairs {
    public static int countPairs(int[] arr , int target){
        int count =0;
        boolean[] isUsed = new boolean[arr.length];
        Arrays.fill(isUsed , false);
        for(int i = 0 ; i<arr.length ; i++){
            if(isUsed[i]){
                continue;
            }
            for(int j =i+1 ; j <arr.length ; j++){
                if(isUsed[j]){
                    continue;
                }
                if(arr[i] + arr[j] == target){
                    isUsed[i] = true;
                    isUsed[j] = true;
                    count++;
                }
            }


        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        int target = sc.nextInt();
        for(int i=0 ; i< length ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(countPairs(arr , target));
    }
}
