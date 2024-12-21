package br.edu.ifs.pp.atividades.decorator.avaliacao.model;

public class AcaiComCupuacu implements Acai{

    @Override
    public double getPreco(){
        return 15d;
    }

    @Override
    public String getNome() {
        return "Acai como Cupuacu";
    }
    
}
