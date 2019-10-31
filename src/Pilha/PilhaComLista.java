package Pilha;

import Lista.classes.Lista;
import ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;

public class PilhaComLista <T> implements Pilha<T>{
	private int tamanhoMaximo;
	private int top = -1;
	private int empilhados;
	private Lista<T> elementos= new ListaDuplamenteEncadeada<T>();

	public PilhaComLista() {
		this.tamanhoMaximo = (int) Float.POSITIVE_INFINITY;
	}
	
	public PilhaComLista(int tamanho) {
		this.tamanhoMaximo = tamanho;
	}
	
	@Override
	public boolean push(T elemento) {
		if (empilhados < tamanhoMaximo) {
			elementos.adicionar(elemento);
			top++;
			empilhados++;
			return true;
		}
		return false;
	}

	@Override
	public T pop() {
		T elemento = null;
		if (top >= 0) {
		elemento = elementos.removerNoFim();
			top--;
			empilhados--;
		}
		return elemento;
	}

	@Override
	public boolean isEmpty() {
		return top < 0;
	}

	@Override
	public T top() {
		return elementos.buscar(this.top);
	}

	@Override
	public int size() {
		return elementos.tamanho();
	}

}
