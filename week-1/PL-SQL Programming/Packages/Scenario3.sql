-- AccountOperations Package
CREATE OR REPLACE PACKAGE AccountOperations AS

PROCEDURE OpenAccount(
p_account NUMBER,
p_customer NUMBER,
p_type VARCHAR2,
p_balance NUMBER
);

PROCEDURE CloseAccount(
p_account NUMBER
);

FUNCTION TotalBalance(
p_customer NUMBER
) RETURN NUMBER;

END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

PROCEDURE OpenAccount(
p_account NUMBER,
p_customer NUMBER,
p_type VARCHAR2,
p_balance NUMBER
)
IS
BEGIN
INSERT INTO Accounts
VALUES(
p_account,
p_customer,
p_type,
p_balance,
SYSDATE
);
END;

PROCEDURE CloseAccount(
p_account NUMBER
)
IS
BEGIN
DELETE FROM Accounts
WHERE AccountID=p_account;
END;

FUNCTION TotalBalance(
p_customer NUMBER
)
RETURN NUMBER
IS
v_total NUMBER;
BEGIN

SELECT SUM(Balance)
INTO v_total
FROM Accounts
WHERE CustomerID=p_customer;

RETURN NVL(v_total,0);

END;

END AccountOperations;
/