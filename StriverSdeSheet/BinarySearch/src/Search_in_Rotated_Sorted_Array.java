public class Search_in_Rotated_Sorted_Array {
    int findPivotIndex(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while (s < e) {
            int mid = s + (e - s) / 2;
            System.out.println("mid : " + mid);
            System.out.println("value of prev S : " + s);

            if (arr[mid] >= arr[0]) {
                // means we are in part 1 ,
                // our pivot will always be the begining of part2
                s = mid + 1;
            }

            else {
                e = mid;
            }
        }
        System.out.println("pivot is : " + s);
        return s;
    }

    public int search(int[] nums, int target) {
        // find pivot

        int pivotIndex = findPivotIndex(nums);

        // now we have found the pivot , we can set the starting point and
        // ending point of the target by comparing whther it lies in part1 or 2
        int s, e;

        if (nums[pivotIndex] <= target && target <= nums[nums.length - 1]) {
            // pivot se nums ke end tak
            s = pivotIndex;
            e = nums.length - 1;
        }

        else {
            // 0 index se pivot ke pehle tak
            s = 0;
            e = pivotIndex;
        }

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[mid] < target) {
                s = mid + 1;
            }

            else {
                e = mid - 1;
            }
        }

        return -1;
    }
}
