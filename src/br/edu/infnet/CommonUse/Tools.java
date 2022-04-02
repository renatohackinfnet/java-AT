package br.edu.infnet.CommonUse;

import java.util.Calendar;

public class Tools {

    public static boolean isDateValid(String data) {

        int dia;
        int mes;
        int ano;

        String[] arrData = splitData(data);

        if (arrData.length != 3) {
            return false;
        }

        try{
            dia = Integer.parseInt(arrData[0]);
            mes = Integer.parseInt(arrData[1]);
            ano = Integer.parseInt(arrData[2]);
        } catch (NumberFormatException e){
            return false;
        }

        return (dia <= 31 && dia >= 1) && (mes <= 12 && mes >= 1) && ano >= Calendar.getInstance().get(Calendar.YEAR);
    }

    public static String[] splitData(String data) {
        data = data.replace("-", "/").replace(" ", "/");
        return data.split("/");
    }

    public static boolean isPrecoValid(String preco){
        String precoFixed = preco.replace(",", ".");

        if (isNumeric(precoFixed)){
            return !(Float.parseFloat(precoFixed) <= 0);
        }
        else return false;


    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum.replace(",", "."));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
