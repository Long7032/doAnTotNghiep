package com.example.demo.entity;

public class PromotionProductDetail {
	private String barcode;
	private double priceDiscount;

	public PromotionProductDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PromotionProductDetail(String barcode, double priceDiscount) {
		super();
		this.barcode = barcode;
		this.priceDiscount = priceDiscount;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getPriceDiscount() {
		return priceDiscount;
	}

	public void setPriceDiscount(double priceDiscount) {
		this.priceDiscount = priceDiscount;
	}

	@Override
	public String toString() {
		return "PromotionProductDetail [barcode=" + barcode + ", priceDiscount=" + priceDiscount + "]";
	}

}
