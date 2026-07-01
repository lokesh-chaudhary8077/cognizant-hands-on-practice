-- Loan Reminder
BEGIN
    FOR rec IN(
        SELECT c.Name,l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID=l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE+30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: '
        ||rec.Name||
        ' Loan Due on '
        ||rec.EndDate);
    END LOOP;
END;
/