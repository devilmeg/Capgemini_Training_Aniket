package Feb4Practice;

class Helper{
	boolean isArrayEqual(int arr1[], int arr2[]) {
		if(arr1.length != arr2.length) return false;
		
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) return false;
		}
		
		return true;
	}	
	
	static void printBoard(int arr[][]) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}

class Logic{
	
}

public class TicTacToe {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		
		Helper.printBoard(arr);
	}

}
