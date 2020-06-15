package java.lang;

/**
 * IntegerCache 会缓存[-128,127]的 Integer（为了自动装箱的复用），valueOf 方法会从缓存中去拿值，如果命中缓存，会减少资源的开销
 * 对象池模式：空间换时间
 *
 * @author wupx
 * @date 2020/04/26
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i1 = 66;// 通过反编译可以知道 Integer i = 66; 这种形式声明的变量是通过 java.lang.Integer#valueOf(int) 来构造 Integer 对象的
        Integer i2 = 66;
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i1 == i2);// true，在[-128,127]内时，会直接从 IntegerCache 中获取 Integer
        System.out.println(i3 == i4);// false，属于两个对象
    }
}