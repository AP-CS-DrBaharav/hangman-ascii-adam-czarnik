

/**
 * All of the below imports are related to File operations, which 
 * are needed only for the extra challenge function :
 *   pickWordFromFile()
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;

public class HangMan {

    String word;
    String wordLowerCase;
    String lettersTried;
    String wordRevealed;
    // final String a2z = "abcdefghijklmnopqrstuvwxyz";

    String messageToPlayer;

    int numOfTries;
    int numOfFailedTries;

    public HangMan() {
        // Constructor. Do nothing for now
    }

    public void startAnew() {
        // pick a word
        word = pickWordSimple();
        
        // ToDo :: Extra challenge
        // Complete the method pickWordFromFile below, and uncomment
        // the below line.
        // word = pickWordFromFile();

        wordLowerCase = word.toLowerCase();

        // initialize
        lettersTried = "";
        wordRevealed = "";

        // ToDo 1 :: replace * with _
        // Yes, this is THAT simple.
        for (int ii = 0; ii < word.length(); ++ii) {
            // ToDo 1 :: replace * with _  in wordRevealed.
            // Yes, this is THAT simple.
            wordRevealed += "*";
        }

        numOfTries = 0;
        numOfFailedTries = 0;

        messageToPlayer = "";
    }

    private String pickWordSimple() {
        // Load words
        String[] words = {"Aardvark", "Aorta", "Supercalifragilisticexpialidocious"};
        int idx = (int) (words.length * Math.random());

        return words[idx];
    }

    
    public void newCharGuessed(char c) {
        messageToPlayer = "";
        ++numOfTries;

        // Did you already try this letter?
        // ToDo 2 :: Does character c appear in lettersTried? 
        //     Hint 1 :: Repalce the 'false' below with a check
        //     Hint 2 :: Use indexOf()
        if (false) {
            messageToPlayer = "\n*** Message: You already tried letter \"" + c + "\".";
            ++numOfFailedTries;
            return;
        }

        // Just a note: 
        // Right now the letters are not shown in Alphabetic order
        // Extra challenge: Keep them IN order.
        lettersTried += c;

        // Does the letter appear in the word?
        // ToDo 3 :: Does character c appear in the word? 
        //   does Not Appear : true
        //   does Appear:  false
        //     Hint 1 :: Repalce the 'true' below with the appropriate check
        //     Hint 2 :: use wordLowerCase, as the letter might be upper case in the original word.
        if (true) {
	    messageToPlayer = "\n*** Message: The letter \"" + c + "\" does not appear in the word.";
            ++numOfFailedTries;
            return;
        }

        // If the letter was found, it might appear Multiple times!
        int fromIndex = 0;
        int idx = wordLowerCase.indexOf(c, fromIndex);
        int foundCount = 0;
        while (idx >= 0) {
            ++foundCount;

            // ToDo 4 :: Create a new wordRevealed, 
            // where the element at index idx is changed to be the appropriate one
            // That means, 'replacing' the element at the idx location.
            // Use substring, and string concatention.
            //
            // You will need to replace the line below.
            // Hint :: The letter in the real word might be Uppercase letter. So
            // pay attention to where the letter is taken from.
            wordRevealed = wordRevealed;		

            fromIndex = idx + 1;
            idx = wordLowerCase.indexOf(c, fromIndex);
        }
        messageToPlayer = "\n*** Message: The letter \"" + c + "\" was found "
                + foundCount + "time(s) in the word.";

    }

    public boolean isDone() {
        // ToDo 5 :: Is wordRevealed the same as word? 
        // use compareTo() to replace the 'false' below	
        if (false) {
	    messageToPlayer = "*** You solved it!!";
            return true;
        }
        // ToDo 6 :: Does the number of failedTries exceeds 6? 
        // Check for >=	to replace the 'false' below
        if (false) {
	    messageToPlayer = "*** You lost!!";
            return true;
        }
        return false;
    }

    public void draw() {

        System.out.println("  ========");
        System.out.println("  ||    | ");
        if (numOfFailedTries < 1) {
            System.out.println("  ||      ");
        } else {
            System.out.println("  ||    O ");
        }

        if (numOfFailedTries < 2) {
            System.out.println("  ||      ");
            System.out.println("  ||      ");
            System.out.println("  ||      ");
        } else {
            if (numOfFailedTries == 2) {
                System.out.println("  ||    | ");
                System.out.println("  ||    | ");
            }
            if (numOfFailedTries == 3) {
                System.out.println("  ||   /| ");
                System.out.println("  ||    | ");
            }
            if (numOfFailedTries >= 4) {
                System.out.println("  ||   /|\\");
                System.out.println("  ||    | ");
            }
            if (numOfFailedTries < 5) {
                System.out.println("  ||       ");
            } else {
                if (numOfFailedTries == 5) {
                    // ToDo 7 :: Print the left leg.
                    // You will need to replace the String which is printed
                    // below with something else.
                    System.out.println("  ||      ");
                }
                if (numOfFailedTries == 6) {
                    // ToDo 8 :: Print the right leg.
                    // You will need to replace the String which is printed
                    // below with something else.
                    // Hint :: Escape sequences.
                    System.out.println("  ||      ");
                }
            }
        }
        System.out.println("  ||      ");
        System.out.println("============");
        System.out.println("            ");

        if (messageToPlayer.length() > 0) {
            System.out.println(messageToPlayer);
        }
        System.out.println("");

        System.out.println("Word to guess (ONLY for debugging): " + word);
        System.out.println("Word guessed so far               : " + wordRevealed);
        System.out.println("Letters tried so far              : " + lettersTried);
        System.out.println("Number of tries (diff letters)    : " + numOfTries);

    }

    private String pickWordFromFile() {

        String wordReturned = "WhatWord";
        // Extra challenge:  Reading from a file

        /* 
            You may find the following short segment very useful: Creating a file!
            Just so as to know where the system is looking for your file.
        */
        /*
        File file = new File("Test.txt");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("Find me if you can\n");
            writer.flush();
            writer.close();
        } catch (IOException ex) { }
        */
        /* Now that you know where the file is created...*/
        FileReader in = null;
        // For NetBeans, the program is 'running' in the parent directory,
        // so we have to go one level down to ./src  .
        String fileName = "./src/CountriesAndCapitols.txt";

        try {
            in = new FileReader(fileName);
            BufferedReader br = new BufferedReader(in);
            // --> ToDo things here
            // read the number of words

            // choose a random number

            // and get that specific word

            in.close();
        } 
        catch (IOException ex) {

        }
        // End of Extra credit

        return wordReturned;
    }

}
