package br.edu.infnet.CommonUse.Exceptions;

public class EmptyStringException extends Exception{

    public EmptyStringException(){
    }

    public EmptyStringException(String msg){
        super(msg);
    }

}
