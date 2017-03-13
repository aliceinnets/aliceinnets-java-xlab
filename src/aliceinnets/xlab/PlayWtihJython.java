package aliceinnets.xlab;

import org.python.util.PythonInterpreter;

public class PlayWtihJython {
	
	public static void main(String[] args) {
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.exec("import sys\nsys.path.append('usr/local/bin/python3.5')");
//		interpreter.exec("import pylab");
//		interpreter.exec("import numpy as np");
		interpreter.exec("import matplotlib.pyplot as plt");
		
		interpreter.exec("x = np.linspace(0,10,100)");
		interpreter.exec("y = np.sin(x)");
		interpreter.exec("plt.plot(x,y)");
		interpreter.exec("plt.show()");
		
		
	}

}
