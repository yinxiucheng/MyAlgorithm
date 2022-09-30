package junior.string;

import java.util.HashSet;
import java.util.Set;

public class AndCorrectEmail {

    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            int index = email.indexOf('@');
            String local = email.substring(0, index).split("\\+")[0];
            local = local.replace(".", "");
            emailSet.add(local + email.substring(index));
        }
        return emailSet.size();
    }
}
