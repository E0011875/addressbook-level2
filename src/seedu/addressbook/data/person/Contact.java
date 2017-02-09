package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public class Contact {
	
	public final String contact;
	private boolean isPrivate;
	
	private static String MESSAGE_CONSTRAINTS;
 	private static String VALIDATION_REGEX;
	
	/**
     * Validates given contact.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String messageConstraints, String validationRegex) throws IllegalValueException {
        this.isPrivate = isPrivate;
		Contact.MESSAGE_CONSTRAINTS = messageConstraints;
		Contact.VALIDATION_REGEX = validationRegex;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
        this.contact = trimmedContact;
    }
	
	/**
     * Checks if a given string is a valid contact.
     */
    public static boolean isValidContact(String test) {
        return test.matches(VALIDATION_REGEX);
    }
	
	@Override
    public String toString() {
        return contact;
    }
	
	@Override
    public int hashCode() {
        return contact.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
