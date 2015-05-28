/**
 * 
 */
package com.autonavi.test.yxb.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.AbstractJsonWriter.Type;

/**
 * @author xiangbin.yang
 *
 */
public class XStreamSerializeUtils {
	/**
	 * Serialize object to xml file using XStream
	 * 
	 * @param obj
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void serialize(Object obj, String file) throws FileNotFoundException, IOException{
		XStream xStream = new XStream();
		
		xStream.autodetectAnnotations(true);
		try (OutputStream out = new FileOutputStream(file); 
				OutputStreamWriter writer = new OutputStreamWriter(out, Charset.forName("UTF-8").newEncoder())) {
			xStream.toXML(obj, writer);
			
		}
	}
	
	/**
	 * Deserialize object from xml file using XStream
	 * 
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	/*
	public static <T> T deserialize(String file) throws IOException{
		T obj = null;
	
		XStream xStream = new XStream();
		xStream.processAnnotations();
		try (InputStream in = new FileInputStream(file); 
				InputStreamReader reader = new InputStreamReader(in, Charset.forName("UTF-8").newDecoder())) {
			obj = (T)xStream.fromXML(reader);
		}
		return obj;
	}
	*/
}
