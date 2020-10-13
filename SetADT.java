//********************************************************************
//  SetADT.java       
//
//  Defines the interface to a set collection.
//********************************************************************

public interface SetADT<T> {

    /* Adds one element to this set, if not already present. 
     * Must double capacity if full. */
    public void add(T element);

    /* Returns true if this set contains the target element. */
    public boolean contains(T target);

    /* Removes and returns the specified element from this set. */
    public T remove (T element) throws ElementNotFoundException, EmptySetException;

    /* Removes and returns a random element from this set. Optional method.
     * If not implemented then must throw Java's built-in UnsupportedOperationException
     * in the implementing class. */
    public T removeRandom () throws EmptySetException;

    /* Returns a new set which is the union of this set and the parameter set.
     * Neither this set nor the parameter set should be altered. */
    public SetADT<T> union(SetADT<T> otherset);

    /* Returns a new set which is the intersection of this set and the parameter set.
     * Neither this set nor the parameter set should be altered. */
    public SetADT<T> intersect(SetADT<T> otherset);

    /* Returns true if this set is a subset of the parameter set. */
    public boolean subset(SetADT<T> otherset);

    /* Returns true if this set and the parameter set contain exactly
     * the same elements, not necessarily in the same order though. */
    public boolean equals(SetADT<T> otherset);

    /* Returns true if this set contains no elements. */
    public boolean isEmpty();

    /* Returns the number of elements in this set. */
    public int size();

    /* Returns all the elements of this set as an array.
     * NOTE: Although declared public, this is intended for internal to class use.
     * Essentially, it is a replacement for an iterator, which we will cover later.
     * The conversion to array will allow you to iterate through the elements 
     * of the associated set. Internally you will need to allocate
     * an Object[] and cast it to T[]. Externally, all elements of this array
     * will have type Object and not what T was owing to Java's implementation of 
     * generics. When used externally, you may need an explicit cast if you access 
     * any information specific to T. */
    public T[] toArray();

    /* Returns a string representation of this set. */
    public String toString();

}
