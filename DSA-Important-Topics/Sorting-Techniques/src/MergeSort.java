public class MergeSort {
    void merge(int[] nums, int s, int e) {
        int mid = s + (e - s) / 2;

        int len1 = mid - s + 1;

        int len2 = e - mid;

        int[] left = new int[len1];
        int[] right = new int[len2];

        int j = 0;
        for (int i = s; i <= mid; i++) {
            left[j++] = nums[i];
        }

        j = 0;
        for (int i = mid + 1; i <= e; i++) {
            right[j++] = nums[i];
        }

        int i = 0;
        j = 0;

        while (i < len1 && j < len2) {
            if (left[i] < right[j]) {
                nums[s++] = left[i];
                i++;
            } else {
                nums[s++] = right[j];
                j++;
            }
        }

        while (i < len1) {
            nums[s++] = left[i];
            i++;
        }

        while (j < len2) {
            nums[s++] = right[j];
            j++;
        }
    }

    void mergeSort(int[] nums, int s, int e) {
        if (s >= e) {
            return;
        }

        int mid = s + (e - s) / 2;
        mergeSort(nums, s, mid);
        mergeSort(nums, mid + 1, e);

        merge(nums, s, e);
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;

    }
}
