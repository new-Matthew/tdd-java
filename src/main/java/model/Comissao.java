package model;

public class Comissao {

    public Double calcular(Double valorVenda){
        return valorVenda < 1000 ? valorVenda * 0.1 : valorVenda * 0.15;
    }

}
