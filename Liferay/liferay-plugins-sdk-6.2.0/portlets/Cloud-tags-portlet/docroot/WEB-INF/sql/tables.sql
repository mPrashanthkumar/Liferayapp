create table Impressions (
	recId LONG not null primary key,
	impressionType VARCHAR(75) null,
	impressionId VARCHAR(75) null,
	impressionAction VARCHAR(75) null,
	ipAddress VARCHAR(75) null,
	deviceType VARCHAR(75) null,
	deviceName VARCHAR(75) null,
	deviceWidth VARCHAR(75) null,
	ideviceBrowser VARCHAR(75) null,
	session_Id VARCHAR(75) null,
	companyId VARCHAR(75) null,
	createDate DATE null,
	storeDeviceId LONG,
	staffId VARCHAR(75) null
);

create table cart_designers (
	cartDesignerId LONG not null primary key,
	cartId LONG,
	designId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	kept BOOLEAN,
	favorite BOOLEAN,
	staffId VARCHAR(75) null,
	userNote TEXT null,
	XPComputed BOOLEAN
);

create table carts (
	cartId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	session_id VARCHAR(75) null,
	staffId VARCHAR(75) null
);

create table cloudtag_DesignersBarcode (
	designerBarcodeId LONG not null primary key,
	barcodeId LONG,
	designId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table designer_barcodes (
	designerBarcodeId LONG not null primary key,
	barcodeId LONG,
	designId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table designers (
	designId LONG not null primary key,
	userId LONG,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name TEXT null,
	productTitle TEXT null,
	description TEXT null,
	shortDescription TEXT null,
	price VARCHAR(75) null,
	public_url TEXT null,
	short_url VARCHAR(75) null,
	slug VARCHAR(75) null,
	sizes VARCHAR(75) null,
	colors VARCHAR(75) null,
	brand VARCHAR(75) null,
	saleprice VARCHAR(75) null,
	retailprice VARCHAR(75) null,
	instock VARCHAR(75) null,
	parentid VARCHAR(75) null,
	category VARCHAR(75) null,
	productcode VARCHAR(75) null,
	barcode VARCHAR(75) null,
	matchWith TEXT null,
	timerDate VARCHAR(75) null,
	tabcurrent BOOLEAN,
	liked LONG,
	ctapp_shorturl BOOLEAN,
	ctapp_shorturl_success BOOLEAN,
	sayduck BOOLEAN,
	left_description TEXT null,
	right_description TEXT null
);

create table designers_customer_images (
	customerImageId LONG not null primary key,
	designerSKU VARCHAR(75) null,
	designerCusImage TEXT null,
	customerImage TEXT null,
	customerName TEXT null,
	customerAddress TEXT null
);

create table designers_images (
	designImageId LONG not null primary key,
	designId LONG,
	entity_image1 TEXT null,
	entity_image2 TEXT null,
	entity_image3 TEXT null,
	entity_image4 TEXT null,
	entity_image5 TEXT null,
	entity_image6 TEXT null,
	entity_image7 TEXT null,
	entity_image8 TEXT null,
	entity_image9 TEXT null,
	entity_image10 TEXT null,
	large_image_url TEXT null,
	small_image_url TEXT null,
	profile_image_url TEXT null
);

create table recommendations (
	recId LONG not null primary key,
	designer1 VARCHAR(75) null,
	designer2 VARCHAR(75) null,
	_type LONG,
	percentage DOUBLE,
	companyId LONG,
	color_name VARCHAR(75) null,
	color_image TEXT null
);

create table store_device_map (
	uuid_ LONG not null primary key,
	storeName VARCHAR(75) null,
	deviceMacAddress VARCHAR(75) null,
	storeId LONG,
	companyId LONG,
	groupId LONG,
	createDate DATE null
);

create table store_information_map (
	uuid_ LONG not null primary key,
	Name VARCHAR(75) null,
	Address VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	createDate DATE null
);