create index IX_29B9D596 on Impressions (impressionType, impressionAction, session_Id, companyId);
create index IX_B377C5DB on Impressions (staffId);
create index IX_7AEE3392 on Impressions (storeDeviceId);

create index IX_1AEB501E on cart_designers (cartId);
create index IX_FD03B6CB on cart_designers (cartId, designId);
create index IX_A2DB6F5C on cart_designers (staffId);

create index IX_DABE6FB1 on carts (session_id);
create index IX_8E6FD393 on carts (userId);

create index IX_1634AC13 on cloudtag_DesignersBarcode (barcodeId);

create index IX_C5DD5BBE on designer_barcodes (barcodeId);

create index IX_B8DFABA on designers (companyId);
create index IX_301C6E36 on designers (companyId, barcode);
create index IX_8D4F9E9E on designers (productcode);

create index IX_A44F98FA on designers_customer_images (designerSKU);

create index IX_210CCDA2 on designers_images (designId);

create index IX_D1A54813 on recommendations (designer1, _type);
create index IX_8B670235 on recommendations (designer1, _type, companyId);

create index IX_3B7106A6 on store_device_map (deviceMacAddress);
create index IX_5F833DC5 on store_device_map (storeName);