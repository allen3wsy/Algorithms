import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class cracking_3 {

	public static void main(String[] args) throws Exception{
			
		// 3.2
		MinStack ms = new MinStack();
		ms.push(4);
		System.out.println(ms.min());
		ms.push(2);
		System.out.println(ms.min());
		ms.push(3);
		System.out.println(ms.min());
		ms.push(0);
		System.out.println(ms.min());
		
		ms.pop();
		ms.pop();
		ms.pop();
		System.out.println(ms.min());
		
		// 3.3
		System.out.println("**** Question 3.3******");
		SetOfStack ss = new SetOfStack(3);
		ss.push(4);
		ss.push(2);
		System.out.println(ss.pop());
		
		ss.push(4);
		ss.push(2);
		ss.push(1);
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());

		
		System.out.println(ss.list.size());
		System.out.println(ss.popAt(0));
		
		// 3.4
		hanoi(2,1,2,3);
		
		// 3.6
//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(3);
//		stack.push(4);
//		stack.push(1);
//		stack.push(5);
//		stack.push(2);
//		
//		Stack<Integer> s = sort(stack);
//		while(!s.isEmpty()){
//			System.out.println(s.pop());
//		}
		
		
		// 3.7
		Cat a = new Cat("first");
		Dog b = new Dog("second");
		Animal c = new Cat("third");
		
		Shelter s1 = new Shelter();
		s1.enqueue(a);
		s1.enqueue(b);
		System.out.println(s1.dequeueAny().name);
			
		
	}
		
	/**
	 * 3.1
	 */

		
	/**
	 * 3.2
	 */
	// subclass MinStack overrides the push() and pop() method
	public static class MinStack extends Stack<Integer>{
		//Stack<Integer> stack; 	// if we don't use extends Stack<Integer>
		Stack<Integer> s2;
		
		public MinStack(){
			//stack = new Stack<Integer>();	// if we don't use extends Stack<Integer>
			s2 = new Stack<Integer>();
		}
		
		public void push(int n){
			if(n <= min()){
				s2.push(n);
			}
			super.push(n);
		}
		
		// notice we have to use Integer
		public Integer pop(){
			int val = super.pop();
			if(val == min()){
				s2.pop();
			}
			return val;
		}
		
		
		public int min(){
			if(!s2.isEmpty())
				return s2.peek();
			return Integer.MAX_VALUE;
		}
	}
	
	/**
	 * 3.3
	 * 
	 */
	static class SetOfStack{
		private int limit;
		int len = 0; 						// not used
		ArrayList<Stack<Integer>> list;
		Stack<Integer> curr;
		
		public SetOfStack(int limit)	{
			this.limit = limit;		
			list = new ArrayList<Stack<Integer>>();
			list.add(new Stack<Integer>());
			curr = list.get(0);
		}
		
		public void push(int i)	{
			len++;
			if(curr.size() >= limit)	{
				list.add(new Stack<Integer>());
				curr = list.get(list.size() - 1);				
			}
			curr.push(i);
		}
		
		
		// only Integer can accept null
		// if it is public int pop()
		public Integer pop()	{
			if(curr == list.get(0) && curr.size() == 0)
				return null;
				
			int result = curr.pop();
			if(curr.isEmpty())	{
				curr = list.get(list.size() - 2);
				list.remove(list.size() - 1);
			}
			return result;
		}
		
		public Integer popAt(int index)	throws Exception	{
			if(index < 0 || index >= list.size())
				throw new Exception("this is an exception");
			return list.get(index).pop();				
		}
	
	}
	
	/**
	 * 3.4
	 * 
	 */
	
	public static void hanoi(int n, int origin, int buffer, int dest)	{
		if(n <= 0)
			return;
		
		hanoi(n - 1, origin, dest, buffer);
		move(n, origin, dest);
		hanoi(n - 1, buffer, origin, dest);
		
	}
	
	public static void move(int n, int origin, int dest)	{
		System.out.println("we move " + n + " from " + origin + " to " + dest);
	}
	
	
	
	/**
	 * 3.5
	 */
	
	public static class MyQueue{
		Stack<Integer> s1;
		Stack<Integer> s2;
		
		// new this 2 queue in constructor
		public MyQueue()	{
			s1 = new Stack<Integer>();
			s2 = new Stack<Integer>();
		}
		
		public void enqueue(int i)	{
			s1.push(i);
		}
		
		public Integer dequeue()	{
			// don't forget to check if s1 & s2 are both empty
			
			int result;
			if(!s2.isEmpty())
				return s2.pop();
			
			while(!s1.isEmpty())	{
				Integer temp = s1.pop();
				s2.push(temp);
			}
			
			return s2.pop();		
		}
	}
	
	// another good question.
	// use two queues to build a stack
	public static class MyStack<T> {
		Queue<T> q1 = new LinkedList<T>();
		Queue<T> q2 = new LinkedList<T>();
		Queue<T> curr = q1; 
		Queue<T> back = q2;
			
		public int size(){
			return q1.size() + q2.size();
		}
				
		// can also use add
		public void push(T n)	{
			curr.offer(n);
		}
		
		public T pop()	{
			int size = curr.size();		// important !!!
			if(curr.size() == 0)
				return null;
			
			// poll() n-1 times and leave one element in the first queue
			for(int i = 0; i < size - 1; i++)	{
				T v = curr.poll();
//				//System.out.println(v);
				back.offer(v);	
			}
			T result = curr.poll();
		
			// change the pointer of curr and back and make sure that back is 
			// always empty !!!!!!!!!!!!!!!!!!!!
			Queue<T> temp = curr;
			curr = back;
			back = temp;
			
			return result;
		}
	}
	
	/**
	 * 3.6
	 */
	
	// this sorting algorithm is O(N squared)
	public static Stack<Integer> sort(Stack<Integer> s)	{
		Stack<Integer> s2 = new Stack<Integer>();
		// this is my addition (checking whether s is empty)
		if(s.isEmpty())	
			return s;

		s2.push(s.pop());		// ensure that s2 is not empty already!!!
		while(!s.isEmpty())	{
			int temp = s.pop();
			// EX: I forgot to make sure that !s2.isEmpty()
			while(!s2.isEmpty() && temp < s2.peek())	{	// s2 can never be empty so peek() is always right
				s.push(s2.pop());
			}
			s2.push(temp);
		}			
		return s2;
	}
		

	/**
	 * 3.7
	 */
	public static abstract class Animal{
		int order = 0;
		String name;
		
		public Animal(String name)	{
			this.name = name;
		}
		
		public abstract void say();  	// this method is not implemented
	}
	
	public static class Dog extends Animal{
		public Dog(String name)	{
			super(name);
		}

		@Override
		public void say() {
			// TODO Auto-generated method stub			
		}
	}
	
	public static class Cat extends Animal	{
		public Cat(String name)	{
			super(name);
		}

		@Override
		public void say() {
			// TODO Auto-generated method stub	
		}
	}
	
	public static class Shelter	{
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		private int order = 0;
		
		public void enqueue(Animal a){
			order++;
			a.order = this.order;
			if(a instanceof Dog)	
				dogs.add((Dog) a);
			else if(a instanceof Cat)
				cats.add((Cat) a);
			
		}
		
		public Dog dequeueDog(){
			// we can also use dogs.size() == 0
			if(dogs.isEmpty())
				return null;
			return dogs.poll();
		}
		
		public Cat dequeueCat(){
			// cats.size() == 0
			if(cats.isEmpty())
				return null;
			return cats.poll();
		}
		
		public Animal dequeueAny(){
			if(dogs.isEmpty() && cats.isEmpty())
				return null;
			if(dogs.isEmpty())
				return cats.poll();
			if(cats.isEmpty())
				return dogs.poll();
			if(dogs.peek().order < cats.peek().order)	{
				return dogs.poll();
			} else	{
				return cats.poll();
			}
			
		}
		
		
	}
	
}
