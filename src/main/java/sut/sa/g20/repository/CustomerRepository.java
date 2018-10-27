package sut.sa.g20.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sut.sa.g20.entity.CustomerEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public
interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
          CustomerEntity findBycustomername(String customername);
          CustomerEntity findBycustomeraddress(String customeraddress);
          
          CustomerEntity findBycustomerphone(String customerphone);
          CustomerEntity findBycustomerpass(String customerpass);
          CustomerEntity findBycustomerid(Long customerid);
          
          @Query("SELECT u FROM CustomerEntity u WHERE u.customername=:Name")
          CustomerEntity findByUser(@Param("Name") String Name);
          @Query("SELECt t.customerid FROM CustomerEntity t WHERE t.customeremail = :customeremail AND t.customerpass = :customerpass")
          Long findCustomerIdByEmailPass(@Param("customeremail") String customeremail,@Param("customerpass")String customerpass);
          
          @Query("SELECt t FROM CustomerEntity t WHERE t.customeremail = :customeremail")
          CustomerEntity findBycustomeremail(String customeremail);
          

          @Query("SELECt t.customerid FROM CustomerEntity t WHERE t.customeremail = :customeremail")
          Long findCustomerIdByEmail(@Param("customeremail") String customeremail);

        }
