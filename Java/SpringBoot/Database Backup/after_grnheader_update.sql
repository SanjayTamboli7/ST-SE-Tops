DELIMITER $$

CREATE TRIGGER after_grnheader_update
AFTER UPDATE ON txngrnheader
FOR EACH ROW
BEGIN
  -- Declare variables and cursor at the top
  DECLARE done INT DEFAULT FALSE;
  DECLARE v_itemid INT;
  DECLARE v_acceptedqty INT;

  -- Cursor to loop through grn details
  DECLARE curdtl CURSOR FOR
    SELECT itemid, acceptedqty
    FROM txngrndetails
    WHERE grnid = NEW.grnid;

  -- Handler when cursor is exhausted
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  -- Begin logic only if status changes to 'Closed'
  IF NEW.status = 'Closed' AND OLD.status != 'Closed' THEN

    OPEN curdtl;

    read_loop: LOOP
      FETCH curdtl INTO v_itemid, v_acceptedqty;
      IF done THEN
        LEAVE read_loop;
      END IF;

      -- Update maxstock in item master
      UPDATE mstitem
      SET maxstock = IFNULL(maxstock, 0) + IFNULL(v_acceptedqty, 0)
      WHERE itemid = v_itemid;

    END LOOP;

    CLOSE curdtl;

  END IF;
END$$

DELIMITER ;
