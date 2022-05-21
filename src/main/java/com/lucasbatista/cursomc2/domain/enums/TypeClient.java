package com.lucasbatista.cursomc2.domain.enums;

public enum TypeClient {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    private TypeClient(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TypeClient toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for (TypeClient x : TypeClient.values()) {
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("invalid id: " + cod);
    }
}
