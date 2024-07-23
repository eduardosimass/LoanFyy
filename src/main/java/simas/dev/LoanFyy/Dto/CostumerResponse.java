package simas.dev.LoanFyy.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import simas.dev.LoanFyy.Model.Loan;

import java.util.List;


@Getter
@AllArgsConstructor
public class CostumerResponse {
    private String costumer;
    private List<Loan> loanList;

}
