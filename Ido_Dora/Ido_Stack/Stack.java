package Ido_Stack;

public class Stack<T> {
	private Node<T> head;
	
	//constructs and returns an empty stack
	public Stack(){
		this.head=null;
	}
	
	//enters a value to the top of the stack
	public void push(T x) {
		Node<T> temp=new Node<T>(x);
		temp.setNext(head);
		head=temp;
	}
	
	//takes out and returns the value of the top of the stack
	public T pop() {
		T x= head.getValue();
		head=head.getNext();
		return x;
	}
	
	//returns the value of the top of the stack
	public T top() {
		return head.getValue();
	}
	
	//returns true if the stack is empty and false otherwise
	public boolean isEmpty() {
		return head==null; //The stack is empty when there is no head node
	}
	
	//returns a description of the stack
	public String toString() {
		if(this.isEmpty())
			return "[]";
		Stack<T> temp=new Stack<T>();
		while(!this.isEmpty())
			temp.push(this.pop());
		String s="[";
		while(!temp.isEmpty()) {
			s=s+temp.top()+',';
			this.push(temp.pop());
		}
		s=s.substring(0, s.length()-1)+"]";
		return s;
	}
}
