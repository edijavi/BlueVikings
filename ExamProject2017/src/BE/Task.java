package BE;

public class Task {
    int TaskId;
    String TaskName;
    public Task ( String TaskName, int TaskId){
        this.TaskId = TaskId;
        this.TaskName = TaskName;
        
    }

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int TaskId) {
        this.TaskId = TaskId;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String TaskName) {
        this.TaskName = TaskName;
    }
    
    
   
}
