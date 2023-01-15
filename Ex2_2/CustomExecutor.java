package Ex2_2;

import java.util.concurrent.*;

public class CustomExecutor extends ThreadPoolExecutor {
   private ThreadPoolExecutor executor;
   private static int NumProcessors = Runtime.getRuntime().availableProcessors();
    private static PriorityBlockingQueue ProQueue;

    private static int [] MaxPro;



    // constructor
    public CustomExecutor() {

        super(NumProcessors/2, NumProcessors - 1, 300, TimeUnit.MILLISECONDS,  new PriorityBlockingQueue<>());
        ProQueue= new PriorityBlockingQueue<Task>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor((NumProcessors / 2), (NumProcessors - 1), 300, TimeUnit.MILLISECONDS, ProQueue);
        MaxPro = new int[10];
    }

    //// Method for submitting a Task instance
    public <V> Future<V> submit(Task<V> task) {

        if (task != null ){

            int priority = task.getPriority().getPriorityValue();
            this.MaxPro[priority]= MaxPro[priority]+1;
            super.execute(task);

            return task;
        }
        throw new NullPointerException();
    }



    // Method for creating a Task instance from a Callable and TaskType
    public <V> Future<V> submit(Callable<V> TaskToDo, TaskType priority) {
        Task tempTask =  Task.createTask(TaskToDo,priority);
        return submit(tempTask);
    }


    // Method for creating a Task instance from a Callable
    public <V> Future<V> submit(Callable<V> taskToDo) {
        if (taskToDo!=null ){
            Task tempTask =  Task.createTask(taskToDo);
            return submit(tempTask);
        }

        throw new RuntimeException("The Callabl");
    }









    public int getCurrentMax(){

        for (int i = 0; i <= 10; i++) {
        if (this.MaxPro[i]>0)
            return i+1;
    }
        return 0;
    }



    //Method to stop the activity of a CustomExecutor
    public void gracefullyTerminate() {
        try
        {
            super.shutdown();
            while (!super.awaitTermination(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


}
