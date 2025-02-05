package entities;

public class PessoaFisica extends Contribuinte {
	
	private double gastosSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public double impostoPago() {
		if(rendaAnual <= 20000.00) {
			return (rendaAnual * 0.15) - gastosSaude * 0.50;
		} else {
			return (rendaAnual * 0.25) - gastosSaude * 0.50;
		}
	}
	
	@Override
	public String exibeInfo() {
		return super.exibeInfo() + String.format("%nGasto com saude: %.2f, Imposto pago: %.2f", gastosSaude, impostoPago());
		
	}
	
}
 