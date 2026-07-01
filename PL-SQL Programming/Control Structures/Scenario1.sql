-- Apply 1% Discount to Loan Interest Rate for Customers Above 60
BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.DOB
        FROM Loans l
        JOIN Customers c
        ON l.CustomerID = c.CustomerID
    )
    LOOP
        IF FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB)/12) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
        END IF;
    END LOOP;

    COMMIT;
END;
/