package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

	public static final String EXAMPLE = "123, some street";
	public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in "
			+ "the a/BLOCK, STREET, UNIT, POSTAL_CODE format";
	public static final String ADDRESS_VALIDATION_REGEX = ", ";
	public static final Integer BLOCK_INDEX_IN_ADDRESS = 0;
	public static final Integer STREET_INDEX_IN_ADDRESS = 1;
	public static final Integer UNIT_INDEX_IN_ADDRESS = 2;
	public static final Integer POSTALCODE_INDEX_IN_ADDRESS = 3;

	private static final int ADDRESS_COMPONENTS = 4;

	public final Block block;
	public final Street street;
	public final Unit unit;
	public final PostalCode postalCode;

	public final String value;
	private boolean isPrivate;

	/**
	 * Represents the Block of a Person's address in the address book.
	 */
	public class Block {

		private final String value;

		/**
		 * Validates given block.
		 *
		 * @throws IllegalValueException if given block string is invalid.
		 */
		public Block(String block) throws IllegalValueException {
			this.value = block;
		}

		public String getBlock() {
			return this.value;
		}
	}

	/**
	 * Represents the Street of a Person's address in the address book.
	 */
	public class Street {

		private final String value;

		/**
		 * Validates given street.
		 *
		 * @throws IllegalValueException if given street string is invalid.
		 */
		public Street(String street) throws IllegalValueException {
			this.value = street;
		}

		public String getStreet() {
			return this.value;
		}
	}

	/**
	 * Represents the Unit of a Person's address in the address book.
	 */
	public class Unit {

		private final String value;

		/**
		 * Validates given unit.
		 *
		 * @throws IllegalValueException if given unit string is invalid.
		 */
		public Unit(String unit) throws IllegalValueException {
			this.value = unit;
		}

		public String getUnit() {
			return this.value;
		}
	}

	/**
	 * Represents the Postal code of a Person's address in the address book.
	 */
	public class PostalCode {

		private final String value;

		/**
		 * Validates given postalCode.
		 *
		 * @throws IllegalValueException if given postalCode string is invalid.
		 */
		public PostalCode(String postalCode) throws IllegalValueException {
			this.value = postalCode;
		}

		public String getPostalCode() {
			return this.value;
		}
	}

	/**
	 * Validates given address.
	 *
	 * @throws IllegalValueException if given address string is invalid.
	 */
	public Address(String address, boolean isPrivate) throws IllegalValueException {
		String trimmedAddress = address.trim();
		this.isPrivate = isPrivate;
		if (!isValidAddress(trimmedAddress)) {
			throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
		}
		value = trimmedAddress;
		block = new Block(value.split(ADDRESS_VALIDATION_REGEX)[BLOCK_INDEX_IN_ADDRESS]);
		street = new Street(value.split(ADDRESS_VALIDATION_REGEX)[STREET_INDEX_IN_ADDRESS]);
		unit = new Unit(value.split(ADDRESS_VALIDATION_REGEX)[UNIT_INDEX_IN_ADDRESS]);
		postalCode = new PostalCode(value.split(ADDRESS_VALIDATION_REGEX)[POSTALCODE_INDEX_IN_ADDRESS]);
	}

	/**
	 * Returns true if a given string is a valid person address.
	 */
	public static boolean isValidAddress(String test) {
		return test.split(ADDRESS_VALIDATION_REGEX).length == ADDRESS_COMPONENTS;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Address // instanceof handles nulls
						&& this.value.equals(((Address) other).value)); // state
																		// check
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}
