public class bitonic {
    public static int peak(int[] a) {
        int lo = 0, hi = a.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if((mid == 0 || a[mid] > a[mid - 1]) && (mid == a.length - 1 || a[mid] > a[mid + 1])) {
                return mid;
            } else if (mid < a.length - 1 && a[mid] < a[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
    public static boolean binarySearchInc(int[] a, int key, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return true; 
            }
            if (a[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
    public static boolean binarySearchDec(int[] a, int key, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return true; 
            }
            if (a[mid] > key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
    public static boolean bitonic(int[] a, int key) {
        int peak = peak(a);
        if(a[peak] != key) {
            return binarySearchInc(a, key, 0, peak - 1) || binarySearchDec(a, key, peak + 1, a.length - 1);
        } else {
            return true;
        }
    }
}