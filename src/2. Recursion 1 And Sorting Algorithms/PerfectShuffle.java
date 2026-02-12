// Given an array of elements, reorder it as follow:
// { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
// { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

// Try to do it IN PLACE. 就是不要创建一个新的array，在原有的题目给你的array上面操作

// Assumptions
// The given array is not null
// Examples
// { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
// { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 } *** 请你用这个array来思考这个问题
// { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }

// 思路
// 就看{ 1, 2, 3, 4, 5, 6, 7, 8 }
// 
// 把原本的数组被分成：
// [0 1] [2 3] [4 5] [6 7]
// N1 N2 | N3 N4 | N5 N6 | N7 N8
// 目标是把：N3 N4 | N5 N6
// 变成： N5 N6 | N3 N4
// 第一步先把左半边 N3 N4 翻转变成 N4 N3
// 第二步把有半边 N5 N6 翻转变成 N6 N5
// 现在我们就有了 N4 N3 | N6 N5
// 然后把他们整体翻转 得到 N5 N6 | N3 N4
// 整体array变成N1 N2 | N5 N6 | N3 N4 | N7 N8
// 
// 以上同样的操作对 N1 N2 | N5 N6 以及 N3 N4 | N7 N8再做一遍 --> where recursion comes into play!!!
// 即可得到最终结果 N1 N5 | N2 N6 | N3 N7 | N4 N8
public class PerfectShuffle {
    public static int[] reorderArray(int[] array) {
        return array;
    }
}
