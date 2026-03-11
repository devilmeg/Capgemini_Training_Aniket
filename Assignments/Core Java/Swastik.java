import java.util.Scanner;

public class Swastik {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int mid = n/2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if ((i == 0 && (j <= mid || j == n-1))

                || ((j == mid || j == n-1) && i <= mid)
                        || (i == mid)

                        || ((j == 0 || j == mid) && i >= mid)

                        || (i == n - 1 && j >= mid))
                {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
