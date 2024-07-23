package simas.dev.LoanFyy.Service;

import org.springframework.stereotype.Service;
import simas.dev.LoanFyy.Dto.CostumerDto;
import simas.dev.LoanFyy.Dto.Type;
import simas.dev.LoanFyy.Model.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class LoanService {

    public List<Loan> loanList (CostumerDto costumerDto) {
        List<Loan> loanList = new ArrayList<>();
        if(isApprovedPersonalLoan(costumerDto)){
            Loan loan = new Loan(Type.PERSONAL);
            loanList.add(loan);
        }
        if(isApprovedPersonalLoanIncomeRange(costumerDto) && isValideAge(costumerDto) && isResidentOfSaoPaulo(costumerDto)){
            Loan loan = new Loan(Type.PERSONAL);
            loanList.add(loan);
        }
        if(isApprovedConseignmentLoan(costumerDto)){
            Loan loan = new Loan(Type.CONSIGNMENT);
            loanList.add(loan);
        }
        if(isApprovedGuaranteedLoan(costumerDto)){
            Loan loan = new Loan(Type.GUARANTEED);
            loanList.add(loan);
        }
        if(isApprovedGuaranteeLoanWithRangeIncome(costumerDto) && isValideAge(costumerDto) && isResidentOfSaoPaulo(costumerDto)){
            Loan loan = new Loan(Type.GUARANTEED);
            loanList.add(loan);
        }
        return loanList;
    }


    //Conceder o empréstimo pessoal se o salário do cliente for igual ou inferior a R$ 3000.
    private boolean isApprovedPersonalLoan(CostumerDto costumerDto){
        return costumerDto.income() <= 3000;
    }

    //Conceder o empréstimo pessoal se o salário
    // do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30 anos e residir em São Paulo (SP).
    private boolean isResidentOfSaoPaulo(CostumerDto costumerDto){
        return Objects.equals(costumerDto.localtion(), "SP");
    }

    private boolean isValideAge(CostumerDto costumerDto) {
        return costumerDto.age() < 30;
    }
    private boolean isApprovedPersonalLoanIncomeRange(CostumerDto costumerDto) {
        return costumerDto.income() >= 3000 || costumerDto.income() <= 5000;
    }

    //Conceder o empréstimo consignado se o salário do cliente for igual ou superior a R$ 5000.
    private boolean isApprovedConseignmentLoan(CostumerDto costumerDto){
        return costumerDto.income() >= 5000;
    }

    //Conceder o empréstimo com garantia se o salário do cliente for igual ou inferior a R$ 3000.
    private boolean isApprovedGuaranteedLoan(CostumerDto costumerDto){
        return costumerDto.income() <= 3000;
    }


    //Conceder o empréstimo com garantia se o salário do cliente estiver entre R$ 3000 e R$ 5000,
    // se o cliente tiver menos de 30 anos e residir em São Paulo (SP).

    private boolean isApprovedGuaranteeLoanWithRangeIncome(CostumerDto costumerDto){
        return costumerDto.income() >= 3000 || costumerDto.income() <= 5000;
    }

}
