/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpackage;
/**
 *
 * @author Josh
 */
public class TaskTable {
    private String taskName;
    private String taskDescription;
    private String taskSize;
    private String taskTime;
    
    public TaskTable (String TaskName, String TaskDescription, String TaskSize, String TaskTime) {
        this.taskName = TaskName;
        this.taskDescription = TaskDescription;
        this.taskSize = TaskSize;
        this.taskTime = TaskTime;
    }
    
    public String getName() {
        return String.valueOf(TMModel.taskNames());
    }
    public String getDescription() {
        return taskDescription;
    }
    public String getSize() {
        return taskSize;
    }
    public String getTime() {
        return taskTime;
    }
}
