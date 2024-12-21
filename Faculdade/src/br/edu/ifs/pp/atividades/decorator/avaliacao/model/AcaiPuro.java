package br.edu.ifs.pp.atividades.decorator.avaliacao.model;

public class AcaiPuro implements Acai{

    @Override
    public double getPreco(){
        return 10d;
    }

    @Override
    public String getNome() {
        return "Acai Puro";
    }
    
}
