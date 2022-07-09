package com.epam.rd.contactbook;

public class Contact {
    private String contactName;
    private Email[] emails = new Email[EMAIL_LIMIT];
    private Social[] socials = new Social[SOCIAL_LIMIT];
    private ContactInfo phoneNumber;

    private int emailsNumber = 0;
    private int socialsNumber = 0;
    private boolean phoneNumberIsSet = false;

    private final static int EMAIL_LIMIT = 3;
    private final static int SOCIAL_LIMIT = 5;


    public Contact(String contactName) {
        if(contactName == null || contactName.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.contactName = contactName;
    }

    public void rename(String newName) {
        if(newName == null || newName.isEmpty()){
            return;
        }
        this.contactName = newName;
    }

    public Email addEmail(String localPart, String domain) {
        if(emailsNumber == EMAIL_LIMIT){
            return null;
        }
        if(localPart == null || localPart.isEmpty()){
            return null;
        }
        if(domain == null || domain.isEmpty()){
            return null;
        }

        Email email = new Email(localPart, domain);
        emails[emailsNumber] = email;
        emailsNumber++;
        return email;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        if(emailsNumber == EMAIL_LIMIT){
            return null;
        }
        if(firstname == null || firstname.isEmpty()){
            return null;
        }
        if(lastname == null || lastname.isEmpty()){
            return null;
        }

        Email email = new Email(firstname, lastname){
            {
                super.setLocalPart(firstname + "_" + lastname);
                super.setDomain("epam.com");
            }
            @Override
            public String getTitle(){
                return "Epam Email";
            }

            @Override
            public String getValue() {
                return super.getValue();
            }
        };
        emails[emailsNumber] = email;
        emailsNumber++;
        return email;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if(number == null || number.isEmpty()){
            return null;
        }

        if(phoneNumberIsSet){
            return null;
        }

        ContactInfo numberContact = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return "+" + code + " " + number;
            }
        };

        phoneNumber = numberContact;
        phoneNumberIsSet = true;
        return numberContact;

    }

    public Social addTwitter(String twitterId) {
        if(socialsNumber == SOCIAL_LIMIT){
            return null;
        }

        if(twitterId == null || twitterId.isEmpty()){
            return null;
        }

        Social twitter = new Social("Twitter", twitterId);
        socials[socialsNumber] = twitter;
        socialsNumber++;
        return twitter;
    }

    public Social addInstagram(String instagramId) {
        if(socialsNumber == SOCIAL_LIMIT){
            return null;
        }

        if(instagramId == null || instagramId.isEmpty()){
            return null;
        }

        Social instagram = new Social("Instagram", instagramId);
        socials[socialsNumber] = instagram;
        socialsNumber++;
        return instagram;
    }

    public Social addSocialMedia(String title, String id) {
        if(socialsNumber == SOCIAL_LIMIT){
            return null;
        }

        if(title == null || title.isEmpty()){
            return null;
        }

        if(id == null || id.isEmpty()){
            return null;
        }

        Social social = new Social(title, id);
        socials[socialsNumber] = social;
        socialsNumber++;
        return social;
    }

    public ContactInfo[] getInfo() {
        int numberOfContacts = phoneNumberIsSet ? 2 : 1;
        numberOfContacts += emailsNumber + socialsNumber;
        ContactInfo[] contacts = new ContactInfo[numberOfContacts];

        contacts[0] = new NameContactInfo();

        int idx = 1;

        if(phoneNumberIsSet){
            contacts[idx] = phoneNumber;
            idx++;
        }

        for(int i = 0; i < emailsNumber; i++){
            contacts[idx] = emails[i];
            idx++;
        }

        for(int i = 0; i < socialsNumber; i++){
            contacts[idx] = socials[i];
            idx++;
        }

        return contacts;
    }


    private class NameContactInfo implements ContactInfo{
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo{
        private String localPart;
        private String domain;

        private Email(String localPart, String domain){
            this.localPart = localPart;
            this.domain = domain;
        }

        public void setLocalPart(String localPart) {
            if(localPart == null || localPart.isEmpty()){
                return;
            }
            this.localPart = localPart;
        }

        public void setDomain(String domain) {
            if(domain == null || domain.isEmpty()){
                return;
            }
            this.domain = domain;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return localPart + "@" + domain;
        }
    }

    public static class Social implements ContactInfo{
        private String name;
        private String id;

        public Social(String name, String id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String getTitle() {
            return name;
        }

        @Override
        public String getValue() {
            return id;
        }
    }
}
