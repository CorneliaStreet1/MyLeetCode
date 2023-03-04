package Hot100.Medium;

import java.util.ArrayList;
import java.util.List;

/*
* 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
* */
public class generateParenthesis22 {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        //n = 1
        return null;
    }
    public List<String> BF_generateParenthesis(int n) {
        String[] n1 = {"()"};
        String[] n2 = {"()()", "(())"};
        String[] n3 = {"((()))","(()())","(())()","()(())","()()()"};
        return null;
    }
}
