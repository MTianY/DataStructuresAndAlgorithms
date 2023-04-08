public class Main {
    public static void main(String[] args) {
//        int cs = climbStairs(4);
//        System.out.println();
        hano(3, "A","B","C");
    }

    // 爬楼梯
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n-1) + climbStairs(n -2);
    }

    public static int climbStairs2(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    /**
     * 汉诺塔
     * @param n 将 n 个盘子从 A 移到 C, 要求小的一直在上
     * @param p1
     * @param p2
     * @param p3
     */
    static void hano(int n, String p1, String p2, String p3) {
        if (n == 1) {
            move(n, p1, p3);
            return;
        }
        // 先将 n-1 个盘子由 A 移到 B, 那么起点p1, 终点p2
        hano(n-1,p1, p3, p2);
        move(n, p1, p3);
        hano(n-1, p2, p1, p3);
    }

    static void move(int no, String from, String to) {
        System.out.println("将" + no +"号盘子从" + from + "移动到" + to);
    }

}
