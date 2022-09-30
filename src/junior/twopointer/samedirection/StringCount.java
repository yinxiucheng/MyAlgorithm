package junior.twopointer.samedirection;

/**
 * 1870 · 全零子串的数量
 *
 * 描述
 * 给出一个只包含0或1的字符串str,请返回这个字符串中全为0的子字符串的个数
 *
 */
public class StringCount {

    /**
     * @param str: the string
     * @return: the number of substrings
     */
    public int stringCount(String str) {
        if (null == str || str.length() == 0){
            return 0;
        }

        int j = 1;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0'){
                continue;
            }
            j = Math.max(j, i+ 1);
            while (j < str.length() && str.charAt(j) == '0'){
                j ++;
            }
            ans += j - i;
        }

        return ans;
    }
}
