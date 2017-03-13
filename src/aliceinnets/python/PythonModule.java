package aliceinnets.python;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import aliceinnets.util.OneLiners;

public class PythonModule {
	
	public final static String COMMENT = "#";
	public final static String HEADER = COMMENT + "Auto generated python script\n";
	
	
	protected String pathname;
	protected StringBuffer script;
	
	
	public PythonModule() {
		this(PythonScript.DEFAULT_PATH+System.nanoTime()+".py", null);
	}
	
	
	public PythonModule(String pathname, String script) {
		if(pathname != null && !pathname.equals("")) {
			this.pathname = pathname;
		}
		
		init();
		if(script != null) {
			this.script.append(script);
		} 
		
	}
	
	
	public void save() throws FileNotFoundException {
		String path = pathname.substring(0, pathname.lastIndexOf(File.separator));
		OneLiners.mkdirs(path);
		PrintWriter out = new PrintWriter(new File(pathname));
		out.write(script.toString());
		out.close();
	}
	
	
	public void exec() throws IOException {
		save();
		PythonScript.exec(pathname);
	}
	
	
	public void init() {
		this.script = new StringBuffer(HEADER);
		this.script.append(COMMENT+"generated at "+System.nanoTime()+"\n");
		
	}
	
	
	public PythonModule write(String script) {
		this.script.append(script);
		return this;
	}
	

}
