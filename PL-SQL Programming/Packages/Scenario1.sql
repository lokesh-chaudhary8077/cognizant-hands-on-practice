-- CustomerManagement Package
CREATE OR REPLACE PACKAGE CustomerManagement AS

PROCEDURE AddCustomer(
p_id NUMBER,
p_name VARCHAR2,
p_dob DATE,
p_balance NUMBER
);

PROCEDURE UpdateCustomer(
p_id NUMBER,
p_name VARCHAR2
);

FUNCTION GetBalance(
p_id NUMBER
) RETURN NUMBER;

END CustomerManagement;
/





CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

PROCEDURE AddCustomer(
p_id NUMBER,
p_name VARCHAR2,
p_dob DATE,
p_balance NUMBER
)
IS
BEGIN
INSERT INTO Customers
VALUES(p_id,p_name,p_dob,p_balance,SYSDATE,'FALSE');
END;

PROCEDURE UpdateCustomer(
p_id NUMBER,
p_name VARCHAR2
)
IS
BEGIN
UPDATE Customers
SET Name=p_name
WHERE CustomerID=p_id;
END;

FUNCTION GetBalance(
p_id NUMBER
)
RETURN NUMBER
IS
v_balance NUMBER;
BEGIN
SELECT Balance
INTO v_balance
FROM Customers
WHERE CustomerID=p_id;

RETURN v_balance;
END;

END CustomerManagement;
/