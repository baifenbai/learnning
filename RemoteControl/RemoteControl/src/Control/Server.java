package Control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server
{
    private final static int PORT = 12038;
    public static void main(String[] args)
    {
 try
 {
     ServerSocket server = new ServerSocket(PORT);
     Socket connection = null;
     while (true)
     {
  try
  {
     new ShotThread(server).start();
  } finally
  {
      try
      {
   if (connection != null)
       connection.close();
      } catch (IOException e)
      {
      }
  }
     }
 } catch (IOException ee)
 {
     System.err.println(ee);
 }
    } // end main
}


class ShotThread extends Thread
{
    ServerSocket server;
    public ShotThread(ServerSocket server)
    {
 try
 {
     this.connection = server.accept();
 } catch (IOException e)
 {
     e.printStackTrace();
 }
    }
    public void run()
    {
 System.out.println("得到连接:");
// try
// {
//    // this.sleep(500);
// } catch (InterruptedException e2)
// {
//     //
//     e2.printStackTrace();
// }
 java.awt.image.BufferedImage image = (new ShotImage()).snapShot();
 if (image == null)
     try
     {
  throw new IOException();
     } catch (IOException e1)
     {
  // TODO 自动生成 catch 块
  e1.printStackTrace();
     }
 try
 {
  
     javax.imageio.ImageIO.write(image, "jpg", connection
      .getOutputStream());
     connection.close();
 } catch (IOException e)
 {
     e.printStackTrace();
   
 }
    }
    Socket connection = null;
}