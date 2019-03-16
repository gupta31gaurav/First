
        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Gaurav Gupta
 */
public class chat2 extends Frame implements ActionListener{
    TextField tf;
     Button bt;
     static TextArea ta;
     //String s1="";
     static Socket s;
     static ServerSocket ss;
     static DataInputStream di;
     static DataOutputStream dos;
     chat2()
     {
         tf=new TextField();
         tf.setBounds(20, 40, 150, 20);
         tf.setVisible(true);
         bt=new Button("Send");
         bt.setBounds(180, 40, 50, 20);
         bt.addActionListener(this);
         ta=new TextArea("");
         ta.setBounds(20,70,230,400);
         ta.setVisible(true);
         add(tf);
         add(bt);
         add(ta);
         setLayout(null);
         setVisible(true);
         setLocation(100,100);
         setSize(300,500);
     }
     public static void main(String args[])
     {
         try{
         chat2 ca=new chat2();
         ss=new ServerSocket(3333);
         s=ss.accept();
         di=new DataInputStream(s.getInputStream());
         dos=new DataOutputStream(s.getOutputStream());
         String s2="";
         while(!s2.equals("Bye"))
         {
             s2=di.readUTF();
             ta.append("\nHim: "+ s2);
         }
         }
         catch(Exception w)
         {

         }
     }
    public void actionPerformed(ActionEvent e) {
        try{
        String s1="";
        s1=tf.getText();
        tf.setText("");
        ta.append("\nYou: "+s1);
        dos.writeUTF(s1);
        }
        catch(Exception q)
        {

        }
    }
}
