import java.util.Scanner;
class Crossword {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

  //The contents array will store the 5 words for the crossword, and the hints array will store the hints  
  String[] contents = new String[5];
  String[] hints = new String[5];

  //Prompting the user to enter a title and theme for their crossword
  System.out.println("Enter a TITLE for your crossword: ");
  String title = sc.nextLine();
  System.out.println("Enter a THEME for your crossword: ");
  String theme = sc.nextLine();
  
  //This loop will prompt a use to enter one word for the crossword, and then its respective hint. The size variable will increase by each word's length.
  int size = 0;
  for (int i = 0; i < 5; i++) {
    System.out.println("Enter a word for your crossword: ");
    String word = sc.nextLine(); 
    contents[i] = word;
    size += (word.length());
    System.out.println("Enter a hint for this word: ");
    String hint = sc.nextLine();
    hints[i] = hint;
  }
  
  //The 2-D char arrays, "grid" and "crossword", will have their sizes determined by the variable size, which is determined in the previous part of the program.
  char grid[][] = new char[size][size];
  char crossword[][] = new char[size][size];
  
  //This prints the first word entered into the first row, or row 0.
  for (int i = 0; i < contents[0].length(); i++){
    grid[0][i] = contents[0].charAt(i);
    crossword[0][i] = '*' ;
    } 
  
  //This integer represents where the first letter of the second word entered exists in the first word.
  int b = contents[0].indexOf(contents[1].charAt(0));

  //This uses the integer directly before to vertically print the second word starting from the common letter from the first word.
  for (int i = 0; i < contents[1].length(); i++){
    grid[i][b] = contents[1].charAt(i);
    crossword[i][b] = '*';
  }

  //Where the first letter of the third word is located in the second word
  int c = contents[1].indexOf(contents[2].charAt(0));

  //Prints the third word horizontally from the vertical second word
  for (int i = b; i < contents[2].length() + b; i++){
    for (int j = 0; j < contents[2].length(); j++){
      grid[c][i] = contents[2].charAt(j);
      crossword[c][i] = '*';
  }
  }
  
  //Where the first letter of the fourth word is located in the third word
  int d = contents[2].indexOf(contents[1].charAt(0));

  //Prints the fourth word vertically from the common letter's location in the third word
  for (int i = c; i < contents[3].length() + c; i++){
    for (int j = 0; j < contents[3].length(); j++){
      grid[i][d] = contents[3].charAt(j);
      crossword[i][d] = '*';
    }
  }

  //Where the first letter of the fifth word is located in the fourth word
  int e = contents[4].indexOf(contents[3].charAt(0));
  

  //Prints the fifth word horizontally from the fourth word
  for (int i = e; i < contents[4].length() + d; i++){
    for (int j = 0; j < contents[4].length(); j++){
      grid[e][i] = contents[4].charAt(j);
      crossword[e][i] = '*';
    }
  }


//This part prints out the crossword. It uses the crosword grid, which will contain stars, to display what the crossword would look like. It also prints out the hints along with the words
System.out.println("This is the title of your crossword: " + title);
System.out.println("This is the theme of your crossword: " + theme);
System.out.print("These are the words and their respective hints for your crossword: ");
for (int k = 0; k < contents.length; k++){
  System.out.println(contents[k] + "" + "-" + hints[k]);
}
System.out.println("This is the format for your crossword. The letters are represented as stars. Enjoy!:");
for (int i = 0; i < grid.length; i++){
  for (int j = 0; j < grid[0].length; j++){
    System.out.print(crossword[i][j]);
  }
  System.out.println();
}
sc.close();
  }
}
