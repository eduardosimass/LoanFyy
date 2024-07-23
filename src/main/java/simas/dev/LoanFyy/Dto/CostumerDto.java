package simas.dev.LoanFyy.Dto;

public record CostumerDto(Long id,Integer age, String cpf, String name, Double income, String localtion) {
    public CostumerDto(Long id, Integer age, String cpf, String name, Double income, String localtion) {
        this.id = id;
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.localtion = localtion;
    }
}
