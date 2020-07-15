package custom;

public class CustomString {

    public static void main(String[] args) {
        System.out.println(indexOf("0123", "23"));
    }
    public static int indexOf(String s, String sub) {
        //Skip any null checks.
        char[] main = s.toCharArray();
        char[] substr = sub.toCharArray();

        int ptr = 0;

        for (int i = 0; i < main.length - substr.length; i++) {
            if (foundAt(i, main, substr)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean foundAt(int index, char[] main, char[] sub) {
        for (int i = 0; i < sub.length; i++, index++) {
            if (main[index] != sub[i]) {
                return false;
            }
        }
        return true;
    }
}
