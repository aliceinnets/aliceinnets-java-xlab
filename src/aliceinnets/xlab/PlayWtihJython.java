package aliceinnets.xlab;

import org.python.util.PythonInterpreter;

public class PlayWtihJython {
	
	public static void main(String[] args) {
		PythonInterpreter interpreter = new PythonInterpreter();
		
		interpreter.exec("import sys; print('%s %s' % (sys.executable or sys.platform, sys.version))");
//		interpreter.exec("import sys\nsys.path.append('usr/local/bin/python3.4')");
//		interpreter.exec("pylab");
//		interpreter.exec("import numpy as np");
//		interpreter.exec("import matplotlib.pyplot as plt");
		
//		interpreter.exec("x = np.linspace(0,10,100)");
//		interpreter.exec("y = np.sin(x)");
//		interpreter.exec("plt.plot(x,y)");
//		interpreter.exec("plt.show()");
		interpreter.close();
		
	}

}
