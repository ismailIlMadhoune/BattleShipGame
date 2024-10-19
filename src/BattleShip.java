public class BattleShip {

	public static void main(String[] args)
	{
		//1.1
		/*char c = '*';
		if(ValidBoardSquare(c) == true) {
			System.out.println("V");
		}
		*/
		char[][] grid = {
		        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
		        {'.', '*', '*', '.', '.', '.', '.', '.', '.', '.'},
		        {'.', '.', '.', '.', '.', '*', '*', '*', '.', '.'},
		        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
		        {'.', '.', '*', '*', '*', '*', '.', '.', '.', '.'},
		        {'*', '*', '.', '.', '.', '.', '.', '.', '.', '.'},
		        {'.', '.', '.', '.', '.', '*', '*', '.', '.', '.'},
		        {'*', '*', 'S', 'S', 'S', '.', '*', '*', '*', '.'},
		        {'.', '.', '.', '.', '.', '*', '*', '.', '.', '.'},
		        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
		    };
        System.out.println("Mixed Adjacent Characters count: " + numberSunk(grid));
        System.out.println("UNDAMAGED DESTROYER: " + countShips(grid, "Destroyer", "undamaged"));
        System.out.println("DAMAGED DESTROYER: " + countShips(grid, "Destroyer", "damaged"));
        System.out.println("SUNK DESTROYER: " + countShips(grid, "Destroyer", "sunk"));
        System.out.println("ALL DESTROYERS: " + countShips(grid, "Destroyer", "all"));
			//System.out.println(isHit(1, 'C', testBoardForHit)); // 1 (Hit)
		//	System.out.println(isHit(1, 'A', testBoardForHit)); // 0 (Miss)
			//System.out.println(isHit(2, 'C', testBoardForHit)); // 2 (Repeated hit)
			//System.out.println(isHit(11, 'A', testBoardForHit)); // -1 (Invalid row)
			//System.out.println(isHit(1, 'Z', testBoardForHit)); // -2 (Invalid column)
		 
	        // Sample board setup
	        char[][] board = {
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', 'S', 'S', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '*', '*', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', 'S', 'S', 'S', 'S', 'S', '.'},
	            {'.', '*', '*', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', 'S', 'S', 'S', '.', '.', 'S', '*'},
	            {'.', '.', '.', 'S', 'S', 'S', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
	        };

	        // Test cases
	    //    System.out.println(countShips(board, "Destroyer", "damaged")); // Expected: 1
	       // System.out.println(countShips(board, "Battleship", "damaged")); // Expected: 0
	      //  System.out.println(countShips(board, "Cruiser", "sunk")); // Expected: 0
	        //System.out.println(countShips(board, "Destroyer", "all")); // Expected: 2

	        // Invalid ship type tests
	     //   System.out.println(countShips(board, "Submarine", "all")); // Expected: -1

	        // Invalid damage type tests
	     //   System.out.println(countShips(board, "Carrier", "partially sunk")); // Expected: -1

	        // No ships on the board
	        char[][] emptyBoard = {
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
	            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
	        };
	        System.out.println("numberSunk: " + numberSunk(emptyBoard));
	    //    System.out.println(countShips(emptyBoard, "Carrier", "all")); // Expected: 0
	}
	//1.1
	public static boolean ValidBoardSquare(char c)
	{
		if (c == '.' || c == 'S' || c == '*')return true;
		return false;
	}
	//1.2
	public static int ValidBoard(char[][] board)
	{
		  if (board == null) return -1; // Board is null
	        if (board.length != 10) return -2; // Wrong size

	        for (char[] row : board) 
	        {
	            if (row.length != 10) return -2; // Wrong size
	            for (char c : row) 
	            {
	                if (!ValidBoardSquare(c)) return -3; // Invalid square
	            }
	        }
	        return 1; // Board is valid
	}
	//1.3
    public static int numberSunk(char[][] grid) 
    {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] shipSizes = {2, 3, 4, 5}; // Sizes of Destroyer, Cruiser, Battleship, Carrier

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    for (int size : shipSizes) {
                        if (j + size <= cols) {
                            boolean isSunk = true;
                            for (int k = 0; k < size; k++) {
                                if (grid[i][j + k] != '*') {
                                    isSunk = false;
                                    break;
                                }
                            }
                            if (isSunk && (j + size == cols || grid[i][j + size] == '.') && (j == 0 || grid[i][j - 1] == '.')) {
                                count++;
                                j += size - 1; // Skip to the end of this ship
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

	public static int isHit(int row, int col, char[][] board)
	{
        if (row < 1 || row > 10) return -1; // Invalid row
        if (col < 'A' || col > 'J') return -2; // Invalid column

        int rowIndex = row - 1;
        int columnIndex = col - 'A';

        if (board[rowIndex][columnIndex] == 'S') 
        {
            board[rowIndex][columnIndex] = '*';
            return 1; // Hit
        } else if (board[rowIndex][columnIndex] == '.') 
        {
            return 0; // Miss
        } else if (board[rowIndex][columnIndex] == '*') 
        {
            return -3; // Repeated hit
        }
        return -4; // Undefined error
	}
    public static int countShips(char[][] board, String shipType, String damageType) 
    {
        int count = 0;
        int shipSize = getShipSize(shipType);
        if (shipSize == -1 || !isValidDamageType(damageType)) return -1; // Invalid ship type or damage type

        switch (damageType) {
            case "sunk":
                count = sunkShips(board, shipType);
                break;
            case "damaged":
                count = damagedShips(board, shipType);
                break;
            case "undamaged":
                count = undamagedShips(board, shipType);
                break;
            case "all":
                count = undamagedShips(board, shipType) + damagedShips(board, shipType) + sunkShips(board, shipType);
                break;
        }
        return count;
    }

    private static int getShipSize(String shipType) {
        switch (shipType) {
            case "Carrier": return 5;
            case "Battleship": return 4;
            case "Cruiser": return 3;
            case "Destroyer": return 2;
            default: return -1; // Invalid ship type
        }
    }

    private static boolean isValidDamageType(String damageType) {
        return "undamaged".equals(damageType) || "damaged".equals(damageType) || "sunk".equals(damageType)|| "all".equals(damageType);
    }

    public static int damagedShips(char[][] grid, String shipType) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int size = getShipSize(shipType);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'S' || grid[i][j] == '*') {
                    if (j + size <= cols) {
                        boolean hasS = false;
                        boolean hasStar = false;
                        int length = 0;
                        for (int k = 0; k < size; k++) {
                            if (grid[i][j + k] == 'S') hasS = true;
                            else if (grid[i][j + k] == '*') hasStar = true;
                            else {
                                hasS = false;
                                hasStar = false;
                                break;
                            }
                            length++;
                        }
                        if (length == size && hasS && hasStar && (j + size == cols || grid[i][j + size] == '.') && (j == 0 || grid[i][j - 1] == '.')) {
                            count++;
                            j += size - 1; // Skip to the end of this ship
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int sunkShips(char[][] grid, String shipType) 
    {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int size = getShipSize(shipType);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    if (j + size <= cols) {
                        boolean isSunk = true;
                        for (int k = 0; k < size; k++) {
                            if (grid[i][j + k] != '*') {
                                isSunk = false;
                                break;
                            }
                        }
                        if (isSunk && (j + size == cols || grid[i][j + size] == '.') && (j == 0 || grid[i][j - 1] == '.')) {
                            count++;
                            j += size - 1; // Skip to the end of this ship
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int undamagedShips(char[][] grid, String shipType) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int size = getShipSize(shipType);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'S') {
                    if (j + size <= cols) {
                        boolean isUndamaged = true;
                        for (int k = 0; k < size; k++) {
                            if (grid[i][j + k] != 'S') {
                                isUndamaged = false;
                                break;
                            }
                        }
                        if (isUndamaged && (j + size == cols || grid[i][j + size] == '.') && (j == 0 || grid[i][j - 1] == '.')) {
                            count++;
                            j += size - 1; // Skip to the end of this ship
                        }
                    }
                }
            }
        }
        return count;
    }
}