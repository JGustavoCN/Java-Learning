/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifs.pp.atividades.observer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.Timer;

// Interface Observer
interface TimeObserver {
    void updateTime(String time, String date, String dayPeriod);
}

class DigitalClock extends TimerTask {
    
    private List<TimeObserver> observers = new ArrayList<>();
    int hour = 0;
    int minute = 0;
    int second = 0;
    private String currentDate;
    private Calendar calendar;

    // Armazena a data atual
    public DigitalClock() {
        calendar = Calendar.getInstance();  // Instancia o calendário
        currentDate = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());  // Formata a data inicial
    }
    
    // Método para adicionar observadores
    public void addObserver(TimeObserver observer) {
        observers.add(observer);
    }

    // Método para notificar os observadores sobre a mudança de horário e data
    private void notifyObservers() {
        String timeString = String.format("%02d:%02d:%02d", hour, minute, second);
        String dayPeriod = getDayPeriod();
        for (TimeObserver observer : observers) {
            observer.updateTime(timeString, currentDate, dayPeriod);
        }
    }

    // Função para aumentar a hora
    public void increaseHour() {
        int lastHourBeforeChange = hour;
        
        hour = (hour + 1) % 24;  // Aumentando a hora
        if (lastHourBeforeChange == 23 && hour == 0) {
            // Se estava em 23:59 e foi para 00:00, avançar o dia
            advanceDate();
        }

        updateTimeStrings();
        notifyObservers();
    }

    // Função para diminuir a hora
    public void decreaseHour() {
        int lastHourBeforeChange = hour;
        
        hour = (hour - 1 + 24) % 24;  // Diminuindo a hora
        if (lastHourBeforeChange == 0 && hour == 23) {
            // Se estava em 00:00 e foi para 23:59, retroceder o dia
            retrocedeDate();
        }

        updateTimeStrings();
        notifyObservers();
    }

    // Função para avançar o dia (modificar apenas o dia da data)
    private void advanceDate() {
        calendar.add(Calendar.DATE, 1);  // Avançar um dia
        currentDate = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
    }

    // Função para retroceder o dia (modificar apenas o dia da data)
    private void retrocedeDate() {
        calendar.add(Calendar.DATE, -1);  // Retroceder um dia
        currentDate = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
    }

    // Atualiza o horário (hora, minuto, segundo)
    private void updateTimeStrings() {
        String timeString = String.format("%02d:%02d:%02d", hour, minute, second);
        System.out.println(timeString + " - " + currentDate);
    }

    // Método que será executado periodicamente
    @Override
    public void run() {
        // Aumentar o segundo
        second = (second + 1) % 60;

        // Verifica se deve aumentar a hora
        if (second == 0) {
            minute = (minute + 1) % 60;
        }
        if (minute == 0 && second == 0) {
            hour = (hour + 1) % 24;
        }

        // Atualiza a exibição do relógio
        updateTimeStrings();

        // Notificar observadores
        notifyObservers();
    }

    // Método que retorna o período do dia (Dia, Tarde ou Noite)
    private String getDayPeriod() {
        if (hour >= 6 && hour < 12) {
            return "Day";
        } else if (hour >= 12 && hour < 18) {
            return "Afternoon";
        } else {
            return "Night";
        }
    }

    // Retorna a data atual
    public String getCurrentDate() {
        return currentDate;
    }
}


// Cartão de Data (Observer)
class DateCard extends JPanel implements TimeObserver {
    private JLabel dateLabel;

    public DateCard() {
        dateLabel = new JLabel("Date: ", JLabel.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        setLayout(new BorderLayout());
        add(dateLabel, BorderLayout.CENTER);
        setPreferredSize(new Dimension(200, 100));
        setBackground(new Color(173, 216, 230));
    }

    @Override
    public void updateTime(String time, String date, String dayPeriod) {
        dateLabel.setText("Date: " + date);
    }
}

// Gráfico de Temperatura (Observer)
class TemperatureGraph extends JPanel implements TimeObserver {
    private JProgressBar temperatureBar;

