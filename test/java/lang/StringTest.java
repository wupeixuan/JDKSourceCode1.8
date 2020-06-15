package java.lang;

/**
 * @author wupx
 * @date 2020/04/27
 */
public class StringTest {
    public static void main(String[] args) {
//        String name = "wupx";
//        String substring = name.substring(0, 1);
//        System.out.println(name);
//        System.out.println(substring);
        variableParameter("1","2");
    }

    public static void variableParameter(String... strings){
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
