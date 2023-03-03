package com.jaweee.dp;

import org.junit.jupiter.api.Test;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/3 14:52
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class LongestValidParenthesesTest {

    @Test
    public void longestValidParenteses() {
        LongestValidParentheses lv = new LongestValidParentheses();
        int len = lv.longestValidParentheses("");
        System.out.println("\"\"" + " 的最长有效括号长度为："+len);
        len = lv.longestValidParentheses("()(()");
        System.out.println("\"()(()\"" + " 的最长有效括号长度为：" + len);
        len = lv.longestValidParentheses("()(())");
        System.out.println("\"()(())\"" + " 的最长有效括号长度为：" + len);
        len = lv.longestValidParentheses(")()())()()(");
        System.out.println("\")()())()()(\"" + " 的最长有效括号长度为：" + len);
        len = lv.longestValidParentheses("(()(((()");
        System.out.println("\"(()(((()\"" + " 的最长有效括号长度为：" + len);
        len = lv.longestValidParentheses("(())(())");
        System.out.println("\"(())(())\"" + " 的最长有效括号长度为：" + len);

    }
}
