package ivan.samoylov;

import ivan.samoylov.Dao.GroupStorage;
import ivan.samoylov.Dao.StudentStorage;
import ivan.samoylov.Model.Student;

public class Main {
    public static void main(String[] args) {
        StudentStorage sStorage = new StudentStorage();
        GroupStorage gStorage = new GroupStorage();

        gStorage.addUnit(new Student("Ben"));
        gStorage.addUnit(new Student("Alice"));

        sStorage.close();
        gStorage.close();
    }
}
