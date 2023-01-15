package Ex2_1;

import java.io.*;
import java.util.Random;
import java.util.concurrent.*;



public class Ex2_1 {







    public static String[] createTextFiles(int n, int seed, int bound) {
        String[] strarr = new String[n];
        try {


            for (int i = 0; i < n; i++) {
                int RanNum = randnum(seed, bound);
                File file = new File("file_" + i + ".txt");
                FileWriter myWriter = new FileWriter(file);
                for (int j = 1; j <= RanNum; j++) {
                    myWriter.write("it's been a beautiful day\r\n");

                }
                myWriter.close();
                strarr[i] = "file_" + i + ".txt";


            }
            }  catch(IOException e){

                e.printStackTrace();
            }
            return strarr;

        }

    public static int randnum(int seed, int bound){
        Random rand = new Random(seed);
        int x = rand.nextInt(bound);
        return x;
    }

    public static int getNumOfLines(String[] fileNames){
        int SumOfLines=0;
        int numfiles= fileNames.length;
        try {
       for (int i=0;i<numfiles;i++) {
           File f = new File(fileNames[i]);
           FileReader fr = new FileReader(f);
           LineNumberReader lr = new LineNumberReader(fr);
           while (lr.readLine() != null) {
               SumOfLines++;
           }
           fr.close();
       }
        }  catch(IOException e){

            e.printStackTrace();
        }


       return SumOfLines;

    }
    public static int getNumOfLinesTreads(String[] fileNames) throws IOException {
        int sum=0;
        for(int i=0;i<fileNames.length; i++){
            File f = new File(fileNames[i]);
            FileReader fr = new FileReader(f);
            LineNumberReader lr = new LineNumberReader(fr);
            while (lr.readLine() != null) {
                sum++;
            }
            fr.close();



        }
        return sum;

    }

    public static int getNumOfLinesThreadsPool(String[] fileNames) throws InterruptedException,  ExecutionException{
    int sum=0;
    int x= fileNames.length;

            Executor executor = Executors.newFixedThreadPool(x);

            for (int i = 0; i < x; i++) {

                NumOFLinesThreadsPool fl = new NumOFLinesThreadsPool(fileNames[i]);
                Future<Integer> result = ((ExecutorService) executor).submit(fl);
                sum += result.get();

            }
        ((ExecutorService) executor).shutdown();

        return sum;
}




    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        long StartT;
        long EndT;
        long ExpectedT;


        String[] m = createTextFiles(2500, 123, 2560);

        StartT= System.nanoTime();
        System.out.println("Number of lines 1:"+getNumOfLines(m));
        EndT= System.nanoTime();
        ExpectedT= EndT- StartT;
        System.out.println("Time of function1:"+ ExpectedT / 1000000000.0);




        StartT= System.nanoTime();
        System.out.println("Number of lines 2:"+getNumOfLinesTreads(m));
        EndT= System.nanoTime();

        ExpectedT= EndT- StartT;
        System.out.println("Time of function2:"+ ExpectedT / 1000000000.0);



        StartT= System.nanoTime();
         System.out.println("Number of lines 3:"+getNumOfLinesThreadsPool(m));
        EndT= System.nanoTime();
        ExpectedT= EndT- StartT;
        System.out.println("Time of function3:"+ ExpectedT / 1000000000.0);

    }

    }
