package tidy.first;

public class Sample2 {
    public void importantFunction(int left, int right) {
        if(left+right == 10) {
            throw new RuntimeException("error");
        }
    }
}
