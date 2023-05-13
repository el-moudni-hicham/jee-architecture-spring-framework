package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("dao")
@Repository("dao") // Just for Dao
public class DaoImpl implements IDao{
    @Override
    public double getData() {
        System.out.println("Version DB");
        // Connect to database and get temperature
        double temp = Math.random()*40;

        return temp;
    }
}
