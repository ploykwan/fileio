package ku.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Copy the InputStream to the OutputStream.
 * 
 * @author Kwankaew Uttama
 *
 */
public class FileUtil {
	/**
	 * Copy the InputStream to the OutputStream one byte at time.
	 * 
	 * @param in
	 *            is the object of InputStream.
	 * @param out
	 *            is the object of OutputStream.
	 */
	static void copy(InputStream in, OutputStream out) {
		try {
			while (in.read() > 0) {
				out.write(in.read());
			}
			in.close();
			out.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Copy the InputStream to the OutputStream using a byte array.
	 * 
	 * @param in
	 *            is the object of InputStream.
	 * @param out
	 *            is the object of OutputStream.
	 * @param blocksize
	 *            is the size of byte array.
	 */
	static void copy(InputStream in, OutputStream out, int blocksize) {
		byte[] buffer = new byte[blocksize];
		int count = 0;
		try {
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Copy the InputStream to the OutputStream using a BufferedReader to read
	 * the InputStream and PrintWriter to write the OutputStream. Read and write
	 * one line at at time.
	 * 
	 * @param in
	 *            is the object of InputStream.
	 * @param out
	 *            is the object of OutputStream.
	 */
	static void bcopy(InputStream in, OutputStream out) {
		BufferedReader file = new BufferedReader(new InputStreamReader(in));
		PrintWriter read = new PrintWriter(out);
		try {
			while (file.ready()) {
				read.write(file.read());
			}
			file.close();
			read.close();
			in.close();
			out.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 
	 * Copy the InputStream to the OutputStream using a BufferedReader to read
	 * the InputStream and BufferedWriter with a array of char.
	 * 
	 * @param in
	 *            is the object of InputStream.
	 * @param out
	 *            is the object of OutputStream.
	 * @param blocksize
	 *            is the size of array.
	 */
	static void bbcopy(InputStream in, OutputStream out, int blocksize) {
		BufferedReader file = new BufferedReader(new InputStreamReader(in));
		BufferedWriter read = new BufferedWriter(new OutputStreamWriter(out));
		char[] array = new char[blocksize];
		int count;
		try {
			while ((count = file.read(array)) > 0) {
				read.write(array);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			try {
				file.close();
				read.close();
				in.close();
				out.close();
			} catch (IOException e) {
			}

		}
	}
}
