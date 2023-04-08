import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        new Main().pirate();
        new Main().looseChange();

    }

    // 最优装载问题, 最大能装 30 斤古董, 每个古董都价值连城. 最多装多少件
    void pirate() {
        int[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
        Arrays.sort(weights);
        int capacity = 30, weight = 0, count = 0;

        for (int i = 0; i < weights.length && weight < capacity; i++) {
            int newWeight = weight + weights[i];
            if (newWeight <= capacity) {
                weight = newWeight;
                count++;
                System.out.println(weights[i]);
            }
        }
        System.out.println("共选了" + count + "种");
    }

    // 零钱兑换问题: 假设有 25 分,10 分,5 分,1 分的硬币,要找给客户 41 分的零钱,
    // 如何办到硬币个数最少
    void looseChange() {
        int[] moneys = {25, 8, 9, 15, 10, 5, 1};
        Arrays.sort(moneys);

        int capacity = 41 ,count = 0;

        for (int i = moneys.length - 1; i >= 0; i--) {
            if (capacity < moneys[i]) {
                continue;
            }
            System.out.println(moneys[i]);
            capacity -= moneys[i];
            count++;
            i = moneys.length;
        }
        System.out.println("个数" + count);
    }

}