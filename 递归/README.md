# 递归

递归:

- 函数(方法)直接或者间接调用自身. 是一种常用的编程技巧

### 函数递归调用过程

```java
public static void main(String[] args) {
    sum(5);
}

private static int sum(int n) {
    if (n <= 1) return n;
    return n + sum(n - 1);
}
```


| 栈空间 | 调用过程 |
| :-- | :-- |
| sum. n = 1\. return 1 | n=1 结束递归, sum(1), 返回 sum(1), 该栈空间回收, 到下面 sum(2) |
| sum. n = 2\. return 2 + sum(1) | sum(2) = 2 + sum(1), 得到结果后, 栈空间回收, 到下面 sum(3) |
| sum. n = 3. return 3 + sum(2) | sum(3) = 3 + sum(2), 得到结果后, 栈空间回收, 到下面 sum(4) |
| sum. n = 4. return 4 + sum(3) | sum(4) = 4 + sum(3), 得到结果后, 栈空间回收, 到下面 sum(5) |
| sum. n = 5. return 5 + sum(4) | sum(5) = 5 + sum(4), 得到结果后, 栈空间回收, 返回结果 |
| main args | main 函数执行完毕, 栈空间回收 |


所以递归调用必须有一个明确的结束递归的条件(边 界条件、 递归基), 否则会栈内存溢出

### 空间复杂度计算:

递归调用的空间复杂度 = 递归深度 * 每次调用所需的辅助空间

## 尾调用

一个函数的最后一个动作是调用函数.

- 如果最后一个动作是调用自身, 称为尾递归. 是尾调用的特殊情况.






