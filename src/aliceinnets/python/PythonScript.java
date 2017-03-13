package aliceinnets.python;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class PythonScript {
	
	public final static String DEFAULT_PATH = System.getProperty("user.home") + File.separator+PythonScript.class.getSimpleName() + File.separator;
	
	public final static String COMMENT = "#";
	public final static String LOG_HEADER = COMMENT + "Java exec python script log\n";
	public final static String LOG_FOOTER = "";
	
	
	public final static boolean exec(String pathname) throws IOException {
		return exec(pathname, "python", false, false);
	}
	
	
	public final static boolean exec(String pathname, String python) throws IOException {
		return exec(pathname, python, false, false);
	}
	
	
	public final static boolean exec(String pathname, String python, boolean print, boolean saveLog) throws IOException {
		StringBuffer log = new StringBuffer();
		log.append(LOG_HEADER);
		log.append(COMMENT+"Python starts at "+System.nanoTime()+"\n");
		log.append(COMMENT+"exec: "+python+" "+pathname+"\n");
		Process process = Runtime.getRuntime().exec(python+" "+pathname);
		
		String buffer = null;
		BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		while ((buffer = inputStreamReader.readLine()) != null) {
			log.append(buffer);
			if(print) System.out.println(buffer);
		}
		inputStreamReader.close();
		
		boolean error = false;
		BufferedReader errorStreamReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		while ((buffer = errorStreamReader.readLine()) != null) {
			error = true;
			log.append(buffer);
			System.err.println(buffer);
		}
		errorStreamReader.close();
		
		process.destroy();
//		System.exit(0);
		log.append(COMMENT+"Python ends at "+System.nanoTime()+"\n");
		
		if(saveLog) {
			String[] names = pathname.split(Pattern.quote(File.separator));
			PrintWriter out = new PrintWriter(new File(DEFAULT_PATH+names[names.length-1]+"_"+System.nanoTime()+".txt"));
			out.write(log.toString());
			out.close();
		}
		return error;
	}

}
