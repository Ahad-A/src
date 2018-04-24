package projectpackage;

import java.io.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.*;


public class TMModel  {
	
    public boolean startTask(String taskName) {
        String time = LocalDateTime.now().toString();
        Statement stm = null;
        Connection c = null;


        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);
           
            stm = c.createStatement();
            String sql = "INSERT INTO Logs (name,start)VALUES (?, ? )";
            PreparedStatement pstmt= c.prepareStatement(sql);
            pstmt.setString(1,taskName);
            pstmt.setString(2,time);
            pstmt.executeUpdate();
           
            stm.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return true;
    }

    public boolean stopTask(String taskName) {

        String time = LocalDateTime.now().toString();
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);

            String sql = "UPDATE Logs set stop = ? where name = ?";

            PreparedStatement pstmt= c.prepareStatement(sql);
            pstmt.setString(2,taskName);
            pstmt.setString(1,time);

            pstmt.executeUpdate();
            c.commit();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return true;
    }

    public boolean sizeTask(String taskName, String size) {

        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);

            String sql = "UPDATE Logs set size = ? where name = ?";

            PreparedStatement pstmt= c.prepareStatement(sql);
            pstmt.setString(1, size);
            pstmt.setString(2,taskName);

            pstmt.executeUpdate();
            c.commit();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return true;
    }

    public boolean deleteTask (String taskName){
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);

            String sql = "DELETE FROM Logs WHERE  name = ?";

            PreparedStatement pstmt= c.prepareStatement(sql);
            pstmt.setString(1, taskName);

            pstmt.executeUpdate();
            c.commit();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return true;
    }
    
    
    public boolean describeTask(String taskName, String description) {
    	 Connection c = null;
	 try{
	    Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);
		 
            String sql = "UPDATE Logs set description = ? where name = ?";
		 
            PreparedStatement pstmt= c.prepareStatement(sql);
            pstmt.setString(1,description);
            pstmt.setString(2,taskName);
		 
	    pstmt.executeUpdate();
            c.commit();
		 
	 } catch  (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	    return true;
    }
    
    public boolean renameTask (String oldName, String newName){
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);

            String sql = "UPDATE Logs set name = ? where name = ?";

            PreparedStatement pstmt= c.prepareStatement(sql);
            pstmt.setString(1,newName);
            pstmt.setString(2,oldName);

            pstmt.executeUpdate();
            c.commit();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return true;
       
    }
    
    //SQL implemented and fully functional

    public String taskElapsedTime(String taskName) {
        List<Long> arr = new ArrayList<>();
        Connection c = null;
        Statement stmt = null;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Logs");

            while(rs.next()) {

                if(rs.getString("name").equals(taskName))
                {
                    LocalDateTime start = LocalDateTime.parse(rs.getString("start"));
                    LocalDateTime stop = LocalDateTime.parse(rs.getString("stop"));
                    long elpasedTime= ChronoUnit.SECONDS.between(start,stop);
                    arr.add(elpasedTime);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        long total= 0;
        for (int i = 0 ; i<arr.size(); i++){
            total += arr.get(i);
        }

       String timeSpent= total/3600+ ":" + total/60 + ":"+ total%60;
       return String.valueOf(timeSpent);
    }

    // fully functional.
    public String taskSize(String taskName) {
        Connection c = null;
        Statement stmt = null;
        String size= null;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Logs");

            while(rs.next()) {

                if(rs.getString("name").equals(taskName) && !(rs.getString("size").isEmpty()))
                {
                    size = rs.getString("size");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return size;
    }

    // fully functional
    public String taskDescription(String taskName){
        Connection c = null;
        Statement stmt = null;
        String description= null;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Logs");

            while(rs.next()) {

                if(rs.getString("name").equals(taskName)&& !rs.getString("size").isEmpty())
                {
                    description = rs.getString("description");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return description;
    }
    
    //Does not need SQL implementation
    public String minTimeForSize(String size) {
        TreeSet<String> set = new TreeSet<>();
        
        for (String s: taskNamesForSize(size)){
            set.add(taskElapsedTime(s));
        }
        return  set.first().toString();
    }
    
    //Does not need SQL implmentation
    public String maxTimeForSize(String size){
        TreeSet <String> set = new TreeSet<>();
        for (String s: taskNamesForSize(size)){
            set.add(taskElapsedTime(s));
        }
        return  set.last().toString();
    }
    
    //fully functional
    public String avgTimeForSize(String size){
        Connection c = null;
        Statement stmt = null;
        String name= null;
        String start = null;
        String stop = null;
        ArrayList <Long> arr = new ArrayList<>();
        long elapsedSeconds=0;
        long total= 0;
        String avg= null;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Logs");

            while(rs.next()) {

                if(rs.getString("size").equals(size)&& !rs.getString("size").isEmpty())
                {
                   // name = rs.getString("name");
                    start = rs.getString("start");
                    stop = rs.getString("stop");
                     elapsedSeconds=ChronoUnit.SECONDS.between(LocalDateTime.parse(start),LocalDateTime.parse(stop));
                    arr.add(elapsedSeconds);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        for (int i=0; i<arr.size(); i++){
            total=total + arr.get(i);
        }
        total= total/arr.size();
        avg = total/3600+ ":" + total/60 + ":"+ total%60;

     	return avg;
    }
    

    // fully functional
    public Set<String> taskNamesForSize(String size){
        Set <String> set = new TreeSet<>();

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "select * from Logs";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("size").equals(size))
                    set.add(rs.getString("name"));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return set;

    }

    //Implemented
    public String elapsedTimeForAllTasks(){
    
    ArrayList<String> elapseTime = new ArrayList<>();
    
    //Connection to Database
	Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Log.db");
        c.setAutoCommit(false);
        
        stmt = c.createStatement();
        
        String sql = "select name from Logs";

        ResultSet rs = stmt.executeQuery(sql);
        
        //get the elapse time for all tasks
        while (rs.next()) {
        	elapseTime.add(taskElapsedTime(rs.getString("name")));
        }
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    
    //Sum the time of all tasks
    int totalTimeSeconds = 0;
    for (String i: elapseTime) {
    	String token[] = i.split("D:|h:|m:|s");
    	
    	//Convert to seconds to properly add the elapsed time of all seconds
    	totalTimeSeconds += Integer.parseInt(token[0])*24*60*60;
    	totalTimeSeconds += Integer.parseInt(token[1])*60*60;
    	totalTimeSeconds += Integer.parseInt(token[2])*60;
    	totalTimeSeconds += Integer.parseInt(token[3]);
    }
    String totalTime = Integer.toString(totalTimeSeconds/60/60) + "h:"
    				 + Integer.toString(totalTimeSeconds/60%60) + "m:"
    				 + Integer.toString(totalTimeSeconds%3600)  + "s";
    
    //StringFormat: #h:#m:#s
    return totalTime;
    }
    
    //Finished implementation
    public static Set<String> taskNames(){
    	//Set to hold unique taskNames
        Set <String> set = new TreeSet<>();
        
    	//Connection to Database
    	Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);
            
            stmt = c.createStatement();
            
            String sql = "select name from Logs";

            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
            	//names are never null so it doesnt need to be checked
            	set.add(rs.getString("name"));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
                
        return set;
    }

    //Finished implementation
    public Set<String> taskSizes(){
    	
    	//Set to obtain and hold unique values of size for each task
    	Set<String> set = new TreeSet<>();
    	
    	//Connection to Database
    	Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);
            
            stmt = c.createStatement();
            
            String sql = "select size from Logs";

            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
            	if (rs.getString("size") != null) {
            		set.add(rs.getString("size"));
            	}
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return set;
    }
}
