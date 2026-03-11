import java.util.*;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m=n;
        int reverse = 0;
        int dig =0;

        while(n > 0){
            dig = n%10;
            reverse = reverse*10 + dig;
            n = n/10;
        }
        if(reverse == m){
            System.out.println("is Palindrome");
        }
        else{
            System.out.println("is not palindrome");
        }
    }
}
