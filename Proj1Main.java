
public class Proj1Main<T> {

	public static void main(String[] args) {
		
		// Include all your test cases here
		
		ArrayUnBoundedSet stack = new ArrayUnBoundedSet();		
		ArrayUnBoundedSet stack1 = new ArrayUnBoundedSet(); 
		if(stack.isEmpty() == true)
			System.out.println("Stack is empty");
		
		stack.add(1);
		stack.add(2);
		stack.add(1);

		stack1.add(1);
		stack1.add(6);
		stack1.add(8);

		System.out.print(stack.union(stack1));
	}
}
