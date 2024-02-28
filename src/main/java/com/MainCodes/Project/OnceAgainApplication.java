package com.MainCodes.Project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.MainCodes.Project", "com.UserRegesterationCode","com.SellerRegistrationCode","com.DropShipperRegistrationCode","com.Seller.Products","com.User.BuyProducts","com.Review","com.Products.images","com.Cart"})
@EntityScan(basePackages = {"com.MainCodes.Project", "com.UserRegesterationCode","com.SellerRegistrationCode","com.DropShipperRegistrationCode","com.Seller.Products","com.User.BuyProducts","com.Review","com.Products.images","com.Cart"})
public class OnceAgainApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnceAgainApplication.class, args);
		System.out.println("Main class loaded");
		
		
		
		
		
		
	}

	

}

/*
import {Routes,Route ,BrowserRouter as Router} from 'react-router-dom'; 
	@PostConstruct
	public void init() {
		System.out.println("Init method invoked");
	}
	
	
	
	
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroyed method invoked");
	
import Home from "./pages/Home";
import RegesterPage from "./pages/RegesterPage";
import LoginPage from "./pages/LoginPage";

function App() {
  return (
	  
	 <Router>
      <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<RegesterPage />} />
          <Route path="/login/:userType" element={<LoginPage />} />
      </Routes>
    </Router>
    
  );
}

export default App;

//make a seperate page for background and use it  in home 
*/