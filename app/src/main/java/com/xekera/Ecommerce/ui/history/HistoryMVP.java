package com.xekera.Ecommerce.ui.history;

import com.xekera.Ecommerce.data.rest.INetworkListGeneral;
import com.xekera.Ecommerce.data.rest.response.HistoryOrderIdResponse;
import com.xekera.Ecommerce.data.rest.response.OrderList;
import com.xekera.Ecommerce.data.room.model.Booking;
import com.xekera.Ecommerce.ui.adapter.HistoryAdapter;

import java.util.List;

public interface HistoryMVP {

    interface View {

        void showToastShortTime(String message);

        void showToastLongTime(String message);

        void showSnackBarShortTime(String message, android.view.View view);

        void showSnackBarLongTime(String message, android.view.View view);

        void showSnackBarShortTime(String message);

        void showRecylerViewProductsDetail(HistoryAdapter addToCartAdapter);

        void showRecyclerView();

        void hideRecyclerView();

        void setCartCounts(long counts);

        void setCartCounterTextview(int counts);

        void setParentFields();

        void txtNoCartItemFound();

        void hideNoCartItemFound();

        void setSubTotal(String setSubToal);

        void setAdapter(List<Booking> addToCarts);

        void showOrderCompleteSuccessDialog();

        void hideLoadingProgressDialog();

        void showSearchData();

        void hideSearchDate();

        void showProgressDialogPleaseWait();

        void hideProgressDialogPleaseWait();

        void setHistoryAdapter(List<OrderList> response);

    }

    interface Presenter {
        void setView(HistoryMVP.View view);

        void fetchOrderDetails();

        void fetchCartsCount();

        void fetchOrderHistoryID(String username, String emailID);

    }

    interface Model {

        void getOrderDetailsList(HistoryModel.IFetchOrderDetailsList iFetchOrderDetailsList);

        void getCartDetailsList(HistoryModel.IFetchCartDetailsList iFetchCartDetailsList);

        void fetchOrderHistoryId(String username, String emailID, INetworkListGeneral<HistoryOrderIdResponse> iNetworkListGeneral);

    }
}
