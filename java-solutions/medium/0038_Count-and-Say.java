class Solution {
    public String countAndSay(int n) {
        if (n==1) return "1";
        return say(countAndSay(n-1));
    }
    
    private String say(String s) {
        String res = "";
        char num = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == num) {
                count += 1;
            } else {
                res += Integer.toString(count) + num;
                num = s.charAt(i);
                count = 1;
            }
        }
        if (res.length() == 0 || res.charAt(res.length() - 1) != num)
            res += Integer.toString(count) + num;
        return res;
    }
}
