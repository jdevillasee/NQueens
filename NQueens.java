//THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS. JANAY DEVILLASEE

import java.util.Stack;

public class NQueens {
 
  //***** fill in your code here *****
 
	  static int solutions=0;
	  static int row=0;
	  static int current_position=0;
	  
  //finds and prints out all solutions to the n-queens problem
	public static int solve(int n) {
		Stack<Integer> stack = new Stack<Integer>();

	  while (row < n ) {
		  
		  //loop from current position to last position until valid position is found
		  for (; current_position<n;current_position++) {
			  
			 if (isValid(stack, current_position)) {					//check if current position is valid
				 stack.push(current_position);							//push position to stack
				 current_position=0;
				 row++;													//move to next row
				break;
			 } 
		  }
		  
		  
		if (current_position==n)	{								// there is no valid position
			if (stack.isEmpty()) {									//stack is empty
				break;
			 }
			else {
				 row--;
				 current_position=stack.pop()+1;
			 }
			 	
		 } 
				
			 //If stack is full, print result, add to solutions, and look for next solution
			 if (stack.size()==n){
				 printSolution(stack);
				 System.out.println("===========================");
				 solutions++;
				 current_position=stack.pop()+1;
				 row = row - 1;
			 }
	  } 
	  
	  //return solutions found
	  return solutions; 
		}

  
  /** Return true if a queen can be placed at (row, column) */
  public static boolean isValid(Stack<Integer> stack, int column) {
	  int diagRight = column + 1;
	  int diagLeft = column - 1;
	  for (int i = stack.size() - 1; i >= 0; i--)
	  {
		  if (stack.get(i) == column || stack.get(i) ==  diagLeft || stack.get(i) ==  diagRight ) // checks diagonals and column
			  return false; // There is a conflict
		  else {
			  diagRight++;
			  diagLeft--;
		  }
	  }
	  return true;
  }
				  		
  
  
 
	  
  //this method prints out a solution from the current stack
  //(you should not need to modify this method)
  private static void printSolution(Stack<Integer> s) {
    for (int i = 0; i < s.size(); i ++) {
      for (int j = 0; j < s.size(); j ++) {
        if (j == s.get(i))
          System.out.print("Q ");
        else
          System.out.print("* ");
      }//for
      System.out.println();
    }//for
    System.out.println();  
  }//printSolution()
  
  // ----- the main method -----
  // (you shouldn't need to change this method)
  public static void main(String[] args) {
  
  int n = 8;
  
  // pass in parameter n from command line
  if (args.length == 1) {
    n = Integer.parseInt(args[0].trim());
    if (n < 1) {
      System.out.println("Incorrect parameter");
      System.exit(-1);
    }//if   
  }//if
  
  int number = solve(n);
  System.out.println("There are " + number + " solutions to the " + n + "-queens problem.");
 }//main()
  
}