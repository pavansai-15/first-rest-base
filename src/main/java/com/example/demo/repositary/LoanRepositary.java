package com.example.demo.repositary;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Loan;

@Repository
public interface LoanRepositary extends JpaRepository<Loan, Long>{

}
