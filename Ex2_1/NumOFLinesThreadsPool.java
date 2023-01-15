package Ex2_1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.concurrent.Callable;

public class NumOFLinesThreadsPool implements Callable<Integer> {

    private String fileName;

    public NumOFLinesThreadsPool(String fileName) {
        this.fileName = fileName;
    }

    public Integer call() throws Exception {

        int counter=0;
       File file= new File(fileName);
       try {

           FileReader FN = new FileReader(file);
           LineNumberReader lr = new LineNumberReader(FN);
           while (lr.readLine() != null) {
               counter++;
           }

       }catch (IOException e) {
            e.printStackTrace();
        }


        return counter;

    }


}
