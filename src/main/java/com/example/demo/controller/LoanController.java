package com.example.demo.controller;
import org.springframework.http.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Loan;
import com.example.demo.service.LoanService;

@RestController
@RequestMapping("/loan/api/v1.0")
public class LoanController {
	@Autowired
	LoanService service;
	
//	@PostMapping("/create")
//	public Loan loanApplication(@RequestBody Loan loan) {
//		return service.addLoan(loan);
//		
//	}
	@PostMapping("/create")
	public ResponseEntity<Loan> loanApplication(@RequestBody Loan loan) {
		//return new ResponseEntity<Loan>(HttpStatus.CREATED);
		Loan newLoan = service.addLoan(loan);
		//return new ResponseEntity<Loan>(newLoan,HttpStatus.OK);
		HttpHeaders headers=new HttpHeaders();
		headers.add("xx-created by","pavan");
		headers.add("content-type","application/json");//MIME TYPE
		return new ResponseEntity<Loan>(newLoan,headers,HttpStatus.OK);
	}
	@GetMapping("fetch/{lid}")
	public ResponseEntity<Loan> getLoans(@PathVariable long lid){
		//return service.getLoans();
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	@GetMapping("/all")
	public List<Loan> getLoans(){
		return service.getLoans();
		
	}
	@PutMapping("/modify") //full update
	public Loan doUpdate(@RequestBody Loan loan) {
		return service.update(loan);
	}
	@PutMapping("/modify2") //full update
	public Loan doUpdate2(@RequestBody Loan loan) {
		return service.update(loan);
	}
//	@DeleteMapping("/del/{lid}")
//	public void delete(@PathVariable long lid) {
//		service.remove(lid);
//	}	
	
	@DeleteMapping("/remove/{lid}")
	public ResponseEntity delete(@PathVariable Long lid) {
		service.remove(lid);
		return new ResponseEntity<>(HttpStatusCode.valueOf(204));
		//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/pavan")
	public String method() {
		return "pavan kommi";
		
	}
}