public class GameString
{
    private int length;
    private char[] stringArray;

    public void setLength ( int length ) { this.length = length; }
    public int getLength()  { return length; }

    public void setStringArray (char[] passedArray ) { this.stringArray = passedArray; }
    public char[] getStringArray() { return stringArray; }

    GameString()
    {
        length = 15;
        stringArray = new char[] {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'};
    }
}
