package codingtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodRatingsTest {

    @Test
    void test1() {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});

        assertEquals("kimchi", foodRatings.highestRated("korean"));
        assertEquals("ramen", foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi", 16);
        assertEquals("sushi", foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen", 16);
        assertEquals("ramen", foodRatings.highestRated("japanese"));
    }
    
    @Test
    void test2() {
        FoodRatings foodRatings = new FoodRatings(new String[]{"mpsaowuxj","vpjohob","fn","clvugdxsaf","rujps","conjq","rpqdawz"},
                new String[]{"shrkuo","shrkuo","shrkuo","shrkuo","shrkuo","shrkuo","shrkuo"},
                new int[]{3,7,1,8,4,16,11});

        assertEquals("conjq", foodRatings.highestRated("shrkuo"));
        assertEquals("conjq", foodRatings.highestRated("shrkuo"));
        foodRatings.changeRating("rpqdawz",13);
        assertEquals("conjq", foodRatings.highestRated("shrkuo"));
        assertEquals("conjq", foodRatings.highestRated("shrkuo"));
        foodRatings.changeRating("conjq",15);
        assertEquals("conjq", foodRatings.highestRated("shrkuo"));
        assertEquals("conjq", foodRatings.highestRated("shrkuo"));
        foodRatings.changeRating("rujps",17);
        assertEquals("rujps", foodRatings.highestRated("shrkuo"));
        assertEquals("rujps", foodRatings.highestRated("shrkuo"));
    }
}