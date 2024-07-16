public class SingleElement_in_a_SortedArray {
    public int singleNonDuplicate(int[] a) {
        int n = a.length;

        int s = 0;
        int e = n - 2;
        int mid = 0;

        while (s <= e) {
            mid = s + (e - s) / 2;

            // System.out.println("s : " + s);
            // System.out.println("e : " + e);
            // System.out.println("mid : " + mid);
            // System.out.println("val : " + a[mid]);
            // System.out.println();

            if (mid % 2 != 0) {
                if (a[mid - 1] == a[mid])
                    s = mid + 1;

                else
                    e = mid - 1;
            }

            else {
                if (a[mid] == a[mid + 1])
                    s = mid + 1;

                else
                    e = mid - 1;
            }

        }

        return a[s];

    }
}
