package testSetup;


//import java.nio.charset.Charset;
import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;

import org.springframework.http.MediaType;


public class MyMedia extends MediaType {
//	private String type = "APPLICATION";
//	private String subtype = "JSON";
//	private Charset utf8Charset;
//	private Charset utf8 = new Charset();
	
	public MyMedia(String type, String subtype, Charset charset) {
		super(type, subtype, charset);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
