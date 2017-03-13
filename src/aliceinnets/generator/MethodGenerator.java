package aliceinnets.generator;

import java.lang.reflect.Method;

public class MethodGenerator {

	public static String generateBinaryArrayMethod(Class<?> clazz, String methodName, Class<?> parameterType1, Class<?> parameterType2) {
		try {
			Method method = clazz.getDeclaredMethod(methodName, parameterType1, parameterType2);
			return generateBinaryArrayMethod(clazz.getName(), method.getName(), method.getReturnType().toString(), method.getParameterTypes()[0].toString(), method.getParameterTypes()[1].toString());
		}
		catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String generateBinaryArrayMethod(String className, String methodName, String returnTypeName, String parameterTypeName1, String parameterTypeName2) {
		String ret = "";

		ret += "\tpublic static "+returnTypeName+"[][] "+methodName+"("+parameterTypeName1+"[][] a, "+parameterTypeName2+"[][] b) {\n";     
		ret += "\t\t"+returnTypeName+"[][] ret = new "+returnTypeName+"[a.length][a[0].length];\n";
		ret += "\t\tfor(int i=0;i<ret.length;++i)\n";                                                                                        
		ret += "\t\t\tfor(int j=0;j<ret[0].length;++j)\n";
		ret += "\t\t\t\tret[i][j] = "+className+"."+methodName+"(a[i][j], b[i][j]);\n";
		ret += "\t\treturn ret;\n";
		ret += "\t}\n\n";

		ret += "\tpublic static "+returnTypeName+"[][] "+methodName+"("+parameterTypeName1+"[][] a, "+parameterTypeName2+" b) {\n";     
		ret += "\t\t"+returnTypeName+"[][] ret = new "+returnTypeName+"[a.length][a[0].length];\n";
		ret += "\t\tfor(int i=0;i<ret.length;++i)\n";                                                                                        
		ret += "\t\t\tfor(int j=0;j<ret[0].length;++j)\n";
		ret += "\t\t\t\tret[i][j] = "+className+"."+methodName+"(a[i][j], b);\n";
		ret += "\t\treturn ret;\n";
		ret += "\t}\n\n";

		ret += "\tpublic static "+returnTypeName+"[][] "+methodName+"("+parameterTypeName1+" a, "+parameterTypeName2+"[][] b) {\n";     
		ret += "\t\t"+returnTypeName+"[][] ret = new "+returnTypeName+"[b.length][b[0].length];\n";
		ret += "\t\tfor(int i=0;i<ret.length;++i)\n";                                                                                        
		ret += "\t\t\tfor(int j=0;j<ret[0].length;++j)\n";
		ret += "\t\t\t\tret[i][j] = "+className+"."+methodName+"(a, b[i][j]);\n";
		ret += "\t\treturn ret;\n";
		ret += "\t}\n\n";

		ret += "\tpublic static "+returnTypeName+"[] "+methodName+"("+parameterTypeName1+"[] a, "+parameterTypeName2+" b) {\n";     
		ret += "\t\t"+returnTypeName+"[] ret = new "+returnTypeName+"[a.length];\n";
		ret += "\t\tfor(int i=0;i<ret.length;++i)\n";                                                                                        
		ret += "\t\t\tret[i] = "+className+"."+methodName+"(a[i], b);\n";
		ret += "\t\treturn ret;\n";
		ret += "\t}\n\n";

		ret += "\tpublic static "+returnTypeName+"[] "+methodName+"("+parameterTypeName1+" a, "+parameterTypeName2+"[] b) {\n";     
		ret += "\t\t"+returnTypeName+"[] ret = new "+returnTypeName+"[b.length];\n";
		ret += "\t\tfor(int i=0;i<ret.length;++i)\n";                                                                                        
		ret += "\t\t\tret[i] = "+className+"."+methodName+"(a, b[i]);\n";
		ret += "\t\treturn ret;\n";
		ret += "\t}\n\n";

		return ret;        
	}

	public static void main(String[] args) {
		System.out.println(generateBinaryArrayMethod(MathPlus.class, "add", long.class, long.class));
		System.out.println(generateBinaryArrayMethod(MathPlus.class, "subtract", long.class, long.class));
		System.out.println(generateBinaryArrayMethod(MathPlus.class, "mul", long.class, long.class));
		System.out.println(generateBinaryArrayMethod(MathPlus.class, "divide", long.class, long.class));

	}

}
