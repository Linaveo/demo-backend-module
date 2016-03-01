package demo.service;

import demo.domain.Commune;
import demo.domain.Departement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommuneService {

    Page<Commune> findAll(Pageable pageable);
    Commune find(String code);
    Page<Commune> findByCodeDepartement(String code, Pageable pageable);
    List<Departement> findAllDepartement();
}
