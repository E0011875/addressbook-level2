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

	public final Block block = new Block();
	public final Street street = new Street();
	public final Unit unit = new Unit();
	public final PostalCode postalCode = new PostalCode();

	public final String value;
	private boolean isPrivate;

	/**
	 * Represents the Block of a Person's address in the address book.
	 *
	 * @param block
	 *            Block of address
	 * @throws IllegalValueException
	 *             if given block string is invalid.
	 */
	public class Block {
		String value;
	}

	/**
	 * Represents the Street of a Person's address in the address book.
	 *
	 * @param street
	 *            Street of address
	 * @throws IllegalValueException
	 *             if given street string is invalid.
	 */
	public class Street {
		String value;
	}

	/**
	 * Represents the Unit of a Person's address in the address book.
	 *
	 * @param unit
	 *            Unit of address
	 * @throws IllegalValueException
	 *             if given unit string is invalid.
	 */
	public class Unit {
		String value;
	}

	/**
	 * Represents the Postal code of a Person's address in the address book.
	 *
	 * @param postalCode
	 *            Postal code of address
	 * @throws IllegalValueException
	 *             if given postalCode string is invalid.
	 */
	public class PostalCode {
		String value;
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
		this.block.value = trimmedAddress.split(ADDRESS_VALIDATION_REGEX)[BLOCK_INDEX_IN_ADDRESS];
		this.street.value = trimmedAddress.split(ADDRESS_VALIDATION_REGEX)[STREET_INDEX_IN_ADDRESS];
		this.unit.value = trimmedAddress.split(ADDRESS_VALIDATION_REGEX)[UNIT_INDEX_IN_ADDRESS];
		this.postalCode.value = trimmedAddress.split(ADDRESS_VALIDATION_REGEX)[POSTALCODE_INDEX_IN_ADDRESS];
		this.value = trimmedAddress;
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
						&& this.value.equals(((Address) other).value)); // state check
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}
