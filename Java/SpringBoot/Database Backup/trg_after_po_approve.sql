CREATE DEFINER=`root`@`localhost` TRIGGER `trg_after_po_approve` AFTER UPDATE ON `txnpoheader` FOR EACH ROW BEGIN
  DECLARE varpoid INT;
  DECLARE varpodetailid INT;
  DECLARE varprid INT;
  DECLARE done INT DEFAULT FALSE;

  -- Cursor to get podetailid and prid for the current poid
  DECLARE podetail CURSOR FOR 
    SELECT podetailid, prid 
    FROM txnpodetails 
    WHERE poid = NEW.poid AND prid IS NOT NULL;

  -- Handler to set the 'done' flag when no more rows
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  IF NEW.status = 'Approve' AND OLD.status <> 'Approve' THEN
    SET varpoid = NEW.poid;

    OPEN podetail;
	Insert into `debug_log` (`message`) values (`Cursor opened`);
    read_loop: LOOP
      FETCH podetail INTO varpodetailid, varprid;
	  Insert into `debug_log` (`message`) values (`After fetched`);

      -- Check if fetch reached the end before updating
      IF done THEN
		Insert into `debug_log` (`message`) values (`Leaving loop`);
        LEAVE read_loop;
      END IF;

      -- Only update if valid prid exists
      IF varprid IS NOT NULL THEN
		Insert into `debug_log` (`message`) values (`Before update`);
        UPDATE txnpurchaserequest
        SET podetailid = varpodetailid
        WHERE prid = varprid;
		Insert into `debug_log` (`message`) values (`After update`);
      END IF;

    END LOOP;

    CLOSE podetail;
  END IF;
END