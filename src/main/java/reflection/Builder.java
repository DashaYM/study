package reflection;


import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Builder {

    public Class outputReflectionClass(Class clazz) throws Exception{
        try {
            String className = clazz.getName();

            System.out.println(className);

            for (Field field : clazz.getDeclaredFields()) {
                String fieldName = field.getName();
                System.out.println(fieldName);
            }

            for (Field field : clazz.getFields()) {
                String fieldName = field.getName();
                System.out.println(fieldName);
            }

            for (Method method : clazz.getMethods()) {
                String methodName = method.getName();
                System.out.println(methodName);
            }

            MyAnnotation myAnnotation = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
            if (myAnnotation != null) {
                System.out.println(myAnnotation.value());
            }

            ClassPool cp = ClassPool.getDefault();
            cp.insertClassPath(new ClassClassPath(clazz));

            CtClass originalCt = cp.getCtClass(className);

            // inherit new class
            CtClass newCt = cp.makeClass(className + "123", originalCt);
            // set super class
            newCt.setSuperclass(originalCt);
            newCt.defrost();

            return newCt.toClass();
        } catch (Exception e) {
            throw e;
        }
    }


}
