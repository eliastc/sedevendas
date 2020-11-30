package br.com.suporteti.sedevendas.domain.enums;

public enum UnidProd {
	UN(1, "Unidade"),
	CX(2, "Caixa"),
	CT(3, "Cartela"),
	DZ(4, "Dúzia"),
	BD(5, "Bandeja"),
	TB(6, "Tubo"), 
	PC(7, "Pacote"),
	PA(8, "Par"),
	GS(9, "Grosa"),
	RM(10, "Resma de Papel"),
	FD(11, "Fardo"),
	CJ(12, "Conjunto"),
	DP(13, "Display");

	private int cod;
	private String descricao;
	
	private UnidProd(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static UnidProd toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(UnidProd x : UnidProd.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido : " + cod);
	}
}
