-- Apply Annual Fee
DECLARE

CURSOR ApplyAnnualFee IS
SELECT AccountID,Balance
FROM Accounts
FOR UPDATE;

v_id Accounts.AccountID%TYPE;
v_balance Accounts.Balance%TYPE;

BEGIN

OPEN ApplyAnnualFee;

LOOP

FETCH ApplyAnnualFee
INTO v_id,v_balance;

EXIT WHEN ApplyAnnualFee%NOTFOUND;

UPDATE Accounts
SET Balance=Balance-100
WHERE CURRENT OF ApplyAnnualFee;

END LOOP;

CLOSE ApplyAnnualFee;

COMMIT;

END;
/