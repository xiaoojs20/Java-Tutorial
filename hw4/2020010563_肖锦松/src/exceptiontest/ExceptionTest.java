package exceptiontest;
import java.io.*;

public class ExceptionTest {

    public int getFirstValidInt(){
        int firstValidInt;
        while(true){
            try {
                firstValidInt = Test.readInt();
                break;
            }catch(Exception e){
                //System.out.println("str");
            }
        }
        return firstValidInt;
    }

    public double getX(double y) throws XLessThanZeroException, XGreaterThanOneException{
        double x = Math.log(y);
        try{
            if (x < 0) {
                throw new XLessThanZeroException(y);
            }
            if(x > 1){
                throw new XGreaterThanOneException();
            }
        }catch (XLessThanZeroException e){
//            System.out.println(e.getInfo());
            return -1;
        }catch (XGreaterThanOneException e){
//            System.out.println(e.getInfo());
            return -2;
        }
        return x;
    }

    public double solve(double y) {
        double solution = 0;
        try{
            solution = Test.solve2(y);
        } catch (XLessThanZeroException e) {
            e.printStackTrace();
        } catch (XGreaterThanOneException e) {
            e.printStackTrace();
        }

        return solution;
    }
}
