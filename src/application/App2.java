package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        List<Department> list = new ArrayList<>();

        /*System.out.println("Test 1 - insert department");
        Department department = new Department(null, "Furniture");
        departmentDao.insert(department);
        System.out.println("Inserted! New id -> " + department.getId());
        System.out.println();

        System.out.println("Test 2 - update department");
        Department department1;
        department1 = departmentDao.findById(10);
        department.setName("test2");
        departmentDao.update(department1);

        System.out.println("Test 3 - update department");
        Department department2;
        department2 = departmentDao.findById(10);
        System.out.println("Department -> " + department2.getName());

        System.out.println("Test 3 - delete department");
        departmentDao.deleteById(10);
        departmentDao.deleteById(11);
        departmentDao.deleteById(12);*/

        System.out.println("Test 5 - findAll department");
        list = departmentDao.findAll();
        for(Department d : list){
            System.out.println(d);
        }
    }
}
