package junior.datastructure.datastream;


public class FirstUniqueNumber {

    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        if (null == nums || nums.length == 0){
            return -1;
        }
        DataStream stream = new DataStream();
        for (int i = 0; i < nums.length; i++) {
            stream.add(nums[i]);
            if (nums[i] == number){
                return stream.firstUnique();
            }
        }
        return -1;
    }
}
