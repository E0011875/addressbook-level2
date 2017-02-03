package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.List;

/**
 * Formatter for TextUi to show texts to user.
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    
    public String getLinePrefix() {
    	return LINE_PREFIX;
    }
    
    public String getDivider() {
    	return DIVIDER;
    }
	
	/**
     * Formats a command.
     * 
	 * @return    String formattedCommand
     */
    public String getFormattedCommand() {
    	return getLinePrefix() + "Enter command: ";
    }
	
    /**
     * Check if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param   rawInputLine full raw user input line.
     * @return true if user input is either empty or a comment.
     */
    public boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Check if user input line is a comment line.
     *
     * @param rawInputLine raw user input line.
     * @return true if input line is a comment.
     */
    public boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }
    
    /**
     * Formats a welcome message.
     *
     * @param version, storageFilePath
	 * @return    String[] welcomeMessage
     */
    public String[] formatWelcomeMessage(String version, String storageFilePath) {
    	String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    	String[] welcomeMessage = {
    			getDivider(),
                getDivider(),
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                getDivider()
    	};
    	return welcomeMessage;
    }
    
	/**
     * Formats a goodbye message.
     * 
	 * @return    String goodbyeMessage
     */
    public String[] formatGoodbyeMessage() {
    	String[] goodbyeMessage = {
    			MESSAGE_GOODBYE,
    			getDivider(),
    			getDivider()
    	};
    	return goodbyeMessage;
    }
    
	/**
     * Formats an failed message on initiation.
     * 
	 * @return    initFailedMessage
     */
    public String[] formatInitFailedMessage() {
    	String[] initFailedMessage = {
    			MESSAGE_INIT_FAILED, 
    			getDivider(), 
    			getDivider()
    	};
    	return initFailedMessage;
    }
	
	/**
     * Formats a message.
     * 
     * @param message    message to be show to user
	 * @return    String formattedMessage
     */
    public String getFormattedMessage(String message) {
    	return getLinePrefix() + message.replace("\n", LS + getLinePrefix());
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
