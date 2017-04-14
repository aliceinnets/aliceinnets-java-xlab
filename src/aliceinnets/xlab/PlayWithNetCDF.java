package aliceinnets.xlab;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import aliceinnets.util.OneLiners;
import ucar.ma2.Array;
import ucar.ma2.DataType;
import ucar.nc2.Attribute;
import ucar.nc2.Dimension;
import ucar.nc2.NetcdfFileWriter;
import ucar.nc2.Variable;

public class PlayWithNetCDF {

	public static void main(String[] args) throws Exception {
		create();
		read();
	}

	public static void create() throws Exception {
		NetcdfFileWriter dataFile = NetcdfFileWriter.createNew(NetcdfFileWriter.Version.netcdf3, System.getProperty("user.home")+File.separator+"temp"+File.separator+"a.nc");

		double[] time= OneLiners.linspace(0.0, 10.0, 11);

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

	public static void read() throws Exception {
		NetcdfFileWriter dataFile = NetcdfFileWriter.openExisting(System.getProperty("user.home")+File.separator+"temp"+File.separator+"a.nc");
		
		Variable timeVariable = dataFile.findVariable("time");
		Variable bidVariable = dataFile.findVariable("bid");
		Variable askVariable = dataFile.findVariable("ask");
		
		dataFile.write(timeVariable, new int[] { 12 }, Array.factory(new double[] { 11, 12, 13 }));
		dataFile.write(bidVariable, new int[] { 12 }, Array.factory(new double[] { 11*11, 12*12, 13*13 }));
		dataFile.write(askVariable, new int[] { 12 }, Array.factory(new double[] { 11*11, 12*12, 13*13 }));
		
		System.out.println(timeVariable);
		System.out.println(timeVariable.read());
		System.out.println(bidVariable);
		System.out.println(bidVariable.read());
		System.out.println(askVariable);
		System.out.println(askVariable.read());

		dataFile.close();
	}

}
