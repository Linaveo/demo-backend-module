package demo.service;

import demo.domain.Commune;
import demo.domain.Departement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

interface CommuneRepository extends Repository<Commune, String> {

    Commune findOne(String code);
    Page<Commune> findAll(Pageable pageable);
    Page<Commune> findByCodeDepartement(String code, Pageable pageable);

    @Query("select distinct c.codeDepartement, c.departement from Commune c order by c.codeDepartement ASC")
    List<Departement> findAllDepartement();
}
