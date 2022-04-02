package br.edu.infnet.CommonUse.Exceptions;

public class NotInRange extends Exception{

    public NotInRange(){
    }

    public NotInRange(String msg){
        super(msg);
    }

}