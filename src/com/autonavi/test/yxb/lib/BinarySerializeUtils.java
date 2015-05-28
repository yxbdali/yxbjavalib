/**
 * 
 */
package com.autonavi.test.yxb.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @author xiangbin.yang
 *
 */
public class BinarySerializeUtils {
	/**
	 * save object to binary data file
	 * 
	 * @param object
	 * @param dataFile
	 * @throws IOException
	 */
	public static void save(Object object, String dataFile) throws IOException {
		File file = new File(dataFile);
		if (!file.exists()) {
			file.createNewFile();
		}

		try (OutputStream fOutputStream = new FileOutputStream(file)) {
			try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fOutputStream)) {
				objectOutputStream.writeObject(object);
			}
		}
	}

	/**
	 * deserialze object from binary data file
	 * 
	 * @param dataFile
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deserialize(String dataFile) throws IOException, ClassNotFoundException {
		Object object = null;

		try (FileInputStream fileInputStream = new FileInputStream(dataFile)) {
			try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
				object = objectInputStream.readObject();
			}
		}

		return object;
	}
}
