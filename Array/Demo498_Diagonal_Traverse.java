import java.util.Arrays;

class Demo498_Diagonal_Traverse {
	public static void main(String[] args) {
		int[][] matrix = {{1, 2}, {3, 4}};
		for(int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		System.out.println(Arrays.toString(new Solution_498().findDiagonalOrder(matrix)));
	}
}

class Solution_498 {
	public int[] findDiagonalOrder(int[][] matrix) {
     	int row = matrix.length;
     	if (row == 0)
     		return null;
     	int col = matrix[0].length;

     	System.out.println("row: " + row);
     	System.out.println("col: " + col);

     	int i = 0, j = 0, index = 0;
     	boolean direc = true;

     	int[] res = new int[row * col];
     	System.out.println(res.length);

     	while(true) {

     		if(index == res.length)
     			break;
     		res[index] = matrix[i][j];

     		System.out.print("row ind: " + i);
     		System.out.println(", col ind: " + j);
     		System.out.println(direc);
     		System.out.println(res[index]);

     		
     		if(j == 0 || i == row - 1) {
     			direc = true;
     		}
     		if(i == 0 || j == col - 1) {
     			direc = false;
     		}

     		if(direc) {
     			if(i == 0) {
     				j++;
     			}else if(j == col - 1) {
     				i++;
     			}else {
     				i--;
     				j++;
     			}
     		}else {
     			if(j == 0) {
     				i++;
     			}else if(i == row - 1) {
     				j++;
     			}else {
     				j--;
     				i++;
     			}
     		}

     		
     		index++;
     	}

     	return res;
    }
}
