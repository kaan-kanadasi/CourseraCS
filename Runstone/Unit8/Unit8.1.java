/*
 * 2D array = array of arrays
 * it is possible in Java to have inner arrays of different lengths (ragged arrays)
 * Arrays are objects in Java, so any variable that declares an array holds a reference to an object
 * If the array hasn’t been created yet, every element is 0 for numeric types, null for object references, and false for type boolean
*/

// decleartion = types of 2D array + [][] + name
int[][] ticketInfo; 

// creating a 2D array
ticketInfo = new int [2][3];
000
000

/*
 * ticketInfo[0] refers to the first row of the array, ticketInfo[0].length gives you the number 
 * of elements in the first row of the array which corresponds to the columns in 'D array'
*/ 
ticketInfo.length // rows - 2
ticketInfo[0].length // columns - 3

/*
 * would attempt to access the third row of the ticketInfo array. However, in a zero-indexed array, the valid indices for 
 * ticketInfo would be 0 and 1 since it has 2 rows ([0] and [1]). Trying to access ticketInfo[2] would result in an 
 * ArrayIndexOutOfBoundsException because there's no row at index 2 in the ticketInfo array.
*/
ticketInfo[2].length

// initialize the array elements
ticketInfo[0][0] = 15;
ticketInfo[0][1] = 10;
ticketInfo[0][2] = 15;
ticketInfo[1][0] = 25;
ticketInfo[1][1] = 20;
ticketInfo[1][2] = 25;
15 10 15
25 20 25

// sets the value for the 3rd row and 2nd column 
ticketInfo[2][1] = 5;

// initialize (set) the values for the array when you create it
int[][] ticketInfo = { 
    {30,35,40}, 
    {25,20,15} 
};

ticketInfo[1][0]; // returns 25



String[][] asciiArt = {
    {" ", " ", "_", "_", "_", " ", " "},
    {" ", "(", "o", " ", "o", ")", " "},
    {"(", " ", " ", "V", " ", " ", ")"},
    {" ", "-", "m", "-", "m", "-", " "},
};

// change "o" to "@"
for (String[] row : asciiArt) {
    for (int i = 0; i < row.length; i++) {
        if(row[i].equals("o")) {
            row[i] = "@";
        }
    }
}

System.out.println("ASCII Art:");
for (String[] row : asciiArt) {
    for (String column : row) System.out.print(column);
    System.out.println();
}
