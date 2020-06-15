package java.lang;

/**
 * 当一个 Integer 和 int 比较时，Integer 会调用 intValue() 方法自动拆箱后再比较
 *
 * @author wupx
 * @date 2020/04/27
 */
public class IntegerTest2 {
    public static void main(String[] args) {
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(5);// 通过 new 来创建的两个 Integer 对象
        Integer i3 = 5;// 调用 valueOf 将 5 自动装箱成 Integer 类型
        int i4 = 5;// 基本数据类型 5
        System.out.println(i1 == i3);     // false，两个引用没有引用同一对象
        System.out.println(i1 == i2);     // false，两个通过 new 创建的 Integer 对象不是同一个引用
        System.out.println(i3 == i4);     // true，i3 调用 java/lang/Integer.intValue:()I 自动拆箱成 int 类型再和 i4 比较
    }
}