package ExerciciosGraficos.exercicios.tetris.main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author José Gustavo
 */
public class Sound {

    Clip musicClip;
    URL url[] = new URL[10];

    public Sound() {
        // Audio da white ta bom? talvez convertar aumentando o Khz no https://online-audio-converter.com/pt/
        try {
            url[0] = new File("src/ExerciciosGraficos/exercicios/tetris/res/white-labyrinth-active.wav").toURI().toURL();
            url[1] = new File("src/ExerciciosGraficos/exercicios/tetris/res/delete line.wav").toURI().toURL();
            url[2] = new File("src/ExerciciosGraficos/exercicios/tetris/res/gameover(1).wav").toURI().toURL();
            url[3] = new File("src/ExerciciosGraficos/exercicios/tetris/res/rotation.wav").toURI().toURL();
            url[4] = new File("src/ExerciciosGraficos/exercicios/tetris/res/touch floor.wav").toURI().toURL();
        } catch (MalformedURLException e) {
            System.out.println("Problema na url do audio");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void playMusic(int i, boolean music) {

        try {

            Clip clip;
            try (AudioInputStream ais = AudioSystem.getAudioInputStream(url[i])) {
                clip = AudioSystem.getClip();
                if (music) {
                    musicClip = clip;
                }
                clip.open(ais);
                clip.addLineListener(new LineListener() {
                    @Override
                    public void update(LineEvent event) {
                        if (event.getType() == Type.STOP) {
                            clip.close();
                        }
                    }

                });
            }
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Problema no audio");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void loop() {
        musicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        musicClip.stop();
        musicClip.close();
    }

}
