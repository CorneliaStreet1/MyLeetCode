package Hot100.Medium;

public class longestPalindrome5 {
    /*
    我自己的中心扩散，只能找出长度为奇数的最长子串。
    实际上的中心扩散:
    从每一个位置出发，向两边扩散即可。
    遇到不是回文的时候结束。举个例子，acdbbdaa 我们需要寻找从第一个 b（位置为 3）出发最长回文串为多少。怎么寻找？
    首先往左寻找与当前位置相同的字符，直到遇到不相等为止。
    然后往右寻找与当前位置相同的字符，直到遇到不相等为止。
    最后左右双向扩散，直到左和右不相等。
    for (int i = 0; i < strLen; i++) {
        left = i - 1;
        right = i + 1;
        while (left >= 0 && s.charAt(left) == s.charAt(i)) {
            len++;
            left--;
        }
        while (right < strLen && s.charAt(right) == s.charAt(i)) {
            len++;
            right++;
        }
        while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
            len = len + 2;
            left--;
            right++;
        }
        if (len > maxLen) {
            maxLen = len;
            maxStart = left;
        }
        len = 1;
    }
    * */
    public String My_longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int CurrentPos1 = 0, CurrentOffset1 = 0;
        for (int i = 0; i < s.length(); i++) {
            int offset = 0;
            while (i - offset >= 0 && i + offset < s.length()) {
                if (chars[i + offset] == chars[i - offset]) {
                    offset++;
                } else {
                    break;
                }
            }
            offset--;//跳出循环的时候Offset指针要么会指向chars[s.length()],要么指向chars[-1],要么指向非对称的字符,无论哪种情况都需要回退一个字符.
            if (offset > CurrentOffset1) {
                CurrentOffset1 = offset;
                CurrentPos1 = i;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int offset = 0;
            if (i + 1 < s.length() && chars[i] == chars[i + 1]) {
                while (i - offset >= 0 && i + offset + 1 < s.length()) {
                    if (chars[i + offset + 1] == chars[i - offset]) {
                        offset++;
                    } else {
                        break;
                    }
                }
                offset--;//跳出循环的时候Offset指针要么会指向chars[s.length()],要么指向chars[-1],要么指向非对称的字符,无论哪种情况都需要回退一个字符.
                if (offset > CurrentOffset1) {
                    CurrentOffset1 = offset;
                    CurrentPos1 = i;
                }
            }
        }
        return String.copyValueOf(chars, CurrentPos1 - CurrentOffset1, 2 * CurrentOffset1 + 1);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int Start = 0, End = 0;
        char[] chars = s.toCharArray();
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < chars.length; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                isPalindrome[i][i + 1] = true;
                Start = i;
                End = i + 1;
            }
        }
/*    for (int i = 0; i < chars.length; i ++) {
        for (int j = i + 2; j < chars.length; j ++) {
        这样是不行的，因为计算isPalindrome[i][j]的时候会用到isPalindrome[i + 1][j - 1]，而如果按照我们的计算顺序，这样计算是一行一行的计算的，
        先算第i行,再算第i+1行，但是我们计算isPalindrome[i][j]，就已经会用到我们还没有计算的第i+1行的数据，所以这样不行。
        最好还是按照子串长度来枚举
            if (isPalindrome[i + 1][j - 1] && chars[i] == chars[j]) {
                isPalindrome[i][j] = true;
            }
        }
    }*/
        for (int Len = 3; Len <= chars.length; Len++) {//枚举长度
            //对于每个长度Len，讨论其不同的起始位置
            for (int st = 0; st < chars.length; st++) {
                int ed = st + Len - 1;//其终止位置可以根据长度和起始位置计算出来
                if (ed > chars.length - 1) {
                    break;
                }
                if (isPalindrome[st + 1][ed - 1] && chars[st] == chars[ed]) {
                    //Len不能从2开始，因为假如从2开始，那么去掉st和ed之后子串空掉了。这时候从isPalindrome[st + 1][ed - 1]查到的是这个矩阵主对角线以下的错误数据
                    isPalindrome[st][ed] = true;
                    Start = st;
                    End = ed;
                }
            }
        }
/*    for (int i = 0; i < isPalindrome.length; i ++) {
        for (int j = i; j < isPalindrome.length; j ++) {
            if (isPalindrome[i][j]) {
                if (j - i + 1 > End - Start + 1 ) {
                    End = j;
                    Start = i;
                }
            }
        }
    }*/
        return s.substring(Start, End + 1);
    }

    public static void main(String[] args) {
        System.out.println((new longestPalindrome5().longestPalindrome("aaaaa")));
    }


}
