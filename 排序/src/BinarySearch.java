// 二分搜索
public class BinarySearch {

    // 求出 value 在 array 中的索引
    public static int indexOf(int[] array, int value) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (value > array[mid]) {
                // 右
                begin = mid + 1;
            } else if (value < array[mid]) {
                // 左
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 查找 value 在有序数组 array 中待插入位置
    public static int search(int[] array, int value) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (value < array[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

}
