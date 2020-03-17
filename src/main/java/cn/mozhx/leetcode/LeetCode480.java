package cn.mozhx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 480. 滑动窗口中位数
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * <p>
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * <p>
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 */
public class LeetCode480 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] arr = new LeetCode480().medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 提交没通过
     */
    public double[] medianSlidingWindow1(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        List<Integer> tempList = new ArrayList<>();
        for (int num : nums) {
            tempList.add(num);
        }
        //从窗口结束位置索引遍历 顺便可以读到窗口数组 降低时间复杂度
        for (int screenEndIndex = k - 1; screenEndIndex < nums.length; screenEndIndex++) {

            //初始化窗口值
            int startIndex = screenEndIndex - k + 1;
            //subList是处理视图 需要一个新集合

            List<Integer> list = new ArrayList<>(tempList).subList(startIndex, screenEndIndex + 1);
            //排序
            Collections.sort(list);

            //中位数
            double v;
            if (k % 2 != 0) {
                v = list.get(list.size() / 2);
            } else {
                v = (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) >> 1;
            }
            result[screenEndIndex - k + 1] = v;

        }
        return result;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        double[] screenArr = new double[k];
        //从窗口结束位置索引遍历
        for (int i = k - 1; i < nums.length; i++) {
            //初始化窗口值
            for (int j = 0; j < screenArr.length; j++) {
                screenArr[j] = nums[i - k + 1 + j];
            }
            //排序
            Arrays.sort(screenArr);
            //中位数
            double v;
            if (k % 2 != 0) {
                v = screenArr[screenArr.length / 2];
            } else {
                v = (screenArr[screenArr.length / 2 - 1] + screenArr[screenArr.length / 2]) / 2;
            }
            result[i - k + 1] = v;
        }
        return result;
    }
}
