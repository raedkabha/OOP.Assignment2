package Ex2_2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Task<V> extends FutureTask<V> implements Callable<V>, Comparable<Task<V>> {

    private Callable<V> TaskToDo;
    public TaskType  priority;





    private Task(Callable<V> Task) {
        super(Task);
        this.TaskToDo= Task;
        this.priority= TaskType.OTHER;
    }
    private Task(Callable Task, TaskType  priority){

        super(Task);
        this.TaskToDo= TaskToDo;
        this.priority= priority.getType();

    }



    public static <V> Task createTask(Callable<V>TaskToDo,TaskType priority){

        return new Task(TaskToDo,priority);
    }

    public static Task createTask(Callable TaskToDo)
    {
        return new Task(TaskToDo);
    }










    public Callable<V> getTask() {
        return this.TaskToDo;
    }

    public void setTask(Callable<V> task) {
        this.TaskToDo = TaskToDo;
    }



    public TaskType getPriority() {
        return this.priority;
    }

    public void setPriority(TaskType priority) {
        this.priority = priority;
    }








    @Override
    public int compareTo(Task<V> o) {
        return Integer.compare(this.priority.getPriorityValue(),o.priority.getPriorityValue());
    }

    @Override
    public V call() throws Exception {
        return this.TaskToDo.call();
    }


    public String tString(){
        return "Priority=" + this.priority +"";
    }
}
