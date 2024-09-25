package com.con1;

public class empfulldetail {

		public String address;
		public emptechnology etech;
		public empdetails empdet;
		
		public empfulldetail(String address, emptechnology etech, empdetails empdet) {
			super();
			this.address = address;
			this.etech = etech;
			this.empdet = empdet;
		}

		public empfulldetail(String address, emptechnology etech) {
			super();
			this.address = address;
			this.etech = etech;
		}

		public empfulldetail(String address) {
			super();
			this.address = address;
		}

		public empfulldetail() {
			super();
		}
		
		
}
