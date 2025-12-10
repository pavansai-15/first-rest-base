package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Loan;
import com.example.demo.repositary.LoanRepositary;

@Service
public class LoanService {
	@Autowired
	LoanRepositary repositary;
	public Loan addLoan(Loan loan) {
		return repositary.save(loan);
	}
	
	public Loan getLoan(long loanId) {
		Optional<Loan> optionalLoan = repositary.findById(loanId);
		return optionalLoan.get();
	}

	public List<Loan> getLoans() {
		return repositary.findAll();
	}
	public Loan update(Loan loan) {
		return repositary.save(loan);
		
	}
	public Loan update2(Loan loan) {
		Optional<Loan> optional=repositary.findById(loan.getLoanid());
		Loan tempLoan=optional.get();
		
		if(loan.getBorrowerName()!=null) {
			tempLoan.setBorrowerName(loan.getBorrowerName());
		}
		if(loan.getDateBorrowed()!=null) {
			tempLoan.setDateBorrowed(loan.getDateBorrowed());
		}
		if(tempLoan.getTenure()!=loan.getTenure()) {
			tempLoan.setTenure(loan.getTenure());
		}
		if(tempLoan.getAmount()<loan.getAmount()) {
			tempLoan.setAmount(loan.getAmount());
		}
		if(tempLoan.isLoanStatus()!=loan.isLoanStatus()) {
			tempLoan.setLoanStatus(loan.isLoanStatus());
		}
		return repositary.save(tempLoan);

	}

	public void remove(long lid) {
		Optional<Loan> loan=repositary.findById(lid);
		if(loan.isPresent()) {
			repositary.delete(loan.get());
		}
		else {
			throw new IllegalArgumentException(lid+" not found");
		}
	}
	
	
}
