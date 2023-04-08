import java.text.DecimalFormat;

// <E extents Comparable> 表示泛型 E 必须具备可比较性
public abstract class Sort<E extends Comparable> implements Comparable<Sort<E>> {

    protected E[] array;
    private int cmpCount; // 记录比较次数
    private int swapCount;// 记录交换次数
    private long time;

    @Override
    public int compareTo(Sort<E> o) {
        int result = (int)(time - o.time);
        if (result != 0) return result;

        result = cmpCount - o.cmpCount;
        if (result != 0) return result;

        return swapCount - o.swapCount;
    }

    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(E[] array) {
        if (array == null || array.length < 2) return;
        this.array = array;

        // 时间
        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;

    }

    protected abstract void sort();

    private String numString(int number) {
        if (number < 10000) return "" + number;
        if (number < 100000000) return fmt.format(number / 10000.0) + "万";
        return fmt.format(number / 100000000.0) + "亿";
    }

    /**
     * 比较两个索引处元素大小
     * @param index1 索引 1
     * @param index2 索引 2
     * @return 0 表示相等, 小于0 表示 index1<index2. 大于0 表示 index1>index2
     */
    protected int cmp(int index1, int index2) {
        cmpCount++;
        return array[index1].compareTo(array[index2]);
    }

    /**
     * 比较元素
     * @param value1
     * @param value2
     * @return
     */
    protected int cmp(E value1, E value2) {
        cmpCount++;
        return value1.compareTo(value2);
    }

    /**
     * 交换两个索引位置的元素
     * @param index1 索引 1
     * @param index2 索引 2
     */
    protected void swap(int index1, int index2) {
        swapCount++;
        E tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    @Override
    public String toString() {
        String timeStr = "耗时: " + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较: " + numString(cmpCount);
        String swapCountStr = "交换: " + numString(swapCount);
        String stableStr = "稳定性: " + isStable();
        return "【" + getClass().getSimpleName() + "】\n"
                + stableStr + "\t"
                + timeStr + "\t"
                + compareCountStr + "\t"
                + swapCountStr + "\n"
                + "-----------------------------------";
    }

    boolean isStable() {
        return true;
    }

}
