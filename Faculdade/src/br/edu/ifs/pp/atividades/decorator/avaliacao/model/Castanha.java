package br.edu.ifs.pp.atividades.decorator.avaliacao.model;

public class Castanha extends AdicionalDecorator{

    public Castanha(Acai acai) {
        super(acai);
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 3d;
    }

    @Override
    public String getNome() {
        return super.getNome() + " + "+ "Castanha";
    }
    
}
