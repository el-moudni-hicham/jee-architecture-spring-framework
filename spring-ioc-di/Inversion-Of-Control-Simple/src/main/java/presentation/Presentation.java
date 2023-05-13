package presentation;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        /*
         * Injection des dependances par instanciation statique => new ==> couplage forte
         */

        // Instanciation statique
        MetierImpl metier = new MetierImpl();

        DaoImpl dao = new DaoImpl();
        DaoImpl2 dao2 = new DaoImpl2();
        metier.setDao(dao2);
        System.out.println(metier.calcul());
    }
}
