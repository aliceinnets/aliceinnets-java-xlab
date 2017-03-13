package aliceinnets.python;

public class PythonFunction {
	
	String signatureDesc;
	
	String className;
	String name;
	
	String desc;
	
	String parameterDesc;
	String[] parameterNames;
	Class<?> parameterTypes;
	String[] parameterDescs;
	
	String returnDesc;
	String[] returnNames;
	Class<?> returnTypes;
	String[] returnDescs;
	
	String otherParameterDesc;
	String[] otherParameterNames;
	Class<?> otherParameterTypes;
	String[] otherParameterDescs;
	
	String note;
	
	
	public PythonFunction() {
		
	}


	public String getSignatureDesc() {
		return signatureDesc;
	}


	public void setSignatureDesc(String signatureDesc) {
		this.signatureDesc = signatureDesc;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String[] getParameterNames() {
		return parameterNames;
	}


	public void setParameterNames(String[] parameterNames) {
		this.parameterNames = parameterNames;
	}
	
}
