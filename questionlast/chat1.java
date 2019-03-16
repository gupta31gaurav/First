/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package questionlast;
import java.awt.Event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

/**
 *
 * @author Gaurav Gupta
 */
public class chat1 extends Frame implements ActionListener
 {
     
     Label l1;
     static TextField tf,serv;
     Button bt,acti;
     static TextArea ta;
     static Socket s;
     static DataInputStream di;
     static DataOutputStream dos;
     public chat1()
     {
         
         l1=new Label("Enter the Server IP Address:");
         l1.setBounds(20,60,200,40);
         l1.setVisible(true);
         serv=new TextField();
         //local if testing on local network
         //public if testing on different networks
         serv.setBounds(20,100,200,20);
         serv.setVisible(true);
         acti=new Button("Start");
         acti.setBounds(125,120,40,20);
         acti.setVisible(true);
         acti.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 
                 l1.setVisible(false);
                 serv.setVisible(false);
                 acti.setVisible(false);
                 tf.setVisible(true);
                 bt.setVisible(true);
                 ta.setVisible(true);
                 //To change body of generated methods, choose Tools | Templates.
             }
         });
         tf=new TextField();
         tf.setBounds(20, 40, 150, 20);
         tf.setVisible(false);
         bt=new Button("Send");
         bt.setBounds(180, 40, 50, 20);
         bt.setVisible(false);
         bt.addActionListener(this);
         ta=new TextArea("");
         ta.setBounds(20,70,230,400);
         ta.setVisible(false);
         add(l1);
         add(serv);
         add(acti);
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
         new chat1();
         String string;
         string=serv.getText();
         s=new Socket(string, 3333);
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
