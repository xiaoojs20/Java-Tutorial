package filesearcher;

import java.io.*;
import java.util.*;

public class FileSearcher {
    String inputFileName;
    FileSearcher(String ifn){
        this.inputFileName = ifn;
    }

    public int search(String w){
        int num = 0;
        try {
            InputStream in = new FileInputStream(inputFileName);
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader buf = new BufferedReader(isr);

            String lineStr;
            while((lineStr = buf.readLine())!=null){
                lineStr = lineStr.toLowerCase();
                lineStr = lineStr.replace("let's","let us");
                lineStr = lineStr.replace("'s"," is");
                lineStr = lineStr.replace("'m"," am");
                lineStr = lineStr.replace("'re"," are");
                lineStr = lineStr.replace("'t"," not");
                lineStr = lineStr.replace("'ll"," will");
                lineStr = lineStr.replace("i'd","i should");
                lineStr = lineStr.replace("we'd","we should");
                lineStr = lineStr.replace("'d"," would");
                lineStr = lineStr.replace(","," ");
                lineStr = lineStr.replace("."," ");
                lineStr = lineStr.replace("?"," ");
                lineStr = lineStr.replace("!"," ");

                String[] words = lineStr.split(" ");
                for(int i = 0; i < words.length;i++){
                    words[i] = words[i].strip();
                    if(words[i].equals(w)){
                        num++;
                    }
                }
            }
            isr.close();
        }catch (Exception e) {
            System.out.println(e);
        }
//        System.out.println(num);
        return num;
    }
}
