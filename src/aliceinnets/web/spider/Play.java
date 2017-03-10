package aliceinnets.web.spider;

import java.io.FileNotFoundException;
import java.util.Arrays;

import aliceinnets.spring.Array;
import aliceinnets.util.OneLiners;

public class Play {
	
	public static void main(String[] args) {
//		run();
//		run1();
		run2();
	}

	/**
	 * <p class="p1"><span class="s11">matplotlib.pyplot.</span><span class="s1"> </span><span class="s11">acorr</span><span class="s1"> ( <i>x</i>, <i>hold=None</i>, <i>data=None</i>, <i>**kwargs</i> ) </span><span class="s7">¶</span><span class="s1"><span class="Apple-converted-space"> </span></span></p>
<p class="p10"><span class="s1">Plot the autocorrelation of </span><span class="s11">x</span><span class="s1">.</span></p>
<table cellspacing="0" cellpadding="0" class="t1">
  <tbody>
    <tr>
      <td valign="top" class="td1">
        <p class="p13"><span class="s1"><b>Parameters:</b></span></p>
      </td>
      <td valign="top" class="td2">
        <p class="p10"><span class="s1"><b>x</b> : sequence of scalar</span></p>
        <p class="p10"><span class="s1"><b>hold</b> : boolean, optional, <i>deprecated</i>, default: True</span></p>
        <p class="p10"><span class="s1"><b>detrend</b> : callable, optional, default: </span><span class="s11">mlab.detrend_none</span></p>
        <p class="p10"><span class="s1">x is detrended by the </span><span class="s11">detrend</span><span class="s1"> callable. Default is no normalization.</span></p>
        <p class="p10"><span class="s1"><b>normed</b> : boolean, optional, default: True</span></p>
        <p class="p10"><span class="s1">if True, input vectors are normalised to unit length.</span></p>
        <p class="p10"><span class="s1"><b>usevlines</b> : boolean, optional, default: True</span></p>
        <p class="p10"><span class="s1">if True, Axes.vlines is used to plot the vertical lines from the origin to the acorr. Otherwise, Axes.plot is used.</span></p>
        <p class="p10"><span class="s1"><b>maxlags</b> : integer, optional, default: 10</span></p>
        <p class="p10"><span class="s1">number of lags to show. If None, will return all 2 * len(x) - 1 lags.</span></p>
      </td>
    </tr>
    <tr>
      <td valign="top" class="td1">
        <p class="p13"><span class="s1"><b>Returns:</b></span></p>
      </td>
      <td valign="top" class="td2">
        <p class="p10"><span class="s1"><b>(lags, c, line, b)</b> : where:</span></p>
        <ul class="ul1">
          <li class="li1"><span class="s12"></span><span class="s11">lags</span><span class="s1"> are a length 2`maxlags+1 lag vector.</span></li>
          <li class="li1"><span class="s12"></span><span class="s11">c</span><span class="s1"> is the 2`maxlags+1 auto correlation vectorI</span></li>
          <li class="li1"><span class="s12"></span><span class="s11">line</span><span class="s1"> is a <a href="file:///Users/Sapphire/Downloads/lines_api.html#matplotlib.lines.Line2D"><span class="s13">Line2D</span></a> instance returned by </span><span class="s13">plot</span><span class="s1">.</span></li>
          <li class="li1"><span class="s12"></span><span class="s11">b</span><span class="s1"> is the x-axis.</span></li>
        </ul>
      </td>
    </tr>
    <tr>
      <td colspan="2" valign="top" class="td3">
        <p class="p13"><span class="s1"><b>Other Parameters:</b></span></p>
      </td>
    </tr>
    <tr>
      <td valign="top" class="td1">
        <p class="p1"><span class="s1"> </span></p>
      </td>
      <td valign="top" class="td2">
        <p class="p10"><span class="s1"><b>linestyle</b> : <a href="file:///Users/Sapphire/Downloads/lines_api.html#matplotlib.lines.Line2D"><span class="s13">Line2D</span></a> prop, optional, default: None</span></p>
        <p class="p10"><span class="s1">Only used if usevlines is False.</span></p>
        <p class="p10"><span class="s1"><b>marker</b> : string, optional, default: ‘o’</span></p>
      </td>
    </tr>
  </tbody>
</table>

@param
	 */
	private static void run2() {
		try {
			String body = OneLiners.read("/Users/Sapphire/Downloads/html1.html");
			
			System.out.println(body.substring(0, 100000));
			
//			String [] body2 = body.split(" matplotlib.pyplot.");
//			for(String text: body2) {
////				if(text.startsWith(".")) {
//					if(text.contains("¶")) {
//						String[] text2 = text.split("¶");
//						int i = 0;
////						if(text2.length == 1) {
////							for(String subtext : text2) {
//								++i;
//								System.out.println(String.format("======================== part %s ", i));
//								System.out.println(text2[0]);
//								if(text2.length > 1) {
//									
//									String[] text3 = text2[1].split("Parameters:");
//									for(String subtext : text3) {
//										System.out.println(String.format("======================== part %s ", i));
//										System.out.println(subtext);
//									}
//								}
//								
////							}
//							System.out.println("========================");
////						}
//					}
//					
//					
//					
////				}
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private static void run1() {
		Spider spider = new Spider("https://github.com/aliceinnets", new String[] {"alice"});
		spider.setSavePageDocuments(true);
		spider.setSavePageHtmlDocuments(true);
		spider.setNumPagesToSearch(1);
		spider.crawl();
		String text = spider.getPageDocuments().get(0);
//		System.out.println(text.substring(text.length()-100));
		System.out.println(spider.getPageHtmlDocuments().get(0));
		
	}

	private static void run() {
		Spider spider = new Spider("http://matplotlib.org/api/pyplot_api.html", new String[] {"matplotlib.pyplot"});
		spider.setSavePageDocuments(true);
		spider.setSavePageHtmlDocuments(true);
		spider.setNumPagesToSearch(1);
		spider.crawl();
		String text = spider.getPageDocuments().get(0);
		String html = spider.getPageHtmlDocuments().get(0);
//		System.out.println(text.substring(text.length()-100));
//		System.out.println(spider.getPageHtmlDocuments().get(0));
		
		try {
			OneLiners.write("/Users/Sapphire/Downloads/html1.txt", html);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
