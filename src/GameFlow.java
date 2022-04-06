import java.util.Random;

public class GameFlow
{
//  <---------------------------- RANDOM GENERATION OF STRING ------------------------------>

    // Function to generate a random string
    static char[] generateRandomString()
    {
        Random randomNumber = new Random();
        float generatedNumber;
        char[] characters = {'O', 'X'};
        char[] generatedGameString = new char[15];

        for(int index=0; index<15; index++)
        {
            generatedNumber = randomNumber.nextFloat();

            if( generatedNumber >= 0.5)
                generatedGameString[ index ] = characters[0];
            else
                generatedGameString[ index ] = characters[1];
        }

//        GameGraph.stateSpaceGraph(generatedGameString);

        //  to convert into array for the state space graph
        String forGraph = "";
        for(int index=0; index<15; index++)
        {
            forGraph = forGraph + generatedGameString[index];
        }

//        GameGraph.stateSpaceGraph(forGraph);

        return generatedGameString;
    }

//  <---------------------------- RANDOM GENERATION OF STRING ------------------------------>


//  <---------------------------- AI CHOICE ------------------------------>

    // Function for computer to select moves
    static int computerChoice()
    {
        int min=1, max=3, aiChoice;
        Random randNum = new Random();
        aiChoice = randNum.nextInt((max - min) + 1) + min;

        return aiChoice;
    }

//  <---------------------------- AI CHOICE ------------------------------>


//  <---------------------------- FLIP POSITION OF CHARACTERS ------------------------------>

    static void flipPosition1( char[] array ){
        if( array[0] =='O')
            array[0] = 'X';
        else
            array[0] = 'O';
    }

    static void flipPosition2( char[] array ){
        if( array[1] == 'O')
            array[1] = 'X';
        else
            array[1] = 'O';
    }

    static char[] flipCharactersPosition( char[] array , int positionFlag){

        // check the position flag's number
        // if position 1
        if( positionFlag == 1)
            flipPosition1( array );
        else if( positionFlag == 2)
            flipPosition2( array );
        else{
            flipPosition1( array );
            flipPosition2( array );
        }

        return array;
    }

//  <---------------------------- FLIP POSITION OF CHARACTERS ------------------------------>


//  <------------------------------- COMBINE TWO CHARACTERS -------------------------------->

    // Function to combine first two characters of the string
    static char[] combinePositions( char[] array, int length){
        char[] solutionArray = new char[length];

        if( array[0] == 'X' && array[1] == 'X' )
            array[1] = 'O';
        else if( array[0] == 'O' && array[1] == 'O')
            array[1] = 'X';
        else if( array[0] == 'X' && array[1] == 'O')
            array[1] = 'O';
        else
            array[1] = 'X';

        // set to new array
        if (length - 1 >= 0)
            System.arraycopy(array, 1, solutionArray, 0, length - 1);

        return solutionArray;
    }

//  <------------------------------- COMBINE TWO CHARACTERS -------------------------------->

    static String trimmedString( char[] array )
    {
        int length = array.length;
        String shortenedString = "";

        for(int index=0; index<length; index++)
        {
            if(array[index] != ' ')
            shortenedString = shortenedString +  array[ index ] ;
        }

        return shortenedString;
    }
}
