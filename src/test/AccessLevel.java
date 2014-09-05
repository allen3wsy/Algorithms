package test;

/**
 * Used to test 4 different access levels
 * public, protected, default, private
 * 
 * 
 * @author Allen
 */
public class AccessLevel {

	private String format;
	
	// should be public: good design
	protected String getFormat() {
		return this.format;
	}
	
	// should be public: good design
	void setFormat(String format) {
		this.format = format;
	}


}
