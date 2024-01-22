package boundary;

public class CharToNumMinusA implements CharToNum {

    @Override
    public int convert(char character) {
        return character - 'a';
    }
}
