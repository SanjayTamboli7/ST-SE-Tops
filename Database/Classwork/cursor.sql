Create procedure TestCursor()
Begin
	declare test default 0;
	declare name varchar(30), email_id varchar(30), mobile_no varchar(10);
	declare t cursor  for select * from user1;
	open t;
	label:loop
	fetch t into name, email_id, mobile_no;
	insert into user(user_name, user_email_id, user_mobile_no) values name, email_id, mobile_no

	close t;
	
End