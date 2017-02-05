package aliceinnets.xlab;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayWithMethodHandle {
	
	public static void main(String[] args) throws Throwable {
		
		FlyingSpaghettiMonster fsm = new FlyingSpaghettiMonster("methodMonster", 1000);
		
		String methodName = "sayHello";
		Object args1 = new Object[] { "Tom", "Jane" };
//		System.out.println(args1.getClass());
//		System.out.println(Array.get(args1, 0).getClass());
//		System.out.println(args1.getClass().isAssignableFrom(Object[].class));
//		args1 = getObject("Tom");
//		args1 = getObject(null);
//		args1 = getObject("Tom", "Jane");
//		args1 = getObject(new String[] { "Tom", "Jane" });
//		args1 = getObject(new Object[] { 3, new String[] { "Tom", "Jane" } });
//		args1 = getObject(new Object[] { 1, "Jane" });
//		System.out.println(args1.getClass());
//		System.out.println(Array.get(args1, 0).getClass());
//		System.out.println(args1.getClass().isAssignableFrom(Object[].class));
		
		List<Method> methods = new ArrayList<Method>();
		for(Method method : fsm.getClass().getDeclaredMethods()) {
//			if(methodName.equals(method.getName())) methods.add(method);
			if(isInvokable(method, args1)) methods.add(method);
//			methods.add(method);
		}
		for(Method method : methods) {
			System.out.println(method.getName());
			MethodType methodType = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
			MethodHandle handle = MethodHandles.lookup().findVirtual(fsm.getClass(), method.getName(), methodType).bindTo(fsm);
			System.out.println(handle);
			System.out.println(method.getReturnType());
			System.out.println(method.getParameterTypes().length);
			
//			if(method.getParameterTypes().length == 0) {
//				System.out.println(handle.invoke());
//			} else if(method.getParameterTypes().length == 1) {
//				if(!args1.getClass().isArray()) {
//					System.out.println(handle.invoke(args1));
//				} else {
//					if(Array.getLength(args1) == 1) {
//						System.out.println(handle.invoke(Array.get(args1, 0)));
//					} else {
//						System.out.println(handle.invoke(args1));
//					}
//				}
//			} else {
//				System.out.println(handle.invokeWithArguments((Object[]) args1));
//			}
			
			System.out.println(invoke(handle, args1));
			
		}
	}
	
	
	public static Object getObject(Object... args) {
		Object arg = args;
		return arg;
	}
	
	
	public static Object invoke(MethodHandle methodHandle, Object args) throws Throwable {
		if(args == null) {
			return methodHandle.invoke();
		} else if(!args.getClass().isAssignableFrom(Object[].class)) {
			return methodHandle.invoke(args);
		} else {
			return methodHandle.invokeWithArguments((Object[]) args);
		}
	}
	
	
	public static boolean isInvokable(Method method, Object args) {
		Class<?>[] parameterTypes = method.getParameterTypes();
		if(args == null) {
			if(parameterTypes.length == 0) {
				return true;
			} else {
				return false;
			}
		} else if(!args.getClass().isAssignableFrom(Object[].class)) {
			if(parameterTypes.length == 1 && isAssignableFrom(parameterTypes[0], args.getClass())) {
				return true;
			} else {
				return false;
			}
		} else {
			if(parameterTypes.length == 0) {
				return false;
			} else {
				Object[] argsArray = (Object[]) args;
				if(isAssignableFrom(parameterTypes[0], args.getClass())) {
					return true;
				} else if(parameterTypes.length == argsArray.length) {
					for(int i=0;i<parameterTypes.length;++i) {
						if(!isAssignableFrom(parameterTypes[i], argsArray[i].getClass())) {
							return false;
						}
					}
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
	
	public static boolean isInvokable(MethodHandle method, Object args) {
		try {
			method.invokeWithArguments((Object[]) args);
			return true;
		} catch (Throwable e) {
//			e.printStackTrace();
			return false;
		}
	}
	
	
	public static Object get(MethodHandle handle, Object... args) throws Throwable {
		Object args1 = args;
		Object ret = handle.invoke((Object[]) args1);
		return ret;
	}
	
	
	static boolean isAssignableFrom(Class<?> lhs, Class<?> rhs) {
		if (lhs == double.class && rhs == Double.class || lhs == Double.class && rhs == double.class) return true;
		if (lhs == float.class && rhs == Float.class || lhs == Float.class && rhs == float.class) return true;
		if (lhs == int.class && rhs == Integer.class || lhs == Integer.class && rhs == int.class) return true;
		if (lhs == long.class && rhs == Long.class || lhs == Long.class && rhs == long.class) return true;
		if (lhs == byte.class && rhs == Byte.class || lhs == Byte.class && rhs == byte.class) return true;
		if (lhs == boolean.class && rhs == Boolean.class || lhs == Boolean.class && rhs == boolean.class) return true;
		if (lhs == char.class && rhs == Character.class || lhs == Character.class && rhs == char.class) return true;
		if (lhs == short.class && rhs == Short.class || lhs == Short.class && rhs == short.class) return true;
		
		return lhs.isAssignableFrom(rhs);
	}
	
	

}
