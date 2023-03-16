package datachooser;

import java.io.*;
import java.util.*;

public class DataChooser {
    DataChooser(String inputFileName, String outputFileName) {
        try {
            Scanner input = new Scanner(new File(inputFileName));
            File outputFile = new File(outputFileName);
            PrintStream out = new PrintStream(outputFile); //也可文件名

            while(input.hasNextLine()){
                String lineStr = input.nextLine();
                String[] columes = lineStr.split(",");
                out.println(columes[3]);
//                System.out.println(columes[3]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
