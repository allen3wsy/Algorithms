package design_patterns;

import java.awt.Dialog;

public class BuilderPattern {

	public static class Window {
		public Window(boolean visible, boolean modal, boolean dialog) {
			this.visible = visible;
			this.modal = modal;
			this.dialog = dialog;
		}

		private boolean visible;
		private boolean modal;
		private boolean dialog;
	}

	/**
	 * remember!!! in the WindowBuilder class. We should also have these 3
	 * fields !!!
	 */
	public static class WindowBuilder {
		private boolean visible;
		private boolean modal;
		private boolean dialog;

		public WindowBuilder() {
		}

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
			return new Window(visible, modal, dialog);
		}
	}

	public static void main(String[] args) {
		// this is the RIGHT way to new the Window object !!!
		Window w = new WindowBuilder().setDialog(false).setModal(true)
				.setVisible(true).build();

		// this is not a good way to do that !!!
		Window w2 = new Window(true, true, true);
	}
}
