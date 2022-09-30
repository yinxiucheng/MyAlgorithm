package junior.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/426/?fromId=161&_from=collection
 * 描述
 * 给一个由数字组成的字符串。求出其可能恢复为的所有IP地址。
 *
 * (你的任务就是往这段字符串中添加三个点, 使它成为一个合法的IP地址. 返回所有可能的IP地址.)
 */
public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        List<String> ipItem = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12)
            return results;

        dfs(s, 0, ipItem, results);
        return results;
    }

    private void dfs(String s, int startIndex, List<String> subSet, List<String> results){
        if (subSet.size() == 4){
            if (startIndex != s.length()){
                return;
            }
            String ipAddress = getIpAddress(subSet);
            results.add(ipAddress);
            return;
        }
        if (subSet.size() > 4){
            return;
        }
        for (int i = startIndex; i < s.length() && i < startIndex + 3; i++) {
            String ipItem = s.substring(startIndex, i + 1);
            if (isvalid(ipItem)){
                subSet.add(ipItem);
                dfs(s, i+1, subSet, results);
                subSet.remove(subSet.size() - 1);
            }
        }
    }

    private String getIpAddress(List<String> subSet){
        StringBuilder builder = new StringBuilder();
        for (String ip: subSet) {
            builder.append(ip);
            builder.append(".");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private boolean isvalid(String s) {
        if (s.charAt(0) == '0')
            return s.equals("0"); 		// to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}
