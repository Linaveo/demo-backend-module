package demo.service;

import demo.domain.Commune;
import demo.domain.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Component("communeService")
@Transactional
public class CommuneServiceImpl implements CommuneService {

    private final CommuneRepository communeRepository;

    @Autowired
    public CommuneServiceImpl(CommuneRepository communeRepository) {
        this.communeRepository = communeRepository;
    }

    @Override
    public Page<Commune> findAll(Pageable pageable) {
        return this.communeRepository.findAll(pageable);
    }

    @Override
    public Commune find(String code) {
        return this.communeRepository.findOne(code);
    }

    @Override
    public Page<Commune> findByCodeDepartement(String code, Pageable pageable) {
        Assert.notNull(code, "Code département incorrect");
        return this.communeRepository.findByCodeDepartement(code, pageable);
    }

    @Override
    public List<Departement> findAllDepartement() {
        return this.communeRepository.findAllDepartement();
    }
}
