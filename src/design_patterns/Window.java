package design_patterns;

// builder pattern:
public class Window {

	private boolean visible;
	private boolean modal;
	private boolean dialog;

	/**
	 * this public constructor is not the best idea
	 */
	public Window(boolean visible, boolean modal, boolean dialog) {
		this.visible = visible;
		this.modal = modal;
		this.dialog = dialog;
	}

	// A private constructor called by the builder class inside
	private Window(WindowBuilder wBuilder) {
		this.visible = wBuilder.visible;
		this.modal = wBuilder.modal;
		this.dialog = wBuilder.dialog;
	}
	
	/**
	 * remember!!! in the WindowBuilder class. We should also have these 3
	 * fields !!!
	 */
	public static class WindowBuilder {
		private boolean visible;
		private boolean modal;
		private boolean dialog;

		/**
		 * remember to return "WindowBuilder" type !!!
		 */
		public WindowBuilder setDialog(boolean flag) {
			dialog = flag;
			return this; // EX: remember to return this !!!
		}

		public WindowBuilder setModal(boolean flag) {
			modal = flag;
			return this;
		}

		public WindowBuilder setVisible(boolean flag) {
			visible = flag;
			return this;
		}

		/**
		 * this build() is critical !!! Because inside this build() method, we
		 * actually call the Window(b, b, b) constructor to build the Window()
		 * object. So the Window(b, b, b) still has to be written in Window
		 * class!!!
		 * 
		 * @return a Window object
		 */
		public Window build() {
			return new Window(this); // this is the windowBuilder it self
		}

	}

	public static void main(String[] args) {
		// this is the RIGHT way to new the Window object !!!
		Window w = new Window.WindowBuilder().setDialog(true).setModal(true)
				.setVisible(true).build();

		// this is not a good way to do that !!!
		Window w2 = new Window(true, true, true);

		System.out.println(w.dialog);
	}
}
