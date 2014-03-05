package java_introspection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;



public class Main {
	
	public static void main(String[] args) {
		
		Cinema cine = new Cinema(new ArrayList<Film>());
		Class<? extends Cinema> c = cine.getClass();
		Field [] fields = c.getDeclaredFields();
		Method [] methods = c.getDeclaredMethods();
		
		
		System.out.println("Complete class name => " + c.getName());
		Fichier.ecrire("Cinema.cpp", "Complete class name => " + c.getName());
		
		System.out.println("Class name => " + c.getSimpleName());
		
		System.out.println("Class fields : ");
		for(Field f : fields){
			int modifier = f.getModifiers();
			if(Modifier.isStatic(modifier)){
				System.out.print("\t" + "static ");
			} else if (Modifier.isPrivate(modifier)){
				System.out.print("\t" + "private ");
			} else if (Modifier.isPublic(modifier)){
				System.out.print("\t" + "public ");
			} else if (Modifier.isProtected(modifier)){
				System.out.print("\t" + "protected ");
			}
			
			System.out.println("\t" + modifier + " " + (f.getType()).getSimpleName() + " " + f.getName());
		}
		
		String superclass = (c.getSuperclass()).getSimpleName();
		if(superclass.compareTo("Object") != 0){
			System.out.println("Super Class => " + (c.getSuperclass()).getSimpleName());
		}
		
		
		System.out.println("Class methods : ");
		for(Method m : methods){
			int i;
			
			int modifier = m.getModifiers();
			String returnType = m.getReturnType().getSimpleName();
			String name = m.getName();
			String params = "";
			
			Class [] parameters = m.getParameterTypes();
			
			if(parameters.length > 0){
				for(i = 0; i < (parameters.length - 1); ++i){
					params += parameters[i].getSimpleName() + ", ";
				}
				
				params += parameters[i].getSimpleName();
			}
			
			if(Modifier.isStatic(modifier)){
				System.out.print("\t" + "static ");
			} else if (Modifier.isPrivate(modifier)){
				System.out.print("\t" + "private ");
			} else if (Modifier.isPublic(modifier)){
				System.out.print("\t" + "public ");
			} else if (Modifier.isProtected(modifier)){
				System.out.print("\t" + "protected ");
			}
			
			
			System.out.println(returnType + " " + name + "(" + params + ")");
		}
	}
		
}