package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("metier") // Au demarrage cree un objet de cette class
@Service("metier") //Just for Metier
public class MetierImpl implements IMetier {
    //Couplage faible
    //@Autowired // Injecter dans cette variable un objet de type Dao ( va chercher dans tout les annotations de projet
    //@Qualifier("vc") // On specifier la versions Dao a injecter
    private IDao dao;

    // Injection par Constructeur recommended by Spring to replace @Autowired
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double tmp = dao.getData();
        double result = tmp*300 / Math.cos(tmp*Math.PI);

        return result;
    }

    /*
        Pour Injecter dans la variable dao un objet
        d'une classe qui implemente l'interface IDao via setters
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
