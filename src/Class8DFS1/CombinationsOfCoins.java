package Class8DFS1;

import java.util.ArrayList;
import java.util.List;

// Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the 
// possible ways to pay a target number of cents.

// Arguments
// coins - an array of positive integers representing the different denominations of coins, there are no duplicate 
//         numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
// target - a non-negative integer representing the target number of cents, eg. 99

// Assumptions
// coins is not null and is not empty, all the numbers in coins are positive
// target >= 0
// You have infinite number of coins for each of the denominations, you can pick any number of the coins.

// Return
// a list of ways of combinations of coins to sum up to be target.
// each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.

// Examples
// coins = {2, 1}, target = 4, the return should be
// [
//   [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
//   [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
//   [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
// ]

// Think with this more generic example:
// E.g. total value n = 99 cents
//      coin value(币值) ＝ 25 10 5 1 cent
//      e.g. one possible way:
//      3 x 25 cents
//      2 x 10 cents
//      0 x 5 cents
//      4 x 1 cents

// DFS 基本⽅法1：
// 1. what does it store on each level? 
//    - 99 levels, we take out 1 coin at a time
// 2. How many different states should we try to put on this level?
//    - 4 branches (try)
// Time = 4^99 --> stack overflow

// DFS 基本⽅法2：
// 1. what does it store on each level?
//    - 4 levels, and for each level, we consider one coin value
// 2. How many different states should we try to put on this level?
//    - dynamically changing
public class CombinationsOfCoins {
    public static List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        helper(target, coins, 0, solution, res);
        return res;
    }

    private static void helper(int remain, int[] coins, int index, List<Integer> solution, List<List<Integer>> res) {
        if (index == coins.length - 1) {
            if (remain % coins[index] == 0) {
                solution.add(remain / coins[index]); // 只有leaf node才是答案
                res.add(new ArrayList<>(solution)); // 一定要把当前的solution deep copy一份，不然之后solution变化的话，这个res里面已经存储的答案也会跟着改变
                solution.remove(solution.size() - 1);
            }
            return;
        }
        int maxUse = remain / coins[index];
        for (int i = 0; i <= maxUse; ++i) {
            solution.add(i);
            helper(remain - i * coins[index], coins, index + 1, solution, res);
            solution.remove(solution.size() - 1);
        }
    }

    // TC: O(n^m) --> n is target (the actual numeric value of target), m is how many types of coins we have
}
