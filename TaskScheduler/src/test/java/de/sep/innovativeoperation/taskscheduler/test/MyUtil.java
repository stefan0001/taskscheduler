package de.sep.innovativeoperation.taskscheduler.test;

/**
 * MyUtil enthält Methoden, die sich zum Testen als nützlich erwiesen haben.
 * @author Joscha Zander
 *
 */
public class MyUtil {
	
	/**
	 * generates a String with desired length and content of desired letters "content"
	 * @param length - desired length of generatedString, it is the total length if content is one char only
	 * @param content - desired content as String, try to avoid more than one char or you have to do math with the length (append)
	 * @return
	 */
	public static String generateStringWithLength(int length, String content) {
		StringBuffer outputBuffer = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			outputBuffer.append(content);
		}
		return outputBuffer.toString();
	}
}
