package App;

public class Carro {
	private String placa;
	private int movido = 0;
		
	public Carro(String placa) {
		super();
		this.placa = placa;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getMovido() {
		return movido;
	}
	public void mover() {
		this.movido++;
	}
	
}
