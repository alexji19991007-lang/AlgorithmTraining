package Class11BestFSAndDFS2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsets2 {
    public List<String> subSets(String set) {
        
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        // 为什么要 sort
        // 因为：{a a b b c}
        // 这样 duplicate 才是 连续的，才能被 while 跳过
        Arrays.sort(array);
        helper(array, 0, new StringBuilder(), res);
        return res;
    }

    // Logic at each level:
    // 1. Choose --> append the letter at the current level (i.e. index)
    // 2. Not choose --> skip all the duplicates of the character at the current level (i.e. index)
    public void helper(char[] array, int index, StringBuilder sb, List<String> res) {
        if (index == array.length) {
            res.add(sb.toString());
            return;
        }
        // Case 1: choose array[index].
        sb.append(array[index]);
        helper(array, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
        // If you do not choose the current letter, then skip all such letters
        // For example: a (index 0), a (index 1), b (index 2)
        // If you don't choose a at index 0, you must directly jump to b at index 2
        // This is to avoid generating duplicate subsets
        while (index < array.length - 1 && array[index] == array[index + 1]) {
            index++;
        }
        // Case 2: not choose array[index].
        helper(array, index + 1, sb, res);
    }
}
