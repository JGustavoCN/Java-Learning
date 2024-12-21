package br.edu.ifs.pp.atividades.decorator.avaliacao.model;

public class LeiteCondensado extends AdicionalDecorator{

    public LeiteCondensado(Acai acai) {
        super(acai);
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 2d;
    }

    @Override
    public String getNome() {
        return super.getNome() + " + "+ "Leite Condesado";
    }
    
}
