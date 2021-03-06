package algorithm;

public class Decodingnums {

    /**
     上楼梯的复杂版？
     如果连续的两位数符合条件，就相当于一个上楼梯的题目，可以有两种选法：
     1.一位数决定一个字母
     2.两位数决定一个字母
     就相当于dp(i) = dp[i-1] + dp[i-2];
     如果不符合条件，又有两种情况
     1.当前数字是0：
     不好意思，这阶楼梯不能单独走，
     dp[i] = dp[i-2]
     2.当前数字不是0
     不好意思，这阶楼梯太宽，走两步容易扯着步子，只能一个一个走
     dp[i] = dp[i-1];

     */

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0)
                dp[i] += dp[i - 1];
            if (s.charAt(i - 2) == '0')
                continue;
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
