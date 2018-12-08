package com.yaorange.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.output.ByteArrayOutputStream;
/**
 * 文件流转byte数组
 * @author nixianhua
 */
public class FileUtils {
	public static byte[] stream2Byte(InputStream inputStream) {
		BufferedInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = new BufferedInputStream(inputStream);
			out = new ByteArrayOutputStream(1024);

			byte[] temp = new byte[1024];
			int size = 0;
			while ((size = in.read(temp)) != -1) {
				out.write(temp, 0, size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		byte[] content = out.toByteArray();
		return content;
    }
}
