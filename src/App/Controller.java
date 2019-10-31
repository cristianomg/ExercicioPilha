package App;

import java.util.Scanner;

import Pilha.Pilha;
import Pilha.PilhaComLista;

public class Controller {

	private Pilha<Carro> carrosEstacionados = new PilhaComLista<Carro>(10);
	
	public void entradas() {
		Scanner sc = new Scanner(System.in);
		boolean app = true;
		while(app) {
			System.out.print("Insira a placa do carro: ");
			String placa = sc.next();
			Carro carro = new Carro(placa);
			System.out.print("Informe a situação [Entrada / Saida]: ");
			String situacao = sc.next().toLowerCase();
			if (situacao.equals("entrada")) {
				if (carrosEstacionados.size() < 10) {
					estacionar(carro);
					System.out.println("Estacionamento realizado.");
				}
				else System.out.println("Estacionamento lotado!");
			}
			else if (situacao.equals("saida")){
				Carro carroRetirado = this.retirarCarro(carro);
				if (carroRetirado != null) {
					System.out.println("Carro de placa " + carroRetirado.getPlaca() + " retirado.");
					System.out.println("O carro foi movido " + carroRetirado.getMovido() + " vezes enquanto estava estacionado.");
				}
				else {
					System.out.println("Carro não encontrado.");
				}
			}
			else {
				System.out.println("Opção invalida.");
			}
			
		}
	}
	
	private boolean estacionar(Carro carro) {
		if (carrosEstacionados.push(carro)) return true;
		else return false;
	}
	
	private Carro retirarCarro(Carro carro) {
		PilhaComLista<Carro> moverCarros = new PilhaComLista<Carro>(10);
		Carro carroEncontrado = null;
		while(carrosEstacionados.size() > 0) {
			if (carrosEstacionados.top().getPlaca().equals(carro.getPlaca())){
				carroEncontrado = carrosEstacionados.pop();
				break;
			}else {
				carrosEstacionados.top().mover();
				moverCarros.push(carrosEstacionados.pop());
			}
		}
		while(moverCarros.size() > 0) {
			carrosEstacionados.push(moverCarros.pop());
		}
		return carroEncontrado;
	}
	
}
