DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `tempfunc`() RETURNS int
    DETERMINISTIC
BEGIN
    DECLARE result INT;
    SET result = input_num * input_num;
    RETURN result;
END$$
DELIMITER ;
