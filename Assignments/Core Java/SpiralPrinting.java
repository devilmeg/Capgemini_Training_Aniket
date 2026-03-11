import java.util.Scanner;

public class SpiralPrinting {
    public static void printSpiral(int[][] matrix){
        int top = 0;
        int bottom = matrix.length -1 ;
        int left = 0;
        int right = matrix[0].length -1;

        while(left <= right && top <= bottom){
            for(int i=top ; i<=right ; i++){
                System.out.print(matrix[top][i]+" ");
            }
            top++;

            for(int i =top ; i <= bottom ; i++){
                System.out.print(matrix[i][right]+" ");
            }
            right--;

            if(top<=bottom)
            for(int i=right ; i >= left ; i--){
                System.out.print(matrix[bottom][i]+" ");
            }
            bottom -- ;

            if(left<=right)
            for(int i= bottom ; i >= top ; i--){
                System.out.print(matrix[i][left]+" ");
            }
            left++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
        int[][] matrix = {{1,2,3,4},{10,11,12,5},{9,8,7,6}};
//        for(int i=0 ; i< m ; i++){
//            for(int j=0 ; j<n ; j++){
//                matrix[i][j] = sc.nextInt();
//            }
//        }

        printSpiral(matrix);


    }
}
