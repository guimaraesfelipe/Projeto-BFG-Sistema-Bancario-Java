package br.com.bfg.app;

import java.util.Scanner;
import br.com.bfg.model.Cliente;
import br.com.bfg.model.Conta;

public class main {
	static Scanner scan = new Scanner(System.in);
	
	public static void depositar(Conta conta) {
		System.out.println("==================== Dep�sito ====================");
		System.out.println("Informe o valor para dep�sito: ");
		float valor = scan.nextFloat();
		if (valor > 0) {
			conta.depositar(valor);
		}else {
			System.out.println("O valor precisa ser positivo");
		}
	}
	
	public static void sacar(Conta conta) {
		System.out.println("===================== Saque =====================");
		System.out.println("Informe o valor para saque: ");
		float valor = scan.nextFloat();
		if (valor > 0) {
			conta.sacar(valor);
		}else {
			System.out.println("O valor precisa ser positivo");
		}
	}
	
	public static void transferir(Conta conta) {
		System.out.println("================= Transfer�ncia =================");
		System.out.println("Digite o n�medo da conta que deseja realizar o deposito: ");
		// W.I.P
		System.exit(0);
	}
	
	public static void consultar(Conta conta) {
		System.out.println("================ Consultar Saldo ================");
		System.out.println("Seu saldo � " + conta.getSaldo());
	}
	
	public static void main(String[] args) {
		
		// Tela de login: Backlog
		Conta c1 = new Conta(new Cliente("Luciano de Souza", "20/07/1988", 123441234, 1199999999, "luciano.souza@gmail.com"), 7600.89f);
		
		int opcao = 0;
		System.out.println("Bem-vindo ao Banco FG");
		
		do {
			System.out.println("Selecione uma das op��es abaixo: ");
			System.out.println("1 - Depositar");
			System.out.println("2 - Sacar");
			System.out.println("3 - Transferir");
			System.out.println("4 - Consultar Saldo");
			System.out.println("0 - Sair");
			opcao = scan.nextInt();
			
			switch (opcao) {
				case 1:
					depositar(c1);
					break;
					
				case 2:
					sacar(c1);
					break;
					
				case 3:
					transferir(c1);
					break;
					
				case 4:
					consultar(c1);
					break;
					
				case 0:
					System.out.println("Saindo do sistema.... At� � proxima!");
					break;

				default:
					System.out.println("Op��o invalida.");
					break;
				}
			
		}while (opcao != 0);
		
		scan.close();
	}

}
