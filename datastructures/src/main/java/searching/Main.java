package searching;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Main {

    private BinarySearch binarySearch;
    private int[] a = {10, 20, 40, 50, 100, 160};

    @BeforeEach
    void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void test6() {
        int[] key =  {10, 20, 40, 50, 100, 160, 1, 161};
        int[] expected = {0, 1, 2, 3, 4, 5, -1, -1};

        for (int i = 0; i < key.length; i++) {
            Assert.assertEquals(expected[i], binarySearch.search(a, key[i]));
        }
    }

    @Test
    public void test7() {
        int[] key =  {10, 20, 40, 50, 100, 160, 1, 161};
        int[] expected = {0, 1, 2, 3, 4, 5, -1, 5};

        for (int i = 0; i < key.length; i++) {
            Assert.assertEquals(expected[i], binarySearch.binarySearchKeyOfLowest(a, key[i]));
        }
    }

}
