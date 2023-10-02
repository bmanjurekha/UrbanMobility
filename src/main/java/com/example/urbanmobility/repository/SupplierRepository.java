package com.example.urbanmobility.repository;
import com.example.urbanmobility.model.SupplierDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierDetails, Long> {
    SupplierDetails findByName(String name);
    SupplierDetails findById(long id);
    void deleteById(long id);
    void deleteByName(String name);

}
