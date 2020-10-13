/********************************************************************
 ArrayUnBoundedSet.java     
 Implements SetADT using array.
********************************************************************/
import java.util.Random;

public class ArrayUnBoundedSet<T> implements SetADT<T> {

    private int count;  // the current number of elements in the set 
    private T[] contents; // the set as an array
    private int DEFAULT_CAPACITY = 5;
    int currentCap = 5;
    protected int topIndex = -1;      // index of top element in stack
	Random rand = new Random();
	

    /******************************************************************
     Creates an empty set with default capacity.
    ******************************************************************/
    public ArrayUnBoundedSet() 
    {
        count = 0;
        contents = (T[])(new Object[DEFAULT_CAPACITY]);  
    }

    /******************************************************************
     Creates an empty set with specified capacity.
    ******************************************************************/
    public ArrayUnBoundedSet(int initCapacity) 
    {       
        count = 0;
        contents = (T[])(new Object[initCapacity]);  
    }

    /* Adds one element to this set, if not already present. 
     * Must double capacity if full. */
	@Override
	public void add(T element) 
	{
		
		if (topIndex >= contents.length-1)
	 	{
			int newCap = contents.length * 2;
			T[] temp = (T[])(new Object[newCap]);
			for(int index = 0; index < contents.length; index++)
				temp[index] = contents[index];
			
			contents = temp;
	 	}
		
		else
		{
			boolean checker = false;
			for(int index = 0; index < contents.length; index++)
			{
				if(contents[index] == (element))
				checker = true;	
			}
			if (checker  == false)
			{
				topIndex++;
				contents[topIndex] = element;
			}
		}
	}
	
    /* Returns true if this set contains the target element. */
	@Override
	public boolean contains(T target) 
	{

		for(int index = 0; index < contents.length; index++)
		{
			if(target == contents[index])
			{
				return true;
			}
		}
		return false;
	}
	
    /* Removes and returns the specified element from this set. */
	@Override
	public T remove(T element) throws ElementNotFoundException, EmptySetException 
	{
	    if (isEmpty())
	        throw new EmptySetException("Pop attempted on an empty stack.");
	    else
	    {
	    	boolean checking = true;
	    	boolean notThere = false;
		    while(checking) 
		    {
		    	for(int index = 0, n = contents.length; index < n; index++)
		    	{
		    		if(element == contents[index])
		    		{
		    			contents[index] = null;
		    			topIndex--;
		    		}
		    		else 
		    		{
		    			notThere = true;
		    		}
		    	}
		    	checking = false;
		    }
		    if(notThere)
		    {
		    	notThere = false;
		    	throw new ElementNotFoundException("Element not found.");		    	
		    }
	    }
		return element;
	}

	/* Removes and returns a random element from this set. Optional method.
     * If not implemented then must throw Java's built-in UnsupportedOperationException
     * in the implementing class. */
	@Override
	public T removeRandom() throws EmptySetException 
	{
		// TODO Auto-generated method stub
		return null;
	}

    /* Returns a new set which is the union of this set and the parameter set.
     * Neither this set nor the parameter set should be altered. */
	@Override
	public SetADT<T> union(SetADT<T> otherset) 
	{
		ArrayUnBoundedSet tempSet = new ArrayUnBoundedSet(contents.length);
		tempSet.add(otherset);
		
		for(int index = 0; index < contents.length; index++)
		{
			if(!otherset.contains(contents[index]))
			{
				tempSet.add(contents[index]);
			}
		}
		return tempSet;
	}

    /* Returns a new set which is the intersection of this set and the parameter set.
     * Neither this set nor the parameter set should be altered. */
	@Override
	public SetADT<T> intersect(SetADT<T> otherset) 
	{
		ArrayUnBoundedSet tempSet = new ArrayUnBoundedSet(contents.length);
		for(int index = 0; index < contents.length; index++)
		{
			if(otherset.contains(contents[index]))
				tempSet.add(contents[index]);
		}
		return tempSet;
	}

    /* Returns true if this set is a subset of the parameter set. */
	@Override
	public boolean subset(SetADT<T> otherset) 
	{
		for(int index = 0; index < contents.length; index++)
		{
			if(!otherset.contains(contents[index]))
				return false;
		}
		return true;
	}

    /* Returns true if this set and the parameter set contain exactly
     * the same elements, not necessarily in the same order though. */
	//Maybe use one set as control and cycle check second until first has been cycled through, 
	//once an equal found: set true, breaking if false
	@Override
	public boolean equals(SetADT<T> otherset) 
	{
		
		int count = 0;
		for(int index = 0; index < contents.length; index++)
		{
			if(otherset.contains(contents[index]))
				count++;
		}	
		if(count == contents.length)
			return true;
		else 
			return false;
	}

    /* Returns true if this set contains no elements. */	
	@Override
	public boolean isEmpty() 
	{
		if (contents.length < 0)
		{
			return true;
		}
		else
		{
			return false; 
		}
	}

    /* Returns the number of elements in this set. */
	@Override
	public int size() 
	{
	    int stacking = 0;
	    stacking = contents.length;
	    return stacking;
	}

    /* Returns all the elements of this set as an array.
     * NOTE: Although declared public, this is intended for internal to class use.
     * Essentially, it is a replacement for an iterator, which we will cover later.
     * The conversion to array will allow you to iterate through the elements 
     * of the associated set. Internally you will need to allocate
     * an Object[] and cast it to T[]. Externally, all elements of this array
     * will have type Object and not what T was owing to Java's implementation of 
     * generics. When used externally, you may need an explicit cast if you access 
     * any information specific to T. */
	@Override
	public T[] toArray() 
	{
		T[] tempArray;
        tempArray = (T[])(new Object[contents.length]);
        
		for(int index = 0; index < contents.length; index++) 
		{
			tempArray[index] = contents[index];
		}
		return tempArray;
	}
	
    /* Returns a string representation of this set. */
	@Override
    public String toString() 
	{   
		String stackers = "";
		for(int index = 0; index < contents.length; index++) 
		{
			if(contents[index] == null);
			else
				stackers += contents[index] + " ";
        }
     return stackers;
    }
    /* Complete the definition of this ArrayUnBoundedSet class by implementing
       all methods required by the interface SetADT. Note that this is an 
       unbounded array implementation. Thus, you should double the size of 
       the array when full. Eclipse can add stubs for all the required methods. */
}