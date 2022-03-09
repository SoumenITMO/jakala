package com.jakala.repository;

import java.util.List;
import com.jakala.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select * from users Left Join users_contract_links as ulnkcon on users.id = ulnkcon.users_id " +
            "Left Join contract on contract.id = ulnkcon.contract_id where (:firstname is null or users.firstname Like %:firstname)" +
            " and (:lastname is null or users.lastname Like %:lastname) and (:customertype is null or users.usertype Like %:customertype)" +
            " and (:contracttype is null or contract.contract_type Like %:contracttype)" +
            " and (:contractstartdate is null or contract.contract_start_date Like %:contractstartdate)", nativeQuery = true)
    List<UserEntity> searchByCreteria(@Param("firstname") String customerFirstName, @Param("lastname") String customerLastName,
                                      @Param("customertype") String customerType, @Param("contracttype") String contractType,
                                      @Param("contractstartdate") String contractStartDate);
}
