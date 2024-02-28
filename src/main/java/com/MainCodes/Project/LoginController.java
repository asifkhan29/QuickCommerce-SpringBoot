package com.MainCodes.Project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DropShipperRegistrationCode.DropShipperEntity;
import com.DropShipperRegistrationCode.DropShipperLoginValue;
import com.DropShipperRegistrationCode.DropShipperRepository;
import com.SellerRegistrationCode.SellerDTO;
import com.SellerRegistrationCode.SellerEntity;
import com.SellerRegistrationCode.SellerLoginValue;
import com.SellerRegistrationCode.SellerRegistrationRepository;
import com.UserRegesterationCode.UserDTO;
import com.UserRegesterationCode.UserLoginValue;
import com.UserRegesterationCode.UserRegester;
import com.UserRegesterationCode.UserRegestrationRepository;


@RestController
@RequestMapping("/Login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	@Autowired
	UserRegestrationRepository userRegestrationRepository;

	@Autowired
	SellerRegistrationRepository sellerRegistrationRepository;

	@Autowired
	DropShipperRepository dropShipperRepository;

	@GetMapping("/User/{email}/{password}")
	public ResponseEntity<?> userLoginForm(@PathVariable String email , @PathVariable String password) {

		try {
			
			UserRegester userRegester = userRegestrationRepository.findByEmail(email);
			if (userRegester != null && userRegester.getPassword().equals(password)) {
				System.out.println(userRegester);
			}
			return ResponseEntity.ok(new UserDTO(userRegester.getId(),userRegester.getName(),userRegester.getEmail(),userRegester.getState(),userRegester.getCity(),userRegester.getPhoneNumber()));

			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
		}

	}

	@PostMapping("/Seller")
	public ResponseEntity<?> sellerLoginForm(@RequestBody SellerLoginValue sellerLoginValue) {
          System.out.println("work");
		try {

			String email = sellerLoginValue.getEmail();
			String password = sellerLoginValue.getPassword();
            System.out.println("okk");
			SellerEntity sellerEntity = sellerRegistrationRepository.findByEmail(email);

			if (sellerEntity != null && sellerEntity.getPassword().equals(password)) {
				System.out.println(sellerEntity);
			}
			
		    SellerDTO sd = new SellerDTO(sellerEntity.getId(),sellerEntity.getName(),sellerEntity.getShopName(),sellerEntity.getAddress(),sellerEntity.getEmail(),sellerEntity.getPhoneNumber(),sellerEntity.getStorePicture());
			return ResponseEntity.ok(sd);
			

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
		}

	}

	@GetMapping("/DropShipper")
	public ResponseEntity<?> dropShipperLoginForm(@RequestBody DropShipperLoginValue dropShipperLoginValue) {

		try {

			String email = dropShipperLoginValue.getEmail();

			String password = dropShipperLoginValue.getPassword();

			DropShipperEntity dropShipperEntity = dropShipperRepository.findByEmail(email);

			if (dropShipperEntity != null && dropShipperEntity.getPassword().equals(password)) {
				System.out.println(dropShipperEntity);

			}
			return ResponseEntity.ok("Success");

		} catch (Exception e) {
			// TODO: handle 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
		}

	}

}
