package aliceinnets.xlab;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.util.Arrays;

public class PlayWithXml {

	public static void main(String[] args) {
//		playWithJaxb();
		playWithSpring();
		
		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("Jakob");
		customer.setAge(29);
		
		double[] aa = new double[0];
		System.out.println(Arrays.toString(aa));
		
		Object[][][] a = new Object[][][] {{{1.0, 2.0}, {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE}, {customer, null, ""}, {1045374573457345723L, "Jakob"}}, null}; 
		System.out.println(Arrays.deepToString(a));
		System.out.println(Double.parseDouble(String.valueOf(Double.MAX_VALUE)));
		System.out.println(Double.isNaN(Double.parseDouble(String.valueOf(Double.NaN))));
	}

	private static void playWithSpring() {
		
		
	}
	
	

	private static void playWithJaxb() {
		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("Jakob");
		customer.setAge(29);
		
//		double[][] customer = new double[][] { {1.0, 2.0}, {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY} }; 
		
		String filename = System.getProperty("user.home")+File.separator+"temp"+File.separator+"AXml.xml";
		
		try {
			File file = new File(filename);
			JAXBContext jaxbContext = JAXBContext.newInstance(customer.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		try {

			File file = new File(filename);
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer2 = (Customer) jaxbUnmarshaller.unmarshal(file);
			
//			System.out.println(customer2.getAge());
//			System.out.println(customer2.getId());
//			System.out.println(customer2.getName());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
