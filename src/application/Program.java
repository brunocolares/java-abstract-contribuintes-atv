package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira o número de contribuintes: ");
		int n = sc.nextInt();
		sc.nextLine();
		List<Contribuinte> contribuintes = new ArrayList<>();
		double totalArrecadado = 0.0;
		for(int i = 1; i <= n; i++) {
			System.out.println("Dados do contribuinte #"+i+": ");
			System.out.print("Insira o nome: ");
			String nome = sc.nextLine();
			System.out.print("Insira a renda: ");
			double renda = sc.nextDouble();
			sc.nextLine();
			System.out.print("Qual o tipo de contribuinte(f/j)? ");
			char tipoContribuinte = sc.next().charAt(0);
			sc.nextLine();
			if(tipoContribuinte == 'f') {
				System.out.print("Gastos com saúde: ");
				double gastosSaude = sc.nextDouble();
				contribuintes.add(new PessoaFisica(nome, renda, gastosSaude));
			} else if(tipoContribuinte == 'j') {
				System.out.print("Número de funcionários: ");
				int numeroFuncionarios = sc.nextInt();
				contribuintes.add(new PessoaJuridica(nome, renda, numeroFuncionarios));
			} else {
				System.out.println("Tipo inválido.");
			}
			sc.nextLine();
		}
		System.out.println("CONTRIBUINTES:");
		for(Contribuinte contribuinte : contribuintes) {
			System.out.println(contribuinte.exibeInfo());
			totalArrecadado += contribuinte.impostoPago();
		}
		
		System.out.println("TOTAL ARRECADADO: "+ totalArrecadado);
		sc.close();
		
	}

}
