package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

// Programmation dynamique
public class PresentationVer2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(new File("Inversion-Of-Control-Spring/config.txt"));
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Donner la classe de la couche Dao :");

        String daoClassName = scanner.nextLine();
        // Charger la classe en memoire
        Class cDao = Class.forName(daoClassName);

        /*
         *  IDao dao = (IDao) cDao.getConstructor(IMetier.class).newInstance(dao);
         *  pour les version de Java > 8
         *  Injection via Constrecteur
         */
        IDao dao = (IDao) cDao.getConstructor().newInstance();

        //System.out.println("Donner la classe de la couche Metier :");
        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

        System.out.println(metier.calcul());
    }
}
