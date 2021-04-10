package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code02_String;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author qgp
 * @Date 2019/12/5 9:56
 **/
public class SwardOffer_String {
    /**
     * 【替换空格】
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < str.toString().length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                out.append("%20");
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }


    /**
     * 【正则表达式匹配】 19题
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     * 【思路】 递归解答
     * 1.模式中第二个字符不是*
     * 如果字符串中第一个字符与模式中第一个字符相匹配，那么两者都后移1个字符
     * 如果不匹配，返回false
     * 2.模式中第二个字符是*
     * （1）如果字符串中第一个字符与模式的第一个不匹配，那么模式向后移2个字符。 相当于忽略掉了 a* 代表0个
     * （2）如果匹配，可以有三种情况
     * - 字符串不移，模式移动2个字符。像 ab 与 a*ab 的情况
     * - 字符串移动1个字符，模式移动2个字符。像 abc 与 a*bc
     * - 字符串移动1个字符，模式不懂。因为*可以匹配多个前面的字符，像 aaabc与a*bc
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }
    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') { // 即 patternIndex != pattern.length
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }



    /**
     * 【字符流中第一个不重复的字符】 50题
     *    请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     *    当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     *    如果当前字符流没有存在出现一次的字符，返回#字符。
     * 【思路】
     *    利用map的键值对的特性，将 char 作为 key，出现的次数为 value。而 LinkedHashMap是有序的
     */
    //Insert one char from stringstream
    private Map<Character, Integer> linkedHashMap = new LinkedHashMap();
    public void Insert(char ch) {
        if (linkedHashMap.containsKey(ch)){
            linkedHashMap.put(ch,linkedHashMap.get(ch) + 1);
        } else {
            linkedHashMap.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character,Integer> set : linkedHashMap.entrySet()){
            if (set.getValue() == 1){
                return set.getKey();
            }
        }
        return '#';
    }


    /**
     * 【表示数值的字符串】
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */
    public boolean isNumeric(char[] str) {
        return false;
    }

    public boolean isNumeric2(char[] str) {
        //正则表达式解答
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
        /*
          正则说明：
          [\\+\\-]?   ->正或负符号出现与否
          \\d*        ->整数部分是否出现，如 -.34 或 +3.34 均符合
          (\\.\\d+)?  ->如果出现小数点，那么小数点后面必须有数字；否则一起不出现
          ([eE][\\+\\-]?\\d+)?     ->如果存在指数部分，那么e或E肯定出现，+或-可以不出现，紧接着必须跟着整数，或者整个部分都不出现。
         */
    }

}
