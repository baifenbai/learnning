package Control;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
public class ShotImage
{
 private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
 private String imageFormat = "jpg";
 private int Num = 0;
 BufferedImage screenshot;
 public synchronized  BufferedImage snapShot()
 {
  try
  {
   screenshot = (new Robot()).createScreenCapture(new Rectangle(0, 0,
   (int) dimension.getWidth(), (int) dimension.getHeight()));
  } catch (Exception ex)
  {
   System.out.println(ex);
  }
  return screenshot;
 }
}