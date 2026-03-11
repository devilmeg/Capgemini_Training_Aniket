import java.util.Scanner;

public class VoidDiamond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int left = n/2 ;
        int right = n/2;
        for(int i =0 ; i < n ; i++){
            for(int j =0 ; j < n ; j++){
                if( j <= left || j >= right){
                    System.out.print("* ");
                }
                else {
                    System.out.print(" ");
                }

            }
            if(i < n/2){
                left--;
                right++;
            }
            else{
                left++;
                right--;
            }
            System.out.println("");
        }
    }
}
