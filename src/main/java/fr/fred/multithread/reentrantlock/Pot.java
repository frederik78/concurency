package fr.fred.multithread.reentrantlock;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Frederic on 13/06/14.
 */
public class Pot {

    /**
     * Montant dans le pot
     */
    private static volatile int account = 0;

    /**
     * Lock
     */
    final Lock lock = new ReentrantLock(true);

    /**
     * Incrément du pot
     *
     * @param amount somme à rajouter au pot
     * @param name nom du cotisant
     */
    public void increment(int amount, String name) {
        lock.lock();
        try {
            account += amount;
            System.out.println("montant dans le pot " + account + " cotisant n° : " + name);
        } finally {
            lock.unlock();
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
