package br.edu.ifs.fp;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

/**
 *
 * @author José Gustavo
 */
public class Fundamentos {
    
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int value1 = in.nextInt();
        int value2 = in.nextInt();
        int value3 = in.nextInt();
        if (value1 == 20 || value2 == 20 || value3 == 20)
        
        System.out.print("Entre com a sentenca: ");
	String line = in.nextLine();
        // usar " " e "[ ]+" tem diferença
	String[] words = line.split("[ ]+");
	System.out.println("Penultima palavra: "+words[words.length - 2]);
      
        dataHorario();
        asciiUnicode('a');
        infoJava();
    }

    public static void infoJava() {

        System.out.println("\nVersao do Java: " + System.getProperty("os.arch"));
        System.out.println("Java Runtime Version: " + System.getProperty("java.runtime.version"));
        System.out.println("Java Home: " + System.getProperty("java.home"));
        System.out.println("Java Vendor: " + System.getProperty("java.vendor"));
        System.out.println("Java Vendor URL: " + System.getProperty("java.vendor.url"));
        System.out.println("Java Class Path: " + System.getProperty("java.class.path") + "\n");

    }

    public static void asciiUnicode(char ch) {
        int ascii = (int) ch;
        int unicode = Character.getNumericValue(ch);
        System.out.format("ASCII = %d%nUnicode = %d", ascii, unicode);
    }

    public static void dataHorario() {

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataHoraFormatada = dtf.format(dataHoraAtual);
        System.out.println("Data e hora atual no formato do Brasil: " + dataHoraFormatada);
        System.out.println("Data e hora atual no formato do Brasil: " + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(LocalDateTime.now()));
//        System.out.println(Calendar.getInstance().getTimeZone().getID());
//        System.out.println(TimeZone.getDefault().getID());
//        System.out.println(TimeZone.getTimeZone("GMT-3").getID());

        SimpleDateFormat cdt = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        cdt.setCalendar(Calendar.getInstance(TimeZone.getDefault()));
        System.out.println("\nNow: " + cdt.format(System.currentTimeMillis()));
    }

}
