public class InsertionSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int beigin = 1; beigin < array.length; beigin++) {
            int cur = beigin;
            E v = array[cur];   // 取出备份
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];    // 元素覆盖
                cur--;
            }
            array[cur] = v; // 赋值
        }
    }
}
