package br.com.bfg.model;

import java.util.Date;

public class Conta {
	private int numero;
	private float saldo;
	private Cliente cliente;
	private Date data_abertura;
	public static int contador = 19135001;
	
	
	public Conta(Cliente cliente, float saldo) {
		this.numero = contador;
		this.cliente = cliente;
		this.saldo = saldo;
		this.data_abertura = new Date();
		
		Conta.contador = Conta.contador + 1;
	}

	public void depositar(float valor) {
		this.saldo = this.saldo + valor;
		System.out.println("Deposito realizado com sucesso.\nSaldo atualizado: " + this.saldo);
	}
	
	public void sacar(float valor) {
		if (valor <= this.saldo) {
			this.saldo = this.saldo - valor;
			System.out.println("Saque realizado com sucesso.\nSaldo atualizado: " + this.saldo);
		}else {
			System.out.println("Saldo insuficiente.\nSaldo atual: " + this.saldo);
		}
	}
	
	public void transferir(float valor, int beneficiario) {
		if (valor > 0 && valor <= this.saldo) {
			// W.I.P
			System.out.println("Transferência realizada com sucesso.\nSaldo atualizado: " + this.saldo);
		}else if (valor <= 0){
			System.out.println("O valor precisa ser positivo.");
		}else {
			System.out.println("Saldo insuficiente.");
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(Date data_abertura) {
		this.data_abertura = data_abertura;
	}
	
}