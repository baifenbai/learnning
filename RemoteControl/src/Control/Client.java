package Control;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.io.IOException;
import java.net.*;

public class Client extends JFrame
{
 private Socket cs;
 private MyPanel mypanel;
 
 public Client() {
	 
  mypanel=new MyPanel();
  this.getContentPane().add(mypanel);
  
  this.clock.start();
  this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
 }
 
 public static void main(String[] args)
 {
  Client client = new Client();
  client.setSize(800, 800);
  client.setVisible(true);
 
 }
 
   private javax.swing.Timer clock=new javax.swing.Timer(5000,new ActionListener() {
  public void actionPerformed(ActionEvent e)
  {
   try
   {
         cs=new Socket("172.20.56.90", 12038);
    Image image=javax.imageio.ImageIO.read(cs.getInputStream());
    mypanel.setImage(image);
    mypanel.repaint();
    cs.close();
   } catch (UnknownHostException e2)
   {
    
    e2.printStackTrace();
   } catch (IOException e2)
   {
    
    e2.printStackTrace();
   }
   
   
  }
     
    });
 public void drawImage()
 {
  
 }
}

class MyPanel extends JPanel
{
 private Image image;
 public MyPanel(Image image)
 {
    this.image=image; 
 }
   public void setImage(Image image)
   {
    this.image=image;
   }
   
 public MyPanel()
 {
  // TODO 自动生成构造函数存根
 }
 
 public void paintComponent(Graphics g)
 {
  g.drawImage(image, 0, 0, null);
 }
}