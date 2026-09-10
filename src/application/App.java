package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("TEST 1 -> seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println();

        System.out.println("TEST 2 -> seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller sll : list){
            System.out.println(sll);
        }
        System.out.println();

        System.out.println("TEST 3 -> seller findAll ====");
        list = sellerDao.findAll();
        for(Seller sll : list){
            System.out.println(sll);
        }

        /*System.out.println("TEST 4 -> seller insert ====");
        Seller newSeller = new Seller(null, "Mariana Gostosa", "mariana@gmail.com", new Date(), 10.000, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id -> " + newSeller.getId());*/

        System.out.println("TEST 5 -> seller update ====");
        seller = sellerDao.findById(10);
        seller.setBaseSalary(10000.0 );
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("TEST 6 -> seller delete ====");
        sellerDao.deleteById(11);
        System.out.println("Delete completed");
    }
}
