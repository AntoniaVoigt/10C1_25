package czg.sound;

import javax.sound.sampled.*;

public abstract class BaseSound {

    /**
     * Wiedergabezustand
     */
    protected boolean isPlaying = false;

    /**
     * Zugriff auf die verwendete {@link DataLine}, z.B. ein {@link Clip}
     * oder eine {@link SourceDataLine}.
     * @return Die von diesem Sound verwendete {@link DataLine}
     */
    protected abstract DataLine getLine();

    /**
     * Steuert die Wiedergabe des Sounds
     * @param playing Ob der Sound angehalten oder abgespielt werden soll
     */
    public abstract void setPlaying(boolean playing);

    /**
     * @return Ob der Sound abspielt oder angehalten wurde
     */
    public boolean isPlaying() {
        return isPlaying;
    }

    /**
     * Spult zu der angegebenen Position vor oder zurück
     * @param position Position zwischen 0 (Anfang) und 1 (Ende)
     */
    public abstract void seek(float position);


    /**
     * Schneller Zugriff auf die Lautstärkesteuerung
     * @return Lautstärkesteuerung
     */
    public FloatControl getVolumeControl() {
        return (FloatControl) getLine().getControl(FloatControl.Type.VOLUME);
    }

    /**
     * Schneller Zugriff auf die Pan-Steuerung
     * @return Pan-Steuerung
     */
    public FloatControl getPanControl() {
        return (FloatControl) getLine().getControl(FloatControl.Type.PAN);
    }

    /**
     * Schneller Zugriff auf die Stummschaltung
     * @return Stummschaltungssteuerung
     */
    public BooleanControl getMuteControl() {
        return (BooleanControl) getLine().getControl(BooleanControl.Type.MUTE);
    }

}
