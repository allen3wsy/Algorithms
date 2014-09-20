package design_patterns;

// http://www.programcreek.com/2013/02/java-design-pattern-abstract-factory/
public class AbstractFactoryPattern {

	// first interface
	public static interface CPU {
	    void process();
	}
	 
	// second interface for Factory
	/**
	 * this is the abstract factory !!!
	 * @author AllenNg
	 *
	 */
	public static interface CPUFactory {
		CPU produceCPU();
	}
	
	public static class AMDFactory implements CPUFactory {
	    public CPU produceCPU() {
	        return new AMDCPU();
	    }
	}
	 
	public static class IntelFactory implements CPUFactory {
	    public CPU produceCPU() {
	        return new IntelCPU();
	    }
	}
	 
	public static class AMDCPU implements CPU {
	    public void process() {
	        System.out.println("AMD is processing...");
	    }
	}
	 
	public static class IntelCPU implements CPU {
	    public void process() {
	        System.out.println("Intel is processing...");
	    }
	}
	 
	public static class Computer {
		CPU cpu;
	 
	    public Computer(CPUFactory factory) {
	    	cpu = factory.produceCPU();
	        cpu.process();
	    }
	}
	 
	public static class Client {
	    public static void main(String[] args) {
	        new Computer(createSpecificFactory());
	    }
	 
	    public static CPUFactory createSpecificFactory() {
	        int sys = 0; // based on specific requirement
	        if (sys == 0) 
	        	return new AMDFactory();
	        else 
	        	return new IntelFactory();
	    }
	}
}
