package combinator;

import static combinator.CustomerValidatorService.*;

import java.util.function.Function;

public interface CustomerValidatorService extends Function<Customer, ValidationResult> {

	static CustomerValidatorService isValidName() {
		return customer -> customer.getName().length() > 0 ? ValidationResult.Success : ValidationResult.Not_Valid;
	}

	static CustomerValidatorService isValidEmail() {
		return customer -> customer.getEmail().contains("@") ? ValidationResult.Success : ValidationResult.Not_Valid;
	}

	default CustomerValidatorService and(CustomerValidatorService other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.equals(ValidationResult.Success) ? other.apply(customer) : result;
		};
	}

	enum ValidationResult {
		Success, Not_Valid
	}

}
