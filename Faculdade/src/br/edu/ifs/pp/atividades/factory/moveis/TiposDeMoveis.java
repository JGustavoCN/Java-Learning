package br.edu.ifs.pp.atividades.factory.moveis;

public enum TiposDeMoveis {
    CADEIRA("Cadeira"),
    MESA_DE_CENTRO("Mesa de Centro"),
    SOFA("Sofá");
    
    private final String nome;

    private TiposDeMoveis(String nome) {
        this.nome = nome;
    }
    
    public static TiposDeMoveis getTipo(String tipoDeMovel){
        for (TiposDeMoveis tipo : TiposDeMoveis.values()) {
            if (tipo.nome.equalsIgnoreCase(tipoDeMovel)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
