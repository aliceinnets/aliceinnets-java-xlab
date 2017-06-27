package aliceinnets.xlab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PlayWithCheckSum {

	public static void main(String args[]) {
		String pathname = System.getProperty("user.home")+File.separator+".gitconfig";
		try {
			FileInputStream in = new FileInputStream(pathname);
			MessageDigest md = MessageDigest.getInstance("SHA1");
			
			byte[] dataBytes = new byte[1024];
			int nread = 0;
			while ((nread = in.read(dataBytes)) != -1) {
				md.update(dataBytes, 0, nread);
			}
			byte[] mdbytes = md.digest();

			//convert the byte to hex format
			StringBuffer string = new StringBuffer();
			for (int i = 0; i < mdbytes.length; i++) {
				string.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			System.out.println("Digest(in hex format):: " + string.toString());

		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}		
	}
}