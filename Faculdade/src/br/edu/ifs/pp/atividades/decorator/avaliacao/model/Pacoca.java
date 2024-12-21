package br.edu.ifs.pp.atividades.decorator.avaliacao.model;

public class Pacoca extends AdicionalDecorator{

    public Pacoca(Acai acai) {
        super(acai);
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 2d;
    }

    @Override
    public String getNome() {
        return super.getNome() + " + "+ "Paçoca";
    }
    
}
