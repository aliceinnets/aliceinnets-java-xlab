package aliceinnets.python.jyplot;

import java.io.FileNotFoundException;

import aliceinnets.python.Parser;
import aliceinnets.python.PythonModule;

/**
 * TODO: javadoc, simplified method call, avoid \", and data storing
 * 
 * loadData("x", x, "y", y).plot("x", "y", null).save().exec();
 * 
 * @author Sapphire
 *
 */
public class JyPlot extends PythonModule {
	
	
	public JyPlot() {
		
	}
	
	public JyPlot(String pathname, String script) {
		super(pathname, script);
		
	}
	
	
	@Override
	public void save() throws FileNotFoundException {
//		script.append("plt.show()\n");
//		script.append("plt.savefig")
		super.save();
		
	}
	
	@Override
	public void init() {
		super.init();
		script.append("import numpy as np\n");
		script.append("import matplotlib.pyplot as plt\n");
	}
	
	
	@Override
	public JyPlot write(String script) {
		super.write(script);
		return this;
	}
	
	
	public JyPlot plot(double[] x, double[] y) {
		script.append("x = ");
		script.append(Parser.toNumpyExpression(x));
		script.append("\n");
		script.append("y = ");
		script.append(Parser.toNumpyExpression(y));
		script.append("\n");
		script.append("plt.plot("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+")\n");
		return this;
	}
	
	
	public JyPlot grid() {
		script.append("plt.grid()\n");
		return this;
	}
	
