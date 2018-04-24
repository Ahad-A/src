import projectpackage.DataBase;
import projectpackage.TMModel;

public class TM {

    public static void main(String[] args) {
        DataBase.main();
        TMModel tm = new TMModel();
        String description = null;
        String data = null;
        String size = null;
        String cmd= null;
        
        if (args.length == 0) {
        	System.out.println("Invalid call: java TM <command> [taskName] [Description] [Size]");
        }
        if (args.length > 0) {
        	cmd = args[0];
        }
        if (args.length > 1)
            data = args[1];

        if (args.length > 2)
            description = args[2];
        
        if (args.length > 3) {
            size = args[3];

        }
        switch (cmd) {
            case "startTask":
                tm.startTask(data);
                break;
            case "deleteTask":
                tm.deleteTask (data);
                break;
            case "stopTask":
                tm.stopTask(data);
                break;
            case "taskElapsedTime":
                System.out.print("Task: " + data + "\n\tElapsedTime: " +tm.taskElapsedTime(data));
                break;
            case "taskSize":
                System.out.print("Task: " + data + "\n\tTask Size: " +tm.taskSize(data));
                break;
            case "taskDescription" :
                System.out.print("Task: " + data + "\n\tTask Description: " +tm.taskDescription(data));
                break;
            case "minTimeForSize":
                System.out.println("MinTimeForSize: " + data
                				  + "\n\tMinTime: " + tm.minTimeForSize(data));
                break;
            case "maxTimeForSize":
                System.out.println("MaxTimeForSize: " + data
                				  + "\n\tMaxTime: " + tm.maxTimeForSize(data));
                break;
            case "avgTimeForSize":
                System.out.println("AvgTimeForSize: " + data 
                				  +"\n\tAvgTime: " + tm.avgTimeForSize(data));
                break;
            case "taskNamesForSize":
                System.out.println(tm.taskNamesForSize(data));
                break;
            case "sizeTask":
                tm.sizeTask(data, description);
                break;
            case "renameTask":
                tm.renameTask(data,description );
                break;
            case "describeTask":
                tm.describeTask(data, description);
                break;

            case "taskNames":
                System.out.println(tm.taskNames());
                break;
            case "taskSizes" :
                System.out.println(tm.taskSizes());
                break;
            //Don't know if this should be default
            default:
                System.out.println("ElapsedTimeForAllTasks: " 
                				  +tm.elapsedTimeForAllTasks());

        }

    }

}
