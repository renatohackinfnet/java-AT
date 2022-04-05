package br.edu.infnet.CommonUse;

import br.edu.infnet.CommonUse.Exceptions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.in;

public class Tools {

    private static final Scanner input = new Scanner(in);

    public static String getStringInput() throws EmptyStringException {
        String inputStr = input.nextLine();

        if (inputStr.isBlank()) {
            throw new EmptyStringException("Voce nao pode digitar um valor vazio.");
        }

        return inputStr;
    }

    public static double getNumberInput() throws NumberFormatException, EmptyStringException {
        String doubleStr = getStringInput();

        if (!isNumeric(doubleStr)) {
            throw new NumberFormatException("Voce deve inserir um numero.");
        }
        else {
            return Double.parseDouble(doubleStr);
        }
    }

    public static int getIntegerInput() throws NotInteger, EmptyStringException {
        double d;
        try{
            d = getNumberInput();
            if (d % 1 == 0) {
                return (int) d;
            }
            else {
                throw new NotInteger("Você deve inserir um numero inteiro.");
            }
        } catch (NumberFormatException e){
            throw new NotInteger("Você deve digitar um numero inteiro.");
        }

    }

    public static boolean checkIfInRange(double initialValue, double finalValue, double valor){
        return valor >= initialValue && valor <= finalValue;
    }

    public static boolean isDateValid(String dataString) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int dia;
        int mes;
        int ano;

        String[] arrData = splitData(dataString);

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

        try {
            Date date = sdf.parse(dataString);
        } catch (ParseException e) {
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

        return (isNumeric(precoFixed) && Float.parseFloat(precoFixed) > 0);
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

    public static void println(String msg){
        System.out.println(msg);
    }

    public static void print(String msg){
        System.out.print(msg);
    }
}
