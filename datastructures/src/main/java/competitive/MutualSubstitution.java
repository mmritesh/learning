package competitive;

import org.junit.Assert;
import org.junit.Test;

public class MutualSubstitution {

    @Test
    public void test1() {
        Assert.assertEquals("kazak", solve("kajak".toCharArray(), "kja".toCharArray(), "azk".toCharArray()));
    }

    @Test
    public void test2() {
        Assert.assertEquals("kembozrd", solve("keyboard".toCharArray(), "ma".toCharArray(), "yz".toCharArray()));
    }

    public static String solve(char[] source, char[] s1, char[] s2) {
        char[] map = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j] == s1[i]) {
                    map[j] = s2[i];
                    continue;
                }
                if (map[j] == s2[i]) {
                    map[j] = s1[i];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            sb.append(map[getIndex(source[i])]);
        }
        return sb.toString();
    }

    private static int getIndex(char c) {
        return (int)c - 97;
    }
}
