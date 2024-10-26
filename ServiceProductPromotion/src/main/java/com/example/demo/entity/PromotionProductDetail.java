package com.example.demo.entity;

public class PromotionProductDetail {
	private String barcode;
	private double shipDiscount;
	private double pricePercentDiscount;
	public PromotionProductDetail(String barcode, double shipDiscount, double pricePercentDiscount) {
		super();
		this.barcode = barcode;
		this.shipDiscount = shipDiscount;
		this.pricePercentDiscount = pricePercentDiscount;
	}
	public PromotionProductDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public double getShipDiscount() {
		return shipDiscount;
	}
	public void setShipDiscount(double shipDiscount) {
		this.shipDiscount = shipDiscount;
	}
	public double getPricePercentDiscount() {
		return pricePercentDiscount;
	}
	public void setPricePercentDiscount(double pricePercentDiscount) {
		this.pricePercentDiscount = pricePercentDiscount;
	}
	@Override
	public String toString() {
		return "ProductPromotionDetail [barcode=" + barcode + ", shipDiscount=" + shipDiscount
				+ ", pricePercentDiscount=" + pricePercentDiscount + "]";
	}
	
	
	
}
