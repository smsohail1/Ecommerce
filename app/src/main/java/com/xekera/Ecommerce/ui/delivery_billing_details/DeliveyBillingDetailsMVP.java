package com.xekera.Ecommerce.ui.delivery_billing_details;

import android.view.View;

public interface DeliveyBillingDetailsMVP {

    interface View {


        void showToastShortTime(String message);

        void showToastLongTime(String message);

        void showSnackBarShortTime(String message, android.view.View view);

        void showSnackBarLongTime(String message, android.view.View view);

        void showSnackBarShortTime(String message);

        void showBillingAmountDetailView(String flatCharges, String firstName, String lastName, String company, String phone,
                                         String email, String streetAddress1, String streetAddress2,
                                         String townCity, String paymode,
                                         String notes);

    }

    interface Presenter {
        void setView(DeliveyBillingDetailsMVP.View view);

        void saveDetails(String firstName, String lastName, String company, String phone, String email,
                         String streetAddress1, String streetAddress2,
                         String townCity, String paymode, String notes,
                         String flatCharges);

    }

    interface Model {


    }

}
