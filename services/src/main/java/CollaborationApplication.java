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