	public JyPlot acorr(Object x, Object hold, Object data, Object[] keywords) {
		script.append("plt.acorr("+Parser.toNumpyExpression(x)+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot angle_spectrum(Object x, Object Fs, Object Fc, Object window, Object pad_to, Object sides, Object hold, Object data, Object[] keywords) {
		script.append("plt.angle_spectrum("+Parser.toNumpyExpression(x)+(Fs != null ? (", "+Parser.toNumpyExpression(Fs)) : "")+(Fc != null ? (", "+Parser.toNumpyExpression(Fc)) : "")+(window != null ? (", "+Parser.toNumpyExpression(window)) : "")+(pad_to != null ? (", "+Parser.toNumpyExpression(pad_to)) : "")+(sides != null ? (", "+Parser.toNumpyExpression(sides)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot annotate(Object[] args, Object[] keywords) {
		script.append("plt.annotate("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot arrow(Object x, Object y, Object dx, Object dy, Object hold, Object[] keywords) {
		script.append("plt.arrow("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+", "+Parser.toNumpyExpression(dx)+", "+Parser.toNumpyExpression(dy)+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot autoscale(Object enable, Object axis, Object tight) {
		script.append("plt.autoscale("+(enable != null ? (Parser.toNumpyExpression(enable)) : "")+(axis != null ? (", "+Parser.toNumpyExpression(axis)) : "")+(tight != null ? (", "+Parser.toNumpyExpression(tight)) : "")+")\n");
		return this;
	}
	
	public JyPlot autumn() {
		script.append("plt.autumn()\n");
		return this;
	}
	
	public JyPlot axes(Object[] args, Object[] keywords) {
		script.append("plt.axes("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot axhline(Object y, Object xmin, Object xmax, Object hold, Object[] keywords) {
		script.append("plt.axhline("+(y != null ? (Parser.toNumpyExpression(y)) : "")+(xmin != null ? (", "+Parser.toNumpyExpression(xmin)) : "")+(xmax != null ? (", "+Parser.toNumpyExpression(xmax)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot axhspan(Object ymin, Object ymax, Object xmin, Object xmax, Object hold, Object[] keywords) {
		script.append("plt.axhspan("+Parser.toNumpyExpression(ymin)+", "+Parser.toNumpyExpression(ymax)+(xmin != null ? (", "+Parser.toNumpyExpression(xmin)) : "")+(xmax != null ? (", "+Parser.toNumpyExpression(xmax)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot axis(Object[] args, Object[] keywords) {
		script.append("plt.axis("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot axvline(Object x, Object ymin, Object ymax, Object hold, Object[] keywords) {
		script.append("plt.axvline("+(x != null ? (Parser.toNumpyExpression(x)) : "")+(ymin != null ? (", "+Parser.toNumpyExpression(ymin)) : "")+(ymax != null ? (", "+Parser.toNumpyExpression(ymax)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot axvspan(Object xmin, Object xmax, Object ymin, Object ymax, Object hold, Object[] keywords) {
		script.append("plt.axvspan("+Parser.toNumpyExpression(xmin)+", "+Parser.toNumpyExpression(xmax)+(ymin != null ? (", "+Parser.toNumpyExpression(ymin)) : "")+(ymax != null ? (", "+Parser.toNumpyExpression(ymax)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot bar(Object left, Object height, Object width, Object bottom, Object hold, Object data, Object[] keywords) {
		script.append("plt.bar("+Parser.toNumpyExpression(left)+", "+Parser.toNumpyExpression(height)+(width != null ? (", "+Parser.toNumpyExpression(width)) : "")+(bottom != null ? (", "+Parser.toNumpyExpression(bottom)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot barbs(Object[] args, Object[] keywords) {
		script.append("plt.barbs("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot barh(Object bottom, Object width, Object height, Object left, Object hold, Object[] keywords) {
		script.append("plt.barh("+Parser.toNumpyExpression(bottom)+", "+Parser.toNumpyExpression(width)+(height != null ? (", "+Parser.toNumpyExpression(height)) : "")+(left != null ? (", "+Parser.toNumpyExpression(left)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot bone() {
		script.append("plt.bone()\n");
		return this;
	}
	
	public JyPlot box(Object on) {
		script.append("plt.box("+(on != null ? (Parser.toNumpyExpression(on)) : "")+")\n");
		return this;
	}
	
	public JyPlot boxplot(Object x, Object notch, Object sym, Object vert, Object whis, Object positions, Object widths, Object patch_artist, Object bootstrap, Object usermedians, Object conf_intervals, Object meanline, Object showmeans, Object showcaps, Object showbox, Object showfliers, Object boxprops, Object labels, Object flierprops, Object medianprops, Object meanprops, Object capprops, Object whiskerprops, Object manage_xticks, Object autorange, Object zorder, Object hold, Object data) {
		script.append("plt.boxplot("+Parser.toNumpyExpression(x)+(notch != null ? (", "+Parser.toNumpyExpression(notch)) : "")+(sym != null ? (", "+Parser.toNumpyExpression(sym)) : "")+(vert != null ? (", "+Parser.toNumpyExpression(vert)) : "")+(whis != null ? (", "+Parser.toNumpyExpression(whis)) : "")+(positions != null ? (", "+Parser.toNumpyExpression(positions)) : "")+(widths != null ? (", "+Parser.toNumpyExpression(widths)) : "")+(patch_artist != null ? (", "+Parser.toNumpyExpression(patch_artist)) : "")+(bootstrap != null ? (", "+Parser.toNumpyExpression(bootstrap)) : "")+(usermedians != null ? (", "+Parser.toNumpyExpression(usermedians)) : "")+(conf_intervals != null ? (", "+Parser.toNumpyExpression(conf_intervals)) : "")+(meanline != null ? (", "+Parser.toNumpyExpression(meanline)) : "")+(showmeans != null ? (", "+Parser.toNumpyExpression(showmeans)) : "")+(showcaps != null ? (", "+Parser.toNumpyExpression(showcaps)) : "")+(showbox != null ? (", "+Parser.toNumpyExpression(showbox)) : "")+(showfliers != null ? (", "+Parser.toNumpyExpression(showfliers)) : "")+(boxprops != null ? (", "+Parser.toNumpyExpression(boxprops)) : "")+(labels != null ? (", "+Parser.toNumpyExpression(labels)) : "")+(flierprops != null ? (", "+Parser.toNumpyExpression(flierprops)) : "")+(medianprops != null ? (", "+Parser.toNumpyExpression(medianprops)) : "")+(meanprops != null ? (", "+Parser.toNumpyExpression(meanprops)) : "")+(capprops != null ? (", "+Parser.toNumpyExpression(capprops)) : "")+(whiskerprops != null ? (", "+Parser.toNumpyExpression(whiskerprops)) : "")+(manage_xticks != null ? (", "+Parser.toNumpyExpression(manage_xticks)) : "")+(autorange != null ? (", "+Parser.toNumpyExpression(autorange)) : "")+(zorder != null ? (", "+Parser.toNumpyExpression(zorder)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+")\n");
		return this;
	}
	
	public JyPlot broken_barh(Object xranges, Object yrange, Object hold, Object data, Object[] keywords) {
		script.append("plt.broken_barh("+Parser.toNumpyExpression(xranges)+", "+Parser.toNumpyExpression(yrange)+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot cla() {
		script.append("plt.cla()\n");
		return this;
	}
	
	public JyPlot clabel(Object CS, Object[] args, Object[] keywords) {
		script.append("plt.clabel("+Parser.toNumpyExpression(CS)+(args != null ? (", "+Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot clf() {
		script.append("plt.clf()\n");
		return this;
	}
	
	public JyPlot clim(Object vmin, Object vmax) {
		script.append("plt.clim("+(vmin != null ? (Parser.toNumpyExpression(vmin)) : "")+(vmax != null ? (", "+Parser.toNumpyExpression(vmax)) : "")+")\n");
		return this;
	}
	
	public JyPlot close(Object[] args) {
		script.append("plt.close("+(args != null ? (Parser.toNumpyExpression(args)) : "")+")\n");
		return this;
	}
	
	public JyPlot cohere(Object x, Object y, Object NFFT, Object Fs, Object Fc, Object detrend, Object window, Object noverlap, Object pad_to, Object sides, Object scale_by_freq, Object hold, Object data, Object[] keywords) {
		script.append("plt.cohere("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+(NFFT != null ? (", "+Parser.toNumpyExpression(NFFT)) : "")+(Fs != null ? (", "+Parser.toNumpyExpression(Fs)) : "")+(Fc != null ? (", "+Parser.toNumpyExpression(Fc)) : "")+(detrend != null ? (", "+Parser.toNumpyExpression(detrend)) : "")+(window != null ? (", "+Parser.toNumpyExpression(window)) : "")+(noverlap != null ? (", "+Parser.toNumpyExpression(noverlap)) : "")+(pad_to != null ? (", "+Parser.toNumpyExpression(pad_to)) : "")+(sides != null ? (", "+Parser.toNumpyExpression(sides)) : "")+(scale_by_freq != null ? (", "+Parser.toNumpyExpression(scale_by_freq)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot colorbar(Object mappable, Object cax, Object ax, Object[] keywords) {
		script.append("plt.colorbar("+(mappable != null ? (Parser.toNumpyExpression(mappable)) : "")+(cax != null ? (", "+Parser.toNumpyExpression(cax)) : "")+(ax != null ? (", "+Parser.toNumpyExpression(ax)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot colors() {
		script.append("plt.colors()\n");
		return this;
	}
	
	public JyPlot connect(Object s, Object func) {
		script.append("plt.connect("+Parser.toNumpyExpression(s)+", "+Parser.toNumpyExpression(func)+")\n");
		return this;
	}
	
	public JyPlot contour(Object[] args, Object[] keywords) {
		script.append("plt.contour("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot contourf(Object[] args, Object[] keywords) {
		script.append("plt.contourf("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot cool() {
		script.append("plt.cool()\n");
		return this;
	}
	
	public JyPlot copper() {
		script.append("plt.copper()\n");
		return this;
	}
	
	public JyPlot csd(Object x, Object y, Object NFFT, Object Fs, Object Fc, Object detrend, Object window, Object noverlap, Object pad_to, Object sides, Object scale_by_freq, Object return_line, Object hold, Object data, Object[] keywords) {
		script.append("plt.csd("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+(NFFT != null ? (", "+Parser.toNumpyExpression(NFFT)) : "")+(Fs != null ? (", "+Parser.toNumpyExpression(Fs)) : "")+(Fc != null ? (", "+Parser.toNumpyExpression(Fc)) : "")+(detrend != null ? (", "+Parser.toNumpyExpression(detrend)) : "")+(window != null ? (", "+Parser.toNumpyExpression(window)) : "")+(noverlap != null ? (", "+Parser.toNumpyExpression(noverlap)) : "")+(pad_to != null ? (", "+Parser.toNumpyExpression(pad_to)) : "")+(sides != null ? (", "+Parser.toNumpyExpression(sides)) : "")+(scale_by_freq != null ? (", "+Parser.toNumpyExpression(scale_by_freq)) : "")+(return_line != null ? (", "+Parser.toNumpyExpression(return_line)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot delaxes(Object[] args) {
		script.append("plt.delaxes("+(args != null ? (Parser.toNumpyExpression(args)) : "")+")\n");
		return this;
	}
	
	public JyPlot disconnect(Object cid) {
		script.append("plt.disconnect("+Parser.toNumpyExpression(cid)+")\n");
		return this;
	}
	
	public JyPlot draw() {
		script.append("plt.draw()\n");
		return this;
	}
	
	public JyPlot errorbar(Object x, Object y, Object yerr, Object xerr, Object fmt, Object ecolor, Object elinewidth, Object capsize, Object barsabove, Object lolims, Object uplims, Object xlolims, Object xuplims, Object errorevery, Object capthick, Object hold, Object data, Object[] keywords) {
		script.append("plt.errorbar("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+(yerr != null ? (", "+Parser.toNumpyExpression(yerr)) : "")+(xerr != null ? (", "+Parser.toNumpyExpression(xerr)) : "")+(fmt != null ? (", "+Parser.toNumpyExpression(fmt)) : "")+(ecolor != null ? (", "+Parser.toNumpyExpression(ecolor)) : "")+(elinewidth != null ? (", "+Parser.toNumpyExpression(elinewidth)) : "")+(capsize != null ? (", "+Parser.toNumpyExpression(capsize)) : "")+(barsabove != null ? (", "+Parser.toNumpyExpression(barsabove)) : "")+(lolims != null ? (", "+Parser.toNumpyExpression(lolims)) : "")+(uplims != null ? (", "+Parser.toNumpyExpression(uplims)) : "")+(xlolims != null ? (", "+Parser.toNumpyExpression(xlolims)) : "")+(xuplims != null ? (", "+Parser.toNumpyExpression(xuplims)) : "")+(errorevery != null ? (", "+Parser.toNumpyExpression(errorevery)) : "")+(capthick != null ? (", "+Parser.toNumpyExpression(capthick)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot eventplot(Object positions, Object orientation, Object lineoffsets, Object linelengths, Object linewidths, Object colors, Object linestyles, Object hold, Object data, Object[] keywords) {
		script.append("plt.eventplot("+Parser.toNumpyExpression(positions)+(orientation != null ? (", "+Parser.toNumpyExpression(orientation)) : "")+(lineoffsets != null ? (", "+Parser.toNumpyExpression(lineoffsets)) : "")+(linelengths != null ? (", "+Parser.toNumpyExpression(linelengths)) : "")+(linewidths != null ? (", "+Parser.toNumpyExpression(linewidths)) : "")+(colors != null ? (", "+Parser.toNumpyExpression(colors)) : "")+(linestyles != null ? (", "+Parser.toNumpyExpression(linestyles)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot figimage(Object[] args, Object[] keywords) {
		script.append("plt.figimage("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot figlegend(Object handles, Object labels, Object loc, Object[] keywords) {
		script.append("plt.figlegend("+Parser.toNumpyExpression(handles)+", "+Parser.toNumpyExpression(labels)+", "+Parser.toNumpyExpression(loc)+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot fignum_exists(Object num) {
		script.append("plt.fignum_exists("+Parser.toNumpyExpression(num)+")\n");
		return this;
	}
	
	public JyPlot figtext(Object[] args, Object[] keywords) {
		script.append("plt.figtext("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot figure(Object num, Object figsize, Object dpi, Object facecolor, Object edgecolor, Object frameon, Object FigureClass, Object[] keywords) {
		script.append("plt.figure("+(num != null ? (Parser.toNumpyExpression(num)) : "")+(figsize != null ? (", "+Parser.toNumpyExpression(figsize)) : "")+(dpi != null ? (", "+Parser.toNumpyExpression(dpi)) : "")+(facecolor != null ? (", "+Parser.toNumpyExpression(facecolor)) : "")+(edgecolor != null ? (", "+Parser.toNumpyExpression(edgecolor)) : "")+(frameon != null ? (", "+Parser.toNumpyExpression(frameon)) : "")+(FigureClass != null ? (", "+Parser.toNumpyExpression(FigureClass)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot fill(Object[] args, Object[] keywords) {
		script.append("plt.fill("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot fill_between(Object x, Object y1, Object y2, Object where, Object interpolate, Object step, Object hold, Object data, Object[] keywords) {
		script.append("plt.fill_between("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y1)+(y2 != null ? (", "+Parser.toNumpyExpression(y2)) : "")+(where != null ? (", "+Parser.toNumpyExpression(where)) : "")+(interpolate != null ? (", "+Parser.toNumpyExpression(interpolate)) : "")+(step != null ? (", "+Parser.toNumpyExpression(step)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot fill_betweenx(Object y, Object x1, Object x2, Object where, Object step, Object hold, Object data, Object[] keywords) {
		script.append("plt.fill_betweenx("+Parser.toNumpyExpression(y)+", "+Parser.toNumpyExpression(x1)+(x2 != null ? (", "+Parser.toNumpyExpression(x2)) : "")+(where != null ? (", "+Parser.toNumpyExpression(where)) : "")+(step != null ? (", "+Parser.toNumpyExpression(step)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot findobj(Object o, Object match, Object include_self) {
		script.append("plt.findobj("+(o != null ? (Parser.toNumpyExpression(o)) : "")+(match != null ? (", "+Parser.toNumpyExpression(match)) : "")+(include_self != null ? (", "+Parser.toNumpyExpression(include_self)) : "")+")\n");
		return this;
	}
	
	public JyPlot flag() {
		script.append("plt.flag()\n");
		return this;
	}
	
	public JyPlot gca(Object[] keywords) {
		script.append("plt.gca("+(keywords != null ? (Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot gcf() {
		script.append("plt.gcf()\n");
		return this;
	}
	
	public JyPlot gci() {
		script.append("plt.gci()\n");
		return this;
	}
	
	public JyPlot get_current_fig_manager() {
		script.append("plt.get_current_fig_manager()\n");
		return this;
	}
	
	public JyPlot get_figlabels() {
		script.append("plt.get_figlabels()\n");
		return this;
	}
	
	public JyPlot get_fignums() {
		script.append("plt.get_fignums()\n");
		return this;
	}
	
	public JyPlot get_plot_commands() {
		script.append("plt.get_plot_commands()\n");
		return this;
	}
	
	public JyPlot ginput(Object[] args, Object[] keywords) {
		script.append("plt.ginput("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot gray() {
		script.append("plt.gray()\n");
		return this;
	}
	
	public JyPlot grid(Object b, Object which, Object axis, Object[] keywords) {
		script.append("plt.grid("+(b != null ? (Parser.toNumpyExpression(b)) : "")+(which != null ? (", "+Parser.toNumpyExpression(which)) : "")+(axis != null ? (", "+Parser.toNumpyExpression(axis)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot hexbin(Object x, Object y, Object C, Object gridsize, Object bins, Object xscale, Object yscale, Object extent, Object cmap, Object norm, Object vmin, Object vmax, Object alpha, Object linewidths, Object edgecolors, Object reduce_C_function, Object mincnt, Object marginals, Object hold, Object data, Object[] keywords) {
		script.append("plt.hexbin("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+(C != null ? (", "+Parser.toNumpyExpression(C)) : "")+(gridsize != null ? (", "+Parser.toNumpyExpression(gridsize)) : "")+(bins != null ? (", "+Parser.toNumpyExpression(bins)) : "")+(xscale != null ? (", "+Parser.toNumpyExpression(xscale)) : "")+(yscale != null ? (", "+Parser.toNumpyExpression(yscale)) : "")+(extent != null ? (", "+Parser.toNumpyExpression(extent)) : "")+(cmap != null ? (", "+Parser.toNumpyExpression(cmap)) : "")+(norm != null ? (", "+Parser.toNumpyExpression(norm)) : "")+(vmin != null ? (", "+Parser.toNumpyExpression(vmin)) : "")+(vmax != null ? (", "+Parser.toNumpyExpression(vmax)) : "")+(alpha != null ? (", "+Parser.toNumpyExpression(alpha)) : "")+(linewidths != null ? (", "+Parser.toNumpyExpression(linewidths)) : "")+(edgecolors != null ? (", "+Parser.toNumpyExpression(edgecolors)) : "")+(reduce_C_function != null ? (", "+Parser.toNumpyExpression(reduce_C_function)) : "")+(mincnt != null ? (", "+Parser.toNumpyExpression(mincnt)) : "")+(marginals != null ? (", "+Parser.toNumpyExpression(marginals)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot hist(Object x, Object bins, Object range, Object normed, Object weights, Object cumulative, Object bottom, Object histtype, Object align, Object orientation, Object rwidth, Object log, Object color, Object label, Object stacked, Object hold, Object data, Object[] keywords) {
		script.append("plt.hist("+Parser.toNumpyExpression(x)+(bins != null ? (", "+Parser.toNumpyExpression(bins)) : "")+(range != null ? (", "+Parser.toNumpyExpression(range)) : "")+(normed != null ? (", "+Parser.toNumpyExpression(normed)) : "")+(weights != null ? (", "+Parser.toNumpyExpression(weights)) : "")+(cumulative != null ? (", "+Parser.toNumpyExpression(cumulative)) : "")+(bottom != null ? (", "+Parser.toNumpyExpression(bottom)) : "")+(histtype != null ? (", "+Parser.toNumpyExpression(histtype)) : "")+(align != null ? (", "+Parser.toNumpyExpression(align)) : "")+(orientation != null ? (", "+Parser.toNumpyExpression(orientation)) : "")+(rwidth != null ? (", "+Parser.toNumpyExpression(rwidth)) : "")+(log != null ? (", "+Parser.toNumpyExpression(log)) : "")+(color != null ? (", "+Parser.toNumpyExpression(color)) : "")+(label != null ? (", "+Parser.toNumpyExpression(label)) : "")+(stacked != null ? (", "+Parser.toNumpyExpression(stacked)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot hist2d(Object x, Object y, Object bins, Object range, Object normed, Object weights, Object cmin, Object cmax, Object hold, Object data, Object[] keywords) {
		script.append("plt.hist2d("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+(bins != null ? (", "+Parser.toNumpyExpression(bins)) : "")+(range != null ? (", "+Parser.toNumpyExpression(range)) : "")+(normed != null ? (", "+Parser.toNumpyExpression(normed)) : "")+(weights != null ? (", "+Parser.toNumpyExpression(weights)) : "")+(cmin != null ? (", "+Parser.toNumpyExpression(cmin)) : "")+(cmax != null ? (", "+Parser.toNumpyExpression(cmax)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot hlines(Object y, Object xmin, Object xmax, Object colors, Object linestyles, Object label, Object hold, Object data, Object[] keywords) {
		script.append("plt.hlines("+Parser.toNumpyExpression(y)+", "+Parser.toNumpyExpression(xmin)+", "+Parser.toNumpyExpression(xmax)+(colors != null ? (", "+Parser.toNumpyExpression(colors)) : "")+(linestyles != null ? (", "+Parser.toNumpyExpression(linestyles)) : "")+(label != null ? (", "+Parser.toNumpyExpression(label)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot hold(Object b) {
		script.append("plt.hold("+(b != null ? (Parser.toNumpyExpression(b)) : "")+")\n");
		return this;
	}
	
	public JyPlot hot() {
		script.append("plt.hot()\n");
		return this;
	}
	
	public JyPlot hsv() {
		script.append("plt.hsv()\n");
		return this;
	}
	
	public JyPlot imread(Object[] args, Object[] keywords) {
		script.append("plt.imread("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot imsave(Object[] args, Object[] keywords) {
		script.append("plt.imsave("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot imshow(Object X, Object cmap, Object norm, Object aspect, Object interpolation, Object alpha, Object vmin, Object vmax, Object origin, Object extent, Object shape, Object filternorm, Object filterrad, Object imlim, Object resample, Object url, Object hold, Object data, Object[] keywords) {
		script.append("plt.imshow("+Parser.toNumpyExpression(X)+(cmap != null ? (", "+Parser.toNumpyExpression(cmap)) : "")+(norm != null ? (", "+Parser.toNumpyExpression(norm)) : "")+(aspect != null ? (", "+Parser.toNumpyExpression(aspect)) : "")+(interpolation != null ? (", "+Parser.toNumpyExpression(interpolation)) : "")+(alpha != null ? (", "+Parser.toNumpyExpression(alpha)) : "")+(vmin != null ? (", "+Parser.toNumpyExpression(vmin)) : "")+(vmax != null ? (", "+Parser.toNumpyExpression(vmax)) : "")+(origin != null ? (", "+Parser.toNumpyExpression(origin)) : "")+(extent != null ? (", "+Parser.toNumpyExpression(extent)) : "")+(shape != null ? (", "+Parser.toNumpyExpression(shape)) : "")+(filternorm != null ? (", "+Parser.toNumpyExpression(filternorm)) : "")+(filterrad != null ? (", "+Parser.toNumpyExpression(filterrad)) : "")+(imlim != null ? (", "+Parser.toNumpyExpression(imlim)) : "")+(resample != null ? (", "+Parser.toNumpyExpression(resample)) : "")+(url != null ? (", "+Parser.toNumpyExpression(url)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot inferno() {
		script.append("plt.inferno()\n");
		return this;
	}
	
	public JyPlot install_repl_displayhook() {
		script.append("plt.install_repl_displayhook()\n");
		return this;
	}
	
	public JyPlot ioff() {
		script.append("plt.ioff()\n");
		return this;
	}
	
	public JyPlot ion() {
		script.append("plt.ion()\n");
		return this;
	}
	
	public JyPlot ishold() {
		script.append("plt.ishold()\n");
		return this;
	}
	
	public JyPlot isinteractive() {
		script.append("plt.isinteractive()\n");
		return this;
	}
	
	public JyPlot jet() {
		script.append("plt.jet()\n");
		return this;
	}
	
	public JyPlot legend(Object[] args, Object[] keywords) {
		script.append("plt.legend("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot locator_params(Object axis, Object tight, Object[] keywords) {
		script.append("plt.locator_params("+(axis != null ? (Parser.toNumpyExpression(axis)) : "")+(tight != null ? (", "+Parser.toNumpyExpression(tight)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot loglog(Object[] args, Object[] keywords) {
		script.append("plt.loglog("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot magma() {
		script.append("plt.magma()\n");
		return this;
	}
	
	public JyPlot magnitude_spectrum(Object x, Object Fs, Object Fc, Object window, Object pad_to, Object sides, Object scale, Object hold, Object data, Object[] keywords) {
		script.append("plt.magnitude_spectrum("+Parser.toNumpyExpression(x)+(Fs != null ? (", "+Parser.toNumpyExpression(Fs)) : "")+(Fc != null ? (", "+Parser.toNumpyExpression(Fc)) : "")+(window != null ? (", "+Parser.toNumpyExpression(window)) : "")+(pad_to != null ? (", "+Parser.toNumpyExpression(pad_to)) : "")+(sides != null ? (", "+Parser.toNumpyExpression(sides)) : "")+(scale != null ? (", "+Parser.toNumpyExpression(scale)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot margins(Object[] args, Object[] keywords) {
		script.append("plt.margins("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot matshow(Object A, Object fignum, Object[] keywords) {
		script.append("plt.matshow("+Parser.toNumpyExpression(A)+(fignum != null ? (", "+Parser.toNumpyExpression(fignum)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot minorticks_off() {
		script.append("plt.minorticks_off()\n");
		return this;
	}
	
	public JyPlot minorticks_on() {
		script.append("plt.minorticks_on()\n");
		return this;
	}
	
	public JyPlot nipy_spectral() {
		script.append("plt.nipy_spectral()\n");
		return this;
	}
	
	public JyPlot over(Object func, Object[] args, Object[] keywords) {
		script.append("plt.over("+Parser.toNumpyExpression(func)+(args != null ? (", "+Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot pause(Object interval) {
		script.append("plt.pause("+Parser.toNumpyExpression(interval)+")\n");
		return this;
	}
	
	public JyPlot pcolor(Object[] args, Object[] keywords) {
		script.append("plt.pcolor("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot pcolormesh(Object[] args, Object[] keywords) {
		script.append("plt.pcolormesh("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot phase_spectrum(Object x, Object Fs, Object Fc, Object window, Object pad_to, Object sides, Object hold, Object data, Object[] keywords) {
		script.append("plt.phase_spectrum("+Parser.toNumpyExpression(x)+(Fs != null ? (", "+Parser.toNumpyExpression(Fs)) : "")+(Fc != null ? (", "+Parser.toNumpyExpression(Fc)) : "")+(window != null ? (", "+Parser.toNumpyExpression(window)) : "")+(pad_to != null ? (", "+Parser.toNumpyExpression(pad_to)) : "")+(sides != null ? (", "+Parser.toNumpyExpression(sides)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot pie(Object x, Object explode, Object labels, Object colors, Object autopct, Object pctdistance, Object shadow, Object labeldistance, Object startangle, Object radius, Object counterclock, Object wedgeprops, Object textprops, Object center, Object frame, Object hold, Object data) {
		script.append("plt.pie("+Parser.toNumpyExpression(x)+(explode != null ? (", "+Parser.toNumpyExpression(explode)) : "")+(labels != null ? (", "+Parser.toNumpyExpression(labels)) : "")+(colors != null ? (", "+Parser.toNumpyExpression(colors)) : "")+(autopct != null ? (", "+Parser.toNumpyExpression(autopct)) : "")+(pctdistance != null ? (", "+Parser.toNumpyExpression(pctdistance)) : "")+(shadow != null ? (", "+Parser.toNumpyExpression(shadow)) : "")+(labeldistance != null ? (", "+Parser.toNumpyExpression(labeldistance)) : "")+(startangle != null ? (", "+Parser.toNumpyExpression(startangle)) : "")+(radius != null ? (", "+Parser.toNumpyExpression(radius)) : "")+(counterclock != null ? (", "+Parser.toNumpyExpression(counterclock)) : "")+(wedgeprops != null ? (", "+Parser.toNumpyExpression(wedgeprops)) : "")+(textprops != null ? (", "+Parser.toNumpyExpression(textprops)) : "")+(center != null ? (", "+Parser.toNumpyExpression(center)) : "")+(frame != null ? (", "+Parser.toNumpyExpression(frame)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+")\n");
		return this;
	}
	
	public JyPlot pink() {
		script.append("plt.pink()\n");
		return this;
	}
	
	public JyPlot plasma() {
		script.append("plt.plasma()\n");
		return this;
	}
	
	public JyPlot plot(Object[] args, Object[] keywords) {
		script.append("plt.plot("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot plot_date(Object x, Object y, Object fmt, Object tz, Object xdate, Object ydate, Object hold, Object data, Object[] keywords) {
		script.append("plt.plot_date("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+(fmt != null ? (", "+Parser.toNumpyExpression(fmt)) : "")+(tz != null ? (", "+Parser.toNumpyExpression(tz)) : "")+(xdate != null ? (", "+Parser.toNumpyExpression(xdate)) : "")+(ydate != null ? (", "+Parser.toNumpyExpression(ydate)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot plotfile(Object fname, Object cols, Object plotfuncs, Object comments, Object skiprows, Object checkrows, Object delimiter, Object names, Object subplots, Object newfig, Object[] keywords) {
		script.append("plt.plotfile("+Parser.toNumpyExpression(fname)+(cols != null ? (", "+Parser.toNumpyExpression(cols)) : "")+(plotfuncs != null ? (", "+Parser.toNumpyExpression(plotfuncs)) : "")+(comments != null ? (", "+Parser.toNumpyExpression(comments)) : "")+(skiprows != null ? (", "+Parser.toNumpyExpression(skiprows)) : "")+(checkrows != null ? (", "+Parser.toNumpyExpression(checkrows)) : "")+(delimiter != null ? (", "+Parser.toNumpyExpression(delimiter)) : "")+(names != null ? (", "+Parser.toNumpyExpression(names)) : "")+(subplots != null ? (", "+Parser.toNumpyExpression(subplots)) : "")+(newfig != null ? (", "+Parser.toNumpyExpression(newfig)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot polar(Object[] args, Object[] keywords) {
		script.append("plt.polar("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot prism() {
		script.append("plt.prism()\n");
		return this;
	}
	
	public JyPlot psd(Object x, Object NFFT, Object Fs, Object Fc, Object detrend, Object window, Object noverlap, Object pad_to, Object sides, Object scale_by_freq, Object return_line, Object hold, Object data, Object[] keywords) {
		script.append("plt.psd("+Parser.toNumpyExpression(x)+(NFFT != null ? (", "+Parser.toNumpyExpression(NFFT)) : "")+(Fs != null ? (", "+Parser.toNumpyExpression(Fs)) : "")+(Fc != null ? (", "+Parser.toNumpyExpression(Fc)) : "")+(detrend != null ? (", "+Parser.toNumpyExpression(detrend)) : "")+(window != null ? (", "+Parser.toNumpyExpression(window)) : "")+(noverlap != null ? (", "+Parser.toNumpyExpression(noverlap)) : "")+(pad_to != null ? (", "+Parser.toNumpyExpression(pad_to)) : "")+(sides != null ? (", "+Parser.toNumpyExpression(sides)) : "")+(scale_by_freq != null ? (", "+Parser.toNumpyExpression(scale_by_freq)) : "")+(return_line != null ? (", "+Parser.toNumpyExpression(return_line)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot quiver(Object[] args, Object[] keywords) {
		script.append("plt.quiver("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot quiverkey(Object[] args, Object[] keywords) {
		script.append("plt.quiverkey("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot rc(Object[] args, Object[] keywords) {
		script.append("plt.rc("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot rc_context(Object rc, Object fname) {
		script.append("plt.rc_context("+(rc != null ? (Parser.toNumpyExpression(rc)) : "")+(fname != null ? (", "+Parser.toNumpyExpression(fname)) : "")+")\n");
		return this;
	}
	
	public JyPlot rcdefaults() {
		script.append("plt.rcdefaults()\n");
		return this;
	}
	
	public JyPlot rgrids(Object[] args, Object[] keywords) {
		script.append("plt.rgrids("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot savefig(Object[] args, Object[] keywords) {
		script.append("plt.savefig("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot sca(Object ax) {
		script.append("plt.sca("+Parser.toNumpyExpression(ax)+")\n");
		return this;
	}
	
	public JyPlot scatter(Object x, Object y, Object s, Object c, Object marker, Object cmap, Object norm, Object vmin, Object vmax, Object alpha, Object linewidths, Object verts, Object edgecolors, Object hold, Object data, Object[] keywords) {
		script.append("plt.scatter("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+(s != null ? (", "+Parser.toNumpyExpression(s)) : "")+(c != null ? (", "+Parser.toNumpyExpression(c)) : "")+(marker != null ? (", "+Parser.toNumpyExpression(marker)) : "")+(cmap != null ? (", "+Parser.toNumpyExpression(cmap)) : "")+(norm != null ? (", "+Parser.toNumpyExpression(norm)) : "")+(vmin != null ? (", "+Parser.toNumpyExpression(vmin)) : "")+(vmax != null ? (", "+Parser.toNumpyExpression(vmax)) : "")+(alpha != null ? (", "+Parser.toNumpyExpression(alpha)) : "")+(linewidths != null ? (", "+Parser.toNumpyExpression(linewidths)) : "")+(verts != null ? (", "+Parser.toNumpyExpression(verts)) : "")+(edgecolors != null ? (", "+Parser.toNumpyExpression(edgecolors)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot sci(Object im) {
		script.append("plt.sci("+Parser.toNumpyExpression(im)+")\n");
		return this;
	}
	
	public JyPlot semilogx(Object[] args, Object[] keywords) {
		script.append("plt.semilogx("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot semilogy(Object[] args, Object[] keywords) {
		script.append("plt.semilogy("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot set_cmap(Object cmap) {
		script.append("plt.set_cmap("+Parser.toNumpyExpression(cmap)+")\n");
		return this;
	}
	
	public JyPlot setp(Object[] args, Object[] keywords) {
		script.append("plt.setp("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot show(Object[] args, Object[] keywords) {
		script.append("plt.show("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot specgram(Object x, Object NFFT, Object Fs, Object Fc, Object detrend, Object window, Object noverlap, Object cmap, Object xextent, Object pad_to, Object sides, Object scale_by_freq, Object mode, Object scale, Object vmin, Object vmax, Object hold, Object data, Object[] keywords) {
		script.append("plt.specgram("+Parser.toNumpyExpression(x)+(NFFT != null ? (", "+Parser.toNumpyExpression(NFFT)) : "")+(Fs != null ? (", "+Parser.toNumpyExpression(Fs)) : "")+(Fc != null ? (", "+Parser.toNumpyExpression(Fc)) : "")+(detrend != null ? (", "+Parser.toNumpyExpression(detrend)) : "")+(window != null ? (", "+Parser.toNumpyExpression(window)) : "")+(noverlap != null ? (", "+Parser.toNumpyExpression(noverlap)) : "")+(cmap != null ? (", "+Parser.toNumpyExpression(cmap)) : "")+(xextent != null ? (", "+Parser.toNumpyExpression(xextent)) : "")+(pad_to != null ? (", "+Parser.toNumpyExpression(pad_to)) : "")+(sides != null ? (", "+Parser.toNumpyExpression(sides)) : "")+(scale_by_freq != null ? (", "+Parser.toNumpyExpression(scale_by_freq)) : "")+(mode != null ? (", "+Parser.toNumpyExpression(mode)) : "")+(scale != null ? (", "+Parser.toNumpyExpression(scale)) : "")+(vmin != null ? (", "+Parser.toNumpyExpression(vmin)) : "")+(vmax != null ? (", "+Parser.toNumpyExpression(vmax)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot spectral() {
		script.append("plt.spectral()\n");
		return this;
	}
	
	public JyPlot spring() {
		script.append("plt.spring()\n");
		return this;
	}
	
	public JyPlot spy(Object Z, Object precision, Object marker, Object markersize, Object aspect, Object[] keywords) {
		script.append("plt.spy("+Parser.toNumpyExpression(Z)+(precision != null ? (", "+Parser.toNumpyExpression(precision)) : "")+(marker != null ? (", "+Parser.toNumpyExpression(marker)) : "")+(markersize != null ? (", "+Parser.toNumpyExpression(markersize)) : "")+(aspect != null ? (", "+Parser.toNumpyExpression(aspect)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot stackplot(Object x, Object[] args, Object[] keywords) {
		script.append("plt.stackplot("+Parser.toNumpyExpression(x)+(args != null ? (", "+Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot stem(Object[] args, Object[] keywords) {
		script.append("plt.stem("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot step(Object x, Object y, Object[] args, Object[] keywords) {
		script.append("plt.step("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+(args != null ? (", "+Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot streamplot(Object x, Object y, Object u, Object v, Object density, Object linewidth, Object color, Object cmap, Object norm, Object arrowsize, Object arrowstyle, Object minlength, Object transform, Object zorder, Object start_points, Object hold, Object data) {
		script.append("plt.streamplot("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+", "+Parser.toNumpyExpression(u)+", "+Parser.toNumpyExpression(v)+(density != null ? (", "+Parser.toNumpyExpression(density)) : "")+(linewidth != null ? (", "+Parser.toNumpyExpression(linewidth)) : "")+(color != null ? (", "+Parser.toNumpyExpression(color)) : "")+(cmap != null ? (", "+Parser.toNumpyExpression(cmap)) : "")+(norm != null ? (", "+Parser.toNumpyExpression(norm)) : "")+(arrowsize != null ? (", "+Parser.toNumpyExpression(arrowsize)) : "")+(arrowstyle != null ? (", "+Parser.toNumpyExpression(arrowstyle)) : "")+(minlength != null ? (", "+Parser.toNumpyExpression(minlength)) : "")+(transform != null ? (", "+Parser.toNumpyExpression(transform)) : "")+(zorder != null ? (", "+Parser.toNumpyExpression(zorder)) : "")+(start_points != null ? (", "+Parser.toNumpyExpression(start_points)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+")\n");
		return this;
	}
	
	public JyPlot subplot(Object[] args, Object[] keywords) {
		script.append("plt.subplot("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot subplot2grid(Object shape, Object loc, Object rowspan, Object colspan, Object[] keywords) {
		script.append("plt.subplot2grid("+Parser.toNumpyExpression(shape)+", "+Parser.toNumpyExpression(loc)+(rowspan != null ? (", "+Parser.toNumpyExpression(rowspan)) : "")+(colspan != null ? (", "+Parser.toNumpyExpression(colspan)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot subplot_tool(Object targetfig) {
		script.append("plt.subplot_tool("+(targetfig != null ? (Parser.toNumpyExpression(targetfig)) : "")+")\n");
		return this;
	}
	
	public JyPlot subplots(Object nrows, Object ncols, Object sharex, Object sharey, Object squeeze, Object subplot_kw, Object gridspec_kw, Object[] keywords) {
		script.append("plt.subplots("+(nrows != null ? (Parser.toNumpyExpression(nrows)) : "")+(ncols != null ? (", "+Parser.toNumpyExpression(ncols)) : "")+(sharex != null ? (", "+Parser.toNumpyExpression(sharex)) : "")+(sharey != null ? (", "+Parser.toNumpyExpression(sharey)) : "")+(squeeze != null ? (", "+Parser.toNumpyExpression(squeeze)) : "")+(subplot_kw != null ? (", "+Parser.toNumpyExpression(subplot_kw)) : "")+(gridspec_kw != null ? (", "+Parser.toNumpyExpression(gridspec_kw)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot subplots_adjust(Object[] args, Object[] keywords) {
		script.append("plt.subplots_adjust("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot summer() {
		script.append("plt.summer()\n");
		return this;
	}
	
	public JyPlot suptitle(Object[] args, Object[] keywords) {
		script.append("plt.suptitle("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot switch_backend(Object newbackend) {
		script.append("plt.switch_backend("+Parser.toNumpyExpression(newbackend)+")\n");
		return this;
	}
	
	public JyPlot table(Object[] keywords) {
		script.append("plt.table("+(keywords != null ? (Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot text(Object x, Object y, Object s, Object fontdict, Object withdash, Object[] keywords) {
		script.append("plt.text("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+", "+Parser.toNumpyExpression(s)+(fontdict != null ? (", "+Parser.toNumpyExpression(fontdict)) : "")+(withdash != null ? (", "+Parser.toNumpyExpression(withdash)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot thetagrids(Object[] args, Object[] keywords) {
		script.append("plt.thetagrids("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot tick_params(Object axis, Object[] keywords) {
		script.append("plt.tick_params("+(axis != null ? (Parser.toNumpyExpression(axis)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot ticklabel_format(Object[] keywords) {
		script.append("plt.ticklabel_format("+(keywords != null ? (Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot tight_layout(Object pad, Object h_pad, Object w_pad, Object rect) {
		script.append("plt.tight_layout("+(pad != null ? (Parser.toNumpyExpression(pad)) : "")+(h_pad != null ? (", "+Parser.toNumpyExpression(h_pad)) : "")+(w_pad != null ? (", "+Parser.toNumpyExpression(w_pad)) : "")+(rect != null ? (", "+Parser.toNumpyExpression(rect)) : "")+")\n");
		return this;
	}
	
	public JyPlot title(Object s, Object[] args, Object[] keywords) {
		script.append("plt.title("+Parser.toNumpyExpression(s)+(args != null ? (", "+Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot tricontour(Object[] args, Object[] keywords) {
		script.append("plt.tricontour("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot tricontourf(Object[] args, Object[] keywords) {
		script.append("plt.tricontourf("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot tripcolor(Object[] args, Object[] keywords) {
		script.append("plt.tripcolor("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot triplot(Object[] args, Object[] keywords) {
		script.append("plt.triplot("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot twinx(Object ax) {
		script.append("plt.twinx("+(ax != null ? (Parser.toNumpyExpression(ax)) : "")+")\n");
		return this;
	}
	
	public JyPlot twiny(Object ax) {
		script.append("plt.twiny("+(ax != null ? (Parser.toNumpyExpression(ax)) : "")+")\n");
		return this;
	}
	
	public JyPlot uninstall_repl_displayhook() {
		script.append("plt.uninstall_repl_displayhook()\n");
		return this;
	}
	
	public JyPlot violinplot(Object dataset, Object positions, Object vert, Object widths, Object showmeans, Object showextrema, Object showmedians, Object points, Object bw_method, Object hold, Object data) {
		script.append("plt.violinplot("+Parser.toNumpyExpression(dataset)+(positions != null ? (", "+Parser.toNumpyExpression(positions)) : "")+(vert != null ? (", "+Parser.toNumpyExpression(vert)) : "")+(widths != null ? (", "+Parser.toNumpyExpression(widths)) : "")+(showmeans != null ? (", "+Parser.toNumpyExpression(showmeans)) : "")+(showextrema != null ? (", "+Parser.toNumpyExpression(showextrema)) : "")+(showmedians != null ? (", "+Parser.toNumpyExpression(showmedians)) : "")+(points != null ? (", "+Parser.toNumpyExpression(points)) : "")+(bw_method != null ? (", "+Parser.toNumpyExpression(bw_method)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+")\n");
		return this;
	}
	
	public JyPlot viridis() {
		script.append("plt.viridis()\n");
		return this;
	}
	
	public JyPlot vlines(Object x, Object ymin, Object ymax, Object colors, Object linestyles, Object label, Object hold, Object data, Object[] keywords) {
		script.append("plt.vlines("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(ymin)+", "+Parser.toNumpyExpression(ymax)+(colors != null ? (", "+Parser.toNumpyExpression(colors)) : "")+(linestyles != null ? (", "+Parser.toNumpyExpression(linestyles)) : "")+(label != null ? (", "+Parser.toNumpyExpression(label)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot waitforbuttonpress(Object[] args, Object[] keywords) {
		script.append("plt.waitforbuttonpress("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot winter() {
		script.append("plt.winter()\n");
		return this;
	}
	
	public JyPlot xcorr(Object x, Object y, Object normed, Object detrend, Object usevlines, Object maxlags, Object hold, Object data, Object[] keywords) {
		script.append("plt.xcorr("+Parser.toNumpyExpression(x)+", "+Parser.toNumpyExpression(y)+(normed != null ? (", "+Parser.toNumpyExpression(normed)) : "")+(detrend != null ? (", "+Parser.toNumpyExpression(detrend)) : "")+(usevlines != null ? (", "+Parser.toNumpyExpression(usevlines)) : "")+(maxlags != null ? (", "+Parser.toNumpyExpression(maxlags)) : "")+(hold != null ? (", "+Parser.toNumpyExpression(hold)) : "")+(data != null ? (", "+Parser.toNumpyExpression(data)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot xkcd(Object scale, Object length, Object randomness) {
		script.append("plt.xkcd("+(scale != null ? (Parser.toNumpyExpression(scale)) : "")+(length != null ? (", "+Parser.toNumpyExpression(length)) : "")+(randomness != null ? (", "+Parser.toNumpyExpression(randomness)) : "")+")\n");
		return this;
	}
	
	public JyPlot xlabel(Object s, Object[] args, Object[] keywords) {
		script.append("plt.xlabel("+Parser.toNumpyExpression(s)+(args != null ? (", "+Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot xlim(Object[] args, Object[] keywords) {
		script.append("plt.xlim("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot xscale(Object[] args, Object[] keywords) {
		script.append("plt.xscale("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot xticks(Object[] args, Object[] keywords) {
		script.append("plt.xticks("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot ylabel(Object s, Object[] args, Object[] keywords) {
		script.append("plt.ylabel("+Parser.toNumpyExpression(s)+(args != null ? (", "+Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot ylim(Object[] args, Object[] keywords) {
		script.append("plt.ylim("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	
	public JyPlot yscale(Object[] args, Object[] keywords) {
		script.append("plt.yscale("+(args != null ? (Parser.toNumpyExpression(args)) : "")+(keywords != null ? (", "+Parser.toNumpyExpression(keywords)) : "")+")\n");
		return this;
	}
	



}
