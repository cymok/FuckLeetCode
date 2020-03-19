package cn.mozhx.leetcode;

import java.util.*;

/**
 * 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * asteroids = [5, 10, -5]
 * 输出: [5, 10]
 * 解释:
 * 10 和 -5 碰撞后只剩下 10。 5 和 10 永远不会发生碰撞。
 * 示例 2:
 * <p>
 * 输入:
 * asteroids = [8, -8]
 * 输出: []
 * 解释:
 * 8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3:
 * <p>
 * 输入:
 * asteroids = [10, 2, -5]
 * 输出: [10]
 * 解释:
 * 2 和 -5 发生碰撞后剩下 -5。10 和 -5 发生碰撞后剩下 10。
 * 示例 4:
 * <p>
 * 输入:
 * asteroids = [-2, -1, 1, 2]
 * 输出: [-2, -1, 1, 2]
 * 解释:
 * -2 和 -1 向左移动，而 1 和 2 向右移动。
 * 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
 * 说明:
 * <p>
 * 数组 asteroids 的长度不超过 10000。
 * 每一颗行星的大小都是非零整数，范围是 [-1000, 1000] 。
 */
public class LeetCode735 {

    public static void main(String[] args) {
        int[] asteroids = new int[]{-5, -2, 10, -5};
        long startTime = System.currentTimeMillis();
        int[] asteroidCollision = new LeetCode735().asteroidCollision(asteroids);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(asteroidCollision));
        System.out.println("time = " + (endTime - startTime));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        collision:
        for (int newAsteroid : asteroids) {
            //尝试入栈
            //非栈空 或 new与top相向 则先循环判断 否跳过循环判断而直接入栈
            while (!stack.isEmpty() && newAsteroid < 0 && stack.peek() > 0) {
                //abs(new) > abs(top)
                if (-newAsteroid > stack.peek()) {
                    //top毁 即出栈
                    stack.pop();
                    //继续进入循环尝试碰撞 若比stack里的各个值都大 会结束while循环最后入栈
                    continue;
                }
                //abs(new) == abs(top)
                else if (-newAsteroid == stack.peek()) {
                    //同归于尽 即出栈 且不再循环判断 next one
                    stack.pop();
                }
                //abs(new) <= abs(top)
                //new已毁 直接继续for循环 next one
                continue collision;
            }
            //栈空 或abs(new) 比stack里的各个值都大 或背向
            stack.push(newAsteroid);
        }

        int[] result = new int[stack.size()];

/*
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
*/

        int index = 0;
        for (Integer value : stack) {
            result[index++] = value;
        }

        return result;
    }
}
