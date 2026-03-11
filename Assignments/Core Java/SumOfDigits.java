import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dig = 0;
        int sum = 0;
        while(n>0){
            dig = n%10;
            sum += dig;
            n = n/10;
        }
        System.out.println(sum);
    }
}
