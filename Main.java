import java.util.Scanner; //import the java system into the program

class Main { //creates a main class 

  public static void main(String[] args) //main method; where the program starts 
  {
    Scanner input = new Scanner(System.in); //creates the scanner object
    System.out.println("Welcome to Hangman!"); //at the start, type out the line "welcome to hangman"
    System.out.println("please enter a word"); //enter a word 
    String guessWord = input.next() ; //a word that we must guess, a string object 
    char[] guessChars = //the guess word is split up into letters
    guessWord.toCharArray();  //we create an array of letters of that guess guessWord
    String hiddenWord = ""; //start it with nothing 
    for(int i = 0; i < guessWord.length(); i ++) //keep adding dots 
    hiddenWord += "."; //keep adding dots into the string 
    //String hiddenWord = "."; //hides the string obejct(the split up letters) 
    char[] hiddenChars = hiddenWord.toCharArray(); //splits up the hidden words into arrays

    int nGuessesLeft = 5; //maximum number of guesses we can have 

    while(!hiddenWord.equals(guessWord)) //the hidden word is equal to the guess word and function is run if this statement is true 
    {

      System.out.println("You have " + nGuessesLeft + "guesses left!");  //just print out the number of guesses left 
    System.out.print("Please enter a letter to guess: "); //print out the line that tells the player to input a word

  String inputWord = input.next(); //after the previous input was played, the player can input the next word regardless if the preivous guess was right or wrong
  char[] inputChars = inputWord.toCharArray(); //the word is sepreated and the player inputs each individual letter -- char splits up the array of strings into a list of seperate values 
char inputChar = inputChars[0]; //get an input and set as the first letter 
  System.out.println("Your guess: " + inputChar); //print out the line of the guess 

  boolean guessedRight = false; //creating a new variable and starts at first
  
  for (int i = 0; i < guessWord.length(); i++) { //create a counter starting at 0 and aslong as the number is less then the guess word length, each time the loops happens, we add one onto that counter
    char guessChar = guessChars[i]; //guessing the word in the seperated list of unknown words 
    if (guessChar == inputChar) { //if the letter that we guessed is in the list of the hidden words perform this action
      System.out.println("That character is in the word!"); //print the line that the guess is correct 
      hiddenChars[i] = guessChar;  //hidden letter = guessed letter
      guessedRight = true; //perform this action if the guess is corrct 
    }
  }

  if (!guessedRight){ //do this if the guess is incorrect
    nGuessesLeft--;  //if the guess is right, lower the counter 
  }
  if (nGuessesLeft ==0) { //do this when the guess counter is at 0
    System.out.println("Oh no! You ran out of guesses. Better luck next time");
    return; //print out teh line that says the game is over 
  }


ClearConsole(); //clear the entire consol for each action
  hiddenWord = new String(hiddenChars); //for every new letter, clear the consol for each letter 
  System.out.println("The word is: " + hiddenWord); //print out the line that says what the final answer is 
    }

    System.out.println("Congrats! You beat the game!"); //if the hidden word is guessed, then print out the line that says the game has been beaten

  }
static void ClearConsole() { //clears entire consol
  System.out.print("\033[H\033[2J"); //uni code to clear consol
}

}