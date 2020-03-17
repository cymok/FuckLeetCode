package cn.mozhx.leetcode;

import java.util.*;

/**
 * 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 */
public class LeetCode1160 {
    public static void main(String[] args) {
//        String[] words = {"cat", "bt", "hat", "tree"};
//        String chars = "atach";
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        int len = new LeetCode1160().countCharacters(words, chars);
        System.out.println(len);
    }

    public int countCharacters(String[] words, String chars) {

        //返回值 长度之和
        int countLen = 0;

        //遍历词汇表
        for (String word : words) {

            //字母表初始化临时队列
            char[] charsArr = chars.toCharArray();
            List<Character> tempList = new ArrayList<>();
            for (char c : charsArr) {
                tempList.add(c);
            }

            //记录匹配的长度
            int len = 0;

            //遍历词汇表
            word:
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                //遍历字母表
                Iterator<Character> iterator = tempList.iterator();
                while (iterator.hasNext()) {
                    Character character = iterator.next();
                    if (c == character) {
                        //找到有 则移除
                        iterator.remove();
                        //然后继续遍历
                        len++;
                        continue word;
                    }
                }
            }

            //全匹配上
            if (len == word.length()) {
                countLen += word.length();
            }
        }
        return countLen;
    }
}
