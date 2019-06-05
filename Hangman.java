import java.util.Random;
/**
 * Write a description of class Hangman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hangman
{
    Random r;
    GetInformation get;
    String[] words = {"hello", "lifestyle ", "common", "bench", "random"};
    String word;
    boolean finished = false;
    int badGuessCount=0;
    boolean [] foundLetters;
    String entryWord = " ";

    public Hangman()
    {
        r = new Random();
        get = new GetInformation();
        playAGame();
    }

    public void playAGame()
    {
        word = words[r.nextInt(words.length)];
        foundLetters = new boolean[word.length()];
        while (!finished)
        {
            showGallows();
            showWord();
            getGuess();
            checkGuess();
            if (badGuessCount==6)
            {
                System.out.print('\u000C');
                showGallows();
                System.out.println("Sorry, you have lost the game.");
                System.out.println("The word was:" +word);
                finished=true;
            }
        }
    }

    public void showGallows()
    {
        System.out.print('\u000C');
        if (badGuessCount==0)
            man_0(); 
        if (badGuessCount==1)
            man_1(); 
        if (badGuessCount==2)
            man_2(); 
        if (badGuessCount==3)
            man_3();
        if (badGuessCount==4)
            man_4(); 
        if (badGuessCount==5)
            man_5(); 
        if (badGuessCount==6)
            completedMan(); 
        System.out.println("\n");
    }

    public boolean showWord()
    {
        boolean goodGuess = false;
        char ch = entryWord.charAt(0);
        for (int lc=0; lc < word.length(); lc++)
            if (foundLetters[lc]==true)
            {
                System.out.print(word.charAt(lc)+" "); 
            }
            else if (word.charAt(lc)==ch)
                {
                    System.out.print(word.charAt(lc)+" ");
                    foundLetters[lc] = true;
                    goodGuess = true;
                }
                else 
                    System.out.print("_ ");
        return goodGuess;
    }
    
    public void getGuess()
    {
        System.out.println("\n\n\n What is your choice");
        System.out.println("Type the entire word to guess the word");
        System.out.println("You have"+ (6 - badGuessCount) + "guesses left");
        System.out.print("Enter guess >");
        entryWord = get.gWord();
    }
    
    public void checkGuess()
    {
        boolean goodGuess;
        if (entryWord.length()>1)
        {
            if (entryWord.equals(word))
            {
                System.out.println(2);
            }
        }
    }
    
    public void completedMan()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|  /|\\");
        System.out.println("|  / \\");
    }
    
    public void man_0()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|  ");
        System.out.println("|  ");
        System.out.println("|  ");
    }
    
    public void man_1()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|  ");
        System.out.println("|  ");
    }
    
    public void man_2()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|  |");
        System.out.println("|  ");
    }
    
    public void man_3()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|  /|");
        System.out.println("|   ");
    }
    
    public void man_4()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|  /|\\");
        System.out.println("|  ");
    }
    
    public void man_5()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|  /|\\");
        System.out.println("|  / ");
    }
}