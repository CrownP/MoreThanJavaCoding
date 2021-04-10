package com.crownp.morethanjavacoding.Basics.java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author qgp
 * @Date 2019/11/8 14:02
 **/
public class LambdaAndStream {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();

        /**
         * 一、获取三个高卡路里的菜品的名字
         */
        List<String> threeHighCaloricDishNames = menu.stream()
                //筛选流
                .filter(Dish -> Dish.getCalories()>300)
                .map(Dish::getName)
                //截短流
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);



        /**
         * 二、foreach可以消费流中每一个元素
         */
        menu.stream().forEach(System.out::println);



        /**
         * 三、
         * 输入：String[] arrayOfWords = {"Goodbye", "World"};
         * 输出：一个字符流 ["H","e","l", "o","W","r","d"]
         */
        String[] arrayOfWords = {"Goodbye", "World"};
        List<String> words = Arrays.asList(arrayOfWords);
        List<String> uniqueCharacters =
                words.stream()
                        //将单词转换为由字母构成的数组
                        .map(w -> w.split(""))
                        //将各个生成流扁平化为一个流
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());


        /**
         * 四、
         * reduce操作
         * 累加操作
         */
        List<Integer> integerList = Arrays.asList(4,5,3,9);
        int count = integerList.stream().reduce(0,(a,b) -> (a+b));
        System.out.println("累加：" + count);
        System.out.println("找出最大：" + integerList.stream().reduce(Integer::max));

    }

    /**
     * 一、Lambda，是传递方法成为可能
     *      -> 符号：由参数、箭头、主体组成
     *      :: 符号： -> 的语法糖快捷写法，符号左边为目标引用，符号右边为方法的名称
     *
     * 二、Stream包一些操作
     *   筛选和切片、映射
     *     （1）filter(Lambda表达式)  筛选流
     *     （2）distinct()   去重
     *     （3）limit(n)  截短流
     *     （4）skip(n)  返回一个扔掉了前n个元素的流
     *     （5）map(Dish::getName)   映射。map方法会接收一个函数作为参数。这个函数会被应用到每个元素上，并将其映射成一个新的元素。
     *     （6）flatMap()   将各个生成的单个流扁平化为一个流
     *   查找和匹配
     *     （7）anyMatch()  流中是否有一个元素能匹配给定的表达式。返回一个Boolean值，终端操作
     *     （8）allMatch()  判断流中元素是否都匹配了给定的表达式。
     *     （9）noneMatch()  与上一个相对
     *     （10）findAny()  返回符合中间操作的流的一个元素
     *     （11）findFirst()  类似于上一个，但在并行上有所限制
     *   归约操作
     *     （12）reduce()  可做一些复杂的操作，比如说累加、找最小等
     *     （13）count()  计算流中元素的个数
     *
     *
     *
     *
     *
     **/


}
