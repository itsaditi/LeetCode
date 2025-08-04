// Last updated: 8/4/2025, 4:50:46 PM
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmail = new HashSet<>();

        for (String email: emails) {
            uniqueEmail.add(validEmail(email));
        }

        return uniqueEmail.size();
    }

    private String validEmail(String email) {
        String res = "";
        String[] splitArr = email.split("@");
        String domainName = splitArr[splitArr.length - 1];

        String localName = splitArr[0];
        for (int i = 0; i < localName.length() ; i++) {
            if (localName.charAt(i) == '+') {
                break;
            } else if (localName.charAt(i) != '.') {
                res += localName.charAt(i);
            }
        }

        return res + '@' + domainName;
    }
}