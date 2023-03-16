package exceptiontest;

public class XLessThanZeroException extends Exception{
    public double _y;
    public XLessThanZeroException(double y){
        this._y = y;
    }

    public String getInfo(){
        String str = String.valueOf(this._y) + "is too small";
//        System.out.println(str);
        return str;
    }
}
