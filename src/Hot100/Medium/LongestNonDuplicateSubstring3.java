package Hot100.Medium;

import java.util.HashSet;
import java.util.Set;

/*
* 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
* */
public class LongestNonDuplicateSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int maxLength = 1;
        int Start = 0, End = 0;//枚举子串的起始位置和结束位置
        Set<Character> OccurredChar = new HashSet<>();
        OccurredChar.add(chars[Start]);
        while (Start < s.length()) {
            End++;
            while (End < s.length()) {
                if (OccurredChar.add(chars[End])) {
                    if (maxLength < (End - Start + 1)) {
                        maxLength = End - Start + 1;
                    }
                    End++;
                } else {
                    End--;//End当前指向的字符是重复的，将End回退一步
                    break;
                }
            }
            OccurredChar.remove(chars[Start]);//Start右移的时候要将Start右移前指向的字符从集合中去除2
            Start++;
        }
        return maxLength;
    }

    public int DP_lengthOfLongestSubstring(String s) {
        int m = s.length();
        if(m==0) {
            return 0;
        }
        int num =1;  //初始值表示以s的第一个字符为结束的不重复的最长子串
        int max =1;
        for(int i=1;i<m;i++){
            char c = s.charAt(i);
            int index = s.indexOf(c ,i-num);
            if(index<i) {  //num更新，表示以s的第i+1个字符为结束的不重复的最长子串
                num = i-index;
            } else {
                num = num+1;
            }
            max = Math.max(max,num);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println((new LongestNonDuplicateSubstring3()).DP_lengthOfLongestSubstring("pwwkew"));

    }
}
