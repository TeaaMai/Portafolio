package com.portafolio.amazonMail;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class Mail {
	
	private String from;
    private String mailTo;
    private String subject;
    private String directory;
    private String text;
    private MultipartFile[] attachments;
    private Map<String, Object> props;

    private String template;

    public Mail() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public MultipartFile[] getAttachments() {
        return attachments;
    }

    public void setAttachments(MultipartFile[] attachments) {
        this.attachments = attachments;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
