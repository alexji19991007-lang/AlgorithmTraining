package Class9String1;

public class AsciiOperations {
    public static void main(String[] args) {
        // character转换ASCII码
        // 在 Java 中，char 本质上是 整数（UTF-16 编码），所以可以直接转换成 int。
        char c1 = 'A';
        int ascii1 = (int)c1;
        System.out.println(ascii1);

        // 同理，ascii码也可以被cast成他所对应的character
        int ascii2 = 97;
        char c2 = (char)ascii2;
        System.out.println(c2);

        // 因为 char 本质是数字，所以可以做数学运算。
        char c3 = 'a';
        char c3Next = (char)(c3 + 1);
        System.out.println(c3Next);

        // 判断字符是不是数字
        System.out.println(isDigit('5'));  // true
        System.out.println(isDigit('a'));  // false

        // 判断字符是不是字母
        System.out.println(isLetter('5'));  // false
        System.out.println(isLetter('a'));  // true

        // 大写转小写（ASCII技巧）--> 'a' - 'A' = 32
        System.out.println(toLowerCase('A')); // a
        System.out.println(toLowerCase('Z')); // z

        // 计算字符距离（常见算法题）
        int diff = 'd' - 'a';
        System.out.println(diff);

        // 字符转数组索引（算法题最常用）常用于：counting array, frequency table, hash table
        char c4 = 'c';
        int index = c4 - 'a';
        System.out.println(index);
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 32);
        }
        return c;
    }
}
