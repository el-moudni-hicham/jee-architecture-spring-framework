package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    //Couplage faible
    private IDao dao;
    @Override
    public double calcul() {
        double tmp = dao.getData();
        double result = tmp*300 / Math.cos(tmp*Math.PI);

        return result;
    }

    /*
        Pour Injecter dans la variable dao un objet
        d'une classe qui implemente l'interface IDo via setters
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
