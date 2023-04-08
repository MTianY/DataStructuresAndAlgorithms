// 插入排序优化, 利用二分搜索, 减少比较次数

public class InsertionSort3<E extends Comparable<E>> extends Sort<E> {

    // 0  1  2  3   4   5   6   7   8   9
    // 4, 1, 4, 19, 29, 9, 331, 44, 241
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            E v = array[begin]; // 取出备份
            int insertIndex = search(begin);

            // 挪动元素
            for (int i = begin; i > insertIndex; i--) {
                array[i] = array[i-1];
            }
            array[insertIndex] = v;    // 赋值
        }
    }

    // 利用二分查找找到 index位置元素 待插入的位置
    // 左边是已经排好序不分, 右边是待排序部分.已经排好序的索引, [0, index)
    private int search(int index) {
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(array[index], array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

}
