package searching;

public class BinarySearch {

    public int binarySearchKeyOfLowest(int[] a, int key) {
        return binarySearchKeyOfLowest(a, 0, a.length - 1, key);
    }
    private int binarySearchKeyOfLowest(int[] a, int low, int high, int key) {
        if (high > -1 && a[high] < key) {
            return high;
        }
        if (low <= high) {
            int mid = (low + high)/2;
            if (a[mid] == key) {
                return mid;
            }
            if (key > a[mid]) {
                if (mid + 1 < a.length && key < a[mid + 1]) {
                    return mid;
                }
                return binarySearchKeyOfLowest(a, mid + 1, high, key);
            }
            if (mid - 1 > -1 && key > a[mid - 1]) {
                return mid - 1;
            }
            return binarySearchKeyOfLowest(a, low, mid - 1, key);
        }
        return -1;
    }

    public int search(int[] a, int key) {
        return search(a, 0, a.length - 1, key);
    }
    private int search(int[] a, int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key) {
                return mid;
            }
            if (key > a[mid]) {
                return search(a, mid + 1, high, key);
            }
            return search(a, low, mid - 1, key);
        }
        return -1;
    }
}
