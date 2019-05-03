package my_demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.xy.lee.annotation.Init;
import com.xy.lee.domain.Persion;

public class HelloWorld {
	public static void main(String[] args) throws Exception, IllegalAccessException {
//		Persion person = new Persion();
//		Class<?> persionClass  = person.getClass();
		Class<?> persionClass = Class.forName("com.xy.lee.domain.Persion");
		Persion persion = (Persion) persionClass.newInstance();
		Field[] fields = persionClass.getDeclaredFields();
		for (Field field : fields) {
			if ("java.lang.String".equals(field.getGenericType().getTypeName())) {
					Method method = persionClass.getDeclaredMethod("set" + captureName(field.getName()), String.class);
					System.out.println(method.getParameterTypes()[0].getSimpleName());
					if(method.isAnnotationPresent(Init.class)) {
						Init init = method.getAnnotation(Init.class);
						method.invoke(persion,init.name());
					}

			} else if ("int".equals(field.getGenericType().getTypeName())) {
				Method method = persionClass.getDeclaredMethod("set" + captureName(field.getName()), int.class);
				System.out.println(method.getParameterTypes()[0]);
				if(method.isAnnotationPresent(Init.class)) {
					Init init = method.getAnnotation(Init.class);
					method.invoke(persion,init.age());
				}
			}
			/*
			 * field.setAccessible(true); if
			 * ("java.lang.String".equals(field.getGenericType().getTypeName())) {
			 * field.set(persion, "哈哈哈"); } if
			 * ("java.lang.String".equals(field.getGenericType().getTypeName())) {
			 * field.set(persion, "哈哈哈"); } else if
			 * ("int".equals(field.getGenericType().getTypeName())) { field.set(persion,
			 * 12); }
			 */

		}
		System.out.println(persion);

	}

	public static String captureName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;

	}

}
