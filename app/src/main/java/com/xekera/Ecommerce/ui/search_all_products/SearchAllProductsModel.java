package com.xekera.Ecommerce.ui.search_all_products;

import com.xekera.Ecommerce.data.rest.INetworkListGeneral;
import com.xekera.Ecommerce.data.rest.XekeraAPI;
import com.xekera.Ecommerce.data.rest.response.ProductResponse;
import com.xekera.Ecommerce.data.rest.response.searchAllProductReponse.AllProductsResponse;
import com.xekera.Ecommerce.data.room.AppDatabase;
import com.xekera.Ecommerce.data.room.dao.AddToCartDao;
import com.xekera.Ecommerce.data.room.dao.FavouritesDao;
import com.xekera.Ecommerce.data.room.model.AddToCart;
import com.xekera.Ecommerce.data.room.model.Favourites;
import com.xekera.Ecommerce.util.Utils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class SearchAllProductsModel implements SearchAllProductsMVP.Model {
    private XekeraAPI xekeraAPI;
    private AppDatabase appDatabase;
    private Utils utils;

    public SearchAllProductsModel(XekeraAPI xekeraAPI, AppDatabase appDatabase, Utils utils) {
        this.xekeraAPI = xekeraAPI;
        this.appDatabase = appDatabase;
        this.utils = utils;

    }

    @Override
    public void getProductCount(final String productName, final SearchAllProductsModel.IFetchCartDetailsList iFetchCartDetailsList) {
        try {
            Observable.just(appDatabase.getAddToCartDao()).
                    map(new Function<AddToCartDao, List<AddToCart>>() {
                        @Override
                        public List<AddToCart> apply(AddToCartDao addToCartDao) throws Exception {
                            return addToCartDao.getCartDetailsByProductName(productName);
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
                            iFetchCartDetailsList.onCartDetailsReceived(AddToCartList);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iFetchCartDetailsList.onErrorReceived((Exception) e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception e) {
            iFetchCartDetailsList.onErrorReceived(e);
        }
    }

    @Override
    public void saveProductDetails(final AddToCart addToCart, final SearchAllProductsModel.ISaveProductDetails iSaveProductDetails) {
        try {
            Observable.just(appDatabase)
                    .map(new Function<AppDatabase, Boolean>() {
                        @Override
                        public Boolean apply(AppDatabase appDatabase) throws Exception {
                            appDatabase.getAddToCartDao().insert(addToCart);
                            return true;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Boolean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Boolean isAdded) {
                            iSaveProductDetails.onProductDetailsSaved(isAdded);
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (e.getMessage() != null) {
                                iSaveProductDetails.onErrorReceived((Exception) e);
                            }

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception ex) {
            iSaveProductDetails.onErrorReceived(ex);
        }
    }


    @Override
    public void updateItemCountInDB(final String quantity, final String itemPrice, final String productName, final String cutPrice,
                                    final SearchAllProductsModel.ISaveProductDetails iSaveProductDetails) {

        try {
            Observable.just(appDatabase)
                    .map(new Function<AppDatabase, Boolean>() {
                        @Override
                        public Boolean apply(AppDatabase appDatabase) throws Exception {
                            appDatabase.getAddToCartDao().updateItemCount(quantity, itemPrice, productName, cutPrice);
                            return true;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Boolean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Boolean updated) {
                            iSaveProductDetails.onProductDetailsSaved(updated);
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (e.getMessage() != null) {
                                iSaveProductDetails.onErrorReceived((Exception) e);
                            }

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception ex) {
            iSaveProductDetails.onErrorReceived(ex);
        }

    }


    @Override
    public void getCartDetails(final SearchAllProductsModel.IFetchCartDetailsList IFetchCartDetailsList) {
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
    public void removeFromFavourite(final String productName, final SearchAllProductsModel.IRemoveSelectedItemDetails iRemoveSelectedItemDetails) {
        try {
            Observable.just(appDatabase)
                    .map(new Function<AppDatabase, Boolean>() {
                        @Override
                        public Boolean apply(AppDatabase appDatabase) throws Exception {
                            appDatabase.getFavouritesDao().deleteItem(productName);


                            return true;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Boolean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Boolean success) {
                            iRemoveSelectedItemDetails.onSuccess();
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (e.getMessage() != null) {
                                iRemoveSelectedItemDetails.onError((Exception) e);
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception ex) {
            iRemoveSelectedItemDetails.onError(ex);
        }
    }

    @Override
    public void addItemToFavourites(final Favourites favourites, final SearchAllProductsModel.ISaveProductDetails iSaveProductDetails) {
        try {
            Observable.just(appDatabase)
                    .map(new Function<AppDatabase, Boolean>() {
                        @Override
                        public Boolean apply(AppDatabase appDatabase) throws Exception {
                            appDatabase.getFavouritesDao().insert(favourites);
                            return true;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Boolean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Boolean isAdded) {
                            iSaveProductDetails.onProductDetailsSaved(isAdded);
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (e.getMessage() != null) {
                                iSaveProductDetails.onErrorReceived((Exception) e);
                            }

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception ex) {
            iSaveProductDetails.onErrorReceived(ex);
        }

    }

    @Override
    public void checkItemAlreadyAddedOrNot(final String itemName, final SearchAllProductsModel.IFetchFavDetailsList iFetchCartDetailsList) {
        try {
            Observable.just(appDatabase.getFavouritesDao()).
                    map(new Function<FavouritesDao, List<Favourites>>() {
                        @Override
                        public List<Favourites> apply(FavouritesDao favouritesDao) throws Exception {
                            return favouritesDao.getFavouritesByName(itemName);
                        }
                    }).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(new Observer<List<Favourites>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(List<Favourites> bookings) {
                            iFetchCartDetailsList.onCartDetailsReceived(bookings);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iFetchCartDetailsList.onErrorReceived((Exception) e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception e) {
            iFetchCartDetailsList.onErrorReceived(e);
        }

    }

    @Override
    public void removeSelectedCartDetails(final String productName, final SearchAllProductsModel.IRemoveSelectedItemDetails iRemoveSelectedItemDetails) {
        try {
            Observable.just(appDatabase)
                    .map(new Function<AppDatabase, Boolean>() {
                        @Override
                        public Boolean apply(AppDatabase appDatabase) throws Exception {
                            appDatabase.getAddToCartDao().deleteItem(productName);


                            return true;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Boolean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Boolean success) {
                            iRemoveSelectedItemDetails.onSuccess();
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (e.getMessage() != null) {
                                iRemoveSelectedItemDetails.onError((Exception) e);
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception ex) {
            iRemoveSelectedItemDetails.onError(ex);
        }
    }


    @Override
    public void getFavouriteDetailsList(final SearchAllProductsModel.IFetchOrderDetailsList iFetchOrderDetailsList) {
        try {
            Observable.just(appDatabase.getFavouritesDao()).
                    map(new Function<FavouritesDao, List<Favourites>>() {
                        @Override
                        public List<Favourites> apply(FavouritesDao favouritesDao) throws Exception {
                            return favouritesDao.getAllFavourites();
                        }
                    }).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(new Observer<List<Favourites>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(List<Favourites> bookings) {
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
    public void getFavouriteDetailsListByName(final String productName, final SearchAllProductsModel.IFetchOrderDetailsList iFetchOrderDetailsList) {
        try {
            Observable.just(appDatabase.getFavouritesDao()).
                    map(new Function<FavouritesDao, List<Favourites>>() {
                        @Override
                        public List<Favourites> apply(FavouritesDao favouritesDao) throws Exception {
                            return favouritesDao.getFavouritesByName(productName);
                        }
                    }).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(new Observer<List<Favourites>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(List<Favourites> bookings) {
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
    public void checkItemAlreadyAddedOrNot(final String itemName, final SearchAllProductsModel.IFetchCartDetailsList iFetchCartDetailsList) {
        try {
            Observable.just(appDatabase.getAddToCartDao()).
                    map(new Function<AddToCartDao, List<AddToCart>>() {
                        @Override
                        public List<AddToCart> apply(AddToCartDao addToCartDao) throws Exception {
                            return addToCartDao.getCartsByName(itemName);
                        }
                    }).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(new Observer<List<AddToCart>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(List<AddToCart> bookings) {
                            iFetchCartDetailsList.onCartDetailsReceived(bookings);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iFetchCartDetailsList.onErrorReceived((Exception) e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception e) {
            iFetchCartDetailsList.onErrorReceived(e);
        }

    }

    @Override
    public void getProductItemsDetails(@NotNull final INetworkListGeneral<AllProductsResponse> iNetworkListGeneral) {
        Call<AllProductsResponse> call = xekeraAPI.getAllProducts();
        call.enqueue(new Callback<AllProductsResponse>() {
            @Override
            public void onResponse(Call<AllProductsResponse> call, Response<AllProductsResponse> response) {
                try {
                    AllProductsResponse productResponse = response.body();

                    iNetworkListGeneral.onSuccess(productResponse);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<AllProductsResponse> call, Throwable t) {
                iNetworkListGeneral.onFailure(t);
            }
        });
    }

//    @Override
//    public void getProductItemsDetails(String sku, final INetworkListGeneral<ProductResponse> iNetworkListGeneral) {
//        Call<ProductResponse> call = xekeraAPI.getProducts(sku);
//        call.enqueue(new Callback<ProductResponse>() {
//            @Override
//            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
//                try {
//                    ProductResponse productResponse = response.body();
//
//                    iNetworkListGeneral.onSuccess(productResponse);
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ProductResponse> call, Throwable t) {
//                iNetworkListGeneral.onFailure(t);
//            }
//        });
//    }


    public interface IFetchCartDetailsList {
        void onCartDetailsReceived(List<AddToCart> AddToCartList);

        void onErrorReceived(Exception ex);
    }

    public interface IFetchFavDetailsList {
        void onCartDetailsReceived(List<Favourites> AddToCartList);

        void onErrorReceived(Exception ex);
    }

    public  interface IRemoveSelectedItemDetails {
        void onSuccess();

        void onError(Exception ex);
    }

    public interface ISaveProductDetails {
        void onProductDetailsSaved(boolean isAdded);

        void onErrorReceived(Exception ex);
    }

    public interface IFetchOrderDetailsList {
        void onCartDetailsReceived(List<Favourites> bookings);

        void onErrorReceived(Exception ex);
    }

}