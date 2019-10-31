package Pilha;

public interface Pilha <T>{

	public boolean push(T elemento);
	public T pop();
	public boolean isEmpty();
	public T top();
	public int size();
}
