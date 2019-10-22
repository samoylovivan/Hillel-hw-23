package ivan.samoylov.Dao;

import ivan.samoylov.Model.Group;

import java.util.List;

public interface Storage {
        int removeAll();
        int removeUnit(int id);
        int removeUnitByName(String name);
        void addUnit(Object obj);
        void updateUnit(Object obj);
        Object getUnit(int id);
        List<Group> getAllUnits();
}
