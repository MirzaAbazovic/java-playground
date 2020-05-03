package ba.programiraj.spring.aop.util;

public class Common {

    public static String getPureSimpleName(String simpleName){
        int lastIndex = simpleName.indexOf("$$") > 0 ? simpleName.indexOf("$$") : simpleName.length() - 1 ;
        final String pureSimpleName = simpleName.substring(0, lastIndex);
        return pureSimpleName;
    }
}
