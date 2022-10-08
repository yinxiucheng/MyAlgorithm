package senior.扫描线;

public class 范围加法 {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        for (int[] triple: updates) {
            int startIndex = triple[0];
            int endIndex = triple[1];
            int andNum = triple[2];
            for (int i = startIndex; i <= endIndex ; i++) {
                if (i < nums.length){
                    nums[i] += andNum;
                }
            }
        }

        return nums;
    }
}
