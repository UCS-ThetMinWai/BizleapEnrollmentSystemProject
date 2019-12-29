package com.bizleap.enrollment.domain;

public abstract interface SystemConstant {
	public static String INTERNAL_BOID="-2";
	
	public static final String BOID_REQUIRED="-1";
	
	public static enum EntityType{
		
		STUDENT("Student","STUDENT"),
		EMPLOYEE("Employee","EMPLOYEE"),
		SECTION("Section","SECTION"),
		PAYMENT("Payment","PAYMENT"),
		BATCH("Batch","BATCH"),
		COURSE("Course","COURSE");
		
		private String value;
		
		private String boIdPrefix;
		
		EntityType(String value,String boIdPrefix) {
			this.setValue(value);
			this.setBoIdPrefix(boIdPrefix);
		}
		
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		public String getBoIdPrefix() {
			return boIdPrefix;
		}
		public void setBoIdPrefix(String boIdPrefix) {
			this.boIdPrefix = boIdPrefix;
		}
		
	}
	
	public static enum DayType{
		
		MONDAY("Monday"),TUESDAY("Tuesday"),WEDNESDAY("Wednesday"),
		THURSDAY("Thursday"),FRIDAY("Friday"),SATURDAY("Saturday"),SUNDAY("Sunday");
		
		private String value;

		private DayType(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}	
		
		public void setValue(String value) {
			this.value = value;
		}
	}
	
	public static enum SectionStatus{
		
		OPENED("Opened"), CLOSED("Closed");	
		
		private String value;

		private SectionStatus(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}	
		
		public void setValue(String value) {
			this.value = value;
		}
		
	}
	
	public static enum StudentStatus{
		
		REGISTERED("Registered"),ENROLLED("Enrolled"),CANCELED("Canceled");
		
		private String value;

		private StudentStatus(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}	
		
		public void setValue(String value) {
			this.value = value;
		}
	}
	
	public static enum Position{
		
		INSTRUCTOR("Instructor"),ORGANIZER("Organizer"),ADMINISTRATOR("Adminstrator");	
		
		private String value;

		private Position(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}	
		
		public void setValue(String value) {
			this.value = value;
		}
	}

}
