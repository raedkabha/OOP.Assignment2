# OOP.Assignment2
## Ex2_1.

### Function1: Create text file:
In this function we want to create a text file with a random number of lines, the function return an array with the names of files.

### Function2: get number of lines:
In this method we calculate number of lines in all the files in array by using just loops method (for, while) we calculate the lines in 2500 files and we found that the:
1)number of lines in all files is: 3155000. 
2)and the time we take to finsh the method is: 0.7669425 seconds.

### Function3: get number of lines with threads:
This method we calculate number of lines in all the files in array by using threads and I create a class that extend from thread, this class take a file and calculate
of lines in just one file and I create another function "getNumOfLinesTreads", this function send each one of files and send him to the class, in the end I take the total of lines in all files.
1)number of lines in all files is: 3155000. 
2)and the time we take to finsh the method is: 0.7224375 seconds.

### Function3: get number of lines with threads pool:
In this method we calculate number of lines by using thread pool ana I create a class that implement Callable and this class take one file and count the lines in him 
and I create anothe function "getNumOfLinesThreadsPool" this function send each one of files and send him to the class, in the end I take the total of lines in all files.
1)number of lines in all files is: 3155000. 
2)and the time we take to finsh the method is: 3.4336229 seconds.

- In the end we found that the best way to do this task is with threads because its take fewer time to finsh the task.
