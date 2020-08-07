package asimily;

public class PermutationOfString {

    public static void main(String[] args) {
        char[] chars = {'a', 'b'};
        permute("abc", "");
        System.out.println();
    }

    private static void permute(String str, String prefix) {
        if (str.length() == 0) {
            System.out.print(prefix + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            String pref = prefix + str.charAt(i);
            permute(rem, pref);
        }
    }

}
