class Solution {
    public String removeStars(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}