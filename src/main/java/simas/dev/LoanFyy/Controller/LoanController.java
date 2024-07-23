package simas.dev.LoanFyy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simas.dev.LoanFyy.Dto.CostumerDto;
import simas.dev.LoanFyy.Dto.CostumerResponse;
import simas.dev.LoanFyy.Model.Loan;
import simas.dev.LoanFyy.Service.LoanService;

import java.util.List;
@CrossOrigin
@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @CrossOrigin
    @PostMapping("/customer-loans")
    public ResponseEntity<CostumerResponse> getCustomers (@RequestBody CostumerDto costumerDto) {
        String customerName = costumerDto.name();
        List<Loan> loanList = loanService.loanList(costumerDto);
        CostumerResponse response = new CostumerResponse(customerName, loanList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
