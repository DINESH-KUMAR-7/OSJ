package file;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.awt.Desktop;
/*
  -Create,Delete,Read,Write,Append.
*/
public class File_sys {
    final static Scanner sc = new Scanner(System.in);
    public static String path_name,file_name;
    public static File f;

    public static void crtFilorFol(String choice) throws IOException{

      if(choice.equals("folder")){
        System.out.println("Enter path");
        path_name = sc.nextLine();
        System.out.println("Give name:");
        file_name = sc.nextLine();
        path_name = path_name+file_name;

        f = new File(path_name);
        boolean check = f.mkdir();
        if(check){
          System.out.println("Folder:"+file_name+"Created.");
        }
        else{
          System.out.println("Problem in folder Creation.!");
        }
      }

      else{
        System.out.println("Enter path");
        path_name = sc.nextLine();
        System.out.println("Give name:");
        file_name = sc.nextLine();
        path_name = path_name+file_name;

        f = new File(path_name);
        FileOutputStream fis = new FileOutputStream(f);
        try{
          if(fis != null)
            fis.close();
        }
        catch(IOException ioe){
          ioe.printStackTrace();
        }
      }
    }

    public static void del(String cho){

      if(cho.equals("folder")){
        System.out.println("folder name ?");
        file_name = sc.nextLine();

        f = new File(file_name);
        if (!f.exists()) {
          System.out.println("File not exists.");
        }
        else {
          f.delete();
          System.out.println("Deleted.."+file_name);
        }
      }

      else{
        System.out.println("file name ?");
        file_name = sc.nextLine();

        f = new File(file_name);
        if(f.delete())                      //returns Boolean value
        {
          System.out.println(f.getName() + " deleted");   //getting and printing the file name
        }
        else
        {
          System.out.println("Can't Delete file, Maybe it's not exists at all.!");
        }
      }
    }

  public static void open(){

    try
    {
      String u;
      System.out.println("Enter File with path 2 open");
      u = sc.nextLine();
      f = new File(u);

      Desktop desktop = Desktop.getDesktop();
      if(f.exists()){
        desktop.edit(f);
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
