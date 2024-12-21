package br.edu.ifs.pp.atividades.decorator.avaliacao.model;

public class AcaiComBanana implements Acai{

    @Override
    public double getPreco(){
        return 12d;
    }

    @Override
    public String getNome() {
        return "Acai com banana";
    }
    
}
