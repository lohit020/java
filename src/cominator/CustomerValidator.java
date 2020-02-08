package cominator;

public class CustomerValidator {

	public static void main(String[] args) {
		Customer customer = new Customer("asdf", "as@dfgmail.com");

		System.out.println(CustomerValidatorService.isValidEmail().and(CustomerValidatorService.isValidName()).apply(customer));
	}

}
