//OK 19/11 17:47
package com.acme.rn.conta;

import com.acme.excecoes.ExcecaoValorInvalido;

public class IdentificadorConta {

	private long numero; // Declaracao dos atributos
	private int digitoVerificador;

	public IdentificadorConta(long numero) throws ExcecaoValorInvalido { // Construtor
																			// para
																			// inicializar
																			// o
		// atributo numero
		this.setIdentificadorConta(numero); // Atribui ao atributo o valor long
											// recebido
	}

	public void setIdentificadorConta(long numero) throws ExcecaoValorInvalido { // Metodo
																					// para
																					// atribuir
		// valor ao atributo
		if (numero != 0) {
			this.numero = numero; // Atribui ao atributo o valor long recebido
		} else {
			throw new ExcecaoValorInvalido("erro.IdentificadorConta.numeroInvalido");
		}
	}

	public long getIdentificadorConta() { // Metodo para receber o valor do
											// atributo
		return this.numero;
	}

	public int calcularDigitoVerificador(long valor) { // Metodo para calcular o
														// digito verificador,
														// recebendo um long
		int soma = 0; // Inicializa a variavel soma
		while (valor != 0) { // Realiza os passos seguintes caso o valor
								// recebido seja diferente de 0
			soma += valor % 10; // Atribui a variavel soma o valor do resto da
								// divisao da variavel valor e o numero 10
			valor /= 10; // Divide o valor da variavel valor por 10, para
							// diminuir uma casa decimal
		}
		digitoVerificador = (soma % 99); // Atribui ao atributo o valor do resto
											// da divisao da variavel soma e o
											// numero 99
		return digitoVerificador; // Retorna o valor do atributo
	}

	public boolean verificarValidadeDigito(int digitoVerificador) { // Metodo
																	// para
																	// verificar
																	// a
																	// validade
																	// do digito
																	// verificador,
																	// recebendo
																	// um
																	// inteiro
		boolean verificaçao = false; // Inicializa a variavel verificacao
										// booleana com o valor logico falso
		if (this.digitoVerificador == digitoVerificador) { // Verifica se o
															// digito informado
															// e igual ao
															// calculado
			verificaçao = true; // Ja que o digito foi verificado atribui o
								// valor logico verdadeiro a variavel
								// verificacao
		}

		return verificaçao; // Retorna o valor logico da variavel verificacao
	}

	public boolean equals(Object o) {// Metodo para comparar dois objetos
		boolean r = false;// Inicializa com o valor logico falso
		if (o instanceof IdentificadorConta) {// Verifica se o objeto e do tipo
												// IdentificadorConta
			r = Long.toString(this.numero).equals(((IdentificadorConta) o).numero);// Compara
																					// dois
																					// objetos
																					// caso
																					// sejam
																					// iguais
																					// atribui
																					// o
																					// valor
																					// logico
																					// verdadeiro
		}
		return r;// Retorna o valor logico
	}

}
