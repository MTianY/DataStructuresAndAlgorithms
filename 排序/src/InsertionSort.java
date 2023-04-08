public class InsertionSort<E extends Comparable> extends Sort<E> {
    @Override
    protected void sort() {
        for (int beigin = 1; beigin < array.length; beigin++) {
            int curIndex = beigin;
             while(curIndex > 0 && cmp(curIndex, curIndex-1) < 0) {
                 swap(beigin, beigin-1);
                 curIndex--;
             }
        }
    }
}
