public class BinarySearch {
	public int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length();
		while (left < right) {
			int mid = (left+right)>>1;
			if (nums[mid] <= target) 
				right = mid;
			else 
				left = mid+1;
		}
		if (nums[left] != target)
			return -1;
		return left;
	}
}