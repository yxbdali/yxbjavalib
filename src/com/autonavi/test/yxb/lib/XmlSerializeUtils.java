/**
 * 
 */
package com.autonavi.test.yxb.lib;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author xiangbin.yang
 *
 */
public class XmlSerializeUtils {
	/**
	 * Serialize object to xml file
	 * 
	 * @param object
	 * @param xmlFile
	 * @throws IOException
	 */
	public static void SaveToXml(Object object, String xmlFile) throws IOException {
		File save2File = new File(xmlFile);
		if (!save2File.exists()) {
			save2File.createNewFile();
		}

		try (OutputStream out = new FileOutputStream(save2File)) {
			try (XMLEncoder xmlEncoder = new XMLEncoder(out)) {
				xmlEncoder.writeObject(object);
			}
		}
	}

	/**
	 * Deserialize object from xml file
	 * 
	 * @param xmlFile
	 * @return
	 * @throws IOException
	 */
	public static Object deserialze(String xmlFile) throws IOException {
		Object object = null;
		File file = new File(xmlFile);
		try (InputStream in = new FileInputStream(file)) {
			try (XMLDecoder xmlDecoder = new XMLDecoder(in)) {
				object = xmlDecoder.readObject();
			}
		}

		return object;
	}
}
