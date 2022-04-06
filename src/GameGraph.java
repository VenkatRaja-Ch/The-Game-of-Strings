import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class GameGraph
{
    static void stateSpaceGraph( String passedString )
    {
        String gameString = passedString;

        ArrayList <String> gameNodeList = new ArrayList<>();     // creating an empty array list
        gameNodeList.add(gameString);       // adding the passed game string to the array list
        HashMap < Integer, ArrayList <String> > nodeTable = new HashMap<>(); // creating a hash map for keeping the track
        nodeTable.put(0, gameNodeList); // assigning the root node to the table


        // creating a sample space in table to store the nodes mapping to their respective depth level
        int nodeTableSize = nodeTable.size();
        for( int currentNodeDepthLevel=1; currentNodeDepthLevel < nodeTableSize + 1; currentNodeDepthLevel++)   // +1 added to the size to avoid any null pointer exception
        {
            ArrayList <String> newList = new ArrayList<>();
            nodeTable.put(currentNodeDepthLevel, newList);
        }

        // Generating a graph form root node
        generateGraph( nodeTable, 0);

        // Printing a graph for all nodes
        for( int currentDepth=0; currentDepth<nodeTableSize; currentDepth++)
        {

            System.out.print( currentDepth + " -> ");    //   prints current depth level
            int totalNodesInCurrentDepth = nodeTable.get(currentDepth).size(); // number of nodes in current depth

            for(int currentNode=0; currentNode<totalNodesInCurrentDepth; currentNode++)    // loop to fetch elements form current node
            {
                System.out.print(nodeTable.get(currentDepth).get(currentNode) + " ");   // prints elements in current node
            }
            System.out.println(); // moves to new line
        }
    }

    // to generate the graph for the given string
    private static void generateGraph(HashMap<Integer, ArrayList<String>> nodeTable, int height)
    {
        // to store all the node there in the current level
        ArrayList <String> currentLevelNodes = new ArrayList<>();

        boolean isLeafNode = nodeTable.get(height).get(0).length() == 1;
        if( isLeafNode )
            return;

        int totalNodesPresent = nodeTable.get(height).size();
        for(int currentNodeNumber=0; currentNodeNumber<totalNodesPresent; currentNodeNumber++)
        {
            ArrayList <String> node = generateStringList( nodeTable.get(height).get(currentNodeNumber));    // gets current node string
            currentLevelNodes.addAll(node); // add the nodes to the current node level
        }

        nodeTable.put(height+1, currentLevelNodes); // sets all the nodes in the current level in the node table

        generateGraph( nodeTable, height+1);    // recursive call to get all the nodes till it reaches leaf node.
    }

    // generates the resultant string after calculation of first two characters of the string
    private static ArrayList<String> generateStringList(String s)
    {

        ArrayList <String> nodeList = new ArrayList<>();
        String newString;

        for(int charPosititon=0; charPosititon<3; charPosititon++)
        {
            newString = "";

            // character position: 0
            if( charPosititon == 0)
            {
                if (s.charAt(0)=='X'){
                    newString += "O";
                }else{
                    newString += "X";
                }
                // concatenating remaining strings after calculation
                for (int indexJ = 1; indexJ < s.length(); indexJ++){
                    newString += s.charAt(indexJ);
                }
            }
            // character position: 1
            else if( charPosititon == 1 )
            {
                newString = newString + s.charAt(0) ;   // concatenating first character

                if (s.charAt(1)=='X'){
                    newString += "O";
                }else{
                    newString += "X";
                }
                // concatenating remaining strings after calculation
                for (int indexJ = 2; indexJ < s.length(); indexJ++){
                    newString += s.charAt(indexJ);
                }
            }
            // character position: 1&2
            else if( charPosititon == 2 )
            {
                // for character position 1
                if (s.charAt(0)=='X')
                    newString += 'O';
                else
                    newString += 'X';
                // for character position 2
                if (s.charAt(1)=='X')
                    newString += 'O';
                else newString += 'X';

                // concatenating remaining strings after calculation
                for (int indexJ = 2; indexJ < s.length(); indexJ++){
                    newString+=s.charAt(indexJ);
                }
            }
            newString = checkString( s );
            nodeList.add(newString);
        }

        return nodeList;
    }

    // <------------------------------------------- to be made readable from here ------------------------------------------->
    private static String checkString(String s)
    {
        HashMap <String, String> map = new HashMap<>();
        map.put("XX", "O");
        map.put("OO", "X");
        map.put("XO", "O");
        map.put("OX", "X");

        String small = s.substring(0,2);
        String newSmall = map.get(small);

        for( int index=2; index<s.length(); index++)
        {
            newSmall += s.charAt(index);
        }

        return newSmall;
    }
}
