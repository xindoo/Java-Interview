public class OccuredHalfNumber {
	int findOccuredHalfNumber(int[] nums) {
		int res;
		int cnt = 0;
		for (int num : nums) {
			if (0 == cnt) {
				cnt++;
				res = num;
				continue;
			}
			if (res == num) {
				cnt++;
			} else {
				cnt--;
			}
		}
		return res;
	}
}