import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShellSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        List<Integer> stepSequence = shellStepSequence();
        for (Integer step : stepSequence) {
            sort(step);
        }
    }

    // 分成 step 列进行排序
    private void sort(int step) {
        // 使用插入排序
        // col 第几列
        for (int col = 0; col < step; col++) {

            // begin 从第二个元素开始, 第一个元素 col, 第二个 col+step, 第三个 col+2*step
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }

        }
    }

    // 希尔步长序列生成函数, 最坏时间复杂度 O(n²)
    private List<Integer> shellStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = array.length;
        while ((step >>= 1) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }

    // 另一个人的步长序列, 最坏时间复杂度 O(n^4/3)
    private List<Integer> sedgewickStepSequence() {
        List<Integer> stepSequence = new LinkedList<>();
        int k = 0, step = 0;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int)Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int)Math.pow(2, (k-1) >> 1);
                int pow2 = (int)Math.pow(2, (k+1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= array.length) break;
            stepSequence.add(0, step);
            k++;
        }
        return stepSequence;
    }

}
