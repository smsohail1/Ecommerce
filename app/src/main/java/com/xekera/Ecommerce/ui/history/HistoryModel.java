package com.xekera.Ecommerce.ui.history;

import com.xekera.Ecommerce.data.rest.INetworkListGeneral;
import com.xekera.Ecommerce.data.rest.XekeraAPI;
import com.xekera.Ecommerce.data.rest.response.HistoryOrderIdResponse;
import com.xekera.Ecommerce.data.room.AppDatabase;
import com.xekera.Ecommerce.data.room.dao.AddToCartDao;
import com.xekera.Ecommerce.data.room.dao.BookingDao;
import com.xekera.Ecommerce.data.room.model.AddToCart;
import com.xekera.Ecommerce.data.room.model.Booking;
import com.xekera.Ecommerce.util.Utils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class HistoryModel implements HistoryMVP.Model {
    private AppDatabase appDatabase;
    private Utils utils;
    private XekeraAPI xekeraAPI;

    public HistoryModel(AppDatabase appDatabase, Utils utils, XekeraAPI xekeraAPI) {
        this.appDatabase = appDatabase;
        this.utils = utils;
        this.xekeraAPI = xekeraAPI;

    }

    @Override
    public void getOrderDetailsList(final IFetchOrderDetailsList iFetchOrderDetailsList) {
        try {
            Observable.just(appDatabase.getBookingDao()).
                    map(new Function<BookingDao, List<Booking>>() {
                        @Override
                        public List<Booking> apply(BookingDao bookingDao) throws Exception {
                            return bookingDao.getAllBookingDetails();
                        }
                    }).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(new Observer<List<Booking>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(List<Booking> bookings) {
                            iFetchOrderDetailsList.onCartDetailsReceived(bookings);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iFetchOrderDetailsList.onErrorReceived((Exception) e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception e) {
            iFetchOrderDetailsList.onErrorReceived(e);
        }
    }


    @Override
    public void getCartDetailsList(final IFetchCartDetailsList IFetchCartDetailsList) {
        try {
            Observable.just(appDatabase.getAddToCartDao()).
                    map(new Function<AddToCartDao, List<AddToCart>>() {
                        @Override
                        public List<AddToCart> apply(AddToCartDao addToCartDao) throws Exception {
                            return addToCartDao.getAllCartCount();
                        }
                    }).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(new Observer<List<AddToCart>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(List<AddToCart> AddToCartList) {
                            IFetchCartDetailsList.onCartDetailsReceived(AddToCartList);
                        }

                        @Override
                        public void onError(Throwable e) {
                            IFetchCartDetailsList.onErrorReceived((Exception) e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception e) {
            IFetchCartDetailsList.onErrorReceived(e);
        }
    }

    @Override
    public void fetchOrderHistoryId(String username, String emailID, final INetworkListGeneral<HistoryOrderIdResponse> iNetworkListGeneral) {
        Call<HistoryOrderIdResponse> call = xekeraAPI.getOrderHistroryId(username, emailID);
        call.enqueue(new Callback<HistoryOrderIdResponse>() {
            @Override
            public void onResponse(Call<HistoryOrderIdResponse> call, Response<HistoryOrderIdResponse> response) {
                try {
                    HistoryOrderIdResponse historyOrderIdResponse = response.body();

                    iNetworkListGeneral.onSuccess(historyOrderIdResponse);
//                    if(messageResponse == null){
//                        iNetworkLoginSignup.onErrorList(getMessageResponse(utils.getStringFromResourceId(R.string.error),
//                                utils.getStringFromResourceId(R.string.null_response_received)));
//                        return;
//                    }

                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }

            @Override
            public void onFailure(Call<HistoryOrderIdResponse> call, Throwable t) {
                iNetworkListGeneral.onFailure(t);
            }
        });
    }


    interface IFetchCartDetailsList {
        void onCartDetailsReceived(List<AddToCart> AddToCartList);

        void onErrorReceived(Exception ex);
    }

    interface IFetchOrderDetailsList {
        void onCartDetailsReceived(List<Booking> bookings);

        void onErrorReceived(Exception ex);
    }
}
