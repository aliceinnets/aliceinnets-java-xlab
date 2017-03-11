package aliceinnets.jyplot;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import aliceinnets.util.OneLiners;
import aliceinnets.web.WebUtils;

public class PyplotDocs {
	
	public static void main(String[] args) throws Exception {
//		saveHtml();
		parseHtml();
		
	}
	
	/**
	 * <dl class="function"> 
         <dt id="matplotlib.pyplot.acorr"> 
          <code class="descclassname">matplotlib.pyplot.</code>
          <code class="descname">acorr</code>
          <span class="sig-paren">(</span>
          <em>x</em>, 
          <em>hold=None</em>, 
          <em>data=None</em>, 
          <em>**kwargs</em>
          <span class="sig-paren">)</span>
          <a class="headerlink" href="#matplotlib.pyplot.acorr" title="Permalink to this definition">&para;</a>
         </dt> 
         <dd>
          <p>Plot the autocorrelation of <code class="xref py py-obj docutils literal"><span class="pre">x</span></code>.</p> 
          <table class="docutils field-list" frame="void" rules="none"> 
           <colgroup>
            <col class="field-name" /> 
            <col class="field-body" /> 
           </colgroup>
           <tbody valign="top"> 
            <tr class="field-odd field">
             <th class="field-name">Parameters:</th>
             <td class="field-body"><p class="first"><strong>x</strong> : sequence of scalar</p> <p><strong>hold</strong> : boolean, optional, <em>deprecated</em>, default: True</p> <p><strong>detrend</strong> : callable, optional, default: <code class="xref py py-obj docutils literal"><span class="pre">mlab.detrend_none</span></code></p> 
              <blockquote> 
               <div>
                <p>x is detrended by the <code class="xref py py-obj docutils literal"><span class="pre">detrend</span></code> callable. Default is no normalization.</p> 
               </div>
              </blockquote> <p><strong>normed</strong> : boolean, optional, default: True</p> 
              <blockquote> 
               <div>
                <p>if True, input vectors are normalised to unit length.</p> 
               </div>
              </blockquote> <p><strong>usevlines</strong> : boolean, optional, default: True</p> 
              <blockquote> 
               <div>
                <p>if True, Axes.vlines is used to plot the vertical lines from the origin to the acorr. Otherwise, Axes.plot is used.</p> 
               </div>
              </blockquote> <p><strong>maxlags</strong> : integer, optional, default: 10</p> 
              <blockquote> 
               <div>
                <p>number of lags to show. If None, will return all 2 * len(x) - 1 lags.</p> 
               </div>
              </blockquote> </td> 
            </tr> 
            <tr class="field-even field">
             <th class="field-name">Returns:</th>
             <td class="field-body"><p class="first"><strong>(lags, c, line, b)</strong> : where:</p> 
              <blockquote> 
               <div>
                <ul class="simple"> 
                 <li><code class="xref py py-obj docutils literal"><span class="pre">lags</span></code> are a length 2`maxlags+1 lag vector.</li> 
                 <li><code class="xref py py-obj docutils literal"><span class="pre">c</span></code> is the 2`maxlags+1 auto correlation vectorI</li> 
                 <li><code class="xref py py-obj docutils literal"><span class="pre">line</span></code> is a <a class="reference internal" href="lines_api.html#matplotlib.lines.Line2D" title="matplotlib.lines.Line2D"><code class="xref py py-obj docutils literal"><span class="pre">Line2D</span></code></a> instance returned by <a class="reference internal" href="#matplotlib.pyplot.plot" title="matplotlib.pyplot.plot"><code class="xref py py-obj docutils literal"><span class="pre">plot</span></code></a>.</li> 
                 <li><code class="xref py py-obj docutils literal"><span class="pre">b</span></code> is the x-axis.</li> 
                </ul> 
               </div>
              </blockquote> </td> 
            </tr> 
            <tr class="field-odd field">
             <th class="field-name" colspan="2">Other Parameters:</th>
            </tr> 
            <tr class="field-odd field">
             <td>&nbsp;</td>
             <td class="field-body"><p class="first"><strong>linestyle</strong> : <a class="reference internal" href="lines_api.html#matplotlib.lines.Line2D" title="matplotlib.lines.Line2D"><code class="xref py py-obj docutils literal"><span class="pre">Line2D</span></code></a> prop, optional, default: None</p> 
              <blockquote> 
               <div>
                <p>Only used if usevlines is False.</p> 
               </div>
              </blockquote> <p class="last"><strong>marker</strong> : string, optional, default: ‘o’</p> </td> 
            </tr> 
           </tbody> 
          </table> 
          <p class="rubric">Notes</p> 
          <p>The cross correlation is performed with <code class="xref py py-func docutils literal"><span class="pre">numpy.correlate()</span></code> with <code class="xref py py-obj docutils literal"><span class="pre">mode</span></code> = 2.</p> 
          <p class="rubric">Examples</p> 
          <p><a class="reference internal" href="#matplotlib.pyplot.xcorr" title="matplotlib.pyplot.xcorr"><code class="xref py py-obj docutils literal"><span class="pre">xcorr</span></code></a> is top graph, and <a class="reference internal" href="#matplotlib.pyplot.acorr" title="matplotlib.pyplot.acorr"><code class="xref py py-obj docutils literal"><span class="pre">acorr</span></code></a> is bottom graph.</p> 
          <p>(<a class="reference external" href="../mpl_examples/pylab_examples/xcorr_demo.py">Source code</a>, <a class="reference external" href="../mpl_examples/pylab_examples/xcorr_demo.png">png</a>, <a class="reference external" href="../mpl_examples/pylab_examples/xcorr_demo.pdf">pdf</a>)</p> 
          <div class="figure"> 
           <img alt="../_images/xcorr_demo2.png" src="../_images/xcorr_demo2.png" /> 
          </div> 
          <div class="admonition note"> 
           <p class="first admonition-title">Note</p> 
           <p>In addition to the above described arguments, this function can take a <strong>data</strong> keyword argument. If such a <strong>data</strong> argument is given, the following arguments are replaced by <strong>data[&lt;arg&gt;]</strong>:</p> 
           <ul class="last simple"> 
            <li>All arguments with the following names: ‘x’.</li> 
           </ul> 
          </div> 
         </dd>
        </dl> 
	 * @throws Exception
	 */
	private static void parseHtml() throws Exception {
		String dir = System.getProperty("user.home")+"/Downloads/";
//		String body = OneLiners.read(dir+"text.txt");
		String body = OneLiners.read(dir+"html.html");
//		String body = OneLiners.read(dir+"pyplot_api.html");
		
		Scanner scanner = new Scanner(body);
		
		int count = 0;
		while(count < 1000) {
			System.out.println(scanner.nextLine());
			++count;
		}
		
		scanner.reset();
		
		int num = 0;
		while(scanner.hasNext()) {
			String line = scanner.nextLine();
			if(line.contains("<code class=\"descname\">")) {
				System.out.println(line);
				++num;
			}
		}
		
		System.out.println(num);
		
		scanner.close();
//		System.out.println(body);

		
//		System.out.println(body.substring(0, 100000));
//		
//		String [] body2 = body.split(" matplotlib.pyplot.");
//		for(String text: body2) {
////			if(text.startsWith(".")) {
//				if(text.contains("¶")) {
//					String[] text2 = text.split("¶");
//					int i = 0;
////					if(text2.length == 1) {
////						for(String subtext : text2) {
//							++i;
//							System.out.println(String.format("======================== part %s ", i));
//							System.out.println(text2[0]);
//							if(text2.length > 1) {
//								
//								String[] text3 = text2[1].split("Parameters:");
//								for(String subtext : text3) {
//									System.out.println(String.format("======================== part %s ", i));
//									System.out.println(subtext);
//								}
//							}
//							
////						}
//						System.out.println("========================");
////					}
//				}
//				
//				
//				
////			}
//		}
		
	}
	
	
	private static void saveHtml() throws Exception {
		String dir = System.getProperty("user.home")+"/Downloads/";
		String url = "http://matplotlib.org/api/pyplot_api.html";
		
		Document document = Jsoup.connect(url).get();
		String text = document.text();
		String html = document.html();
		
		OneLiners.write(text, dir+"text.txt");
		OneLiners.write(html, dir+"html.html");
		WebUtils.saveUrl(url, dir);
		
	}

}
