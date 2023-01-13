public class Two_DArrays {
    public static void main(String[] args) {
      // test transpose
    System.out.println("--- Test transpose ---");
    double[][] y = new double[][]{{10, 20, 30}, {40, 50, 60}};
    System.out.println(matrixToString(y, 2, 3));
    double[][] yt = transpose(y, 2, 3);
    System.out.println("");
    System.out.println(matrixToString(yt, 3, 2));
    System.out.println("");
  
      // test isTriangular
    System.out.println("--- Test isTriangular ---");
    double[][] z1 = new double[][]{ {1, 0, 0, 1},
                                    {1, 1, 0, 0},
                                    {1, 1, 1, 0},
                                    {1, 1, 1, 1}};

    System.out.println(matrixToString(z1, 4, 4));
    System.out.println("Is lower triangular: " + isLowerTriangular(z1, 4));
    System.out.println("Is upper triangular: " + isUpperTriangular(z1, 3));
    System.out.println("Is triangular: " + isTriangular(z1, 3));
        //System.out.println("Is upper triangular: " + isUpperTriangular(z1, 3));
        //System.out.println("Is triangular: " + isTriangular(z1, 3));
  
    double[][] z2 = new double[][]{{1, 0, 0}, //our original z2****
                                   {1, 1, 0},
                                   {1, 1, 1}};
    System.out.println("");
    System.out.println(matrixToString(z2, 3, 3));
    System.out.println("Is lower triangular: " + isLowerTriangular(z2, 3));//our modified z2 is printed in terminal******
    
    System.out.println("Is upper triangular: " + isUpperTriangular(z2, 3));
    System.out.println("Is triangular: " + isTriangular(z2, 3));
  
        double[][] z3 = new double[][]{{1, 0, 0},
                                       {0, 1, 3},
                                       {0, 0, 1}};
  //    
    System.out.println("");
    System.out.println(matrixToString(z3, 3, 3));
    System.out.println("Is lower triangular: " + isLowerTriangular(z3, 3));
    System.out.println("Is upper triangular: " + isUpperTriangular(z3, 3));
    System.out.println("Is triangular: " + isTriangular(z3, 3));
  
      // test splitStrings
      System.out.println("");
        System.out.println("--- Test splitStrings ---");
        String[][] q = splitStrings(new String[]{"apple", "book", "car"});
        System.out.println(array2DToString(q));
    }
  
    /**
     * Returns a string representation of a 2D array of doubles in the format:
     * [
     *  [x[0][0], x[0][1], x[0][m-1]]
     *  [x[1][0], x[1][1], x[1][m-1]]
     *  [...        ...        ...      ]
     *  [x[n-1][0], x[n-1][1], x[n-1][m-1]]
     * ]
     * @param x a matrix (2D array) of doubles
     * @param n number of rows of x[][]
     * @param m number of columns of x[][]
     * @return a String representation of x[][]
     */
    public static String matrixToString(double[][] x, int n, int m) {
      if (x == null) {//if array is empty
        return null;
      }
      String result = "[\n";
      for (int row = 0; row < n; row++) {
        result += " [";
        for (int col = 0; col < m - 1; col++) {
          result += x[row][col] + ", ";
        }
        result += x[row][m - 1] + "]\n";
      }
      result += "]";
      return result;
    }
  
     /**
     * Returns a string representation of a 2D array of strings in the format:
     * [
     *  [x[0][0], x[0][1], ...]
     *  [x[1][0], x[1][1], ...]
     *  [...]
     *  [x[n-1][0], x[n-1][1], ...]
     * ]
     *
     * @param x a 2D array of strings
     * @param n number of rows of x[][]
     * @param m number of columns of x[][]
     * @return a String representation of x[][]
     */
    public static String array2DToString(String[][] x) {
      if (x == null) {
        return null;
      }
      String result = "[\n";
      for (int row = 0; row < x.length; row++) {
        result += " [";
        for (int col = 0; col < x[row].length - 1; col++) {
          result += x[row][col] + ", ";
        }
        result += x[row][x[row].length - 1] + "]\n";
      }
      result += "]";
      return result;
    }
  
    /**
     * Returns a new matrix that contains the transpose of a given
     * matrix with n rows and m columns.
     *
     * @param x a matrix (array of arrays) of doubles
     * @param n number of rows of x[][]
     * @param m number of columns of x[][]
     * @return the transpose of x[][]
     */
    public static double[][] transpose(double[][] x, int n, int m) {
      double[][] transpose = new double[m][n];
      for(int row = 0; row < m; row++){//switch row number to column number
          for(int col = 0; col < n; col++){ //column number is no up to number of rows
              transpose[row][col] = x[col][row];//invert x rows/col and place it transpose array
          }
      }
         return transpose;
      
   }
  
    /**
     * Checks whether a given square matrix is lower triangular.
     * A lower triangular matrix is a special kind of square matrix
     * where all the entries above the main diagonal are zero.
     * https://en.wikipedia.org/wiki/Triangular_matrix
     *
     * @param x a matrix of doubles
     * @param n number of rows and columns of x[][]
     * @return true if x[][] is lower triangular, false otherwise
     */
    public static boolean isLowerTriangular(double[][] x, int n) {
      boolean result = true;
      for(int row = 0; row < n; row++){ //parsing through matrices rows, starting w/ the first row
          for(int col = row + 1  ; col < n ; col++){ //start w/ second column, first column's first entry contains non zero from Main diagonal
              if(x[row][col] != 0){ //if the second entry up to the last entry in the first row...
                                    //... or the third entry up to the last entry in the second row, etc, are equal != 0, we know its not lower triangular
                 result = false;
              }
          }
      }
      return result;
    }
  
    
  
    /**
    * Checks whether a given square matrix is upper triangular.
    * An upper triangular matrix is a special kind of square matrix
    * where all the entries below the main diagonal are zero.
    * https://en.wikipedia.org/wiki/Triangular_matrix
    *
    * @param x a matrix of doubles
    * @param n number of rows and columns of x[][]
    * @return true if x[][] is upper triangular, false otherwise
     */
  
    public static boolean isUpperTriangular(double[][] x, int n) {
    boolean upper = true;
    for(int row = 1; row < n ; row++){//start at 2nd row (first one has first entry that is part of main diagonal), parse to end after
      for(int col = 0; col < row; col++){//parse right from first col up to the col = row, where row is the int...
                                         //... tailored to correctly update depending on whch row we are parsing through in the outer loop
          if(x[row][col] != 0){//if any of these entries below the Main diagonal is zero, its not upper triangulars
              upper = false;
          }
      }
    }
      return upper; 
   }
  
    /**
     * Checks whether a given square matrix is triangular.
     * A triangular matrix is a special kind of square matrix where
     * either all the entries below or all the entries above
     * the main diagonal are zero.
     * https://en.wikipedia.org/wiki/Triangular_matrix
     *
     * @param x a matrix of doubles
     * @param n number of rows and columns of x[][]
     * @return true if x[][] is triangular, false otherwise
     */
  
    public static boolean isTriangular(double[][] x, int n) {
    boolean triangular = false;
    if(isLowerTriangular(x, n) == true || isUpperTriangular(x, n) == true){
      triangular = true;
    }
    if(isLowerTriangular(x, n) == false || isUpperTriangular(x, n) == false){
      triangular = false;
    }
      return triangular;
  }
  
    /**
     * Given an array of strings, creates a 2D array of strings
     * where each row contains an array whose elements are the
     * individual characters of the corresponding input string.
     * For example, given the array {"apple", "book", "car"}
     * the method would return the 2D array:
     * {{"a", "p", "p", "l", "e"},
     *  {"b", "o", "o", "k"},
     *  {"c", "a", "r"}}
     *
     * @param s an array of strings
     * @return a 2D array of strings containing all the individual
     *         characters from the input strings (see example above)
     */
    public static String[][] splitStrings(String[] s) {
    String[][] word = new String[s.length][]; //IC, has as many rows as String[] s has columns (or elements/words/Strings)
     for(int row = 0; row < s.length; row++){//starts w row 0, and adds a row for each String in 'String[] s'
       word[row] = new String[s[row].length()]; //we set the columns of each specific row to be equal to the number of chars in that String s[column] 
        for(int col = 0; col < word[row].length ; col++){//this for loop simple creates each row (each w varying column quantity)
            word[row][col] = s[row].charAt(col) + " ";
        }
      }
      return word;
     }
  }
