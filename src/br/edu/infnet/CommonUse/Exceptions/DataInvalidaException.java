package br.edu.infnet.CommonUse.Exceptions;

public class DataInvalidaException extends Exception{

    public DataInvalidaException(){
    }

    public DataInvalidaException(String msg){
        super(msg);
    }
}
