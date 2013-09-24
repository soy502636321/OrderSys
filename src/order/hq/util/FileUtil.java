package order.hq.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	public static void copy(File oFile, File nFile) {
		if (oFile != null && nFile != null) {
			try {
				InputStream inputStream = new FileInputStream(oFile);
				OutputStream outputStream = new FileOutputStream(nFile);
				
				int length = 0;
				byte[] bs = new byte[2048];
				while ((length = inputStream.read(bs)) != -1) {
					outputStream.write(bs, 0, length);
				}
				
				inputStream.close();
				outputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
