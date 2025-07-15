DELIMITER //

CREATE TRIGGER after_txnstockadjustment_update
AFTER UPDATE ON txnstockadjustment
FOR EACH ROW
BEGIN
    IF NEW.status = 'Approved' THEN
        UPDATE mstitem
        SET maxstock = maxstock - NEW.qty
        WHERE itemid = NEW.itemid;
    END IF;
END;//

DELIMITER ;