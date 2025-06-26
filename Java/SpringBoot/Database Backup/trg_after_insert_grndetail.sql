DELIMITER $$

CREATE TRIGGER trg_after_insert_grndetail
AFTER INSERT ON txngrndetails
FOR EACH ROW
BEGIN
  IF NEW.podetailid IS NOT NULL THEN
    UPDATE txnpodetails
    SET grndetailid = NEW.grndetailid
    WHERE podetailid = NEW.podetailid;
  END IF;
END$$

DELIMITER ;
