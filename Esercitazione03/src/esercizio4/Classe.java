package esercizio4;

public class Classe {

	private Scuola scuola;
	private Insegnante ins1;
	private Insegnante in2;
	private Insegnante ins3;
	private int numAlunni;
	private String nome;

	// Constructor
	public Classe(Scuola scuola, Insegnante ins1, Insegnante in2, Insegnante ins3, int numAlunni, String nome) {
		this.scuola = scuola;
		this.ins1 = ins1;
		this.in2 = in2;
		this.ins3 = ins3;
		this.numAlunni = numAlunni;
		this.nome = nome;
	}
	
	//Services
	public void inserisciInsegnante(int posizione, Insegnante ins) {
		switch (posizione) {
		case 1:
			this.ins1 = ins;
			break;
		case 2:
			this.in2 = ins;
			break;
		case 3:
			this.ins3 = ins;
			break;
		default:
			break;
		}
	}
	
	public void stampa() {
		System.out.print("dati classe: "+ this.nome +" "+ this.numAlunni+ " "+ this.in2.getNome()+ "ecc..");
	}

//Getters and setters
	public Scuola getScuola() {
		return scuola;
	}

	public void setScuola(Scuola scuola) {
		this.scuola = scuola;
	}

	public Insegnante getIns1() {
		return ins1;
	}

	public void setIns1(Insegnante ins1) {
		this.ins1 = ins1;
	}

	public Insegnante getIn2() {
		return in2;
	}

	public void setIn2(Insegnante in2) {
		this.in2 = in2;
	}

	public Insegnante getIns3() {
		return ins3;
	}

	public void setIns3(Insegnante ins3) {
		this.ins3 = ins3;
	}

	public int getNumAlunni() {
		return numAlunni;
	}

	public void setNumAlunni(int numAlunni) {
		this.numAlunni = numAlunni;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
