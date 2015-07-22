package com.cloud.tags.common;

public enum ImpressionTypes {
	
	IPADDRESS("IPADDRESS"),PRODUCT("PRODUCT"), TAPPED("TAPPED"), EMAILED_RECOMMENDATIONS("EMAILED_RECOMMENDATIONS"),
	SEND("SEND"), SEND_MAIL("SENDMAIL"), CAROUSEL("CAROUSEL"), IMAGE("IMAGE"), CARTS("CARTS"),
	ADDED("ADDED"), LIKED("LIKED"), USER("USER"), LOGIN("LOGIN"), REMOVED("REMOVED"), UNDOCKED("UNDOCKED"),
	EMAIL_NOTIFICATION("EMAIL-NOTIFICATION"), CART_PRODUCT("CART-PRODUCT"), UNDOCKED_NEW("UNDOCKED-NEW"),
	_WALL("-WALL"), DOCKED_NEW("DOCKED-NEW"),DOCKED("DOCKED"), EMAIL_NOTIFICATION_FRIEND("EMAIL_NOTIFICATION_FRIEND")
	,SHARED_PRODUCTS("SHARED_PRODUCTS"),STAFFPAGE("STAFFPAGE"), UNDOCK_EMAIL("UNDOCK_EMAIL"),SHORTLIST("SHORTLIST"),
	RELATED("RELATED"),OUREDIT("OUR_EDIT"),COLOURS("COLOURS"),COLLECTIONS("COLLECTIONS"),UNDOCKEDEMAIL("UNDOCK_EMAIL")
	,EMAILADDRESS("EMAIL_ADDRESS"),INSTRUCTIONPAGE("INSTRUCTION_PAGE"),INSTRUCTIONS("INSTRUCTIONS"),ADDITEM("ADD_ITEM"),TUTORIAL("TUTORIAL"),
	CONGRATS("CONGRATS"),SUCCESS("SUCCESS"), WOW("WOW"),MESSAGE("MESSAGE");
	
	private String value;
	 
	private ImpressionTypes(String key) {
		value = key;
	}
 
	public String getValue() {
		return value;
	}
}
// TAPPED-WALL, DOCKED-NEW

// Files are EmailNotification, Recommendationcontroller, ShortList, Undocked, Undocked1,

