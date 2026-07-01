-- Generate Monthly Statements
DECLARE

CURSOR GenerateMonthlyStatements IS
SELECT c.Name,
       t.TransactionID,
       t.Amount,
       t.TransactionDate
FROM Customers c
JOIN Accounts a
ON c.CustomerID=a.CustomerID
JOIN Transactions t
ON a.AccountID=t.AccountID
WHERE EXTRACT(MONTH FROM t.TransactionDate)=EXTRACT(MONTH FROM SYSDATE)
AND EXTRACT(YEAR FROM t.TransactionDate)=EXTRACT(YEAR FROM SYSDATE);

v_name Customers.Name%TYPE;
v_tid Transactions.TransactionID%TYPE;
v_amount Transactions.Amount%TYPE;
v_date Transactions.TransactionDate%TYPE;

BEGIN

OPEN GenerateMonthlyStatements;

LOOP
FETCH GenerateMonthlyStatements
INTO v_name,v_tid,v_amount,v_date;

EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

DBMS_OUTPUT.PUT_LINE(
'Customer: '||v_name||
' TransactionID: '||v_tid||
' Amount: '||v_amount||
' Date: '||v_date);

END LOOP;

CLOSE GenerateMonthlyStatements;

END;
/