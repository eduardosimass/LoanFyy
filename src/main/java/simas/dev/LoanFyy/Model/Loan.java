package simas.dev.LoanFyy.Model;

import lombok.Getter;
import simas.dev.LoanFyy.Dto.Type;

@Getter
public class Loan{
    private final Type type;
    private Double interest_rate;
    public Loan(Type type){
        this.type = type;
        switch (type){
            case PERSONAL -> this.interest_rate = 4.00;
            case GUARANTEED -> this.interest_rate = 3.00;
            case CONSIGNMENT -> this.interest_rate = 2.00;
        }
    }
}