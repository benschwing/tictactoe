
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Schwinghammer_13_11 extends JFrame {

    // Constants for window size
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;

    // Creating the gui elements
    private JPanel gamePanel;
    private JPanel buttonPanel;
    private JPanel homePanel;

    // radio buttons and their labels
    private JRadioButton aiRadio;
    private JRadioButton pvpRadio;
    private ButtonGroup radioGroup;

    // The 9 spaces
    private JButton space1;
    private JButton space2;
    private JButton space3;
    private JButton space4;
    private JButton space5;
    private JButton space6;
    private JButton space7;
    private JButton space8;
    private JButton space9;

    // The buttons
    private JButton newButton;
    private JButton exitButton;
    private JButton startButton;

    // Game array
    char[][] gameArray = new char[3][3];

    // Misc gui elements
    private JLabel homeLabel;
    
    // Some variables we will need later
    int turnsComplete = 0;
    char whichWinner = 'f';
    boolean playerWent = false;
    String gameMode = "ai"; 


    // Constructor
    public Schwinghammer_13_11() {
        // Setting a title
        setTitle("Tic Tac Toe");

        // Setting the size
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Default close
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Setting the layout
        setLayout(new BorderLayout());

        // Building the main menu
        buildHomePanel();
        buildGamePanel();
        buildButtonPanel();

        // Adding the panels
        add(homePanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Making it all visible
        setVisible(true);
        
        // Making the game layout invisible for now.
        gamePanel.setVisible(false);

    }

    // The computerTurn method plays a computer's turn
    private void computerTurn() {
        Random rand = new Random();

        // Generating a random number to prep the loop
        int randInt = (rand.nextInt(9) + 1);

        // A flag if the cpu has played or not.
        boolean hasPlayed = false;

        // While a valid number hasn't been generated, try again.
        while (hasPlayed == false) {
            // A switch case for each random number to check if the associated button was pressed
            switch (randInt) {
                case 1:
                    if (space1.isEnabled()){
                        space1.setText("O");
                        space1.setEnabled(false);
                        hasPlayed = true;
                        gameArray[0][0] = 'o';
                    }
                    break;

                case 2:
                    if (space2.isEnabled()){
                        space2.setText("O");
                        space2.setEnabled(false);
                        hasPlayed = true;
                        gameArray[0][1] = 'o';
                    }
                    break;

                case 3:
                    if (space3.isEnabled()){
                        space3.setText("O");
                        space3.setEnabled(false);
                        hasPlayed = true;
                        gameArray[0][2] = 'o';
                    }
                    break;

                case 4:
                    if (space4.isEnabled()){
                        space4.setText("O");
                        space4.setEnabled(false);
                        hasPlayed = true;
                        gameArray[1][0] = 'o';
                    }
                    break;

                case 5:
                    if (space5.isEnabled()){
                        space5.setText("O");
                        space5.setEnabled(false);
                        hasPlayed = true;
                        gameArray[1][1] = 'o';
                    }
                    break;

                case 6:
                    if (space6.isEnabled()){
                        space6.setText("O");
                        space6.setEnabled(false);
                        hasPlayed = true;
                        gameArray[1][2] = 'o';
                    }
                    break;

                case 7:
                    if (space7.isEnabled()){
                        space7.setText("O");
                        space7.setEnabled(false);
                        hasPlayed = true;
                        gameArray[2][0] = 'o';
                    }
                    break;

                case 8:
                    if (space8.isEnabled()){
                        space8.setText("O");
                        space8.setEnabled(false);
                        hasPlayed = true;
                        gameArray[2][1] = 'o';
                    }
                    break;

                case 9:
                    if (space9.isEnabled()){
                        space9.setText("O");
                        space9.setEnabled(false);
                        hasPlayed = true;
                        gameArray[2][2] = 'o';
                    }
                    break;

            }

            // Generating a new random number
            randInt = (rand.nextInt(9) + 1);


        }

        // Counting up another turn played
        turnsComplete++;
        
        // Checking for a winner
        checkWin();

    }

    // Building the panel that holds the buttons
    private void buildButtonPanel() {
        // Creating the button panel
        buttonPanel = new JPanel();

        // Creating the two buttons
        newButton = new JButton("New Game");
        newButton.setMnemonic(KeyEvent.VK_N);
        newButton.setToolTipText("Click here to start a new game.");

        exitButton = new JButton("Exit");
        exitButton.setMnemonic(KeyEvent.VK_E);
        exitButton.setToolTipText("Click here to close the game.");

        startButton = new JButton("Start Game");
        startButton.setMnemonic(KeyEvent.VK_S);
        startButton.setToolTipText("Click here to start the game.");

        // Adding event listeners.
        newButton.addActionListener(new newButtonListener());
        exitButton.addActionListener(new exitButtonListener());
        startButton.addActionListener(new startButtonListener());

        // Adding the buttons to the panel
        buttonPanel.add(startButton);
        buttonPanel.add(newButton);
        buttonPanel.add(exitButton);

        // Making the new button not visible
        newButton.setVisible(false);

        // Setting some variables for the program
        whichWinner = 'f';
        playerWent = false;

    }

    // Building the panel that holds the actual game
    private void buildGamePanel() {
        // Creating the game panel
        gamePanel = new JPanel();

        // Setting up a gridLayout
        gamePanel.setLayout(new GridLayout(3, 3));

        // Creating the 9 buttons
        space1 = new JButton();
        space2 = new JButton();
        space3 = new JButton();
        space4 = new JButton();
        space5 = new JButton();
        space6 = new JButton();
        space7 = new JButton();
        space8 = new JButton();
        space9 = new JButton();
        
        // Setting font sizes for the buttons
        space1.setFont(new Font("Arial", Font.PLAIN, 60));
        space2.setFont(new Font("Arial", Font.PLAIN, 60));
        space3.setFont(new Font("Arial", Font.PLAIN, 60));
        space4.setFont(new Font("Arial", Font.PLAIN, 60));
        space5.setFont(new Font("Arial", Font.PLAIN, 60));
        space6.setFont(new Font("Arial", Font.PLAIN, 60));
        space7.setFont(new Font("Arial", Font.PLAIN, 60));
        space8.setFont(new Font("Arial", Font.PLAIN, 60));
        space9.setFont(new Font("Arial", Font.PLAIN, 60));

        // Adding event listeners to each button
        space1.addActionListener(new space1Listener());
        space2.addActionListener(new space2Listener());
        space3.addActionListener(new space3Listener());
        space4.addActionListener(new space4Listener());
        space5.addActionListener(new space5Listener());
        space6.addActionListener(new space6Listener());
        space7.addActionListener(new space7Listener());
        space8.addActionListener(new space8Listener());
        space9.addActionListener(new space9Listener());

        // Adding the buttons
        gamePanel.add(space1);
        gamePanel.add(space2);
        gamePanel.add(space3);
        gamePanel.add(space4);
        gamePanel.add(space5);
        gamePanel.add(space6);
        gamePanel.add(space7);
        gamePanel.add(space8);
        gamePanel.add(space9);

        // A variable to track the number of turns
        turnsComplete = 0;

    }

    // Building the panel that holds the radio buttons
    private void buildHomePanel() {
        // Creating the panel
        homePanel = new JPanel();

        // Setting the layout

        // Making the label and adding it
        homeLabel = new JLabel("How would you like to play?");

        // Building the radio buttons and adding them to the group
        radioGroup = new ButtonGroup();
        aiRadio = new JRadioButton();
        pvpRadio = new JRadioButton();

        aiRadio.setText("vs AI");
        pvpRadio.setText("vs Player");

        radioGroup.add(aiRadio);
        radioGroup.add(pvpRadio);

        // Adding the elements
        homePanel.add(homeLabel);
        homePanel.add(aiRadio);
        homePanel.add(pvpRadio);

         // Setting a default game mode
        aiRadio.setSelected(true);

        // Setting up a variable with a default value
        gameMode = "ai"; 


    }

    // A method that checks if someone won or not.
    public void checkWin() {

        // Checking all possible win positions
        if (gameArray[0][0] == gameArray[0][1] && gameArray[0][0] == gameArray[0][2]) {
            whichWinner = gameArray[0][0];
        } else if (gameArray[1][0] == gameArray[1][1] && gameArray[1][0] == gameArray[1][2]) {
            whichWinner = gameArray[1][0];
        } else  if (gameArray[2][0] == gameArray[2][1] && gameArray[2][0] == gameArray[2][2]) {
            whichWinner = gameArray[2][0];
        } else  if (gameArray[0][0] == gameArray[1][0] && gameArray[0][0] == gameArray[2][0]) {
            whichWinner = gameArray[0][0];
        } else  if (gameArray[0][1] == gameArray[1][1] && gameArray[0][1] == gameArray[2][1]) {
            whichWinner = gameArray[0][1];
        } else if (gameArray[0][2] == gameArray[1][2] && gameArray[0][2] == gameArray[2][2]) {
            whichWinner = gameArray[0][2];
        } else if (gameArray[0][0] == gameArray[1][1] && gameArray[0][0] == gameArray[2][2]) {
            whichWinner = gameArray[0][0];
        } else if (gameArray[0][2] == gameArray[1][1] && gameArray[0][2] == gameArray[2][0]) {
            whichWinner = gameArray[0][2];
        }


        // If someone won it disables all buttons and displays a message
        if (whichWinner != 'f') {
            // Displaying a popup for the winner
        	if (whichWinner == 'x') {
                JOptionPane.showMessageDialog(null, "The X Player has won!");
        	} else if (whichWinner == 'o') {
        		JOptionPane.showMessageDialog(null, "The O Player has won!");
        	}


            // Disabling all the buttons
            space1.setEnabled(false);
            space2.setEnabled(false);
            space3.setEnabled(false);
            space4.setEnabled(false);
            space5.setEnabled(false);
            space6.setEnabled(false);
            space7.setEnabled(false);
            space8.setEnabled(false);
            space9.setEnabled(false);
            
        }

        // If there is no winner and 9 moves have been played display a tie
        if (turnsComplete == 9 && whichWinner == 'f') {
            // A tie!
        	JOptionPane.showMessageDialog(null, "A tie! Try again!");

            // Disabling all the buttons
            space1.setEnabled(false);
            space2.setEnabled(false);
            space3.setEnabled(false);
            space4.setEnabled(false);
            space5.setEnabled(false);
            space6.setEnabled(false);
            space7.setEnabled(false);
            space8.setEnabled(false);
            space9.setEnabled(false);
        }

    }

    // Making the space listeners
    private class space1Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Disabling the button
            space1.setEnabled(false);

            // Checking if x just went and setting the appropriate letter and array item
            if (playerWent == false) {
                space1.setText("X");
                gameArray[0][0] = 'x';

                // Checking if the gamemode is pvp and flipping the flag to allow O to be placed
                if (gameMode == "pvp") {
                    playerWent = true;
                }
            } else {
                space1.setText("O");
                gameArray[0][0] = 'o';
                playerWent = false;
            }

            // Incrementing the turn tracker
            turnsComplete++;

            // Checking for a winner before ai goes
            checkWin();

            // Checking if the player just went and which mode is on
            if (gameMode == "ai" && turnsComplete < 9 && whichWinner == 'f') {
                computerTurn();
            }


        }
    }

    private class space2Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            // Disabling the button
            space2.setEnabled(false);

            // Checking if x just went and setting the appropriate letter and array item
            if (playerWent == false) {
                space2.setText("X");
                gameArray[0][1] = 'x';

                // Checking if the gamemode is pvp and flipping the flag to allow O to be placed
                if (gameMode == "pvp") {
                    playerWent = true;
                }
            } else {
                space2.setText("O");
                gameArray[0][1] = 'o';
                playerWent = false;
            }

            // Incrementing the turn tracker
            turnsComplete++;

            // Checking for a winner before ai goes
            checkWin();

            // Checking if the player just went and which mode is on
            if (gameMode == "ai" && turnsComplete < 9 && whichWinner == 'f') {
                computerTurn();
            }
   

        }
    }

    private class space3Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Disabling the button
            space3.setEnabled(false);

            // Checking if x just went and setting the appropriate letter and array item
            if (playerWent == false) {
                space3.setText("X");
                gameArray[0][2] = 'x';

                // Checking if the gamemode is pvp and flipping the flag to allow O to be placed
                if (gameMode == "pvp") {
                    playerWent = true;
                }
            } else {
                space3.setText("O");
                gameArray[0][2] = 'o';
                playerWent = false;
            }

            // Incrementing the turn tracker
            turnsComplete++;

            // Checking for a winner before ai goes
            checkWin();

            // Checking if the player just went and which mode is on
            if (gameMode == "ai" && turnsComplete < 9 && whichWinner == 'f') {
                computerTurn();
            }


        }
    }

    private class space4Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Disabling the button
            space4.setEnabled(false);

            // Checking if x just went and setting the appropriate letter and array item
            if (playerWent == false) {
                space4.setText("X");
                gameArray[1][0] = 'x';

                // Checking if the gamemode is pvp and flipping the flag to allow O to be placed
                if (gameMode == "pvp") {
                    playerWent = true;
                }
            } else {
                space4.setText("O");
                gameArray[1][0] = 'o';
                playerWent = false;
            }

            // Incrementing the turn tracker
            turnsComplete++;

            // Checking for a winner before ai goes
            checkWin();

            // Checking if the player just went and which mode is on
            if (gameMode == "ai" && turnsComplete < 9 && whichWinner == 'f') {
                computerTurn();
            }


        }
    }

    private class space5Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Disabling the button
            space5.setEnabled(false);

            // Checking if x just went and setting the appropriate letter and array item
            if (playerWent == false) {
                space5.setText("X");
                gameArray[1][1] = 'x';

                // Checking if the gamemode is pvp and flipping the flag to allow O to be placed
                if (gameMode == "pvp") {
                    playerWent = true;
                }
            } else {
                space5.setText("O");
                gameArray[1][1] = 'o';
                playerWent = false;
            }

            // Incrementing the turn tracker
            turnsComplete++;

            // Checking for a winner before ai goes
            checkWin();

            // Checking if the player just went and which mode is on
            if (gameMode == "ai" && turnsComplete < 9 && whichWinner == 'f') {
                computerTurn();
            }


        }
    }

    private class space6Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Disabling the button
            space6.setEnabled(false);

            // Checking if x just went and setting the appropriate letter and array item
            if (playerWent == false) {
                space6.setText("X");
                gameArray[1][2] = 'x';

                // Checking if the gamemode is pvp and flipping the flag to allow O to be placed
                if (gameMode == "pvp") {
                    playerWent = true;
                }
            } else {
                space6.setText("O");
                gameArray[1][2] = 'o';
                playerWent = false;
            }

            // Incrementing the turn tracker
            turnsComplete++;

            // Checking for a winner before ai goes
            checkWin();

            // Checking if the player just went and which mode is on
            if (gameMode == "ai" && turnsComplete < 9 && whichWinner == 'f') {
                computerTurn();
            }


        }
    }

    private class space7Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Disabling the button
            space7.setEnabled(false);

            // Checking if x just went and setting the appropriate letter and array item
            if (playerWent == false) {
                space7.setText("X");
                gameArray[2][0] = 'x';

                // Checking if the gamemode is pvp and flipping the flag to allow O to be placed
                if (gameMode == "pvp") {
                    playerWent = true;
                }
            } else {
                space7.setText("O");
                gameArray[2][0] = 'o';
                playerWent = false;
            }

            // Incrementing the turn tracker
            turnsComplete++;

            // Checking for a winner before ai goes
            checkWin();

            // Checking if the player just went and which mode is on
            if (gameMode == "ai" && turnsComplete < 9 && whichWinner == 'f') {
                computerTurn();
            }


        }
    }

    private class space8Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Disabling the button
            space8.setEnabled(false);

            // Checking if x just went and setting the appropriate letter and array item
            if (playerWent == false) {
                space8.setText("X");
                gameArray[2][1] = 'x';

                // Checking if the gamemode is pvp and flipping the flag to allow O to be placed
                if (gameMode == "pvp") {
                    playerWent = true;
                }
            } else {
                space8.setText("O");
                gameArray[2][1] = 'o';
                playerWent = false;
            }

            // Incrementing the turn tracker
            turnsComplete++;
            
            // Checking for a winner before ai goes
            checkWin();

            // Checking if the player just went and which mode is on
            if (gameMode == "ai" && turnsComplete < 9 && whichWinner == 'f') {
                computerTurn();
            }


        }
    }

    private class space9Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Disabling the button
            space9.setEnabled(false);

            // Checking if x just went and setting the appropriate letter and array item
            if (playerWent == false) {
                space9.setText("X");
                gameArray[2][2] = 'x';

                // Checking if the gamemode is pvp and flipping the flag to allow O to be placed
                if (gameMode == "pvp") {
                    playerWent = true;
                }
            } else {
                space9.setText("O");
                gameArray[2][2] = 'o';
                playerWent = false;
            }
            
            // Incrementing the turn tracker
            turnsComplete++;

            // Checking for a winner before ai goes
            checkWin();

            // Checking if the player just went and which mode is on
            if (gameMode == "ai" && turnsComplete < 9 && whichWinner == 'f') {
                computerTurn();
            }


        }
    }


    // Making the startButton listener
    private class startButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Hiding the start game and showing the new game buttons
            newButton.setVisible(true);
            startButton.setVisible(false);

            // Resetting the array.
            gameArray[0][0] = 'f';
            gameArray[0][1] = 'f';
            gameArray[0][2] = 'f';

            gameArray[1][0] = 'f';
            gameArray[1][1] = 'f';
            gameArray[1][2] = 'f';

            gameArray[2][0] = 'f';
            gameArray[2][1] = 'f';
            gameArray[2][2] = 'f';

            // Resetting the winner variable
            whichWinner = 'f';

            // Hiding the home panel and showing the game panel
            homePanel.setVisible(false);
            gamePanel.setVisible(true);

            // Settings all the button to be pressable again
            space1.setEnabled(true);
            space2.setEnabled(true);
            space3.setEnabled(true);
            space4.setEnabled(true);
            space5.setEnabled(true);
            space6.setEnabled(true);
            space7.setEnabled(true);
            space8.setEnabled(true);
            space9.setEnabled(true);

            // Making a boolean to track if the player just went or not
            playerWent = false;

            // Checking which gameMode is selected and making it play according
            if (aiRadio.isSelected()) {
            	gameMode = "ai";
            } else if (pvpRadio.isSelected()) {
                gameMode = "pvp";
            }

            // Resetting the turn tracker
            turnsComplete = 0;

        }
    }


    // Making the exitButton listener
    private class exitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Closing the window.
            System.exit(0);

        }
    }

    // Making the newButton listener
    private class newButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // Making the new button not visible
            newButton.setVisible(false);
            startButton.setVisible(true);

            // Resetting the icons to be the placeholder
            space1.setText(null);
            space2.setText(null);
            space3.setText(null);
            space4.setText(null);
            space5.setText(null);
            space6.setText(null);
            space7.setText(null);
            space8.setText(null);
            space9.setText(null);

            // Hiding the game panel and showing the home panel.
            homePanel.setVisible(true);
            gamePanel.setVisible(false);

        }
    }


    public static void main(String[] args) {
        Schwinghammer_13_11 s13_11 = new Schwinghammer_13_11();
    }


}


