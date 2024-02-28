package com.MainCodes.Project;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DropShipperRegistrationCode.DropShipperEntity;
import com.DropShipperRegistrationCode.DropShipperRepository;
import com.DropShipperRegistrationCode.DropShipperValue;
import com.SellerRegistrationCode.SellerDTO;
import com.SellerRegistrationCode.SellerEntity;
import com.SellerRegistrationCode.SellerRegistrationRepository;
import com.SellerRegistrationCode.SellerValue;
import com.UserRegesterationCode.UserDTO;
import com.UserRegesterationCode.UserRegester;
import com.UserRegesterationCode.UserRegestrationRepository;
import com.UserRegesterationCode.UserValue;

@RestController
@RequestMapping("/Registration")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {

	@Autowired
	UserRegestrationRepository userRegestrationRepository;

	@Autowired
	SellerRegistrationRepository sellerRegistrationRepository;

	@Autowired
	DropShipperRepository dropShipperRepository;

	@PostMapping("/User")
	public ResponseEntity<?> userRegistrationForm(@RequestBody UserValue userValue) {
		System.err.println("working here ");
		try {
			if (userRegestrationRepository.existsByEmail(userValue.getEmail())) {
				return ResponseEntity.badRequest().body("bad request");
			}

			UserRegester uv = new UserRegester();
			uv.setName(userValue.getName());
			uv.setEmail(userValue.getEmail());
			uv.setState(userValue.getState());
			uv.setCity(userValue.getCity());
			uv.setPassword(userValue.getPassword());
			uv.setPhoneNumber(userValue.getPhoneNumber());
			userRegestrationRepository.save(uv);

			return ResponseEntity.ok(new UserDTO(uv.getId(),uv.getName(),uv.getEmail(),uv.getState(),uv.getCity(),uv.getPhoneNumber()));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("unsuccess");
		}
	}

	@PostMapping("/Seller")
	public ResponseEntity<?> sellerRegistrationForm(@RequestBody SellerValue sellerValue) {
		try {
			if (sellerRegistrationRepository.existsByEmail(sellerValue.getEmail())) {
				return ResponseEntity.badRequest().body("bad request");
			}

			SellerEntity sellerEntity = new SellerEntity();
			sellerEntity.setName(sellerValue.getName());
			sellerEntity.setShopName(sellerValue.getShopName());
			sellerEntity.setEmail(sellerValue.getEmail());
			sellerEntity.setAddress(sellerValue.getAddress());
			sellerEntity.setPhoneNumber(sellerValue.getPhoneNumber());
			sellerEntity.setPassword(sellerValue.getPassword());

			sellerRegistrationRepository.save(sellerEntity);
			SellerEntity se = sellerRegistrationRepository.findByEmail(sellerValue.getEmail());
		    SellerDTO sd = new SellerDTO(se.getId(),se.getName(),se.getShopName(),se.getAddress(),se.getEmail(),se.getPhoneNumber(),se.getStorePicture());
			return ResponseEntity.ok(sd);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
		}
	}

	@PostMapping("/DropShipper")
	public ResponseEntity<?> dropshipperRegistrationForm(@RequestBody DropShipperValue dropShipperValue) {
		try {

			if (dropShipperRepository.existsByEmail(dropShipperValue.getEmail())) {
				return ResponseEntity.badRequest().body("Email Already In Use");
			}
			DropShipperEntity dropShipperEntity = new DropShipperEntity();

			dropShipperEntity.setName(dropShipperValue.getName());
			dropShipperEntity.setEmail(dropShipperValue.getEmail());
			dropShipperEntity.setState(dropShipperValue.getState());
			dropShipperEntity.setCity(dropShipperEntity.getCity());
			dropShipperEntity.setPhoneNumber(dropShipperValue.getPhoneNumber());
			dropShipperEntity.setPassword(dropShipperValue.getPassword());

			dropShipperRepository.save(dropShipperEntity);

			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
		}

	}
	@PostMapping("/setStorePicture")
	public ResponseEntity<?> setStorePicture( @RequestBody SellerValue sellerValue)
	{
		try {

			SellerEntity se = sellerRegistrationRepository.findByEmail(sellerValue.getEmail());
			se.setStorePicture(sellerValue.getStorePicture());
			sellerRegistrationRepository.save(se);
			return ResponseEntity.ok("Profule Added Successful");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("UnsuccesFull");
		}
		
		
		
		
		
	}
    
	
}
