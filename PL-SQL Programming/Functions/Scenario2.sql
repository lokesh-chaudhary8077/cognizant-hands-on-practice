-- CalculateMonthlyInstallment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loanAmount NUMBER,
    p_interestRate NUMBER,
    p_years NUMBER
)
RETURN NUMBER
IS
    v_installment NUMBER;
BEGIN
    v_installment :=
        (p_loanAmount +
        (p_loanAmount * p_interestRate * p_years / 100))
        / (p_years * 12);

    RETURN v_installment;
END;
/