package Ex2_1;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class NumOfLinesThreads extends Thread{

    private String StrArr;
    private int lineCount ;



    public NumOfLinesThreads(String fileName) {
        this.StrArr = fileName;
    }

    @Override
    public void run() {


        try  {

                FileReader fl = new FileReader(StrArr);
                LineNumberReader lr = new LineNumberReader(fl);
                while (lr.readLine() != null) {
                    lineCount++;
                }


        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("");

    }
    public int getNumLines() {
        return lineCount;

    }
}







