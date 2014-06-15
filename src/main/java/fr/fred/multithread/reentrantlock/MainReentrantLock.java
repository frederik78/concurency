package fr.fred.multithread.reentrantlock;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by Frederic on 13/06/14.
 */
public class MainReentrantLock {

    /**
     * Nombre max de thread pool utilisables
     */
    static final int MAX_THREAD_POOL = Runtime.getRuntime().availableProcessors();

    /**
     * Nombre de cotisants
     */
    static final int NB_COTISANTS = 50;

    final Set<Callable<Void>> allCotisants = new HashSet<Callable<Void>>(NB_COTISANTS);

    /**
     * Pot
     */
    final Pot pot = new Pot();

    final ExecutorService executor = Executors.newFixedThreadPool(MAX_THREAD_POOL);


    /**
     * Exécute les incréments dans le pot
     * @throws ExecutionException en cas d'erreur lors de l'invocation des threads
     * @throws InterruptedException en cas d'erreur suite à une erreur pendant qu'un thread est endormi
     */
    public void launch() throws ExecutionException, InterruptedException {
        for (int i = 0; i < NB_COTISANTS; i++) {
            allCotisants.add(new Cotisant(pot, "cotisant " + i));
        }
        final List<Future<Void>> allFutures = executor.invokeAll(allCotisants);

        for (Future<Void> future : allFutures) {
             future.get();
        }
        // Attend que tous les thread soient finis sans accepter d'autres threads
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Tout le monde a cotisé!!!");
        System.out.println("Somme dans le pot : " + pot.getAccount());    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final MainReentrantLock main = new MainReentrantLock();
        main.launch();

    }
}
