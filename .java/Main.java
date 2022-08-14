class Main {
	public static void main (String args[]) {
		Veiculo carro[] = new Veiculo[16];
		Keyboard teclado = new Keyboard();

		System.out.println("-------------------------------");
		System.out.println("| Montadora de Veículo Maciel |");
		System.out.println("-------------------------------");

		while (true) {
			try {
				System.out.println("> Menu Principal <");
				System.out.println();
				System.out.printf("1. Montar veículo %n2. Registrar veículo %n3. Teste Drive %n4. Consultar veículo %n5. Desmontar veículo %n6. Sair %n");
				System.out.println();
				teclado.input();

				//>>> MONTAR VEÍCULO <<<
				if (teclado.getTeclado().equals("1")) {
					String modelo, marca, cor, ano;

					System.out.println("> Montar veículo <");
					System.out.println("Qual o modelo do veículo?");
					teclado.input();
					modelo = teclado.getTeclado();

					System.out.println("Qual a marca do veículo?");
					teclado.input();
					marca = teclado.getTeclado();

					System.out.println("Qual a cor do veículo?");
					teclado.input();
					cor = teclado.getTeclado();

					System.out.println("Qual o ano do veículo?");
					teclado.input();
					ano = teclado.getTeclado();

					for (int i = 0; i < carro.length; i++) {
						if (carro[i] == null) {
							carro[i] = new Veiculo(modelo, marca, cor, Integer.parseInt(ano));
							carro[i].setProprietario("Não registrado");
							carro[i].setNumeroFabricacao(i + 1);
							System.out.println();
							System.out.println("Veículo montado com sucesso.");
							System.out.println();
							break;
						}
					}

				//>>> REGISTRAR VEÍCULO <<<
				} else if (teclado.getTeclado().equals("2")) {				
					System.out.println();
					System.out.println("> Registrar Veículo <");
					System.out.println("Digite o modelo do veículo para realizar a pesquisa:");
					teclado.input();

					boolean vazio = true;

					for (int i = 0; i < carro.length; i++) {
						if (carro[i] != null) {
							if (teclado.getTeclado().equalsIgnoreCase(carro[i].getModelo())) {
							carro[i].status();			
							vazio = false;		
							}
						}
					}

					if (vazio) {
						System.out.println();
						System.out.println("Nenhum registro foi encontrado.");
						System.out.println();
						continue;
					}

					System.out.println("Consulte o veículo desejado na lista acima e digite o número de fabricação:");
					teclado.input();
					String fabricacao = teclado.getTeclado();

					System.out.println("Em qual nome o veículo será registrado?");
					teclado.input();
					String proprietario = teclado.getTeclado();
					System.out.println();
						
					for (int i = 0; i < carro.length; i++) {
						if (carro[i] != null) {
							if (carro[i].getNumeroFabricacao() == Integer.parseInt(fabricacao)) {
								carro[i].setProprietario(proprietario);
								System.out.println("Veículo registrado com sucesso no nome de " + proprietario);
								System.out.println();
							}
						}
					}

				// >>> Teste Drive <<<	
				} else if (teclado.getTeclado().equals("3")) {
					System.out.println();

					boolean vazio = true;

					for (int i = 0; i < carro.length; i++) {
						if (carro[i] != null) {
							vazio = false;
						}
					}

					if (vazio == true) {
						System.out.println("Não existem veículos disponíveis para teste.");
						System.out.println();
						continue;
					}

					System.out.println("Um veículo aleatório foi selecionado para o teste.");
					System.out.println();
					System.out.println("> Teste Drive <");
					System.out.println();

					int i = -1;
					do {
						i++;
					} while (carro[i] == null);

					while (true) {
						try {
							System.out.println("1. Ligar veículo    5. Desligar Veículo");
							System.out.println("2. Acelerar         6. Parar");
							System.out.println("3. Freiar           7. Marcha Ré");
							System.out.println("4. Trocar marcha    8. Sair");

							System.out.println();
							teclado.input(); 
		
							if (teclado.getTeclado().equals("1")) {
								System.out.println();
								carro[i].ligar();
								System.out.println();
							} else if (teclado.getTeclado().equals("2")) {
								System.out.println();
								carro[i].acelerar();
								System.out.println();
							} else if (teclado.getTeclado().equals("3")) {
								System.out.println();
								carro[i].freiar();
								System.out.println();
							} else if (teclado.getTeclado().equals("4")) {
								System.out.println();
								carro[i].trocarMarcha();
								System.out.println();
							} else if (teclado.getTeclado().equals("5")) {
								System.out.println();
								carro[i].desligar();
								System.out.println();
							} else if (teclado.getTeclado().equals("6")) {
								System.out.println();
								carro[i].parar();
								System.out.println();
							} else if (teclado.getTeclado().equals("7")) {
								System.out.println();
								carro[i].marchaRe();
								System.out.println();
							} else if (teclado.getTeclado().equals("8")) {
								System.out.println();
								break;
							}

						} catch (Exception ex) {
							System.out.println("Opção inválida.");
						}
					}

				// >>> Consulta <<<
				} else if (teclado.getTeclado().equals("4")) {
					System.out.println();
					System.out.println("> Consultar Veículo <");
					System.out.println();

					System.out.format("1. Proprietário %n2. Modelo %n3. Marca %n4. Ano %n5. Consultar todos %n6. Voltar %n");
					System.out.println();
					System.out.println("Esolha o tipo de consulta:");
					teclado.input();

					if (teclado.getTeclado().equals("1")) {
						System.out.println("Qual o nome do proprietário?");
						teclado.input();

						for (int i = 0; i < carro.length; i++) {
							if (carro[i] != null) {
								if (carro[i].getProprietario().equalsIgnoreCase(teclado.getTeclado())) {
									carro[i].status();
								}
							}
						}

					} else if (teclado.getTeclado().equals("2")) {
						System.out.println("Qual o modelo do veículo?");
						teclado.input();

						for (int i = 0; i < carro.length; i++) {
							if (carro[i] != null) {
								if (carro[i].getModelo().equalsIgnoreCase(teclado.getTeclado())) {
									carro[i].status();
								}
							}
						}

					} else if (teclado.getTeclado().equals("3")) {
						System.out.println("Qual a marca do veículo?");
						teclado.input();

						for (int i = 0; i < carro.length; i++) {
							if (carro[i] != null) {
								if (carro[i].getMarca().equalsIgnoreCase(teclado.getTeclado())) {
									carro[i].status();
								}
							}
						}
					
					} else if (teclado.getTeclado().equals("4")) {
						System.out.println("Qual o ano do veículo?");
						teclado.input();

						for (int i = 0; i < carro.length; i++) {
							if (carro[i] != null) {
								if (carro[i].getAno() == Integer.parseInt(teclado.getTeclado())) {
									carro[i].status();
								}
							}
						}
					
					} else if (teclado.getTeclado().equals("5")) {
						boolean vazio = true;
						
						for (int i = 0; i < carro.length; i++) {
							if (carro[i] != null) {
								carro[i].status();
								vazio = false;
							}
						}

						if (vazio == true) {
							System.out.println();
							System.out.println("Nenhum registro foi encontrado.");
							System.out.println();
							continue;
						}
					
					} else if (teclado.getTeclado().equals("6")) {
						System.out.println();
						continue;
					} else {
						System.out.println("Opção inválida!");
						System.out.println();
						continue;
					}

				} else if (teclado.getTeclado().equals("5")) {
					System.out.println();
					System.out.println("> Desmontar Veículo <");

					System.out.println("Digite o número de fabricação do veículo a ser desmontado:");
					teclado.input();

					boolean vazio = true;

					for (int i = 0; i < carro.length; i++) {
						if (carro[i] != null) {
							carro[i].status();
							vazio = false;
						}
					}

					if (vazio == true) {
						System.out.println();
						System.out.println("Nenhum registro foi encontrado.");
						System.out.println();
						continue;
					}

					for (int i = 0; i < carro.length; i++) {
						if (carro[i] != null) {
							if (carro[i].getNumeroFabricacao() == Integer.parseInt((teclado.getTeclado()))) {
								carro[i] = null;
								System.out.println("Veículo desmontado com sucesso.");
								System.out.println();
							}
						}
					}

				} else if (teclado.getTeclado().equals("6")) {
					System.out.println();
					System.out.println("Programa encerrado.");
					break;
				}

			} catch (Exception e) {
				System.out.println("ERRO: Parece que algo deu errado.");
				System.out.println();
			}
		}


	}
}