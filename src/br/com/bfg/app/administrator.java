package br.com.bfg.app;

import java.util.Scanner;
import br.com.bfg.dao.ContaDao;
import br.com.bfg.model.Cliente;
import br.com.bfg.model.Conta;

public class administrator {

	static Scanner scan = new Scanner(System.in);
	
	public static void abrir() {
		System.out.println("================ Abertura de Conta ===============");
		
		System.out.println("Nome completo: ");
		String nome = scan.nextLine();
		scan.next();
		
		System.out.println("Data de nascimento: ");
		String data_nascimento = scan.nextLine();
		scan.next();
		
		System.out.println("CPF (somente números): ");
		long cpf = scan.nextLong();
		
		System.out.println("Telefone (somente números): ");
		long telefone = scan.nextLong();
		
		System.out.println("E-mail: ");
		String email = scan.nextLine();
		scan.next();
		
		System.out.println("Valor de deposito inicial: ");
		float valor = scan.nextFloat();
		
		try {
			Conta conta = new Conta(new Cliente(nome, data_nascimento, cpf, telefone, email), valor);
			ContaDao.create(conta);
			
		}catch (Exception e) {
			System.out.println("Não foi possivel realizar a abertura da conta. Verifique os dados e tente novamente!");
		}
		
	}
	
	public static void main(String[] args) {
		int opcao = 0;
		System.out.println("Administrador - Banco BFG");
		
		do {
			System.out.println("Selecione uma das opções abaixo: ");
			System.out.println("1 - Abrir Conta");
			System.out.println("2 - Deletar Conta");
			System.out.println("3 - Editar Conta");
			System.out.println("4 - Consultar Conta");
			System.out.println("0 - Sair");
			opcao = scan.nextInt();
			
			switch (opcao) {
				case 1:
					abrir();
					break;

				default:
					break;
				}
			
		}while(true);
	}

}
