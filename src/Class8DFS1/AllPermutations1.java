package Class8DFS1;

import java.util.ArrayList;
import java.util.List;

// Given a string with no duplicate characters, return a list with all permutations of the characters.
// Assume that input string is not null.

// Examples
// Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
// Set = "", all permutations are [""]


//DFS 基本⽅法：
// 1. What does it store on each level? 
//    - three levels, each level represents one position
// 2. How many different states should we try to put on this level?
//    - remaining unused letter

public class AllPermutations1 {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        if (set.length() == 0) {
            res.add("");
            return res;
        }
        char[] charList = set.toCharArray();
        findPermutations(charList, 0, res);
        return res;
    }

    private void findPermutations(char[] charList, int index, List<String> res) {
        if (index == charList.length - 1) {
            res.add(new String(charList)); // 只有leaf node才是答案
            return;
        }
        // 不能从0开始，因为index以前的数字都已经确认位置了，只有index后面的数字（包括自己）才可以变动
        for (int i = index; i < charList.length; i++) {
            swap(charList, index, i); // set
            findPermutations(charList, index + 1, res);
            swap(charList, index, i); // unset
        }
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
