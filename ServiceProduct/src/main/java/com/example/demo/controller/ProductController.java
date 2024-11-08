package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/demo")
	public ResponseEntity<Object> prepareSampleData() {
		String des = "1. Kiểu sản phẩm: Áo Sơ Mi cổ trụ tay dài\r\n"
				+ "2. Ưu điểm: Không chỉ ít nhăn, mà thiết kế cổ trụ còn mang đến vẻ thanh lịch và trẻ trung.\r\n"
				+ "3. Chất liệu: Sợi Modal Poly với thành phần 12% Modal và 88% Polyester.\r\n"
				+ "4. Kỹ thuật: Đột chỉ hai bên vai, giúp tăng tính cơ động và thoải mái cho người mặc, dễ dàng theo chuyển động của cơ thể mà không gây hạn chế.\r\n"
				+ "5. Phù hợp với ai: Lịch lãm, phù hợp với phong cách công sở và dạo phố.\r\n"
				+ "6. Thuộc Bộ Sưu Tập: NON IRON - bộ sưu tập áo sơ mi vải ít nhăn và dễ ủi.\r\n"
				+ "7. Các tên thường gọi hoặc tìm kiếm về sản phẩm này: Áo Sơ Mi cổ trụ, áo sơ mi cổ lãnh tụ, áo sơ mi cổ grandad, áo sơ mi tay dài, áo sơ mi công sở, áo sơ mi dạo phố, áo sơ mi đi tiệc, áo sơ mi đi làm, sơ mi trắng";
		Set<String> set = new HashSet<>();
		set.add("https://cdn2.yame.vn/pimg/ao-thun-co-tru-on-gian-y-nguyen-ban-ver144-0021848/70da0c3c-3f60-9502-e855-001a33f98269.jpg?w=540&h=756");
		set.add("https://cdn2.yame.vn/pimg/ao-so-mi-co-lanh-tu-soi-modal-wrinkle-free-03-0022462/4fab1a61-3b8b-d300-1d90-001ae3b893f0.jpg?w=540&h=756");
		set.add("https://cdn2.yame.vn/pimg/ao-so-mi-co-lanh-tu-soi-modal-wrinkle-free-03-0022464/ea3a35f2-c325-3a00-5dd9-001ac2f43fec.jpg?w=540&h=756");
		set.add("https://cdn2.yame.vn/pimg/ao-so-mi-co-lanh-tu-soi-modal-wrinkle-free-03-0022464/5977ae81-d4b7-3b00-5f8d-001ac2f44000.jpg?w=540&h=756");
		set.add("https://cdn2.yame.vn/pimg/ao-so-mi-co-lanh-tu-soi-modal-wrinkle-free-03-0022464/9e500645-5bdc-0700-3057-001aeaf2b10f.jpg?w=540&h=756");

		for (int j = 0; j < 3; j++) {
			des += "1. Kiểu sản phẩm: Áo Sơ Mi cổ trụ tay dài\r\n"
					+ "2. Ưu điểm: Không chỉ ít nhăn, mà thiết kế cổ trụ còn mang đến vẻ thanh lịch và trẻ trung.\r\n"
					+ "3. Chất liệu: Sợi Modal Poly với thành phần 12% Modal và 88% Polyester.\r\n"
					+ "4. Kỹ thuật: Đột chỉ hai bên vai, giúp tăng tính cơ động và thoải mái cho người mặc, dễ dàng theo chuyển động của cơ thể mà không gây hạn chế.\r\n"
					+ "5. Phù hợp với ai: Lịch lãm, phù hợp với phong cách công sở và dạo phố.\r\n"
					+ "6. Thuộc Bộ Sưu Tập: NON IRON - bộ sưu tập áo sơ mi vải ít nhăn và dễ ủi.\r\n"
					+ "7. Các tên thường gọi hoặc tìm kiếm về sản phẩm này: Áo Sơ Mi cổ trụ, áo sơ mi cổ lãnh tụ, áo sơ mi cổ grandad, áo sơ mi tay dài, áo sơ mi công sở, áo sơ mi dạo phố, áo sơ mi đi tiệc, áo sơ mi đi làm, sơ mi trắng";
		}

		for (int i = 0; i < 20; i++) {
			productService.saveProduct(new Product(String.valueOf(89120000 + i),
					"Áo Sơ Mi Cổ Trụ Tay Dài Sợi Modal Ít Nhăn Trơn Dáng Rộng Giá Tốt Non Branded 38 Vol 24", set,
					"male", des, 10000000.00, "1", 10, "active"));
		}
		return ResponseEntity.status(200).body(new String("ok"));
	}

	// ========== Get Products ==========
	@GetMapping("/")
	public ResponseEntity<Object> getProducts() {
		return ResponseEntity.status(200).body(productService.getProducts());
	}

	@GetMapping("/{page}/{size}")
	public ResponseEntity<Object> getProductsInRange(@PathVariable int page, @PathVariable int size) {
		List<Product> rs = productService.getProductInRange(page, size);
		if (rs.toArray().length == 0) {
			return ResponseEntity.status(409).body(productService.getProductInRange(page, size));
		}
		return ResponseEntity.status(200).body(productService.getProductInRange(page, size));
	}

	// ========== Get Product By Bar Code ==========
	@PostMapping("/barcode")
	public ResponseEntity<Object> getProductsBarcode(@RequestBody Product product) {
		System.out.println("Product Controller - Get Products By Barcode");
		return ResponseEntity.status(200).body(productService.getProduct(product));
	}

	// ========== Get Products By Category ==========
	@PostMapping("/category-length")
	public ResponseEntity<Object> getProductsByIdCategory(@RequestBody Product product) {
		return ResponseEntity.status(200)
				.body(productService.getProductsByCategory(product.getIdCategory()).toArray().length);
	}

	@PostMapping("/category/{page}/{size}")
	public ResponseEntity<Object> getProductsByIdCategoryInRange(@RequestBody Product product, @PathVariable int page,
			@PathVariable int size) {
		return ResponseEntity.status(200).body(productService.getProductsByCategoryInRange(product.getIdCategory(),
				page, size));
	}

	// ========== Get Products By Name ==========
	@GetMapping("/{name}")
	public ResponseEntity<Object> getProductsByName(@PathVariable String name) {
		List<Product> rs = productService.getProductsByName(name);
		if (rs.toArray().length == 0) {
			return ResponseEntity.status(409).body(productService.getProductsByName(name));
		}
		return ResponseEntity.status(200).body(productService.getProductsByName(name));
	}

	// ========== Save Product ==========
	@PostMapping("/")
	public ResponseEntity<Object> saveProducts(@RequestBody Product product) {
		System.out.println("Product: " + product);
		Product p = productService.saveProduct(product);
		if (p == null) {
			return ResponseEntity.status(409).body(new String("Product has been exists"));
		}
		return ResponseEntity.status(200).body(p);
	}

}
