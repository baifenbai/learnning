package Control;

import java.io.IOException;

public class CloseComputer {

	public static void main(String[] args) {
		sendCloseOS();
	}

	/**
	  * Ô¶³Ì¹Ø»ú
	  */
	 public static void sendCloseOS() {
	  String command = "shutdown -m \\172.20.56.90 -f -s -t 1000";
	        Runtime r = Runtime.getRuntime();
	        try {
	   r.exec(command);
	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	 }
}
