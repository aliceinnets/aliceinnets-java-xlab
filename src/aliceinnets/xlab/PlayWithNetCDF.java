package aliceinnets.xlab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aliceinnets.util.OneLiners;
import ucar.ma2.Array;
import ucar.ma2.DataType;
import ucar.nc2.Attribute;
import ucar.nc2.Dimension;
import ucar.nc2.NetcdfFile;
import ucar.nc2.NetcdfFileWriter;
import ucar.nc2.Variable;

public class PlayWithNetCDF {

	public static void main(String[] args) throws Exception {
		run2();
	}

	public static void run1() throws Exception {
		NetcdfFile ncfile = NetcdfFile.open("c:/data/caches/datasignalscache/jet/66271/ppf/magn/ipla.nc");
		List<Variable> variables = ncfile.getVariables();
		for(Variable v : variables) {
			System.out.println(v.getNameAndDimensions());
		}

		Variable data = ncfile.findVariable("data");

		int[] shape = data.getShape();
		int[] origin = new int[shape.length];

		Array ncdfArray = data.read(new int[] { 5 }, new int[] { 10 });                
		Object javaArray = ncdfArray.copyToNDJavaArray(); 

		System.out.println(Arrays.toString((float[])javaArray));

		ncfile.close();
	}

	public static void run2() throws Exception {
		NetcdfFileWriter dataFile = NetcdfFileWriter.createNew(NetcdfFileWriter.Version.netcdf3, "c:/temp/a.nc");

		double[] time= OneLiners.linspace(0.0, 10.0, 100);

		// Create netCDF dimensions,
		Dimension timeDim = dataFile.addUnlimitedDimension("time");
		List<Dimension> dims = new ArrayList<Dimension>();
		dims.add(timeDim);
		Variable timeVariable = dataFile.addVariable(null, "time", DataType.DOUBLE, dims);
		timeVariable.addAttribute(new Attribute("units", "milliseconds since epoch"));
		Variable bidVariable = dataFile.addVariable(null, "bid", DataType.DOUBLE, dims);
		Variable askVariable = dataFile.addVariable(null, "ask", DataType.DOUBLE, dims);

		dataFile.addGroupAttribute(null, new Attribute("Source", "Dukascopy"));
		dataFile.addGroupAttribute(null, new Attribute("Instrument", "EURUSD"));
		dataFile.addGroupAttribute(null, new Attribute("Type", "Tick"));

		dataFile.create();
		dataFile.write(timeVariable, Array.factory(time));
		dataFile.write(bidVariable, Array.factory(time));
		dataFile.write(askVariable, Array.factory(time));
		dataFile.close();

	}

	public static void run3() throws Exception {
		NetcdfFileWriter dataFile = NetcdfFileWriter.openExisting("c:/temp/a.nc");

		Variable timeVariable = dataFile.findVariable("time");
		Variable bidVariable = dataFile.findVariable("bid");
		Variable askVariable = dataFile.findVariable("ask");

		dataFile.write(timeVariable, new int[] { 100 }, Array.factory(new double[] { 11, 12, 13 }));
		dataFile.write(bidVariable, new int[] { 100 }, Array.factory(new double[] { 11*11, 12*12, 13*13 }));
		dataFile.write(askVariable, new int[] { 100 }, Array.factory(new double[] { 11*11, 12*12, 13*13 }));
		dataFile.close();
	}

}
