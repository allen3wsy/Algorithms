package design_patterns;

// http://alvinalexander.com/java/java-factory-pattern-example
public class FactoryPattern {

	/**
	 * the interface Dog !!!
	 */
	public static interface Dog {
		public void speak();
	}

	public static class Poodle implements Dog {
		public void speak() {
			System.out.println("The poodle says \"arf\"");
		}
	}

	public static class Rottweiler implements Dog {
		public void speak() {
			System.out
					.println("The Rottweiler says (in a very deep voice) \"WOOF!\"");
		}
	}

	public static class SiberianHusky implements Dog {
		public void speak() {
			System.out.println("The husky says \"Dude, what's up?\"");
		}
	}

	public static class DogFactory {
		public DogFactory() {
		}

		/**
		 * Remember to return Dog type
		 * @param criteria
		 * @return
		 */
		public static Dog getDog(String criteria) {
			if (criteria.equals("small"))
				return new Poodle();
			else if (criteria.equals("big"))
				return new Rottweiler();
			else if (criteria.equals("working"))
				return new SiberianHusky();

			return null;
		}
	}

	public static void main(String[] args) {
		
		Dog dog1 = DogFactory.getDog("small");
		dog1.speak();
		Dog dog2 = DogFactory.getDog("big");
		dog2.speak();
	}
}
