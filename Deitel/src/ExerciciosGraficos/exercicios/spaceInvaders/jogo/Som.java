package ExerciciosGraficos.exercicios.spaceInvaders.jogo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author José Gustavo
 */
public class Som {
    
    public static final int SPACE_BATTLE = 0;
    public static final int EXPLOSAO = 1;
    public static final int GAME_OVER = 2;
    public static final int GAME_WIN = 3;
    
    Clip clip;
    URL soundURL[] = new URL[10];;

    public Som() {
        
        try {
            soundURL[0] = new File("src/ExerciciosGraficos/exercicios/spaceInvaders/sons/SpaceBattle.wav").toURI().toURL();
            soundURL[1] = new File("src/ExerciciosGraficos/exercicios/spaceInvaders/sons/explosao.wav").toURI().toURL();
            soundURL[2] = new File("src/ExerciciosGraficos/exercicios/spaceInvaders/sons/gameover.wav").toURI().toURL();
            soundURL[3] = new File("src/ExerciciosGraficos/exercicios/spaceInvaders/sons/win.wav").toURI().toURL();
        } catch (MalformedURLException e) {
            System.out.println("Problema no audio 1");
            e.printStackTrace();
        }
 
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.out.println("Problema no audio 2");
            e.printStackTrace();
        } 
            
            
        
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
        // clip.close(); para musica não ficar repetindo assim posso aquele contador k
    }

}
