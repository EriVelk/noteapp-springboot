package com.veliz.NoteApp.utils;

public class Constants {
    public static String BLANK_SPACE= " ";
    public static String EMAIL_IS_REQUIRED = "E-mail field is required";
    public static String USER_IS_REQUIRED = "User field is required";
    public static String FIRSTNAME_IS_REQUIRED = "First Name field is required";
    public static String LASTNAME_IS_REQUIRED = "Last Name field is required";
    public static String USER_DELETED = "User has been removed";
    public static String EMAIL_EXIST = "Email already exists in the database";
    public static String NOTE_DELETED = "Note has been removed";

    public enum ResponseConstant{
        SUCCESS("SUCCESS"),
        FAILURE("FAILURE");

        private String description;

        ResponseConstant(final String description){
            this.description = description;
        }

        public String getDescription(){
            return description;
        }
    }
}
