package com.revolv3r.generics.service;

import java.util.Collection;

/**
 * Created by chimp on 26/11/2017.
 */
public interface Shop<T> {

    T buy();

    void sell(T aItem);
    void buyLot(int aCount,
             Collection<? super T> aCollection);
    void sellLot(Collection<? extends T> aLot);

}
