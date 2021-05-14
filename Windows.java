/**
 * Project: 01
 * @ Author: Dk
 * @ Date_started >> 28-Mar-2020
 * <Sat,Sat,Sun,Tue>
 * @ 4day project
 * @ Date_of_Completion >> 14-Apr-2020
 * @ Title:O.S.J -> [Opertaing System by Java].
*/

import file.*;
import java.io.*;
import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;


class Windows extends Thread{
    final static Scanner sc = new Scanner(System.in);
    static File_sys fs = new File_sys();
    final static String pwd = "osj@10";
    static Console console = System.console();
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException{

        int i = 0;
        String s;
        String anim= "|/-\\";

        String[] menu ={"File_Explorer","CMD","Internet","Shut_Down","Sleep","Comment_box"};
        //final String ANSI_BLACK = "\u001B[30m";
        //final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

        //final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

        String str = "\033[0;106mO.S.J\033[0m"; //to make the string bold.

        System.out.println("\t"+"\033[43m"+str);
        System.out.print("Loading Windows...");

        Thread.sleep(1000); // Just to give the user a chance to see "hello".
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b"); // \b - used to change the value given in the index.
        //System.out.println("                             ");

        while(i < 21) {
            System.out.print("[");
            for (int j=0;j<i;j++) {
                System.out.print("\033[44m#\033[0m");
            }

            for (int j=0;j<20-i;j++) {
                System.out.print(" ");
            }

            System.out.print("] "+  i*5 + "%");
            if(i<20) {
                System.out.print("\r");
                Thread.sleep(300);
            }
            i++;
        }
        //System.out.println();
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        //System.out.println("                             ");

        System.out.println("        \033[0;34m@OSJ - 1.0.0\033[0m       \n");
        Thread.sleep(500); // Using sleep method as delaying system to provide good look.

        console.printf("User_Name:\n");
        String user = console.readLine();
        console.printf("Password:");
        char[] pass = console.readPassword();
        String pass_code = new String(pass);

        if(pass_code.equals(pwd)){
            System.out.println("Welcome:"+user);
        }
        else{
            System.out.println(user+"check ur password.!");
        }

        System.out.println("\033[43m                             \033[0m\n");
        for(String a:menu){
            System.out.println(a+"\n");
            Thread.sleep(100);
        }
        System.out.println("\033[43m                              \033[0m\n");

        s = sc.nextLine();

        do{
            switch(s){
                case "file":
                    System.out.println("Loading File_System...");
                    for (int x =0 ; x < 101 ; x++) {
                        String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
                        System.out.write(data.getBytes());
                        Thread.sleep(100);
                    }
                    System.out.println("\n");

                    System.out.println("\033[1;34m HINT\nCommands to operate file: -[crt>] -[del] -[op]\033[0m\n");
                    System.out.println("Welcom to file_sys: what u want me 2 do?");
                    String get = sc.nextLine();
                    do{
                        switch(get){
                            case "crt>":
                              String choice;
                              System.out.println("File / Folder u want to create?");
                              choice = sc.nextLine();
                              File_sys.crtFilorFol(choice);
                              break;

                            case "del":
                                String cho;
                                System.out.println("File / Folder u want to delete?");
                                cho = sc.nextLine();
                                File_sys.del(cho);
                                break;

                            case "op":
                              File_sys.open();
                              break;

                            default:
                              System.out.println("No such option,Use help to know more");
                        }
                        System.out.println("Back_File_System");
                        get =sc.nextLine();
                    }while(!get.equals("exit"));
                    break;

                case "cmd":
                    System.out.println("Loading CMD...");
                    for (int x =0 ; x < 101 ; x++) {
                        String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
                        System.out.write(data.getBytes());
                        Thread.sleep(100);
                    }
                    System.out.println("\n");

                    try
                    {
                        // Just one line and you are done !
                        // We have given a command to start cmd
                        // /K : Carries out command specified by string
                        Runtime.getRuntime().exec(new String[] {"cmd", "/c", "Start"});
                    }
                    catch (Exception e)
                    {
                        System.out.println("HEY Buddy ! U r Doing Something Wrong ");
                        e.printStackTrace();
                    }
                    break;

                case "Internet":

                    System.out.println("Loading Internet");
                    for (int x =0 ; x < 101 ; x++) {
                        String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
                        System.out.write(data.getBytes());
                        Thread.sleep(100);
                    }
                    System.out.println("\n");

                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        Desktop.getDesktop().browse(new URI("http://www.google.com"));
                    }
                    break;

                case "shutdown":
                    System.out.println("Shutting down...");
                    Thread.sleep(100);
                    System.exit(0);
                    break;

                case "sleep":
                    int slp;
                    //System.out.println("sleep:");
                    slp = sc.nextInt();
                    Thread.sleep(slp);
                    break;

                case "commentbox":
                    System.out.println("Sorry!. Currently unAvailable.");
                    break;

                default:
                   System.out.println("Plz, select options within.!");
                   System.out.println("\n");
            }

            System.out.println("\033[43m                              \033[0m\nBack_2_Menu.");
            s =  sc.nextLine();
        }while(!s.equals("shutdown"));

        //END of M_F
    }
    //Outside of Main_Function.
}
//End of Main_Class.
