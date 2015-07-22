package com.cloud.tags.common.util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProductDetails")
public class ProductDetails {
	private long designId;	
	private String name;
	private String productTitle;		
	private String productCode;	
	private String category;
	private String price;
	private String entity_image1;
	private String entity_image2;
	private String entity_image3;
	private String entity_image4;
	private String entity_image5;
	private String entity_image6;
	private String entity_image7;
	
	@XmlElement
	public long getDesignId() {
		return designId;
	}
	public void setDesignId(long designId) {
		this.designId = designId;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	
	@XmlElement
	public String getProductCode() {
		return productCode;
	}
	
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@XmlElement
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@XmlElement
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@XmlElement
	public String getEntity_image1() {
		return entity_image1;
	}
	public void setEntity_image1(String entity_image1) {
		this.entity_image1 = entity_image1;
	}
	
	@XmlElement
	public String getEntity_image2() {
		return entity_image2;
	}
	public void setEntity_image2(String entity_image2) {
		this.entity_image2 = entity_image2;
	}
	
	@XmlElement
	public String getEntity_image3() {
		return entity_image3;
	}
	public void setEntity_image3(String entity_image3) {
		this.entity_image3 = entity_image3;
	}
	
	@XmlElement
	public String getEntity_image4() {
		return entity_image4;
	}
	public void setEntity_image4(String entity_image4) {
		this.entity_image4 = entity_image4;
	}
	
	@XmlElement
	public String getEntity_image5() {
		return entity_image5;
	}
	public void setEntity_image5(String entity_image5) {
		this.entity_image5 = entity_image5;
	}
	
	@XmlElement
	public String getEntity_image6() {
		return entity_image6;
	}
	public void setEntity_image6(String entity_image6) {
		this.entity_image6 = entity_image6;
	}
	
	@XmlElement
	public String getEntity_image7() {
		return entity_image7;
	}
	public void setEntity_image7(String entity_image7) {
		this.entity_image7 = entity_image7;
	}
	
	
	
	
}
