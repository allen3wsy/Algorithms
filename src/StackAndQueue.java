import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


// offer() and poll() is similar to add() and remove()

public class StackAndQueue {
	public static void main(String[] args) throws Exception{
//		ThreeStack threeS = new ThreeStack(10);
//		threeS.s1.push(4);
//		threeS.s1.push(5);
//		threeS.s1.push(6);
//		threeS.s1.push(7);
//		threeS.s1.pop();
//		System.out.println(threeS.s1.mtop1);
		
//		MinStack ms = new MinStack();
//		ms.push(4);
//		System.out.println(ms.min());
//		ms.push(2);
//		System.out.println(ms.min());
//		ms.push(3);
//		System.out.println(ms.min());
//		ms.push(0);
//		System.out.println(ms.min());
//		
//		ms.pop();
//		ms.pop();
//		ms.pop();
//		System.out.println(ms.min());
		
		SetOfStack ss = new SetOfStack(3);
		ss.push(4);
		ss.push(2);
		System.out.println(ss.pop());
		ss.push(4);
		ss.push(2);
		ss.push(1);
		System.out.println(ss.list.size());

//		hanio(4, 1,2,3);
//		System.out.println();

//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(3);
//		stack.push(4);
//		stack.push(1);
//		stack.push(5);
//		stack.push(2);
//		
//		Stack<Integer> s = sortStack(stack);
//		while(!s.isEmpty()){
//			System.out.println(s.pop());
//		}
		
		Dog d = new Dog("haha");
		Cat c = new Cat("xx");
		Animal c1 = new Cat("allen");
		Shelter s1 = new Shelter();
		s1.enqueue(d);
		s1.enqueue(c);
		s1.equals(c1);
		
		System.out.println(s1.dequeueCat().name);
		
		hanio(4, 1, 2, 3);
	}
	
	/**
	 * 3.1
	 */
	static class ThreeStack{
		int[] arr;
		int top1, top2, top3;
		int len1, len2, len3;
		stack1 s1;
		
		public ThreeStack(int len){
			if(len < 3){
				return ;
			}
			
			this.arr = new int[len];
			this.top1 = 0;
			this.top2 = len/3;
			this.top3 = len/3 * 2;
			
			this.len1 = len/3;
			this.len2 = len/3;
			this.len3 = len - len/3*2;
			s1 = new stack1();
			
		}
		
		class stack1{
			int mtop1;
			public stack1(){
				this.mtop1 = top1;
			}
			
			void push(int i){
				if(mtop1 < len1){
					arr[mtop1++] = i;
				}
			}
			
			int pop(){
				if(mtop1 == top1)
					return 0;
				mtop1--;
				return arr[mtop1];
			}
			
			int peek(){
				if(mtop1 == top1)
					return 0;
				return arr[mtop1 - 1];
			}
		}
		
		//stack2, stack3 are similar
	}
	
	/**
	 * 3.2
	 */
	static class MinStack extends Stack<Integer>{
		//Stack<Integer> stack; 
		Stack<Integer> rec;
		
		public MinStack(){
			//stack = new Stack<Integer>();
			rec = new Stack<Integer>();
		}
		
		public void push(int n){
			if(n <= min()){
				rec.push(n);
			}
			super.push(n);
		}
		
		public Integer pop(){
			int val = super.pop();
			if(val == min()){
				rec.pop();
			}
			return val;
		}
		
		public int min(){
			if(!rec.isEmpty())
				return rec.peek();
			return Integer.MAX_VALUE;
		}
	}
	
	/**
	 * 3.3
	 */
	static class SetOfStack{
		private int limit;
		int len;
		ArrayList<Stack<Integer>> list;
		Stack<Integer> curr;
		
		public SetOfStack(int l){
			this.limit = l;
			this.len = 0;
			this.list = new ArrayList<Stack<Integer>>();
			this.list.add(new Stack<Integer>());
			this.curr = list.get(0);
		}
		
		public void push(int i){
			len++;
			if(curr.size() >= limit){
				Stack<Integer> n_stack = new Stack<Integer>();
				list.add(n_stack);
				curr = n_stack;
			}
			curr.push(i);
		}
		
		public Integer pop(){
			len--;
			if(curr.size() == 0){
				if(list.size() == 1)
					return null;
				
				list.remove(list.size()-1);
				curr = list.get(list.size()-1);

			}
			return curr.pop();
		}
		
		public Integer popAt(int index) throws Exception{
			if(index < 0 || index >= list.size())
				throw new Exception("index not right");
			return list.get(index).pop();
			
		}
	}
	
	/**
	 * 3.4
	 */
	public static void hanio(int n, int origin, int buffer, int dest){
		if(n == 0)
			return;
//		if(n != 1)	{
//			System.out.println("we have to move " + n + " and all the top to " + dest);
//		}
		hanio(n-1, origin, dest, buffer);
		moveTo(origin, dest);
		hanio(n-1, buffer, origin, dest);
	}
	
	private static void moveTo(int o, int d){
		System.out.println(o + "->" + d);
	}
	
	/**
	 * 3.5
	 */
	static class MyQueue{
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		
		public void enqueue(int i){
			s1.push(i);
		}
			
		public Integer dequeue(){
			if(s2.isEmpty()){
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
			return s2.pop();
		}
	}
	
	// use two queues to build a stack
	static class MyStackUsingTwoQueue<T> {
		Queue<T> q1 = new LinkedList<T>();
		Queue<T> q2 = new LinkedList<T>();
		Queue<T> curr = q1; 
		Queue<T> back = q2;
		
		public int size(){
			return q1.size() + q2.size();
		}
		
		// can also use add
		public void push(T n){
			curr.offer(n);
		}
		
		public T pop(){
			int size = curr.size();  // important
			for(int i=0; i < size - 1; i++){
				T v = curr.poll();
				//System.out.println(v);
				back.offer(v);	
			}
			T result = curr.poll();
			Queue<T> tmp = curr;
			curr = back;
			back = tmp;

			return result;
		}
	}
	
	/**
	 * 3.6
	 */
	public static Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> back = new Stack<Integer>();
		
		while(!s.isEmpty()){
			int val = s.pop();
			if(!back.isEmpty() && val < back.peek()){
				while(val < back.peek()){
					s.push(back.pop());
					if(back.isEmpty())
						break;
				}
			}
			back.push(val);
		}
		return back;
	}
	
}


/**
 * 3.7
 */
abstract class Animal{
	int order = 0;
	String name;
	public Animal(String name){
		//order++;
		this.name = name;
	}
	
	public abstract void say();
}

class Dog extends Animal{  
	public Dog(String name){
		super(name);
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		
	}
}

class Cat extends Animal{
	public Cat(String name){
		super(name);
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		
	}
}

class Shelter{
	LinkedList<Dog> dogs = new LinkedList<Dog>(); 
	LinkedList<Cat> cats = new LinkedList<Cat>();
	
	private int order = 0;
	
	public void enqueue(Animal o){
		order++;
		o.order = this.order;
		if(o instanceof Dog){
			dogs.add((Dog)o);
		}else if(o instanceof Cat){
			cats.add((Cat)o);
		}
	}
	
	public Dog dequeueDog(){
		if(dogs.isEmpty())
			return null;
		return dogs.poll();
	}
	
	public Cat dequeueCat(){
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
		
		if(cats.peek().order < dogs.peek().order){
			return cats.poll();
		}else{
			return dogs.poll();
		}
	}
}



