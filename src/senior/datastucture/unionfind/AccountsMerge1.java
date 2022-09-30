package senior.datastucture.unionfind;

import java.util.*;

/**
 * 1070 · 账户合并
 *
 * https://www.lintcode.com/problem/1070/?fromId=178&_from=collection
 *
 * 给定一个帐户列表，每个元素accounts [i]是一个字符串列表，其中第一个元素accounts [i] [0]是账户名称，其余元素是这个帐户的电子邮件。
 * 现在，我们想合并这些帐户。
 * 如果两个帐户有相同的电子邮件地址，则这两个帐户肯定属于同一个人。
 * 请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为两个不同的人可能会使用相同的名称。
 * 一个人可以拥有任意数量的账户，但他的所有帐户肯定具有相同的名称。
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按字典序排序后的电子邮件。
 * 帐户本身可以按任何顺序返回。
 *
 * 输入:
 * 	[
 * 		["John", "johnsmith@mail.com", "john00@mail.com"],
 * 		["John", "johnnybravo@mail.com"],
 * 		["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 * 		["Mary", "mary@mail.com"]
 * 	]
 *
 * 	输出:
 * 	[
 * 		["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 * 		["John", "johnnybravo@mail.com"],
 * 		["Mary", "mary@mail.com"]
 * 	]
 *
 * 	解释:
 * 	第一个第三个John是同一个人的账户，因为这两个账户有相同的邮箱："johnsmith@mail.com".
 * 	剩下的两个账户分别是不同的人。因为他们没有和别的账户有相同的邮箱。
 *
 * 	你可以以任意顺序返回结果。比如：
 *
 * 	[
 * 		['Mary', 'mary@mail.com'],
 * 		['John', 'johnnybravo@mail.com'],
 * 		['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']
 * 	]
 * 	也是可以的。
 *
 */
public class AccountsMerge1 {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add("john_newyork@mail.com");
        accounts.add(account1);

        List<String> account2 = new ArrayList<>();
        account2.add("John");
        account2.add("johnsmith@mail.com");
        account2.add("john00@mail.com");
        accounts.add(account2);


        List<String> account3 = new ArrayList<>();
        account3.add("Mary");
        account3.add("mary@mail.com");
        accounts.add(account3);

        List<String> account4 = new ArrayList<>();
        account4.add("John");
        account4.add("johnnybravo@mail.com");
        accounts.add(account4);

        List<List<String>> results =  accountsMerge(accounts);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        initUnionFind(accounts.size());
        Map<String, Set<Integer>> emailToIds = getEmailToIds(accounts);
        for (Map.Entry<String, Set<Integer>> entry: emailToIds.entrySet()) {
            Set<Integer> ids = entry.getValue();
            Iterator<Integer> iterator = ids.iterator();
            Integer root_id = iterator.next();
            while (iterator.hasNext()){
                union(iterator.next(), root_id);
            }
        }
        Map<Integer, Set<String>> idToEmails = getIdToEmails(accounts);
        List<List<String>> results = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry: idToEmails.entrySet()) {
            List<String> result = new ArrayList<>();
            int usrId = entry.getKey();
            result.add(accounts.get(usrId).get(0));
            Set<String> emails = entry.getValue();
            emails.stream().sorted();
            result.addAll(emails);
            results.add(result);
        }
        return results;
    }

    private static Map<Integer, Set<String>> getIdToEmails(List<List<String>> accounts){
        Map<Integer, Set<String>> idToEmails = new HashMap<>();
        for (int useId = 0; useId < accounts.size(); useId++) {
            int root_id = find(useId);
            Set<String> emailSet = idToEmails.getOrDefault(root_id, new HashSet<>());
            List<String> account = accounts.get(useId);
            for (int i = 1; i < account.size(); i++) {
                emailSet.add(account.get(i));
            }
            idToEmails.put(root_id, emailSet);
        }
        return idToEmails;
    }

    private static Map<String, Set<Integer>> getEmailToIds(List<List<String>> accounts){
        Map<String, Set<Integer>> emailToIds = new HashMap<>();
        for (int use_id = 0; use_id < accounts.size(); use_id++) {
            List<String> account = accounts.get(use_id);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                Set<Integer> set = emailToIds.getOrDefault(email, new HashSet<>());
                set.add(use_id);
                emailToIds.put(email, set);
            }
        }
        return emailToIds;
    }

    static int[] father = null;
    private static void initUnionFind(int accountsLength){
        father = new int[accountsLength];
        for (int i = 0; i < accountsLength ; i++) {
            father[i] = i;
        }
    }

    private static void union(int a, int b){
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b){
            father[root_a] = root_b;
        }
    }

    private static int find(int x){
        int j = x;
        List<Integer> path = new ArrayList<>();
        while (j != father[j]){
            j = father[j];
            path.add(j);
        }
        for (Integer cur: path) {//压缩路径
            father[cur] = j;
        }
        return j;
    }


}
