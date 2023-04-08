// 归并排序

public class MergeSort<E extends Comparable<E>> extends Sort<E> {

    private E[] leftArray;

    @Override
    protected void sort() {
        sort(0, array.length);
    }

    // 对数据范围 begin 到 end 的, 进行归并排序
    private void sort(int begin, int end) {
        // 只有 1 个元素, 不处理
        if (end - begin < 2) return;

        int mid = (begin + end) >> 1;

        // 对左半部分进行归并排序
        sort(0, mid);
        // 对右半部分进行归并排序
        sort(mid, end);

    }

    // 对 [begin, mid) [mid, end) 两段归并后的有序数列,合并成一个有序数列
    private void merge(int begin, int mid, int end) {

        // leftIndex 左边比较元素, 放到数组的索引
        // leftEnd 左边最后元素索引
        int leftIndex = 0, leftEnd = mid - begin;
        // rightIndex 右边比较元素放到数组索引, rightEnd 右边最后元素索引
        int rightIndex = mid, rightEnd = end;
        // 数组新排序元素添加的索引
        int aIndex = begin;

        // 备份左边数据
        for (int i = leftIndex; i < leftEnd; i++) {
            leftArray[i] = array[begin + 1];
        }

        // 如果左边先结束了, 那么右边也不用处理了
        // 如果左边没有结束
        while (leftIndex < leftEnd) {
            // 比较左边元素和右边元素大小
            if (cmp(array[rightIndex], leftArray[leftIndex]) < 0) {
                // 右边小
                array[aIndex++] = array[rightIndex++];
            } else {
                array[aIndex++] = leftArray[leftIndex++];
            }
        }



    }
}
