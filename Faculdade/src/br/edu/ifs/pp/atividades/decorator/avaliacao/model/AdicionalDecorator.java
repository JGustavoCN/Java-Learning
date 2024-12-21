package br.edu.ifs.pp.atividades.decorator.avaliacao.model;

public abstract class AdicionalDecorator implements Acai {
    
    Acai acai;

    public AdicionalDecorator(Acai acai) {
        this.acai = acai;
    }

    @Override
    public String getNome(){
        return acai.getNome();
    }

    @Override
    public double getPreco(){
        return acai.getPreco();
    }
    
    
    
}
