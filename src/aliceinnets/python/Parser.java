package aliceinnets.python;

import java.lang.reflect.Array;

public class Parser {
	
	public final static String toNumpyExpression(Object obj) {
		if(obj == null) {
			return "";
		} else if(!obj.getClass().isArray()) {
			if(obj instanceof Double) {
				if(obj.equals(Double.NaN)) {
					return "np.NaN";
				} else if(obj.equals(Double.NEGATIVE_INFINITY)) {
					return "-np.Inf";
				} else if(obj.equals(Double.POSITIVE_INFINITY)) {
					return "np.Inf";
				}
			} else if(obj instanceof Float) {
				if(obj.equals(Float.NaN)) {
					return "np.NaN";
				} else if(obj.equals(Float.NEGATIVE_INFINITY)) {
					return "-np.Inf";
				} else if(obj.equals(Float.POSITIVE_INFINITY)) {
					return "np.Inf";
				}
			}
			return String.valueOf(obj);
		} else {
			Class<?> componentType = obj.getClass().getComponentType();
			if(!componentType.equals(Object.class)) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("[");
				for(int i=0;i<Array.getLength(obj)-1;++i) {
					buffer.append(toNumpyExpression(Array.get(obj, i)));
					buffer.append(", ");
				}
				buffer.append(toNumpyExpression(Array.get(obj, Array.getLength(obj)-1)));
				buffer.append("]");
				return buffer.toString();
			} else {
				StringBuffer buffer = new StringBuffer();
				for(int i=0;i<Array.getLength(obj)-1;++i) {
					buffer.append(toNumpyExpression(Array.get(obj, i)));
					buffer.append(", ");
				}
				buffer.append(toNumpyExpression(Array.get(obj, Array.getLength(obj)-1)));
				return buffer.toString();
			}
			
		}
	}
	

	public final static String toParameterName(String pythonParam) {
		if(pythonParam.matches("\\*\\*.+")) {
			return pythonParam.substring(2);
		} else if(pythonParam.matches("\\*.+")) {
			return pythonParam.substring(1);
		} else if(pythonParam.contains("=")){
			return pythonParam.split("\\=")[0];
		} else {
			return pythonParam;
		}
	}

}
