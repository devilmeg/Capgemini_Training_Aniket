import java.time.LocalDateTime;
import java.util.*;
import java.util.Queue;
enum Status{
    PENDING ,
    IN_PROGRESS,
    COMPLETED

}
public class TaskScheduling {

    public static void main(String[] args) {

    }

}
class Task{
    int id;
    int Priority;
    String Desc;
    Status status;
    LocalDateTime createdTime = LocalDateTime.now();

    Task(int id , int Priority ,String Desc, Status status , LocalDateTime createdTime){

    }


}

