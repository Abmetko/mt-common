package core.mt.utils;

public class ValuesUtils {

    public static String replaceCommaToDot(String text){
        return text.replace(",",".");
    }

    public static String replaceDotToComma(String text){
        return text.replace(",",".");
    }

    public static double getDoubleValue(String text){
        return Double.parseDouble(replaceCommaToDot(text));
    }
}