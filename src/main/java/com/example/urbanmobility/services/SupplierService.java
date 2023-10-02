package com.example.urbanmobility.services;
import com.example.urbanmobility.model.BookingDetails;
import com.example.urbanmobility.model.SupplierDetails;
import com.example.urbanmobility.repository.BookingRepository;
import com.example.urbanmobility.repository.RouteRepository;
import com.example.urbanmobility.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    RouteRepository routeRepository;
    // ALL CRUD Operations for Supplier
    public void saveSupplier(SupplierDetails supplierDetails) {
        routeRepository.saveAll(supplierDetails.getRouteDetails());
        supplierRepository.save(supplierDetails);
    }
    public void deletesupplierbyname(String username){
        supplierRepository.deleteByName(username);
    }
    public void deleteSupplierbyId(long supplierid){
        supplierRepository.deleteById(supplierid);
    }

    public SupplierDetails getSupplierByname(String username){
        return supplierRepository.findByName(username);
    }
    public SupplierDetails getSupplierById(long tripid){
        return supplierRepository.findById(tripid);
    }

}
