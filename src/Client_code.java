import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client_code {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        try{
            Socket s= new Socket("localhost",8080);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            System.out.print("\n Enter a Number to be sent over: ");
            int num = scan.nextInt();

            dout.writeInt(num);
            String ans = (String)dis.readUTF();
            System.out.println("\n User Input: "+num+ " Status: "+ans);
            dout.flush();
            dout.close();
            s.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        scan.close();
    }
}
