package fr.fred.multithread.synchronization;

/**
 * Created by Frederic on 13/06/14.
 */
public class Pot {

    /**
     * Montant dans le pot
     */
    int account = 0;

    /**
     * Incrément du pot
     *
     * @param amount somme à rajouter au pot
     * @param name nom du cotisant
     */
    public synchronized void increment(int amount, String name) {
        account += amount;
        System.out.println("montant dans le pot " + account + " cotisant n° : " + name);
    }

    /**
     * Retourne la somme du compte
     *
     * @return la somme du compte
     */
    public synchronized int getAccount() {
        return account;
    }

}
