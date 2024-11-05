public class ArrayIndexChecker {

    /**
     * Public method to start the recursive divide-and-conquer check.
     *
     * @param arr A sorted array of integers.
     * @return true if there is any element in arr greater than its index; false otherwise.
     */
    public static boolean hasElementGreaterThanIndex(int[] arr) {
        return hasElementGreaterThanIndex(arr, 0, arr.length - 1);
    }

    /**
     * Private helper method for divide-and-conquer.
     * 
     * @param arr  The sorted array of integers.
     * @param left  The starting index of the subarray.
     * @param right The ending index of the subarray.
     * @return true if an element greater than its index is found; false otherwise.
     */
    private static boolean hasElementGreaterThanIndex(int[] arr, int left, int right) {
        // Base case: if left index is greater than right, no elements to check
        if (left > right) {
            return false;
        }

        // Find the middle index
        int mid = left + (right - left) / 2;

        // Check if the element at mid is greater than its index
        if (arr[mid] > mid) {
            return true;
        }

        // Recurse on the right half if arr[mid] <= mid
        if (arr[mid] <= mid) {
            return hasElementGreaterThanIndex(arr, mid + 1, right);
        }

        // Otherwise, check the left half as well
        return hasElementGreaterThanIndex(arr, left, mid - 1);
    }

    /**
     * Main method for testing the algorithm.
     */
    public static void main(String[] args) {
        int[] example1 = {-5, -3, 0, 2, 3};   // Expected output: false
        int[] example2 = {0, 1, 2, 4, 6};     // Expected output: true

        System.out.println("Example 1: " + hasElementGreaterThanIndex(example1)); // Output: false
        System.out.println("Example 2: " + hasElementGreaterThanIndex(example2)); // Output: true
    }
}
