package aliceinnets.xlab.play;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PlayWithPython {
	
	public static void main(String[] args) {
		String pathname = System.getProperty("user.home")+"/temp/auto.py";
		
		try {
			PrintWriter out = new PrintWriter(new File(pathname));
			
			out.append("import sys; print('%s %s' % (sys.executable or sys.platform, sys.version))\n");
//			out.append("import pylab\n");
			out.append("import numpy as np\n");
			out.append("import matplotlib.pyplot as plt\n");
			
			out.append("x = np.linspace(0,10,100)\n");
			out.append("y = np.sin(x)\n");
			out.append("x\n");
			out.append("y\n");
			
			out.append("a = 1\n");
			out.append("b = 2\n");
			out.append("a+b\n");
			
			out.append("plt.plot(x,y)\n");
//			out.append("plt.show()\n");
			
			out.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String s = null;
		try {
			System.out.println("python "+pathname);
			Process p = Runtime.getRuntime().exec("python "+pathname);
			System.out.println(p);
			
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			
			p.getOutputStream().write("plt.show()\n".getBytes());
			
			// read the output from the command
			System.out.println("Here is the standard output of the command:\n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

			// read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}

			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
