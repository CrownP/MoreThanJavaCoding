package com.crownp.morethanjavacoding.Basics.java8feature;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 菜品的实体类，内含返回一个菜单列表的方法，并实例化了内容
 * @Author qgp
 * @Date 2019/11/8 13:51
 **/
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    //菜名
    public String getName() {
        return name;
    }

    //是否是蔬菜
    public boolean isVegetarian() {
        return vegetarian;
    }

    //卡路里
    public int getCalories() {
        return calories;
    }

    //菜的类型
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {MEAT, FISH, OTHER}


    //菜单
    public static List<Dish> getMenu(){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH) );
        return menu;
    }

}