    public TemperatureGraph() {
        temperatureBar = new JProgressBar(0, 40);
        temperatureBar.setStringPainted(true);
        temperatureBar.setPreferredSize(new Dimension(300, 50));
        add(temperatureBar);
        setBackground(new Color(255, 250, 250));
    }

    @Override
    public void updateTime(String time, String date, String dayPeriod) {
        int temp = 0;
        if (dayPeriod.equals("Day")) {
            temp = (int)(Math.random() * 20 + 10);
        } else if (dayPeriod.equals("Afternoon")) {
            temp = (int)(Math.random() * 10 + 20);
        } else {
            temp = (int)(Math.random() * 10);
        }
        temperatureBar.setValue(temp);
        temperatureBar.setString("Temp: " + temp + "°C");
    }
}

// Indicador de Dia/Tarde/Noite (Observer)
class DayPeriodIndicator extends JPanel implements TimeObserver {
    private JLabel periodLabel;

    public DayPeriodIndicator() {
        periodLabel = new JLabel("Day", JLabel.CENTER);
        periodLabel.setFont(new Font("Arial", Font.BOLD, 20));
        setLayout(new BorderLayout());
        add(periodLabel, BorderLayout.CENTER);
        setPreferredSize(new Dimension(200, 100));
    }

    @Override
    public void updateTime(String time, String date, String dayPeriod) {
        periodLabel.setText(dayPeriod);
        if (dayPeriod.equals("Day")) {
            setBackground(new Color(255, 255, 102));
        } else if (dayPeriod.equals("Afternoon")) {
            setBackground(new Color(255, 140, 0));
        } else {
            setBackground(new Color(0, 0, 139));
        }
    }
}

// Janela Principal
public class TimeNotificationSystem extends JFrame {
    private DigitalClock digitalClock;
    Timer timer;
    private JTextField timeInputField;

    public TimeNotificationSystem() {
        setTitle("Sistema de Notificação de Alteração de Tempos");
        setLayout(new BorderLayout());

        // Criar o relógio digital
        digitalClock = new DigitalClock();

        // Criar os observadores
        DateCard dateCard = new DateCard();
        TemperatureGraph tempGraph = new TemperatureGraph();
        DayPeriodIndicator dayPeriodIndicator = new DayPeriodIndicator();

        // Registrar os observadores
        digitalClock.addObserver(dateCard);
        digitalClock.addObserver(tempGraph);
        digitalClock.addObserver(dayPeriodIndicator);

        // Organizar os componentes no painel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 3, 10, 10));
        topPanel.add(dateCard);
        topPanel.add(tempGraph);
        topPanel.add(dayPeriodIndicator);

        // Criar botões de aumento e diminuição da hora
        JPanel controlPanel = new JPanel();
        JButton increaseButton = new JButton("+");
        JButton decreaseButton = new JButton("-");

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digitalClock.increaseHour();
                updateTimeInputField();
            }
        });

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digitalClock.decreaseHour();
                updateTimeInputField();
            }
        });

        // Campo de entrada de hora
        timeInputField = new JTextField(5);
        timeInputField.setText(String.format("%02d:%02d", digitalClock.hour, digitalClock.minute));

        // Adicionar os componentes de controle
        controlPanel.add(new JLabel("Time (HH:MM):"));
        controlPanel.add(timeInputField);
        controlPanel.add(increaseButton);
        controlPanel.add(decreaseButton);

        // Organizar na janela
        add(topPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Configurações da janela
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar o Timer para atualizar o relógio a cada segundo
        timer = new Timer();
        timer.scheduleAtFixedRate(digitalClock, 0, 1000);
    }

    // Atualizar o campo de hora
    private void updateTimeInputField() {
        timeInputField.setText(String.format("%02d:%02d", digitalClock.hour, digitalClock.minute));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TimeNotificationSystem().setVisible(true);
            }
        });
    }
}
