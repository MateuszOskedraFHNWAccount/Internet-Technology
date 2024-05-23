@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class CollaborationApplication {

	@Autowired
	private CollaborationsList collaborationsList;

	public static void main(String[] args) {
		SpringApplication.run(CollaborationApplication.class, args);
	}
	@PostConstruct
	private void initPlaceholderData() throws Exception {
	AccessLogs access = new AccessLogs();
	