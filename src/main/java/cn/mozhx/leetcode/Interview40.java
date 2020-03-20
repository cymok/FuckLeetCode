package cn.mozhx.leetcode;

import java.util.*;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Interview40 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 1, 5, 2, 0, 3, 6};
        int k = 3;
        int[] leastNumbers = new Interview40().getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(leastNumbers));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        //Arrays.sort 排序
        Arrays.sort(arr);
        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        //利用 Collection 排序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        List<Integer> queue = new ArrayList<>();
        for (int i : arr) {
            queue.add(i);
        }
        int[] result = new int[k];
        int index = 0;
        for (Integer integer : queue) {
            result[index++] = integer;
            if (index == k) {
                break;
            }
        }
        return result;
    }

}
