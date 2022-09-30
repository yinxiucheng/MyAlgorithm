package junior.twopointer.samedirection;

/**
 * https://www.lintcode.com/problem/1870/description
 *
 * 给出一个只包含0或1的字符串str,请返回这个字符串中全为0的子字符串的个数
 */
public class CountZeroSubStr {
    /**
     * @param str: the string
     * @return: the number of substrings
     */
    public int stringCount(String str) {
        // Write your code here.
        if (null == str || str.length() == 0){
            return -1;
        }
        char[] chars = str.toCharArray();
        int j = 1;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                continue;
            }
            j = Math.max(j, i + 1);
            while (j < chars.length && chars[j] == '0'){
                j ++;
            }
            count += j - i;
        }
        return count;
    }
}
