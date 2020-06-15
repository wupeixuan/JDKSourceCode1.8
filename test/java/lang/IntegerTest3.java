package java.lang;

/**
 * getInteger 方法从系统属性中获取值，然后再装箱，如果系统属性中没有该值，则返回备用值 val
 *
 * @author wupx
 * @date 2020/04/27
 */
public class IntegerTest3 {
    public static void main(String[] args) {
        System.setProperty("age", "18");
        Integer age = Integer.getInteger("age", 25);
        System.out.println(age);
    }
}