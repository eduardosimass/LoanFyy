package simas.dev.LoanFyy.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import simas.dev.LoanFyy.Dto.CostumerDto;
import simas.dev.LoanFyy.Dto.CostumerResponse;
import simas.dev.LoanFyy.Dto.Type;
import simas.dev.LoanFyy.Model.Costumers;
import simas.dev.LoanFyy.Model.Loan;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @InjectMocks
    private LoanService loanService;


    @Test
    void shouldBeReturnTypeGuaranteed() {
        CostumerDto costumer = new CostumerDto(1L, 26,"0909970979","Eduardo",5000.00,"SP");
        CostumerResponse costumerResponse = new CostumerResponse(costumer.name(),loanService.loanList(costumer));
        Assertions.assertEquals("Eduardo", costumerResponse.getCostumer());
        Assertions.assertNotNull(costumerResponse.getLoanList());
        Assertions.assertEquals(Type.GUARANTEED, costumerResponse.getLoanList().stream().filter(f -> f.getType().equals(Type.GUARANTEED)).findFirst().get().getType());

    }

    @Test
    void shouldBeReturnTypePersonal() {
        CostumerDto costumer = new CostumerDto(3L, 30,"0909970979","Eduardo",3000.00,"SP");
        CostumerResponse costumerResponse = new CostumerResponse(costumer.name(),loanService.loanList(costumer));
        Assertions.assertEquals("Eduardo", costumerResponse.getCostumer());
        Assertions.assertNotNull(costumerResponse.getLoanList());
        Assertions.assertEquals(Type.PERSONAL, costumerResponse.getLoanList().stream().filter(f -> f.getType().equals(Type.PERSONAL)).findFirst().get().getType());

    }
}