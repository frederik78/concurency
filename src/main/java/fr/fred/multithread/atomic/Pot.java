package fr.fred.multithread.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Frederic on 13/06/14.
 */
public class Pot {

    /**
     * Montant dans le pot
     */
    private static volatile int account = 0;

    final AtomicBoolean lock = new AtomicBoolean(true);

    /**
     * Incrément du pot
     *
     * @param amount somme à rajouter au pot
     * @param name nom du cotisant
     */
    public void increment(int amount, String name) throws InterruptedException {
        while (true)
            if (lock.getAndSet(false)) {
                try {
                    account += amount;
                    System.out.println("montant dans le pot " + account + " cotisant n° : " + name);
                } finally {
                    lock.set(true);
                    break;
                }
            } else {
                Thread.sleep(1000);
            }
    }

    /**
     * Retourne la somme dans le pot
     *
     * @return la somme dans le pot
     */
    public int getAccount() {
        return account;
    }

}
