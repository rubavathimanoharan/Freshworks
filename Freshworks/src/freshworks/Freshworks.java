/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package freshworks;
import java.io.*;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Freshworks
{
 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Object json; 
    JSONObject obj=new JSONObject(); 
   static String file="C:\\Users\\rubav\\Documents\\NetBeansProjects\\Freshworks\\src\\freshworks\\data.json";
     Scanner scann = new Scanner (System.in);
    File f=new File(file);
    
    
 public synchronized void Insert( ) throws IOException, Exception
 {
     System.out.println("enter 1 to create your own file path\nEnter any number to create a default path");
        int choice=scann.nextInt();
        if(choice==1)
        {
            System.out.println("Enter path eg.C:\\Users\\rubav\\Documents\\NetBeansProjects\\Freshworks\\src\\freshworks\\data.json");
            file=scann.next();
            File filee = new File(file);
            boolean exists = filee.exists();
            if(!exists)
                System.out.println("created successfully");
            else
                System.out.println("File already exist");
        }
        
     Scanner in = new Scanner (System.in); 
       System.out.println("enter key with 32 char not execeeding that");   
	String keyval=in.next();
         
       if(check(keyval)==0)
       {
          System.out.println("The entered key is already occupied ,please enter a new key");
           keyval=in.next(); 
       }
        
        System.out.println("Enter your any value: ");
        String value=in.next();
        
        int flag=1;
        String key="";
       while(flag==1)
        {
        if(keyval.length()>32)
        {
            System.out.println("key exceeds 32 characters the key value is trimmed to 32 characters"); 
            System.out.println("if you want to re-enter the key enter 1 else any number");
            flag=in.nextInt();
            if(flag!=1)
            {
                key=key.substring(0,32);
                 break;
            }
        }
        else
        {
            
            break;
        }
        }
        
     
  try{  
          long size=file.length();
            double size_of_file;
            if(size>10000){
                size_of_file=size/1024;//KB=b/0124
                size_of_file=size_of_file/1024;//mg=kb/1024
                size_of_file=size_of_file/1024;//gb=mb/1024
                if(size_of_file>1){
                    System.out.println("The File size should be less than 1 GB");
                }
            }
         obj.put(keyval,value);
          try (FileWriter file1 = new FileWriter(file,false)) {
          file1.write(obj.toJSONString());
          file1.flush();
                }
       
  }catch(Exception e){
            System.out.println("Error was occured at creating the key while try to write the replaced content"+e);
        }
  }
 
 public int check(String keyval) throws FileNotFoundException, IOException, ParseException
 {
       Object obj1; 
        obj1 = new JSONParser().parse(new FileReader(f));
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj1; 
       String key = null;
        // getting firstName and lastName 
        key =  (String) jo.get(keyval); 
         if(key!=null)
         {
            return 0; 
         }
         else {
         return 1;
     }
        
 }
 
 public synchronized void Read( ) throws IOException, ParseException
 {
  Object obj2; 
        obj2 = new JSONParser().parse(new FileReader(file));
         String key;
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj2; 
      // getting firstName and lastName 
        Scanner scan=new Scanner(System.in);
        System.out.println("ENter the key");
        key=scan.next();
       String value = (String) jo.get(key); 
            System.out.println("key:"+key+ "  value:" +value+"\n");
}

 
public synchronized void Delete( ) throws IOException, ParseException
{
    Scanner scan=new Scanner(System.in);
    String key;
    Object obj3; 
        obj3 = new JSONParser().parse(new FileReader(file));
       JSONObject jo; 
        jo = (JSONObject) obj3;
        System.out.println("enter the key which you want to delete");
         key=scan.nextLine();
        jo.remove(key);
        System.out.println("kay value pair of the key: "+key + " is deleted");
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file,false)))) {
            pw.print(jo);
        }
}

public static void main(String args[]) throws IOException, ParseException, Exception, FileNotFoundException
{
     Freshworks in = new Freshworks();
    int ch,choice;
    Scanner scan=new Scanner(System.in);
    while(true)
    {
    System.out.println("**********************");
    System.out.println("\t1.create \n\t2.Read \n\t3.Delete \n\t4.exit");
    System.out.println("**********************");
    System.out.println("Selection any option");
    choice=scan.nextInt();
    switch(choice)
    {
        case 1:
        {
             in.Insert();
             break;
        }
        case 2:
        {
          in.Read();
          break;
        }
        case 3:
        {
          in.Delete();
          break;
        }
        case 4:
        {
            return;
        }
        default:
        {
            System.out.println("You have entered a wrong option.Enter any option from 1 to 4");
            break;
        }
    }   
}
}
}
