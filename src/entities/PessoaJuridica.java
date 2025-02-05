package entities;

public class PessoaJuridica extends Contribuinte {
	
	private int numeroFuncionarios;
	
	public PessoaJuridica() {
		
	}

	public PessoaJuridica(String nome, double rendaAnual, int numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	@Override
	public double impostoPago() {
		if(numeroFuncionarios > 10) {
			return rendaAnual * 0.14;
		} else {
			return rendaAnual * 0.16;
		}
	}
	
	@Override
	public String exibeInfo() {
		return super.exibeInfo() + String.format("%nNúmero funcionários: %d, Imposto pago: %.2f", numeroFuncionarios, impostoPago());
		
	}
}
