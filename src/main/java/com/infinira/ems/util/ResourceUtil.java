package com.infinira.ems.util;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.MissingResourceException;
import java.text.MessageFormat;

public class ResourceUtil {
	private static final String RESOURCE_FILE = "ems_messages";
	private static ResourceBundle bundle;
	
	private ResourceUtil() {
		try {
			bundle = ResourceBundle.getBundle(RESOURCE_FILE, Locale.getDefault());
		}catch(MissingResourceException ex) {
			throw new RuntimeException(prepareMessage(MSG_0001, RESOURCE_FILE), ex);
		}
	}

    private static class ResourceUtilHelper {
        static final ResourceUtil resourceUtil = new ResourceUtil();
    }

    public static ResourceUtil getInstance() {
        return ResourceUtilHelper.resourceUtil;
    }
	
	private static String prepareMessage(String msg, Object ...args) {
		try {
			return MessageFormat.format(msg,args);
		}
		catch(IllegalArgumentException ex) {
			return MSG_0006 + msg;
		}
	}
	public String getMessage(String msgKey, Object ...args) {
		if(msgKey == null || msgKey.isEmpty()) {
			return MSG_0002;
		}
		if(args == null) {
			return MSG_0003;
		}
		if(!bundle.containsKey(msgKey)) {
				return prepareMessage(MSG_0004, msgKey, RESOURCE_FILE);
		}
		String message = bundle.getString(msgKey);
		if(message == null || message.isEmpty()) {
			return prepareMessage(MSG_0005,msgKey);
		}
		if (args.length == 0) {
			return message;
		}
		return prepareMessage(message, args);
	}
	
	private static final String MSG_0001 = "Resource file {0}.properties not found";
	private static final String MSG_0002 = "MessageKey cannot be null or empty";
	private static final String MSG_0003 = "Message's Parameter cannot be null";
	private static final String MSG_0004 = "Requested key {0} is not found  in the {1}.properties file";
	private static final String MSG_0005 = "{0} has no value/message";
	private static final String MSG_0006 = "Failed to format the message ";
}