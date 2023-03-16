package exceptiontest;

public class XGreaterThanOneException extends Exception{
    public String getInfo(){
        String str = "Too large";
//        System.out.println(str);
        return str;
    }
}
