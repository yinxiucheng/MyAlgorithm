package junior.twopointer.merge;

/**
 * 1343 · 两字符串和
 *
 * https://www.lintcode.com/problem/1343/?fromId=161&_from=collection
 *
 * 描述
 * 给定两个仅含数字的字符串，你需要返回一个由各个位之和拼接的字符串
 *
 * 示例1:
 * 输入:
 * A = "99"
 * B = "111"
 * 输出: "11010"
 * 解释: 因为 9 + 1 = 10, 9 + 1 = 10, 0 + 1 = 1,连接之后的结果是 "11010"
 */
public class SumofTwoStrings {

    /**
     * @param a: a string
     * @param b: a string
     * @return: return the sum of two strings
     */
    public String sumofTwoStrings(String a, String b) {
        // write your code here
        String aRevers = reverse(a);
        String bRevers = reverse(b);
        StringBuffer result = new StringBuffer();
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < aRevers.length() && bIndex < bRevers.length()){
            int aInt = Integer.parseInt(aRevers.substring(aIndex, aIndex+1));
            int bInt = Integer.parseInt(bRevers.substring(bIndex, bIndex + 1));
            int sum = aInt + bInt;
            if (sum >= 10){
                result.append(reverse(String.valueOf(sum)));
            }else {
                result.append(sum);
            }
            aIndex ++;
            bIndex ++;
        }

        if (aIndex < aRevers.length()){
            result.append(aRevers.substring(aIndex));
        }

        if (bIndex < bRevers.length()){
            result.append(bRevers.substring(bIndex));
        }
        result = result.reverse();
        return result.toString();
    }

    private String reverse(String original){
        return new StringBuffer(original).reverse().toString();
    }

}
