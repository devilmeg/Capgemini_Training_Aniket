import java.util.*;
public class Assess {
    public static int longestSubarray(int[] arr , int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        int k = sc.nextInt();

        for(int i=0 ; i< length ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(longestSubarray(arr , k));

    }
}
