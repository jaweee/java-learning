package com.jaweee.strings;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/17 14:57
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class AddStrings {

    public String addStrings(String num1, String num2){
        int n1 = num1.length() - 1, n2 = num2.length() - 1, step = 0;
        StringBuffer sb = new StringBuffer();
        while(n1 >= 0 || n2 >= 0 || step != 0) {
            // 不能再比较的时候进行--操作。
            int x = n1 >= 0 ? num1.charAt(n1--) - '0' : 0;
            int y = n2 >= 0 ? num2.charAt(n2--) - '0' : 0;
            int result = x + y + step;
            sb.append(result % 10);
            step = result / 10;
        }
        sb.reverse();
        return sb.toString();
    }
}
