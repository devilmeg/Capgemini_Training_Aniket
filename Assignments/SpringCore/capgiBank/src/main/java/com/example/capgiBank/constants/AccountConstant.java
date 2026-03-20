package com.example.capgiBank.constants;

public final class AccountConstant {

    // Private constructor to restrict instantiation
    private AccountConstant() {
        //restrict instantiaon
    }

    // ================= SUCCESS =================
    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";

    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Account created successfully";

    public static final String STATUS_202 = "202";
    public static final String MESSAGE_202 = "Request accepted for processing";

    // ✅ FETCH (GET)
    public static final String STATUS_FETCH_SUCCESS = "200";
    public static final String MESSAGE_FETCH_SUCCESS = "Account fetched successfully";

    public static final String STATUS_FETCH_ALL_SUCCESS = "200";
    public static final String MESSAGE_FETCH_ALL_SUCCESS = "All accounts fetched successfully";

    // ================= CLIENT ERRORS =================
    public static final String STATUS_400 = "400";
    public static final String MESSAGE_400 = "Bad request";

    public static final String STATUS_404 = "404";
    public static final String MESSAGE_404 = "Account not found";

    // ================= BUSINESS LOGIC =================
    public static final String STATUS_300 = "300";
    public static final String MESSAGE_300 = "Account already exists";

    // ================= SERVER ERROR =================
    public static final String STATUS_500 = "500";
    public static final String MESSAGE_500 = "Internal server error";

}