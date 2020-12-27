package question05;

public class StringSquareMatrixDemo {
	static boolean findString(char[][] matrix,String string) {
		char c = string.charAt(0);
		for(int i = 0;i<matrix[0].length;i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(matrix[i][j] == c)
					return searchString(matrix,string,i, 0, j,c);
			}
		}
		
		return true;
	}
	
	private static boolean searchString(char[][] matrix, String string, int i, int j, int k, char c) {
		if(c == string.charAt(string.length()-1)) {
			return true;
		} else if(c == string.charAt(k)) {
			
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] matrix = {
				{'I','G','E','F'},
				{'H','S','A','M'},
				{'A','B','C','D'},
				{'F','O','U','R'}};
		String string = "FOUR";
		findString(matrix, string);
		
	}
}
