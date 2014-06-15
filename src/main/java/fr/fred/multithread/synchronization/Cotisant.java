package fr.fred.multithread.synchronization;

/**
 * Created by Frederic on 13/06/14.
 */
public class Cotisant implements Runnable {


    /**
     * Nom du cotisant
     */
    private String name;

    /**
     * Pot
     */
    private Pot pot;

    /**
     * Constructor
     * @param pot pot
     * @param name nom du cotisant
     */
    public Cotisant(Pot pot, String name) {
        this.name = name;
        this.pot = pot;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            pot.increment(10, name);
        }
    }
}
