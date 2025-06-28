DELIMITER $$

CREATE TRIGGER reduce_maxstock_after_issued
AFTER UPDATE ON txnissuerequest
FOR EACH ROW
BEGIN
    IF NEW.status = 'Issued' THEN
        UPDATE mstitem
        SET maxstock = maxstock - NEW.qty
        WHERE itemid = NEW.itemid;
    END IF;
END$$

DELIMITER ;
