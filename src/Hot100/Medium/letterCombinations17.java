package Hot100.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
* 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class letterCombinations17 {
    public List<String> letterCombinations(String digits) {
        Map<String, String> NumToLetter = new HashMap<>();
        NumToLetter.put("2", "abc");
        NumToLetter.put("3", "def");
        NumToLetter.put("4", "ghi");
        NumToLetter.put("5", "jkl");
        NumToLetter.put("6", "mno");
        NumToLetter.put("7", "pqrs");
        NumToLetter.put("8", "tuv");
        NumToLetter.put("9", "wxyz");
        //for (int i = )
        return null;
    }
}
