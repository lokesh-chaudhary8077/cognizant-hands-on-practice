-- HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_accountId NUMBER,
    p_amount NUMBER
)
RETURN VARCHAR2
IS
    v_balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_accountId;

    IF v_balance >= p_amount THEN
        RETURN 'TRUE';
    ELSE
        RETURN 'FALSE';
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'ACCOUNT NOT FOUND';
END;
/

SELECT HasSufficientBalance(1,500)
FROM Dual;