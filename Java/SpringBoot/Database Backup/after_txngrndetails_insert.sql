-- Optional: Drop the existing update trigger if it exists
DROP TRIGGER IF EXISTS after_txngrndetails_update;

-- Drop any conflicting insert trigger (if you had one before)
DROP TRIGGER IF EXISTS after_txngrndetails_insert;

DELIMITER $$

-- Create the AFTER INSERT trigger
CREATE TRIGGER after_txngrndetails_insert
AFTER INSERT ON txngrndetails
FOR EACH ROW
BEGIN
  -- Check if podetailid is present
  IF NEW.podetailid IS NOT NULL THEN
    UPDATE txnpodetails
    SET grndetailid = NEW.grndetailid
    WHERE podetailid = NEW.podetailid;
  END IF;
END$$

DELIMITER ;
