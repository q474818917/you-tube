package com.tube.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import com.tube.core.StreamProgress;


public class IoUtils {
	
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println((System.currentTimeMillis() - startTime) );
	}
	
	/** 默认缓存大小 */
	public static final int DEFAULT_BUFFER_SIZE = 1024;
	/** 默认缓存大小 */
	public static final int DEFAULT_LARGE_BUFFER_SIZE = 4096;
	/** 数据流末尾 */
	public static final int EOF = -1;
	
	public static long copyByNIO(InputStream in, OutputStream out, int bufferSize, StreamProgress streamProgress) {
		return copy(Channels.newChannel(in), Channels.newChannel(out), bufferSize, streamProgress);
	}
	
	public static long copy(ReadableByteChannel in, WritableByteChannel out, int bufferSize, StreamProgress streamProgress) {
		long startTime = System.currentTimeMillis();
		ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize <= 0 ? DEFAULT_BUFFER_SIZE : bufferSize);
		long size = 0;
		if (null != streamProgress) {
			streamProgress.start();
		}
		try {
			while (in.read(byteBuffer) != EOF) {
				byteBuffer.flip();// 写转读
				size += out.write(byteBuffer);
				byteBuffer.clear();
				if (null != streamProgress && ((System.currentTimeMillis() - startTime) > 1000)) {
					startTime = System.currentTimeMillis();
					streamProgress.progress(size);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (null != streamProgress) {
			streamProgress.finish();
		}

		return size;
	}
	
}
