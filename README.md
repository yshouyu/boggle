# The Gmae of Boggle V1.2
## About
This program is designed, wrote and tested by Shouyu Yang.

Boggle is a game of guessing words, wrote by JavaFX with GUI.
## Rules
• The game is usually played with 4x4 or 5x5 tray that holds dice, which display letters on all sides.

• The game starts by shaking the dice (with the lid on) until they fall into place inside the tray.

• A three-minute timer is started.

• Each player writes on a piece of paper words he/送花e sees on the tray, as fast as possible.

• The game stops when the timer expires.

• The player gets point only for words that

    • are visible on the tray

    • are listed in the dictionary

    • are not capitalized or foreign words

    • do not appear on any other player’s list

    • are at least three-letter long

• There is no penalty for rejected words.

• Distinct words can use the same dice in the tray, e.g., “home,” “homes,” and “homed” might all appear
in the tray.

• The number of points received for a given word equals the length of the word minus two, e.g., 1 point
for “dog,” 2 points for “lava,” and 4 points for “retina.”

• A word appears on the tray if

    • it consists of a string of letters that is formed by traversing neighboring dice without stepping on the same
    dice twice.
## How to Use This Program
Click the jar file to start the game, the game start as 4 x 4, and if you find the button at the right side of switch, you can switch the game to 5 x 5, and click the reset button to start the game, then click the letter you want and you can play the game,
every three letters words will be count as 3 points. 


## Known Bugs
I do not found any problem right now.
## Update History
V1

     allow the player to type a word and check that it is in your dictionary.

V2

    generate and display the tray, allow the player to type single words, and check that the words are valid with respect to the
    tray contents.
V3

    generate a first complete game, but continue to allow the player to type words on the keyboard.
    
V4

     modify the code so as to allow the user to select letters on the screen and to see what was selected as in the example 
     below.
    
V4 final

    The best version I made, fix the bug i know and add the 5x5 style.
    
