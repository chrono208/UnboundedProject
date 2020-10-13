
public class Project1Driver<T> {

	public static void main(String[] args) {

		
		ArrayUnBoundedSet stack = new ArrayUnBoundedSet();		
		ArrayUnBoundedSet stack1 = new ArrayUnBoundedSet(); 
		if(stack.isEmpty() == true)
			System.out.println("Stack is empty");
		
		stack.add(1);
		stack.add(2);
		stack.add(3);

		stack1.add(1);
		stack1.add(2);
		stack1.add(4);

		stack1.toArray();
		System.out.print(stack1.subset(stack));
	}
}
