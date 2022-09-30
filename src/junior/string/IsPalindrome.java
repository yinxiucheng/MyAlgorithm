package junior.string;

/**
 * https://leetcode.cn/problems/XltzEq/
 *
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 本题中，将空字符串定义为有效的 回文串 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 */
public class IsPalindrome {

    public static void main(String[] args) {
        char c = '3';
        char compare = Character.toLowerCase(c);
        System.out.print( "toLowerCase " + c + " is " + compare);
    }

    public boolean  isPalindrome(String s){
        int n = s.length();
        int i = 0, j = n - 1;
        while ( i < j){
            while (i < j && !isValidChart(s.charAt(i))) i++;

            while (i < j && !isValidChart(s.charAt(j))) j--;

            if (i < j){
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isValidChart(char c){
       return  Character.isLetterOrDigit(c);
    }
}
