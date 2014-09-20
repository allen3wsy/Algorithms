package test;

public class A {
	public void doIt() {
		System.out.println("A's doIt()");
	}
}

class B extends A {
	public void doIt() {
		System.out.println("B's doIt()");
	}

	public void b() {
		System.out.println("B's b()");
	}
}

class C extends B {
	public void doIt() {
		System.out.println("C's doIt()");
	}

	public static void main(String[] args) {
		A x = new B();
		x.doIt(); // x.doIt() -- void A (it seems like A's doIt(), but because
					// of dynamic binding, it actually calls B' doIt())
		C c = new C();
		c.doIt();
		// ((A) x).doIt();
	}
}
