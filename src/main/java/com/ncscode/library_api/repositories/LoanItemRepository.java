package com.ncscode.library_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncscode.library_api.entities.LoanItem;
import com.ncscode.library_api.entities.pk.LoanItemPk;

public interface LoanItemRepository extends JpaRepository<LoanItem, LoanItemPk> {

}
