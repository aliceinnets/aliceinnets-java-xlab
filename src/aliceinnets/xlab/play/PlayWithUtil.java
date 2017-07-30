package aliceinnets.xlab.play;

import aliceinnets.maven.util.MavenUtil;
import aliceinnets.util.OneLiners;

public class PlayWithUtil {
	
	public static void main(String[] args) {
		PlayWithUtil util = new PlayWithUtil();
		util.getPrintUserDir();
		
		System.out.println(MavenUtil.getModel().getArtifactId());
		System.out.println(MavenUtil.getModel().getGroupId());
		System.out.println(MavenUtil.getModel().getVersion());
	}
	
	public PlayWithUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public void getPrintUserDir() {
		OneLiners.printUserDir();
	}

}
