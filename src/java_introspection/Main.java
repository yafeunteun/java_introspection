package java_introspection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;



public class Main {
	
	public static void main(String[] args) {
		
		Cinema cine = new Cinema(new ArrayList<Film>());
		Class<? extends Cinema> c = cine.getClass();
		Field [] fields = c.getDeclaredFields();
		Method [] methods = c.getDeclaredMethods();
		
		
		System.out.println("Complete class name => " + c.getName());
		System.out.println("Class name => " + c.getSimpleName());
		
		System.out.println("Class fields : ");
		for(Field f : fields){
			System.out.println("\t" + f.getModifiers() + " " + (f.getType()).getSimpleName() + " " + f.getName());
		}
		
		String superclass = (c.getSuperclass()).getSimpleName();
		if(superclass.compareTo("Object") != 0){
			System.out.println("Super Class => " + (c.getSuperclass()).getSimpleName());
		}
		
		
		System.out.println("Class methods : ");
		for(Method m : methods){
			System.out.print("\t" +  m.getReturnType().getSimpleName() + " " + m.getName() + "( " );
			Class [] parameters = m.getParameterTypes();
			for(Class p : parameters){
				System.out.print(p.getSimpleName() + " ");
			}
			System.out.println(")");
		}
	}
		
}