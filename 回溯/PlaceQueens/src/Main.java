public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Main().placeQueens(4);
    }

    /**
     * 数组. 索引是行号, 元素是列号
     */
    int[] cols;

    /**
     * 多少种摆法
     */
    int ways;

    /**
     * 八皇后问题:
     *
     * 在 8*8 的棋盘上,摆放八个皇后, 不能互相攻击. 任意两个皇后不能处于同一行、同一列或同一斜线上. 请问多少种摆法
     */

    /**
     * 摆放 n 个皇后
     * @param n 皇后个数
     */
    void placeQueens(int n) {
        if (n < 1) return;
        // 初始化, 数组容量同 n
        cols = new int[n];
        // 默认先从第 0 行开摆
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    /**
     * 往行上摆放皇后
     * @param row 第几行
     */
    void place(int row) {

        if (row == cols.length) {
            ways++;
            show();
            return;
        }

        // 按行 row 摆放, 那么每行有 n 种选择(几皇后就几种选择)
        for (int col = 0; col < cols.length; col++) {
            // 是否可以摆放棋子
            if (isVaild(row, col)) {
                // 往第 row 行, 第 col 列上摆放棋子
                cols[row] = col;
                // 摆放下一行
                place(row + 1);
            }
        }
    }

    /**
     * 剪枝处理, 判断第 row 行, 第 col 列是否可以摆放棋子
     * @param row 行数
     * @param col 列数
     * @return 棋子摆放合法性判断
     */
    boolean isVaild(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 第 col 列已经摆放过
            if (cols[i] == col) {
                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
            // 第 i 行的皇后跟第 row 行,第 col 列的格子在同一个斜线上.
            if (row - i == Math.abs(col - cols[i])) {
                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
        }
        System.out.println("[" + row + "][" + col + "]=true");
        return true;
    }

    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print("1" + "  ");
                } else {
                    System.out.print("0" + "  ");
                }
            }
            System.out.println();
        }
        System.out.println("======================");
    }

}