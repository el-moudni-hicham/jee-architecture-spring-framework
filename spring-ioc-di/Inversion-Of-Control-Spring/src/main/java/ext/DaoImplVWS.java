package ext;

import dao.IDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("vws")
public class DaoImplVWS implements IDao {
    @Override
    public double getData() {
        System.out.println("Version WS");
        return 37;
    }
}
