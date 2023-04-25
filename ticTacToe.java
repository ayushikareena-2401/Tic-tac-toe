//import necssary packages.
import java.io.*;
import java.util.*;
class ticTacToe {
   int row,column;
   public char[][] create() {
    //Create a 3*3 2D matrix.
     char[][] matrix= new char[3][3];
    //Initialise all the matrix of the grid as "-".
    for(int i=0;i<3;i++) {
      for(int j=0;j<3;j++){
         matrix[i][j]='-';
      }
     }
      return matrix;
   }
   public void print(char[][] array) {
      //Now print the grid(matrix).
       for(int i=0;i<3;i++) {
         for(int j=0;j<3;j++){
         System.out.print(array[i][j]);
      }
       System.out.print("\n");
     }
   }
  public void takeInput(char[][] matrix,int x) {
    //while taking input take care that the row and column entered should not be out of range that is it should be less than 3.
    Scanner s= new Scanner(System.in);
    while(true){
      System.out.print("Enter the row:");
      row=s.nextInt();
      System.out.print("Enter the column:");
      column=s.nextInt();
      if(row<=2 && row>=0 && column<=2 && column>=0) {
        if(matrix[row][column]=='-') {
         break;
        } else {
        System.out.println("Already filled!!..");
       }
       } else {
       System.out.println("Enter the correct value!!..");
       }
     }
     if(x==0) {
     matrix[row][column]='o'; 
    } else {
      matrix[row][column]='x';
     }
    print(matrix);
   }
   public boolean isFull(char[][] array) {
        for(int i=0;i<3;i++) {
         for(int j=0;j<3;j++){
           if(array[i][j]=='-') {
             return false;
          }
      }
     }
      return true;
   }
   public boolean result(char[][] mat,int row,int column) {
 //For checking if a person won or not?we need to check after every valid entry that if in the entire row or column or diagonally if the elements are same then that person won.Check all   the elements are same but it should not be empty.
   int flag=0;
     if(mat[row][0]==mat[row][1] && mat[row][1]==mat[row][2] && mat[row][0]!='-'){
       //if the elements across the row is same.
       //display winner.
        if(mat[row][0]=='o') {
          System.out.println("Player1 won!!...");
         } else if(mat[row][0]=='x') {
          System.out.println("Player2 won!!...");
         } 
         flag=1;
     } else  if(mat[0][column]==mat[1][column] && mat[1][column]==mat[2][column] && mat[0][column]!='-'){
       //if the elements across the column is same.
        //display winner.
        if(mat[0][column]=='o') {
          System.out.println("Player1 won!!...");
         } else if(mat[0][column]=='x') {
          System.out.println("Player2 won!!...");
         } 
         flag=1;
     } else if((mat[0][0]==mat[1][1] && mat[1][1]==mat[2][2] && mat[0][0]!='-') || (mat[0][2]==mat[1][1] && mat[1][1]==mat[2][0] && mat[0][2]!='-') ){
        //if the elements across the diagonal is same.
        //display winner.
        if(mat[1][1]=='o') {
          System.out.println("Player1 won!!...");
         } else if(mat[1][1]=='x') {
          System.out.println("Player2 won!!...");
         } 
         flag=1;
     } else if(isFull(mat)){
       System.out.println("It's a tie!!..");
       //if the matrix is full.
       flag=1;
     }
     if(flag==1) {
      return false;
     }
     return true;
   }
   public void method(String a,String b) {
     //create the matrix & print the matrix created.
     char[][] m= new char[3][3];
     m=create();
     print(m);
     boolean p1=true,p2=false;
      //Now inside loop once take input from both the players and update the table after every entry and display the table.
      do {
        if(p1==true) {
          System.out.println(a+"'s turn:");
          p1=false;
          p2=true;
          takeInput(m,0);
         } else if(p2==true){
          System.out.println(b+"'s turn:");
          p2=false;
          p1=true;
          takeInput(m,1);
         }
      }while(result(m,row,column));
     }
     
   public static void main(String a[]) {
      //Display a welcome message.
      System.out.println("Welcome to Tic Tac Toe!\n");
      //Take input the name of both the players.
      Scanner sc= new Scanner(System.in);
      String Player1,Player2;
      System.out.println("Player 1,Enter your name..");
      Player1=sc.nextLine();
      System.out.println("Player 2,Enter your name..");
      Player2=sc.nextLine();
      ticTacToe ob = new ticTacToe();
      ob.method(Player1,Player2); 
   }
}