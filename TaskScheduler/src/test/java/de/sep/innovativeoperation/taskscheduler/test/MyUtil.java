package de.sep.innovativeoperation.taskscheduler.test;

public class MyUtil {
	
	public static String generateStringWithLength(int length, String content) {
		StringBuffer outputBuffer = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			outputBuffer.append(content);
		}
		return outputBuffer.toString();
	}
}
