package br.edu.ifs.pp.atividades.decorator.avaliacao.model;


public interface Acai {
   
    double getPreco();
    
    String getNome();
    
    default String minhaTigela(){
        return "Descricao: "+ this.getNome()+"\nPreco: "+ this.getPreco();
    } 
}
