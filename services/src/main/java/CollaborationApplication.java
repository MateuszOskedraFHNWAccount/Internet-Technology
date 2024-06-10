import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import services/src/main/java/business/CollaborationsList.java;
import services/src/main/java/data/domain/AccountManagement.java;
import services/src/main/java/data/domain/AdminActions.java;
import services/src/main/java/data/domain/BuddySystem.java;
import services/src/main/java/data/domain/ForumPost.java;
import services/src/main/java/data/domain/ForumResponse.java;
import services/src/main/java/data/domain/IndependentProject.java;
import services/src/main/java/data/domain/JobAdvertisement.java;
import services/src/main/java/data/domain/MentoringForProjects.java;
import services/src/main/java/data/domain/RoomAssignment.java;
import services/src/main/java/data/domain/SystemLog.java;
import services/src/main/java/data/domain/TutoringSession.java;
import services/src/main/java/data/domain/User.java;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class CollaborationApplication {

	@Autowired
	private CollaborationsList collaborationsList;

	public static void main(String[] args) {
		SpringApplication.run(CollaborationApplication.class, args);
	}

	// Use this method to initialize placeholder data without using Postman
	// If you are persisting data in a file (see application.properties), initializing data that already exists will cause an error during starting the application
	// To resolve the error, delete the file and restart the application
	@PostConstruct
	private void initPlaceholderData() throws Exception {
		Pizza pizza = new Pizza();
		pizza.setPizzaName("Margherita");
		pizza.setPizzaToppings("Tomato sauce, mozzarella, basil");
		menuService.addPizza(pizza);

		pizza = new Pizza();
		pizza.setPizzaName("Funghi");
		pizza.setPizzaToppings("Tomato sauce, mozzarella, mushrooms");
		menuService.addPizza(pizza);
		
	}

}
