package tidy.first;

public class Sample1 {
//    public int boundAdjust(int number) {
//        if(number > 0) {
//            if(number >= 10) {
//                number = 10;
//                return number;
//            }
//            number++;
//        } else {
//            number = 0;
//        }
//
//        return number;
//    }

    public int boundAdjust(int number) {
        if(number < 0) return 0;
        if(number >= 10) return 10;

        number++;

        return number;
    }
}
