package com.solvd.library.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.entities.Client;

public class reflectionTask {
	private static final Logger LOGGER = LogManager.getLogger(reflectionTask.class);

	public static void main(String[] arg) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<Client> clientClass = Client.class;
		Constructor<?>[] constructors = clientClass.getConstructors();

		LOGGER.info("The constructors are: ");
		for (Constructor<?> c : constructors) {
			LOGGER.info(c);
		}
		Client felipe = (Client) constructors[1].newInstance();

		Field[] fields = felipe.getClass().getDeclaredFields();
		LOGGER.info("The fields are: ");
		for (Field f : fields) {
			LOGGER.info(f);
		}

		Method[] methods = felipe.getClass().getDeclaredMethods();
		LOGGER.info("The methods are: ");
		for (Method m : methods) {
			LOGGER.info(m);
		}

		Method[] superMethods = felipe.getClass().getSuperclass().getDeclaredMethods();
		for (Method m : superMethods) {
			LOGGER.info(m);
		}

		Method getId = felipe.getClass().getSuperclass().getDeclaredMethod("getId");
		Method setIdMethod = felipe.getClass().getSuperclass().getDeclaredMethod("setId", int.class);
		setIdMethod.invoke(felipe, 12345678);

		Parameter[] parameters = setIdMethod.getParameters();
		for (Parameter p : parameters) {
			LOGGER.info(p);
		}

		int id = (int) getId.invoke(felipe);
		LOGGER.info(id);
		felipe.setName("Felipe Copello");
		LOGGER.info(felipe.getName());
	}
}
