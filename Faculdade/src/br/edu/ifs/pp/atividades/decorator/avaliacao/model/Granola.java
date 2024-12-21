package br.edu.ifs.pp.atividades.decorator.avaliacao.model;

public class Granola extends AdicionalDecorator{

    public Granola(Acai acai) {
        super(acai);
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 2d;
    }

    @Override
    public String getNome() {
        return super.getNome() + " + "+ "Granola";
    }
    
}
