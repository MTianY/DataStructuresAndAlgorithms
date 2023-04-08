public class QuickSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    /**
     * 对 [begin, end) 范围内的元素进行快速排序
     * @param begin 序列开始位置
     * @param end 序列长度.
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;

        // 确定轴点元素位置
        int mid = pivotIndex(begin,end);

        // 对左侧子序列进行快速排序
        sort(begin, mid);
        // 对右侧子序列进行快速排序
        sort(mid+1, end);

    }

    private int pivotIndex(int begin, int end) {

        // 随机选择一个元素跟 begin 位置元素进行交换. 为了降低轴点左右两侧分布极度不均匀的情况出现
        swap(begin, begin + (int)(Math.random() * (end - begin)));

        //  假设取 begin 位置元素当做轴点, 备份 begin 位置元素.
        E pivot = array[begin];
        // end 之前是数组长度, 现指向数组最后一个元素位置
        end--;

        // 当 begin 和 end 重合之后, 构造轴点位置结束. 所以循环时要 begin < end
        while (begin < end) {

            while (begin < end) {
                // 轴点元素和 end 位置元素比较, 如果 end 元素大时, 则 end--. 元素不动, 本来就在右边
                if (cmp(pivot, array[end]) < 0) {
                    end--;
                } else {
                    // end 位置元素小于轴点元素, 覆盖 begin 位置元素, begin++
                    array[begin++] = array[end];
                    // 这里结束循环, 是因为要改变扫描方向, 从 begin 处开始往右扫描了
                    break;
                }
            }

            while (begin < end) {
                // 轴点元素比 begin 位置元素大, 元素不动, begin++
                if (cmp(pivot, array[begin]) > 0) {
                    begin++;
                } else {
                    // 轴点元素比 begin 元素小, 放到轴点元素右侧,覆盖 end 位置元素, end--
                    array[end--] = array[begin];
                    // 结束循环, 掉头,从 end 开始扫描, 指向上面的 while 循环
                    break;
                }
            }

        }

        // 将轴点元素放入最终的位置
        array[begin] = pivot;

        // 返回轴点元素的位置. 此时 begin 和 end 已经重合, 返回谁都可以
        // 这里只会有 begin == end 的情况, 不会有 begin > end 的情况
        return begin;

    }

}
