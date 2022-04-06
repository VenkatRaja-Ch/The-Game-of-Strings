import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Window extends JFrame implements ActionListener {

    // STATIC GLOBAL VARIABLES
    static String name, compName = "Jarvis_AI", currentGameString;
    static boolean isPlayerTurn;
    static char playerCharacter, computerCharacter;
    static int compChoice, currentLength = 15, choiceP;
    static char[] tobeUpdatedCharString, updatedCharString;

    // SAVES FOR DELAY OF 2 SEC
    int compDelay = 3000, humanDelay = 50;

    static GamePlayer player;
    static GamePlayer computer;
    static GameString string;

    // FRAME COMPONENTS
    JLabel heading, pCharacter, currentString, currentStringLength, flipCharLabel, winnerLabel;
    JButton startBtn, playerNameBtn, playerStartsBtn, computerStartsBtn, gameStartBtn,
            posOneBtn, posTwoBtn, posOneNTwoBtn;
    JTextField nameField;


    // DEFAULT CONSTRUCTOR
    Window() {

        player = new GamePlayer();
        computer = new GamePlayer();
        string = new GameString();

//        <--------------------------------------- LABELS ----------------------------------->
        heading = new JLabel();
        heading.setText("Welcome to the game of Strings");
        heading.setForeground(Color.BLACK);
        heading.setBounds(150, 10, 200, 50);
        heading.setBackground(Color.BLACK);

        pCharacter = new JLabel();
        pCharacter.setForeground(Color.BLACK);
        pCharacter.setBounds(150, 70, 200, 50);
        pCharacter.setVisible(false);

        currentString = new JLabel();
        currentString.setBounds(10, 120, 500, 50);
        currentString.setForeground(Color.BLACK);
        currentString.setVisible(false);

        currentStringLength = new JLabel();
        currentStringLength.setBounds(10, 170, 400, 50);
        currentStringLength.setForeground(Color.BLACK);
        currentStringLength.setVisible(false);

        flipCharLabel = new JLabel();
        flipCharLabel.setBounds(10, 370, 200, 50);
        flipCharLabel.setForeground(Color.BLACK);
        flipCharLabel.setVisible(false);
//        <-------------------------------------- LABELS ------------------------------------->


//        <----------------------------------- TEXT FIELDS ----------------------------------->
        nameField = new JTextField();
        nameField.setVisible(false);
        nameField.setBounds(125, 125, 200, 50);
//        <----------------------------------- TEXT FIELDS ----------------------------------->


//        <-------------------------------------- BUTTONS ------------------------------------>
        startBtn = new JButton();
        startBtn.setText("START");
        startBtn.setForeground(Color.BLACK);
        startBtn.setBounds(225, 250, 100, 50);

        playerNameBtn = new JButton();
        playerNameBtn.setText("Submit");
        playerNameBtn.setForeground(Color.BLACK);
        playerNameBtn.setBounds(225, 250, 100, 50);
        playerNameBtn.setVisible(false);

        playerStartsBtn = new JButton();
        playerStartsBtn.setForeground(Color.BLACK);
        playerStartsBtn.setBounds(225, 250, 100, 50);
        playerStartsBtn.setVisible(false);

        computerStartsBtn = new JButton();
        computerStartsBtn.setText("Computer Starts");
        computerStartsBtn.setForeground(Color.BLACK);
        computerStartsBtn.setBounds(225, 350, 100, 50);
        computerStartsBtn.setVisible(false);

        gameStartBtn = new JButton();
        gameStartBtn.setText("Let's Roll");
        gameStartBtn.setForeground(Color.BLACK);
        gameStartBtn.setVisible(false);
        gameStartBtn.setBounds(225, 350, 100, 50);

        posOneBtn = new JButton();
        posOneBtn.setText("(1)");
        posOneBtn.setForeground(Color.RED);
        posOneBtn.setVisible(false);
        posOneBtn.setBounds(10, 420, 50, 50);

        posTwoBtn = new JButton();
        posTwoBtn.setText("(2)");
        posTwoBtn.setForeground(Color.RED);
        posTwoBtn.setVisible(false);
        posTwoBtn.setBounds(100, 420, 50, 50);

        posOneNTwoBtn = new JButton();
        posOneNTwoBtn.setText("(1 & 2)");
        posOneNTwoBtn.setForeground(Color.RED);
        posOneNTwoBtn.setVisible(false);
        posOneNTwoBtn.setBounds(200, 420, 100, 50);
//      <-------------------------------------- BUTTONS ------------------------------------>


//      <-------------------------------------- DEFAULT ------------------------------------>

        // adding components to the frame
        this.add(heading);
        this.add(startBtn);
        this.add(playerNameBtn);
        this.add(nameField);
        this.add(playerStartsBtn);
        this.add(computerStartsBtn);
        this.add(pCharacter);
        this.add(gameStartBtn);
        this.add(currentString);
        this.add(currentStringLength);
        this.add(flipCharLabel);
        this.add(posOneBtn);
        this.add(posTwoBtn);
        this.add(posOneNTwoBtn);

        //default settings of the frame
        this.setLayout(new BorderLayout());
        this.setSize(600, 500);
        this.setForeground(Color.BLACK);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("The Game of Strings");
//      <-------------------------------------- DEFAULT ------------------------------------>


//      <---------------------------- BUTTON ACTION LISTENERS ------------------------------>

        startBtn.addActionListener(e -> {
            // set heading text to "Enter GamePlayer's name
            heading.setText("Submit GamePlayer's name");
            // set visibility of the start button to false
            startBtn.setVisible(false);
            // add text field for player's name
            nameField.setVisible(true);
            // add submit button to the frame.
            playerNameBtn.setVisible(true);

            System.out.println("Start Game Button working");

        });

        playerNameBtn.addActionListener(e -> {
            // set heading to text "Who is starting the Game"
            heading.setText("Who is starting the Game?");
            // set visibility of the text field to false
            nameField.setVisible(false);
            // extract the string name from the text field
            name = nameField.getText();
            // set the extracted name to the player object.
            playerStartsBtn.setText(name);
            // set the visibility of the submit button to false
            playerNameBtn.setVisible(false);
            // set the visibility of the player one button to true
            playerStartsBtn.setVisible(true);
            // set the visibility of the computer button to true.
            computerStartsBtn.setVisible(true);
            // todo
            // print to console about it working
            System.out.println("GamePlayer name submit button working");
        });

        playerStartsBtn.addActionListener(e -> {
            // <-------- player starts the game -------->
            // set isPlayerFirst to true
            isPlayerTurn = true;
            // set game player's character to 'O' and computer's character to 'X';
            playerCharacter = 'O';
            computerCharacter = 'X';
            // set the header text to (name + "'s turn")
            heading.setText(name + "'s turn first");
            // set assigned player's character
            pCharacter.setText("Character Assigned: 'O' ");
            // set assigned player's character label to true
            pCharacter.setVisible(true);
            // set attributes to the human player
            setGamePlayerAttributes(player, name, 'O', true);
            // set attributes to the computer player
            setGamePlayerAttributes(computer, compName, 'X', false);
            // <-------- player starts the game -------->

            // <-------- common part which is to be done -------->
            // set the visibility of the player start button to false
            playerStartsBtn.setVisible(false);
            // set the visibility of the computer start button to false
            computerStartsBtn.setVisible(false);
            // call a function which generates a string of length 25 characters
            string.setStringArray(GameFlow.generateRandomString());
            // set let's roll button's visibility to true.
            gameStartBtn.setVisible(true);
        });

        computerStartsBtn.addActionListener(e -> {
            // <-------- computer starts the game -------->
            // set isPlayerFirst to true
            isPlayerTurn = false;
            // set game player's character to 'O';
            playerCharacter = 'X';
            computerCharacter = 'O';
            // set the header text to (name + "'s turn")
            heading.setText(compName + "'s turn first");
            // set assigned player's character
            pCharacter.setText("Character Assigned: 'O' ");
            // set assigned player's character label to true
            pCharacter.setVisible(true);
            // set attributes to the human player
            setGamePlayerAttributes(player, name, 'X', true);
            // set attributes to the computer player
            setGamePlayerAttributes(computer, compName, 'O', false);
            // <-------- computer starts the game -------->

            // <-------- common part which is to be done -------->
            // set the visibility of the player start button to false
            playerStartsBtn.setVisible(false);
            // set the visibility of the computer start button to false
            computerStartsBtn.setVisible(false);
            // call a function which generates a string of length 25 characters
            string.setStringArray(GameFlow.generateRandomString());
            // set let's roll button's visibility to true.
            gameStartBtn.setVisible(true);
        });


        gameStartBtn.addActionListener(e -> {

            // set visibility of start game button to false
            gameStartBtn.setVisible(false);
            // set header's text player's name whose assigned character is 'O'
            if (player.getGameStringAssigned() == 'O') {
                heading.setText(name + "'s Turn");
            } else {
                heading.setText(compName + "'s Turn");
            }

            // set bounds for header
            heading.setBounds(10, 20, 200, 50);
            // set bounds of the pCharacter accordingly.
            pCharacter.setBounds(10, 70, 200, 50);
            // set label currentStrings to "Current String"
            currentGameString = Arrays.toString(string.getStringArray()).substring(1, string.getLength() * 3 - 1);
            currentString.setText("Current String: < " + currentGameString + " >");
            // set visibility of the currentString to true
            currentString.setVisible(true);
            // set label currentStringLength to "Length:"
            currentStringLength.setText("Current String Length: " + string.getLength());
            // set visibility of the currentStringLength to true
            currentStringLength.setVisible(true);
            // set label flipChar to "Flip Character at Pos:"
            flipCharLabel.setText("Flip Character at Position: ");
            // set visibility of the currentStringLength to true
            flipCharLabel.setVisible(true);


            // if computer's turn
            if (!isPlayerTurn) {
                computerPlay();
            } else {
                //players turn
                // set visibility of button Pos1, 2, and 1&2 to true
                posOneBtn.setVisible(true);
                posTwoBtn.setVisible(true);
                posOneNTwoBtn.setVisible(true);
                isPlayerTurn = true;
            }


        });

        posOneBtn.addActionListener(this);
        posTwoBtn.addActionListener(this);
        posOneNTwoBtn.addActionListener(this);
//      <---------------------------- BUTTON ACTION LISTENERS ------------------------------>
    }

//      <---------------------------- OBJECT SETTER METHODS ------------------------------>

    // setting the passed attributes to the object.
    public void setGamePlayerAttributes(GamePlayer currentPlayer, String name, char character, boolean isHuman) {
        // set name
        currentPlayer.setName(name);
        // set hasWon
        currentPlayer.setHasWon(false);
        // set assigned game character
        currentPlayer.setGameStringAssigned(character);
        // set player type
        currentPlayer.setIsHuman(isHuman);
    }

//      <---------------------------- OBJECT SETTER METHODS ------------------------------>


//      <---------------------------- GAME ACTION LISTENER METHODS ------------------------------>

    // Function for the Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {
        // game runs till the string length is greater than one
        if (string.getLength() > 2) {
            // check who is starting the game: human or computer
            if (isPlayerTurn) {
                choiceP = 0;

                if (e.getSource() == "posOneBtn")
                    choiceP = 1;
                else if (e.getSource() == "posTwoBtn")
                    choiceP = 2;
                else if (e.getSource() == "posOneNTwoBtn")
                    choiceP = 3;

                tobeUpdatedCharString = string.getStringArray();

                // highlight the button chosen in behalf of the computer
                if (choiceP == 1) {
                    // display the button 1 as highlighted as computer chosen choice
                    posOneBtn.setForeground(Color.BLUE);
                    // flip the position One
                    string.setStringArray(GameFlow.flipCharactersPosition(tobeUpdatedCharString, 1));
                } else if (choiceP == 2) {
                    // display the button 2 as highlighted as computer chosen choice
                    posTwoBtn.setForeground(Color.BLUE);
                    // flip the position Two
                    string.setStringArray(GameFlow.flipCharactersPosition(tobeUpdatedCharString, 2));
                } else {
                    // display the button 3 as highlighted as computer chosen choice
                    posOneNTwoBtn.setForeground(Color.BLUE);
                    // flip the position Three
                    string.setStringArray(GameFlow.flipCharactersPosition(tobeUpdatedCharString, 3));
                }

                Timer timeDelay = new Timer(50, ev -> {
                    // the code will be executed once the delay is over

                    // reset the highlight create over button
                    if (choiceP == 1)
                        posOneBtn.setForeground(Color.RED);
                    else if (choiceP == 2)
                        posTwoBtn.setForeground(Color.RED);
                    else
                        posOneNTwoBtn.setForeground(Color.RED);

                    // fetch the flipped string
                    updatedCharString = string.getStringArray();
                    // update current length of the string
                    currentLength -= 1;
                    // update the length of the string object
                    string.setLength(currentLength);
                    // fetch the combined strings after flipping the position
                    string.setStringArray(GameFlow.combinePositions(updatedCharString, currentLength));
                    // switch heading: player -> computer or computer -> player
                    heading.setText(compName + "'s turn");
                    // set character assigned of whose turn it is
                    pCharacter.setText("Character Assigned: '" + computer.getGameStringAssigned() + "'");
                    // set the updated string to the currentString Label
                    currentGameString = Arrays.toString(string.getStringArray()).substring(1, string.getLength() * 3 - 1);
                    currentString.setText("Current String: < " + currentGameString + " >");
                    // set the updated string length to the currentStringLength
                    currentStringLength.setText("Current String Length: " + string.getLength());
                    // set isPlayerTurn -> true

                    isPlayerTurn = false;

                    if(string.getLength() > 2)
                        computerPlay();
                    else
                        winnerFunction();
                });

                timeDelay.start();
                timeDelay.setRepeats(false);
            }

        } else {
            winnerFunction();
        }
    }

    public void winnerFunction()
    {
        winnerLabel = new JLabel();
        boolean isPlayerWinner = chooseWinner();
        if(isPlayerWinner)
            winnerLabel.setText(player.getName() + " is winner");
        else
            winnerLabel.setText(computer.getName() + " is winner");

        this.add(winnerLabel);

    }


    public boolean chooseWinner()
    {
        char lastChar = string.getStringArray()[0];
        char playerChar = player.getGameStringAssigned();
        char compChar = computer.getGameStringAssigned();

        int i = 0;
        if(lastChar == playerChar)
            return true;
        else if (lastChar == compChar)
            return false;

        return false;
    }

    public void computerPlay() {
        posOneBtn.setVisible(true);
        posTwoBtn.setVisible(true);
        posOneNTwoBtn.setVisible(true);

        // make the choice in behalf of the computer
        compChoice = GameFlow.computerChoice();
        tobeUpdatedCharString = string.getStringArray();

        // highlight the button chosen in behalf of the computer
        if (compChoice == 1) {
            // display the button 1 as highlighted as computer chosen choice
            posOneBtn.setForeground(Color.cyan);
            // flip the position One
            string.setStringArray(GameFlow.flipCharactersPosition(tobeUpdatedCharString, 1));
        } else if (compChoice == 2) {
            // display the button 2 as highlighted as computer chosen choice
            posTwoBtn.setForeground(Color.cyan);
            // flip the position Two
            string.setStringArray(GameFlow.flipCharactersPosition(tobeUpdatedCharString, 2));
        } else {
            // display the button 3 as highlighted as computer chosen choice
            posOneNTwoBtn.setForeground(Color.cyan);
            // flip the position Three
            string.setStringArray(GameFlow.flipCharactersPosition(tobeUpdatedCharString, 3));
        }


        // display the delay
        // create a delay of two secs
        Timer timeDelay = new Timer(compDelay, ev -> {
            // the code will be executed once the delay is over
            // fetch the flipped string
            updatedCharString = string.getStringArray();
            // update current length of the string
            currentLength -= 1;
            // update the length of the string object
            string.setLength(currentLength);
            // fetch the combined strings after flipping the position
            string.setStringArray(GameFlow.combinePositions(updatedCharString, currentLength));
            // switch heading: player -> computer or computer -> player
            heading.setText(name + "'s turn");
            // set character assigned of whose turn it is
            pCharacter.setText("Character Assigned: '" + player.getGameStringAssigned() + "'");
            // set the updated string to the currentString Label
            currentGameString = Arrays.toString(string.getStringArray()).substring(1, string.getLength() * 3 - 1);
            currentString.setText("Current String: < " + currentGameString + " >");
            // set the updated string length to the currentStringLength
            currentStringLength.setText("Current String Length: " + string.getLength());
            // set isPlayerTurn -> true
            isPlayerTurn = true;
        });

        timeDelay.start();
        timeDelay.setRepeats(false);

        // reset the highlight create over button
        if (compChoice == 1)
            posOneBtn.setForeground(Color.RED);
        else if (compChoice == 2)
            posTwoBtn.setForeground(Color.RED);
        else
            posOneNTwoBtn.setForeground(Color.RED);
    }
//      <---------------------------- GAME ACTION LISTENER METHODS ------------------------------>
}


