package br.edu.infnet.CommonUse.Exceptions;

public class NotInteger extends Exception{

    public NotInteger(){
    }

    public NotInteger(String msg){
        super(msg);
    }

}