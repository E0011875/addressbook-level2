package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Represents an entry in a tag session.
 * Entry contains the addition or deletion of a tag for a specific person in the addressbook during a session
 */
public class Tagging {
	
	public static enum TagAction {ADD, REMOVE};
	
	private ReadOnlyPerson person;
    private Tag tag;
    private TagAction action;
	
	/**
     * Constructs an address book with the given data.
     *
     * @param person 
     * @param tag
	 * @param action
     */
	public Tagging(ReadOnlyPerson person, Tag tag, TagAction action) {
		this.person = person; 
		this.tag = tag; 
		this.action = action;
	}
	
	/**
     * @return the person
     */
	public ReadOnlyPerson getPerson() {
		return person;
    }
	
	/**
     * @return the tag of the person
     */
	public Tag getTag() {
        return tag;
    }
	
	/**
     * @return the tag action associated to person
     */
	public TagAction getAction() {
        return action;
    }
}
