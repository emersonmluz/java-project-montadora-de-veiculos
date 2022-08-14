class Veiculo implements TestDrive{
	public final int length = 0;
    private String proprietario;
	private String modelo;
	private String marca;
	private String cor;
	private int ano;
	private int numeroFabricacao;
	private int velocimetro;
	private int marcha;
	private boolean ligado;
	

	public Veiculo (String modelo, String marca, String cor, int ano) {
		this.setModelo(modelo);
		this.setMarca(marca);
		this.setCor(cor);
		this.setVelocimetro(0);
		this.setLigado(false);
		this.setAno(ano);
		this.setMarcha(0);
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getVelocimetro() {
		return velocimetro;
	}

	public void setVelocimetro(int velocimetro) {
		this.velocimetro = velocimetro;
	}

	public int getMarcha() {
		return marcha;
	}

	public void setMarcha(int marcha) {
		this.marcha = marcha;
	}

	public boolean getLigado() {
		return ligado;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getNumeroFabricacao() {
		return numeroFabricacao;
	}

	public void setNumeroFabricacao(int numeroFabricacao) {
		this.numeroFabricacao = numeroFabricacao;
	}

	public void status() {
		System.out.println("------------------------------------");
		System.out.println("Número de Fabricação: " + this.getNumeroFabricacao());
		System.out.println("Proprietário: " + this.getProprietario());
		System.out.println("Modelo: " + this.getModelo());
		System.out.println("Marca: " + this.getMarca());
		System.out.println("Cor: " + this.getCor());
		System.out.println("Ano: " + this.getAno());
		System.out.println("------------------------------------");
	}

	@Override
	public void ligar() {
		if (this.getLigado()) {
			System.out.println("O veículo já está ligado.");
		} else if (this.getMarcha() > 0) {
			System.out.println("A marcha precisa estar em ponto morto antes de ligar, o veículo apagou.");
				System.out.println("O cambio está em ponto morto e o veículo desligado.");
				this.setMarcha(0);
		} else {
			this.setLigado(true);
			System.out.println("Veículo ligado e pronto para teste.");
		}
	}

	@Override
	public void desligar() {
		if (!(this.getLigado())) {
			System.out.println("O veículo já está desligado.");
		} else if (this.getVelocimetro() > 0) {
			System.out.println("O veículo está em movimento, pare antes de desligar para não causar um acidente.");
		} else {
			this.setLigado(false);
			this.setMarcha(0);
			System.out.println("Veículo desligado com sucesso.");
		}
	}

	@Override
	public void acelerar() {
		if ((this.getLigado())) {

			if (this.getMarcha() == 0) {
				this.setMarcha(1);
			}

			if (this.getMarcha() > 2 && this.getVelocimetro() < 20 || this.getMarcha() == 5 && this.getVelocimetro() < 40) {
				System.out.println("A marcha está muito alta para acelerar, o veículo apagou.");
				System.out.println("O cambio está em ponto morto e o veículo desligado.");
				this.setMarcha(0);
				this.setVelocimetro(0);
				this.setLigado(false);
			} else {
				if (this.getVelocimetro() == 10 && this.getMarcha() == 1) {
					System.out.println("Troque a marcha antes de continuar.");
				} else if (this.getVelocimetro() == 20 && this.getMarcha() == 2) {
					System.out.println("Troque a marcha antes de continuar.");
				} else if (this.getVelocimetro() == 35 && this.getMarcha() == 3) {
					System.out.println("Troque a marcha antes de continuar.");
				} else if (this.getVelocimetro() == 50 && this.getMarcha() == 4) {
					System.out.println("Troque a marcha antes de continuar.");
				} else {
					this.setVelocimetro(this.getVelocimetro() + 5);
					System.out.printf("Aceleração: O veículo está a %d Km/h. %n", this.getVelocimetro());
				}
			}

		} else {
			System.out.println("Ligue o veículo antes de acelerar.");
		}
	}

	@Override
	public void freiar() {
		if (!(this.getLigado())) {
			System.out.println("Ação desnecessária, o veículo não se encontra em movimento.");
		} else if (this.getVelocimetro() >= 5) {
			this.setVelocimetro(this.getVelocimetro() - 5);
			System.out.printf("Freio: O veículo está a %d km/h. %n", this.getVelocimetro());
			if (this.getVelocimetro() == 0) {
				this.setMarcha(0);
				System.out.println("Freio: O veículo parou.");
			}	
		} else {
			System.out.println("O veículo se encontra parado.");
		}
	}

	@Override
	public void parar() {
		if (this.getLigado() && this.getVelocimetro() > 0) {
			this.setVelocimetro(0);
			this.setMarcha(0);
			System.out.println("O veículo parou.");
		} else if (this.getMarcha() > 0) {
			this.setVelocimetro(0);
			this.setMarcha(0);
			System.out.println("O veículo parou.");
		} else {
			System.out.println("O veículo já está parado, nenhuma ação é necessária.");
		}
	}

	@Override
	public void trocarMarcha() {
		if (this.getMarcha() == 5) {
			System.out.println("O veículo já está na marcha mais alta.");	
		} else {
			this.setMarcha(this.getMarcha() + 1);
			System.out.println("Cambio: marcha " + this.getMarcha());
		}		
	}

	@Override
	public void marchaRe() {
		if (this.getLigado() && this.getVelocimetro() == 0) {
			this.setMarcha(0);
			this.setVelocimetro(5);
			System.out.println("O veículo está em marcha ré.");
		} else if (!(this.getLigado())) {
			System.out.println("Ligue o veículo antes de engatar a ré.");
		} else if (this.getVelocimetro() > 0) {
			System.out.println("Pare o veículo antes de engatar a ré.");
		}
	}
}