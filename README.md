# BattleShip Game

## Introduction
The BattleShip game simulates a classic naval combat game, where the player tries to locate and destroy ships on a 10x10 board. This program contains various methods that validate the board, count ships based on their type and damage status, and check if a particular location is a hit or miss.

## Key Features

1. **Board Validation**: Checks if the board is valid based on size and allowed characters.
2. **Ship Status**: Methods to count ships based on their type and damage status (sunk, damaged, undamaged, all).
3. **Ship Hit Detection**: Check if a certain location is a hit or miss, and return appropriate values based on that.
4. **Ship Counting**: Counts ships of a specified type (e.g., "Destroyer", "Battleship") based on damage types (e.g., "damaged", "sunk", "undamaged", "all").

## Functions

### 1. `ValidBoardSquare(char c)`
- **Purpose**: Checks if a given square on the board is valid.
- **Parameters**: A character (`c`), which can be one of the following: `.`, `S`, or `*`.
- **Returns**: `true` if the square is valid, otherwise `false`.

### 2. `ValidBoard(char[][] board)`
- **Purpose**: Validates the entire board to ensure correct size (10x10) and valid square characters.
- **Parameters**: A 2D char array representing the board.
- **Returns**: 
  - `1` if the board is valid.
  - `-1` if the board is `null`.
  - `-2` if the board size is not 10x10.
  - `-3` if the board contains invalid characters.

### 3. `numberSunk(char[][] grid)`
- **Purpose**: Counts the number of ships that are completely sunk (represented by `*`).
- **Parameters**: A 2D char array representing the board.
- **Returns**: The count of sunk ships.

### 4. `isHit(int row, int col, char[][] board)`
- **Purpose**: Checks if a given location is a hit, miss, or repeated hit.
- **Parameters**: 
  - `row` (integer): The row number (1-10).
  - `col` (char): The column (A-J).
  - `board` (2D char array): The current game board.
- **Returns**: 
  - `1` if it is a hit (`S`).
  - `0` if it is a miss (`.`).
  - `-3` if it is a repeated hit (`*`).
  - `-1` if the row is invalid.
  - `-2` if the column is invalid.

### 5. `countShips(char[][] board, String shipType, String damageType)`
- **Purpose**: Counts the number of ships of a certain type and their damage status.
- **Parameters**:
  - `board`: A 2D char array representing the board.
  - `shipType`: The type of ship (e.g., "Carrier", "Battleship", "Cruiser", "Destroyer").
  - `damageType`: The damage status ("sunk", "damaged", "undamaged", "all").
- **Returns**: The count of ships that match the criteria.

### 6. `damagedShips(char[][] grid, String shipType)`
- **Purpose**: Counts the number of ships that are partially damaged (some squares are `S`, others are `*`).
- **Parameters**: 
  - `grid`: The game board.
  - `shipType`: The ship type.
- **Returns**: The count of damaged ships.

### 7. `sunkShips(char[][] grid, String shipType)`
- **Purpose**: Counts the number of ships that are completely sunk (all squares are `*`).
- **Parameters**: 
  - `grid`: The game board.
  - `shipType`: The ship type.
- **Returns**: The count of sunk ships.

### 8. `undamagedShips(char[][] grid, String shipType)`
- **Purpose**: Counts the number of ships that are undamaged (all squares are `S`).
- **Parameters**:
  - `grid`: The game board.
  - `shipType`: The ship type.
- **Returns**: The count of undamaged ships.

## Example Usage

```java
public static void main(String[] args) {
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
}
Notes
The game board is represented by a 10x10 2D character array, where each cell can contain:
. for an empty water space.
S for a part of a ship.
* for a hit on a ship.
The ships can be of various sizes: Destroyer (2), Cruiser (3), Battleship (4), Carrier (5).
The game logic supports different damage states: "undamaged", "damaged", "sunk", and "all".
Conclusion
This Java implementation of the BattleShip game provides the essential game mechanics such as hit detection, ship status counting, and board validation. You can easily modify or extend the logic for more complex game scenarios.

vbnet
Copy
Edit

This markdown README includes descriptions of the key methods, usage examples, and additional notes to understand the functionality of the `BattleShip` class. Feel free to copy it for use in your repository.






