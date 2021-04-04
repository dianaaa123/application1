package com.doctor.appointment.repository;

import com.doctor.appointment.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepositoryCustom {
    List<Company> getCustomCompanies(String string);
}
