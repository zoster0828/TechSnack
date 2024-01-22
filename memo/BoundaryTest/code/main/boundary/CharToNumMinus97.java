package boundary;

public class CharToNumMinus97 implements CharToNum {
    @Override
    public int convert(char character) {
        return character - getBaseNumber();
    }

    int getBaseNumber() {
        return 97;
    }
}
