package fr.fred.multithread.reentrantlock;

import java.util.concurrent.Callable;

/**
 * Created by Frederic on 13/06/14.
 */
public class Cotisant implements Callable<Void> {

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
        this.pot = pot;
        this.name = name;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 0; i < 10; i++) {
            pot.increment(10, name);
        }
        return null;
    }
}
