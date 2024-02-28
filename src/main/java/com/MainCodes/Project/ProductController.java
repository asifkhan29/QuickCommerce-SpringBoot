package com.MainCodes.Project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Cart.CartEntity;
import com.Cart.CartRepository;
import com.Cart.CartValues;
import com.Review.ReviewDTO;
import com.Review.ReviewEntity;
import com.Review.ReviewRepository;
import com.Review.ReviewValue;
import com.Seller.Products.ProductDTO;
import com.Seller.Products.ProductRepository;
import com.Seller.Products.Products;
import com.Seller.Products.ProductsValue;
import com.SellerRegistrationCode.SellerDTO;
import com.SellerRegistrationCode.SellerEntity;
import com.SellerRegistrationCode.SellerRegistrationRepository;
import com.SellerRegistrationCode.SellerValue;
import com.User.BuyProducts.BuyProductDTO;
import com.User.BuyProducts.BuyProductRepository;
import com.User.BuyProducts.BuyProductValues;
import com.User.BuyProducts.BuyProductsEntity;
import com.UserRegesterationCode.UserRegester;
import com.UserRegesterationCode.UserRegestrationRepository;
import com.products.images.ImageDTO;
import com.products.images.ImageEntity;
import com.products.images.ImageEntityRepository;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/Products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	SellerRegistrationRepository sellerRegistrationRepository;

	@Autowired
	BuyProductRepository buyProductRepository;

	@Autowired
	UserRegestrationRepository userRegestrationRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	ImageEntityRepository imageEntityRepository;

	@Autowired
	CartRepository cartRepository;

	@PostMapping("/Add")
	public ResponseEntity<?> addProducts(@RequestBody ProductsValue productsValue) {
		try {
			System.err.println(productsValue.getImg1());

			Products products = new Products();
			products.setProductName(productsValue.getProductName());
			products.setProductPrice(productsValue.getProductPrice());
			products.setProductDescription(productsValue.getProductDescription());
			products.setFrontImage(productsValue.getImg1());

			SellerEntity se = sellerRegistrationRepository.findByEmail(productsValue.getEmail());

			// sellerEntity.setProducts(products);
			List<Products> pro = new ArrayList<>();
			pro.add(products);
			se.setProducts(pro);
			products.setSellerEntity(se);
			productRepository.save(products);
			sellerRegistrationRepository.save(se);

			ImageEntity ie = new ImageEntity();
			ie.setImg1(productsValue.getImg1());
			ie.setImg2(productsValue.getImg2());
			ie.setImg3(productsValue.getImg3());
			ie.setImg4(productsValue.getImg4());
			ie.setImg5(productsValue.getImg5());
			ie.setProducts(products);
			imageEntityRepository.save(ie);

			return ResponseEntity.ok("Success");

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}

	}

	@PostMapping("/Get")
	public ResponseEntity<?> getProducts(@RequestBody SellerValue sellerValue) {
		try {

			SellerEntity se = sellerRegistrationRepository.findByEmail(sellerValue.getEmail());
			int x = se.getId();
			List<Products> l1 = productRepository.findBySellerEntityId(x);

			List<ProductDTO> productDTOList = l1.stream()
					.map(product -> new ProductDTO(product.getProductId(), product.getProductPrice(),
							product.getProductName(), product.getProductDescription(), product.getFrontImage()))
					.collect(Collectors.toList());

			return ResponseEntity.ok(productDTOList);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail");
		}

	}

	@GetMapping("/GetSearchProduct/{searchProduct}")
	public ResponseEntity<?> getSearchProduct(@PathVariable String searchProduct) {
		try {
			List<Products> p = productRepository.findByProductNameContainingIgnoreCase(searchProduct);
			if (p.isEmpty()) {
				return ResponseEntity.badRequest().body("Product Not Found");
			}

			List<ProductDTO> p2 = p.stream()
					.map(product -> new ProductDTO(product.getProductId(), product.getProductPrice(),
							product.getProductName(), product.getProductDescription(), product.getFrontImage()))
					.collect(Collectors.toList());
			return ResponseEntity.ok(p2);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body("Fail");
		}

	}

	@GetMapping("/GetStores/{searchStore}")
	public ResponseEntity<?> getStoreData(@PathVariable String searchStore) {
		try {

			List<SellerEntity> l1 = sellerRegistrationRepository.findByShopName(searchStore);

			if (l1.isEmpty()) {
				return ResponseEntity.badRequest().body("Store Not Found");
			}

			List<SellerDTO> sd = l1.stream()
					.map(sellerData -> new SellerDTO(sellerData.getId(), sellerData.getName(), sellerData.getShopName(),
							sellerData.getAddress(), sellerData.getEmail(), sellerData.getPhoneNumber(),
							sellerData.getStorePicture()))
					.collect(Collectors.toList());
			return ResponseEntity.ok(sd);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail");
		}

	}

	@GetMapping("/GetFullDetails/{productId}")
	public ResponseEntity<?> getProductFullDetails(@PathVariable int productId) {
		try {
			Products p = productRepository.findById(productId);

			SellerEntity sellerId = p.getSellerEntity();

			ProductDTO d = new ProductDTO(p.getProductId(), p.getProductPrice(), p.getProductName(),
					p.getProductDescription(), sellerId.getShopName(), sellerId.getAddress(), sellerId.getName(),
					sellerId.getEmail());
			return ResponseEntity.ok(d);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fails");

		}

	}

	@PostMapping("/Buy")
	public ResponseEntity<?> buyProductsAndSellerOrder(@RequestBody BuyProductValues buyProductValues) {
		try {

			System.out.println(buyProductValues.getUserEmail());
			System.out.println(buyProductValues.getSellerEmail());
			UserRegester ur = userRegestrationRepository.findByEmail(buyProductValues.getUserEmail());
			SellerEntity se = sellerRegistrationRepository.findByEmail(buyProductValues.getSellerEmail());
			BuyProductsEntity bpe = new BuyProductsEntity();
			bpe.setProductName(buyProductValues.getProductName());
			bpe.setProductId(buyProductValues.getProductId());
			bpe.setQuantity(buyProductValues.getQuantity());
			bpe.setShopName(buyProductValues.getShopName());
			bpe.setShopAddress(buyProductValues.getShopAddress());
			bpe.setCustomerName(buyProductValues.getUserName());
			bpe.setCustomerAddress(buyProductValues.getUserAddress());
			bpe.setPaymentInfo(buyProductValues.getPaymentInfo());
			bpe.setProductPrice(buyProductValues.getProductPrice());
			bpe.setCustomerNumber(buyProductValues.getUserPhoneNumber());
			bpe.setProductColor(buyProductValues.getProductColor());
			bpe.setOrderStatus("Pending");
			bpe.setUserRegester(ur);
			bpe.setSellerEntity(se);
			List<BuyProductsEntity> b = new ArrayList<>();
			b.add(bpe);
			ur.setBuyProducts(b);
			se.setNumberOfOrder(b);
			buyProductRepository.save(bpe);
			sellerRegistrationRepository.save(se);
			userRegestrationRepository.save(ur);

			return ResponseEntity.ok("Succesfully Buy Product");

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail To Buy Product");
		}

	}

	@GetMapping("/GetUserOrder/{email}")
	public ResponseEntity<?> getUserOrder(@PathVariable String email) {
		try {

			UserRegester ur = userRegestrationRepository.findByEmail(email);
			int userId = ur.getId();

			List<BuyProductsEntity> l1 = buyProductRepository.findByUserRegesterId(userId);

			List<BuyProductDTO> bpdto = l1.stream()
					.map(orderDetails -> new BuyProductDTO(orderDetails.getId(), orderDetails.getProductName(),
							orderDetails.getQuantity(), orderDetails.getShopName(), orderDetails.getPaymentInfo(),
							orderDetails.getProductColor(), orderDetails.getProductPrice(),
							orderDetails.getOrderStatus()))
					.collect(Collectors.toList());

			System.out.println(bpdto);

			return ResponseEntity.ok(bpdto);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail To Display Product");
		}

	}

	@GetMapping("/GetSellerOrders/{email}")
	public ResponseEntity<?> getSellerOrderS(@PathVariable String email) {
		try {

			SellerEntity se = sellerRegistrationRepository.findByEmail(email);
			int sellerId = se.getId();

			List<BuyProductsEntity> l1 = buyProductRepository.findBySellerEntityId(sellerId);

			List<BuyProductDTO> bpdto = l1.stream()
					.map(orderDetails -> new BuyProductDTO(orderDetails.getId(), orderDetails.getProductName(),
							orderDetails.getQuantity(), orderDetails.getProductColor(), orderDetails.getProductPrice(),
							orderDetails.getOrderStatus()))
					.collect(Collectors.toList());

			// String productName, String quantity, String productColor, String
			// productPrice)

			return ResponseEntity.ok(bpdto);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail To Display Product");
		}

	}

	@GetMapping("/GetShopDetails/{email}")
	public ResponseEntity<?> getShopDetail(@PathVariable String email) {
		try {

			SellerEntity se = sellerRegistrationRepository.findByEmail(email);
			int x = se.getId();
			List<Products> l1 = productRepository.findBySellerEntityId(x);

			List<ProductDTO> productDTOList = l1.stream()
					.map(product -> new ProductDTO(product.getProductId(), product.getProductPrice(),
							product.getProductName(), product.getProductDescription(), product.getFrontImage()))
					.collect(Collectors.toList());

			return ResponseEntity.ok(productDTOList);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail");
		}

	}

	@GetMapping("/Delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) {
		try {

			Products p = productRepository.findById(id);
			productRepository.delete(p);

			return ResponseEntity.ok("Deleting Product SuccessFul");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
		}
	}

	@PostMapping("/Update")
	public ResponseEntity<?> UpdateProduct(@RequestBody ProductsValue productsValue) {
		try {
			Products p = productRepository.findById(productsValue.getId());
			p.setProductName(productsValue.getProductName());
			p.setProductPrice(productsValue.getProductPrice());
			p.setProductDescription(productsValue.getProductDescription());
			productRepository.save(p);
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail To Update");
		}

	}

	@GetMapping("/CancelOrder/{orderId}")
	public ResponseEntity<?> CancelOrder(@PathVariable int orderId) {

		try {

			BuyProductsEntity bpe = buyProductRepository.findById(orderId);
			String status = bpe.getOrderStatus();
			if (!status.equals("Pending")) {
				return ResponseEntity.badRequest().body("Product Already Delivered Or Cancelled");
			}
			bpe.setOrderStatus("Order Cancel");
			buyProductRepository.save(bpe);

			return ResponseEntity.ok("Success");

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
		}

	}

	@PostMapping("/SetReviews")
	public ResponseEntity<?> setReview(@RequestBody ReviewValue reviewValue) {

		try {

			ReviewEntity re = new ReviewEntity();
			re.setReview(reviewValue.getReview());
			re.setRating(reviewValue.getRating());
			re.setReviewer(reviewValue.getReviewer());

			Products product = productRepository.findById(reviewValue.getProductId());

			re.setProducts(product);

			reviewRepository.save(re);

			List<ReviewEntity> l1 = new ArrayList<>();
			l1.add(re);
			product.setReviewEntity(l1);

			productRepository.save(product);

			return ResponseEntity.ok("Success");

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
		}

	}

	@GetMapping("/GetReviews/{productId}")
	public ResponseEntity<?> getReview(@PathVariable int productId) {

		try {

			List<ReviewEntity> l1 = reviewRepository.findByProductsProductId(productId);

			List<ReviewDTO> l2 = l1.stream()
					.map(reviews -> new ReviewDTO(reviews.getRating(), reviews.getReview(), reviews.getReviewer()))
					.collect(Collectors.toList());

			return ResponseEntity.ok(l2);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
		}

	}

	@GetMapping("/GetProductImages/{productId}")
	public ResponseEntity<?> getProductsImages(@PathVariable int productId) {

		try {

			ImageEntity ie = imageEntityRepository.findByProductsProductId(productId);
			ImageDTO IDTO = new ImageDTO(ie.getImg1(), ie.getImg2(), ie.getImg3(), ie.getImg4(), ie.getImg5());

			return ResponseEntity.ok(IDTO);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
		}

	}

	@GetMapping("Searching/{searchProduct}")
	public ResponseEntity<?> atProductSearchingTime(@PathVariable String searchProduct) {
		try {

			List<Products> searchingResults = productRepository.findByProductNameContainingIgnoreCase(searchProduct);
			if (searchingResults.isEmpty()) {
				return ResponseEntity.badRequest().body("No Product Found");
			}

			List<ProductDTO> sendSearchingResult = searchingResults.stream()
					.map((products) -> new ProductDTO(products.getProductId(), products.getProductName()))
					.collect(Collectors.toList());
			return ResponseEntity.ok(sendSearchingResult);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail To Get Product");
		}

	}

	@GetMapping("SearchingStore/{searchStore}")
	public ResponseEntity<?> atStoreSearchingTime(@PathVariable String searchStore) {
		try {

			List<SellerEntity> searchingResults = sellerRegistrationRepository
					.findByShopNameContainingIgnoreCase(searchStore);
			if (searchingResults.isEmpty()) {
				return ResponseEntity.badRequest().body("No Store Found");
			}

			List<SellerDTO> sendSearchingResult = searchingResults.stream()
					.map((stores) -> new SellerDTO(stores.getId(), stores.getShopName())).collect(Collectors.toList());
			return ResponseEntity.ok(sendSearchingResult);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail To Get Product");
		}

	}

	@PostMapping("/AddCart")
	public ResponseEntity<?> cart(@RequestBody CartValues cartValue) {
		try {

			System.out.println(cartValue.getProductId());
			CartEntity cart = cartRepository.findByUserRegesterIdAndProductsProductId(cartValue.getUserId(),
					cartValue.getProductId());
			if (cart != null) {
				int q = cart.getQuantity();
				q = q + 1;
				cart.setQuantity(q);
				cartRepository.save(cart);
				return ResponseEntity.ok("Success");
			}

			UserRegester ur = userRegestrationRepository.findById(cartValue.getUserId());
			Products p = productRepository.findById(cartValue.getProductId());

			CartEntity cartEntity = new CartEntity();
			cartEntity.setUserRegister(ur);
			cartEntity.setProducts(p);
			cartEntity.setQuantity(1);
			cartRepository.save(cartEntity);

			return ResponseEntity.ok("200");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("hello");
		}

	}

	@GetMapping("/GetCart/{userId}")
	public ResponseEntity<?> fetchCart(@PathVariable int userId) {

		try {
			List<CartEntity> productList1 = cartRepository.findByUserRegesterId(userId);

			List<Products> products = new ArrayList<>();
			
		    
			productList1.forEach(item ->{
				products.add(item.getProducts());
			});
//
//			
//			
			List<ProductDTO> productDTOList = products.stream()
					.map(product -> new ProductDTO(product.getProductId(), product.getProductPrice(),
							product.getProductName(), product.getProductDescription(), product.getFrontImage()))
					.collect(Collectors.toList());
//			List<ProductDTO> productsCart = productList1.stream()
//					.map(productsC -> new ProductDTO(productsC.getProducts(),productsC.getId()))
//					.collect(Collectors.toList());
//         
			
			return ResponseEntity.ok(productDTOList);
			//return ResponseEntity.ok("ok");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail To Get Products");
		}

	}
    
	@DeleteMapping("/RemoveCart/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable int id) {
		
		
      return ResponseEntity.ok("ok");
	}

}
