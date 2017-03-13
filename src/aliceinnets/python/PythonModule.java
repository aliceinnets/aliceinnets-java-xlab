package aliceinnets.python;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

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

		String[] folders = pathname.split(Pattern.quote(File.separator));
		
		String path = folders[0];
		
		for (int i = 0; i < folders.length - 2; i++) {
			path += File.separator + folders[i+1];
			File pathName = new File(path);
			if (!pathName.exists() || !pathName.isDirectory()) {
				pathName.mkdir();
			}
		}

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
