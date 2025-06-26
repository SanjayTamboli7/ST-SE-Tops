DELIMITER $$

CREATE TRIGGER after_txngrndetails_update
AFTER UPDATE ON txngrndetails
FOR EACH ROW
BEGIN
  IF NEW.podetailid IS NOT NULL AND NEW.podetailid != OLD.podetailid THEN
    UPDATE txnpodetails
    SET grndetailid = NEW.grndetailid
    WHERE podetailid = NEW.podetailid;
  END IF;
END$$

DELIMITER ;
