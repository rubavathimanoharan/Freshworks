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
 public void Insert( ) throws IOException, Exception
 {
     
   Scanner in = new Scanner (System.in);
   JSONObject obj=new JSONObject(); 
        System.out.println("Enter your key: ");   
	long keyval=in.nextInt();
       
        File f=new File("C:\\Users\\rubav\\Documents\\NetBeansProjects\\Freshworks\\src\\freshworks\\data.json");
        if(f.length()!=0)
        {
       if(check(keyval)==0)
       {
          System.out.println("The entered key is already occupied ,please enter a new key");
           keyval=in.nextInt(); 
       }
        }
	System.out.println("Enter Name: ");
        String name=in.next();
        
        System.out.println("Enter country name : ");
	String addr=in.next();
        
	System.out.println("Enter Phone number: ");
	long phone;     
        phone = in.nextInt();
 
  try{  
          long size=f.length();
            System.out.println("size of the file "+size);
            double size_of_file;
            if(size>10000){
                size_of_file=size/1024;//KB=b/0124
                size_of_file=size_of_file/1024;//mg=kb/1024
                size_of_file=size_of_file/1024;//gb=mb/1024
                if(size_of_file>1){
                    System.out.println("The File size should be less than 1 GB");
                }
            }
        
//Toast.makeText(MainActivity.this, ""+obj, Toast.LENGTH_LONG);
       
 obj.put("key",keyval);
 obj.put("name",name); 
  obj.put("country",addr);
  obj.put("phone",phone);
         try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\rubav\\Documents\\NetBeansProjects\\Freshworks\\src\\freshworks\\data.json",true)))) {
             pw.print(obj);
             pw.append("\n");
             System.out.println("Details added\n\n");
         }
  }catch(Exception e){
            System.out.println("Error was occured at creating the key while try to write the replaced content"+e);
        }
  }
 
 public int check(long keyval) throws FileNotFoundException, IOException, ParseException
 {
       Object obj; 
        obj = new JSONParser().parse(new FileReader("C:\\Users\\rubav\\Documents\\NetBeansProjects\\Freshworks\\src\\freshworks\\data.json"));
         
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
    
        // getting firstName and lastName 
        long key = (long) jo.get("key"); 
         if(key==keyval)
         {
            return 0; 
         }
         else {
         return 1;
     }
 }
 
 public void Read( ) throws IOException, ParseException
 {
  Object obj; 
        obj = new JSONParser().parse(new FileReader("C:\\Users\\rubav\\Documents\\NetBeansProjects\\Freshworks\\src\\freshworks\\data.json"));
         
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj;
        // getting firstName and lastName 
        long key = (long) jo.get("key"); 
        String name = (String) jo.get("name"); 
        String country = (String) jo.get("country");      
        long phone = (long) jo.get("phone"); 
     //   System.out.println(phone);    
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\rubav\\Documents\\NetBeansProjects\\Freshworks\\src\\freshworks\\data.json"));
        try (Scanner read = new Scanner(in)) {
            System.out.println("key:"+key+ "  name:" + name + "  country:" + country + "  phone:" + phone+"\n");
        }  
 }
 

 
public void Delete( ) throws IOException, ParseException
{
    Scanner scan=new Scanner(System.in);
    String key;
    Object obj; 
        obj = new JSONParser().parse(new FileReader("C:\\Users\\rubav\\Documents\\NetBeansProjects\\Freshworks\\src\\freshworks\\data.json"));
       JSONObject jo; 
        jo = (JSONObject) obj;
        System.out.println("enter the key which you want to delete");
         key=scan.nextLine();
        jo.remove(key);
        System.out.println("kay value pair of the key: "+key + " is deleted");
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\rubav\\Documents\\NetBeansProjects\\Freshworks\\src\\freshworks\\data.json",false)))) {
            pw.print(jo);
        }
}


public static void main(String args[]) throws IOException, ParseException, Exception, FileNotFoundException
{
     Freshworks in = new Freshworks();
    int ch,choice;
    Scanner scan=new Scanner(System.in);
   // String q="*";
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
