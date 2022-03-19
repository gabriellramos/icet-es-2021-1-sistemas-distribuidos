import java.util.ArrayList;
import java.util.List;

public class Armazenamento {
	private int memoria_max;
	private int memoria_disponivel;
	private int memoria_alocada;
	private int tam_req;
	public ArrayList<Integer> requisicoes;
	
	Armazenamento(int tam){
		setMemoria_max(tam);
		setMemoria_disponivel(tam);
		setMemoria_alocada(0);
		setRequisicoes();
	}
	
	/*
	 * função para alocar na memoria
	 */
	public boolean alocar(int req) {
		if (!memoria_cheia() && getMemoria_disponivel()>=req) {
			setMemoria_alocada(getMemoria_alocada()+req);
			setMemoria_disponivel(getMemoria_disponivel()-req);
			this.requisicoes.add(req);
			System.out.println("foi alocado");
			return true;	
		}
		System.out.println("nao foi alocado");
		return false;
	}
	
	/*
	 * função para verificar memoria cheia
	 */
	public boolean memoria_cheia() {
		return getMemoria_disponivel() == 0 ? true : false;
	}
	
	public void status_memoria() {
		System.out.println("\nMemoria MAXIMA: " + getMemoria_max());
		System.out.println("Memoria Alocada: " + getMemoria_alocada());
		System.out.println("Memoria Disponivel: " + getMemoria_disponivel() + "\n\n");

	}

	public int getMemoria_max() {
		return memoria_max;
	}

	public void setMemoria_max(int memoria_max) {
		this.memoria_max = memoria_max;
	}

	public int getMemoria_disponivel() {
		return memoria_disponivel;
	}

	public void setMemoria_disponivel(int memoria_disponivel) {
		this.memoria_disponivel = memoria_disponivel;
	}

	public int getTam_req() {
		return tam_req;
	}

	public void setTam_req(int tam_req) {
		this.tam_req = tam_req;
	}

	public List<Integer> getRequisicoes() {
		return requisicoes;
	}

	public void setRequisicoes() {
		this.requisicoes = new ArrayList<>();
	}

	public int getMemoria_alocada() {
		return memoria_alocada;
	}

	public void setMemoria_alocada(int memoria_alocada) {
		this.memoria_alocada = memoria_alocada;
	}
	
	
	
}
