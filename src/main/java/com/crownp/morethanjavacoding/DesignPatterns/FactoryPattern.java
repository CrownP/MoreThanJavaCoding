package com.crownp.morethanjavacoding.DesignPatterns;

/**
 * @Description 工厂模式：普通工厂模式、多个工厂方法模式、静态工厂方法模式
 * @Date 2019/10/24 9:18
 **/
public class FactoryPattern {

    public static void main(String[] args) {
        MultiFactory factory = new MultiFactory();
        Human human = factory.createMale();
        human.eat();
        human.sleep();
        human.beat();

    }

    //共同的接口
    interface Human {
        public void eat();

        public void sleep();

        public void beat();
    }

    //创建实现类 Male
    static class Male implements Human {

        @Override
        public void eat() {
            System.out.println("Male can eat");
        }

        @Override
        public void sleep() {
            System.out.println("Male can sleep");
        }

        @Override
        public void beat() {
            System.out.println("Male can beat");
        }
    }

    //创建实现类 Female
    static class Female implements Human {

        @Override
        public void eat() {
            System.out.println("Female can eat");
        }

        @Override
        public void sleep() {
            System.out.println("Female can sleep");
        }

        @Override
        public void beat() {
            System.out.println("Female can beat");
        }
    }

    //创建 普通工厂类
    static class NormalFactory {
        public Human createHuman(String gender) {
            if (gender.equals("male")) {
                return new Male();
            } else if (gender.equals("female")) {
                return new Female();
            } else {
                System.out.println("请输入正确的类型！");
                return null;
            }
        }

    }

    //创建 多个工厂方法
    public static class MultiFactory {
        public Male createMale() {
            return new Male();
        }

        public Female createFemale() {
            return new Female();
        }
    }

    // 静态工厂方法模式：将 多个工厂方法模式 里的方法置为静态的就是了，不需要创建工厂实例，
    // 通常采用此方法


}
