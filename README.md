# CS1302Project

Contains a main window/view that displays a welcome message to user. The main view is the home view and contains a menu bar with buttons to display the next described views. When clicking a button on the menu a transition animation occurs.

1. Home View - Displays a welcome message for user related to this course. Includes a alternating fade transition animation for the Welcome message. The home view also contains an image of the KSU owl. The owl image uses a alternating PathTransition which moves the owl back and forth diagonally.

2. Author View - Displays an about me label. Includes a picture of myself. Then lists education status, and hobbies using labels. There is also a video introducing myself with play and pause buttons that are used as actionEvents.

3. Game View - The game is a memory match game. It includes fadeTransition animations when flipping tiles. It includes a play again button, as well as a label that tells you how to play the game.

Description of the game:

There is a board full of overturned cards. There is a pair for each card. The Player flips over two cards. If they match, then they stay overturned, otherwise they flip back. The game is over after all the cards are matched.
